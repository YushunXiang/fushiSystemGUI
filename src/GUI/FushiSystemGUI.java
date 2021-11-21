package GUI;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import examPaperCatalog.*;
import formatterSettings.*;
import IO.*;
import studentCatalog.*;

/**
 *  This class provides a GUI for the retest system and also implements the click event in the page.
 *
 * @author liYX&YangYY
 * @version 1.1.0
 * @see EnglishTest
 * @see ExamPaper
 * @see MathTest
 * @see ProfessionalTest
 * @see Student
 * @see StudentCatalog
 * @see Test
 * @see TestDatabase
 * @see TestItem
 * @see FileFushiTestDatabaseLoader
 * @see FushiTestDatabaseLoader
 * @see StudentsFormatter
 * @see PlainTextStudentsFormatter
 * @see HTMLStudentsFormatter
 * @see XMLStudentsFormatter
 */
public class FushiSystemGUI extends  JPanel {

    /** Standard error stream */
    static private PrintWriter stdErr = new PrintWriter(System.err, true);

    /** Window width in pixels */
    static private int WIDTH = 1200;

    /** Window height in pixels */
    static private int HEIGHT = 660;

    /** Size of the catalog list cell in pixels */
    static private int CATALOG_CELL_SIZE = 50;

    /** Visible rows in catalog list */
    static private int CATALOG_LIST_ROWS = 14;

    /** Rows in status text area rows */
    static private int STATUS_ROWS = 10;

    /** Rows in status text area cols */
    static private int STATUS_COLS = 40;

    private JList catalogList;
    private JButton generateExamPaperButton;
    private JButton displayExamPaperButton;
    private JButton saveExamPaperButton;
    private JTextArea statusTextArea;
    private JRadioButton plainRadioButton;
    private JRadioButton HTMLRadioButton;
    private JRadioButton XMLRadioButton;

    private static TestDatabase testDatabase;
    private static StudentCatalog studentCatalog;
    private static Student student;
    private StudentsFormatter studentsFormatter;

    /**
     * Desc: Loads a test database and starts the application.
     * @param args
     * @throws IOException
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/11/11 19:52
     */
    public static void main(String[] args) throws IOException {

        String filename = "";

        if (args.length != 1) {
            filename = "testCatalog.dat";
        } else {
            filename = args[0];
        }
        try {
            testDatabase = (new FileFushiTestDatabaseLoader()).loadTestDatabase(filename);
            JFrame frame = new JFrame("Fushi System");
            frame.setContentPane(new FushiSystemGUI(testDatabase));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.setResizable(true);
            frame.setVisible(true);

        } catch (FileNotFoundException fnfe) {
            stdErr.println("The file does not exist");

            System.exit(1);

        } catch (DataFormatException dfe) {
            stdErr.println("The file contains malformed data: " + dfe.getMessage());

            System.exit(1);
        }
    }

    /**
     * Desc: Instantiates the components and arranges them in a window.
     * @param testDatabase
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/11/11 19:53
     */
    public FushiSystemGUI(TestDatabase testDatabase) {

        // create the components
        catalogList = new JList();
        catalogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        catalogList.setVisibleRowCount(CATALOG_LIST_ROWS);
        catalogList.setFixedCellWidth(CATALOG_CELL_SIZE);
        generateExamPaperButton = new JButton("Generate Exampaper");
        displayExamPaperButton = new JButton("Display Exampaper");
        saveExamPaperButton = new JButton("Save Exampaper");
        statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
        statusTextArea.setEditable(false);
        plainRadioButton = new JRadioButton("Plain", true);
        HTMLRadioButton = new JRadioButton("HTML");
        XMLRadioButton = new JRadioButton("XML");

        ButtonGroup group = new ButtonGroup();

        group.add(plainRadioButton);
        group.add(HTMLRadioButton);
        group.add(XMLRadioButton);

        // Catalog panel
        JPanel catalogPanel = new JPanel(new BorderLayout());

        catalogPanel.setBorder(BorderFactory.createTitledBorder("Catalog"));
        catalogPanel.add(generateExamPaperButton,BorderLayout.SOUTH);
        catalogPanel.add(new JScrollPane(catalogList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        catalogPanel.setPreferredSize(new Dimension(190, 150));

        // examPaper panel
        JPanel examPaperPanel = new JPanel(new BorderLayout());

        examPaperPanel.setBorder(BorderFactory.createTitledBorder("Exampaper"));

        JPanel examPaperButtonsPanel = new JPanel(new GridLayout(1, 5));

        examPaperButtonsPanel.add(plainRadioButton);
        examPaperButtonsPanel.add(HTMLRadioButton);
        examPaperButtonsPanel.add(XMLRadioButton);
        examPaperButtonsPanel.add(displayExamPaperButton);
        examPaperButtonsPanel.add(saveExamPaperButton);
        examPaperPanel.add(new JScrollPane(statusTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        examPaperPanel.add(examPaperButtonsPanel, BorderLayout.SOUTH);

        // arrange panels in window
        setLayout(new BorderLayout());
        add(catalogPanel, BorderLayout.WEST);
        add(examPaperPanel, BorderLayout.CENTER);

        // start listening for list and buttons events
        catalogList.addListSelectionListener(new DisplayStudentListener());
        generateExamPaperButton.addActionListener(new generateExamPaperListener());
        displayExamPaperButton.addActionListener(new DisplayExamPaperListener());
        saveExamPaperButton.addActionListener(new SaveExamPaperListener());
        plainRadioButton.addActionListener(new PlainListener());
        HTMLRadioButton.addActionListener(new HTMLListener());
        XMLRadioButton.addActionListener(new XMLListener());

        // populate the student catalog
        studentCatalog = loadStudent();
        String[] codes = new String[studentCatalog.getNumberOfStudents()];
        int i = 0;
        for (Student student : studentCatalog) {
            codes[i++] = student.toString();
        }
        catalogList.setListData(codes);
        studentsFormatter = PlainTextStudentsFormatter.getSingletonInstance();
    }

    /**
     * Desc: A static method which loads the information of a student catalog.
     * @return {@link StudentCatalog}
     * @author Yushun Xiang
     * @date 2021/11/11 19:54
     */
    private static StudentCatalog loadStudent() {
        StudentCatalog studentCatalog = new StudentCatalog();

        studentCatalog.addStudent(new Student("2019213001", "吴广胜"));
        studentCatalog.addStudent(new Student("2019213002", "陈盛典"));
        studentCatalog.addStudent(new Student("2019213003", "刘子豪"));
        studentCatalog.addStudent(new Student("2019213004", "仇历"));
        studentCatalog.addStudent(new Student("2019213005", "郑西泽"));
        studentCatalog.addStudent(new Student("2019213006", "李梦琪"));
        studentCatalog.addStudent(new Student("2019213007", "王志"));
        studentCatalog.addStudent(new Student("2019213008", "张天一"));
        studentCatalog.addStudent(new Student("2019213009", "周琳琳"));
        studentCatalog.addStudent(new Student("2019213010", "周爽"));
        studentCatalog.addStudent(new Student("2019213011", "张涵"));
        studentCatalog.addStudent(new Student("2019213012", "李依然"));
        studentCatalog.addStudent(new Student("2019213013", "孟子涛"));
        studentCatalog.addStudent(new Student("2019213014", "腊志翱"));
        studentCatalog.addStudent(new Student("2019213015", "张一鸣"));
        studentCatalog.addStudent(new Student("2019213016", "李华"));
        studentCatalog.addStudent(new Student("2019213017", "冷子晴"));
        studentCatalog.addStudent(new Student("2019213018", "金灿"));
        studentCatalog.addStudent(new Student("2019213019", "朱文杰"));
        studentCatalog.addStudent(new Student("2019213020", "刘美含"));
        studentCatalog.addStudent(new Student("2019213021", "张涵"));
        studentCatalog.addStudent(new Student("2019213022", "李依"));
        studentCatalog.addStudent(new Student("2019213023", "孟涛"));
        studentCatalog.addStudent(new Student("2019213024", "王志"));
        studentCatalog.addStudent(new Student("2019213025", "周鸣"));
        studentCatalog.addStudent(new Student("2019213026", "王华"));
        studentCatalog.addStudent(new Student("2019213027", "张晴晴"));
        studentCatalog.addStudent(new Student("2019213028", "周晓晓"));
        studentCatalog.addStudent(new Student("2019213029", "冯愈"));
        studentCatalog.addStudent(new Student("2019213030", "刘琳"));
        studentCatalog.addStudent(new Student("2019213031", "周涵"));
        studentCatalog.addStudent(new Student("2019213032", "王依一"));
        studentCatalog.addStudent(new Student("2019213033", "张涛"));
        studentCatalog.addStudent(new Student("2019213034", "王真"));
        studentCatalog.addStudent(new Student("2019213035", "武娟"));
        studentCatalog.addStudent(new Student("2019213036", "王煊"));
        studentCatalog.addStudent(new Student("2019213037", "时帧"));
        studentCatalog.addStudent(new Student("2019213038", "习雨"));
        studentCatalog.addStudent(new Student("2019213039", "冯载愈"));
        studentCatalog.addStudent(new Student("2019213040", "刘珍珍"));
        return studentCatalog;
    }

    /**
     * Desc: This inner class handles list-selection events.
     * @see ListSelectionListener
     * @see ListSelectionEvent
     * @author Yushun Xiang
     * @date 2021/11/11 19:55
     */
    class DisplayStudentListener implements ListSelectionListener {

        /**
         * Desc: Gets the information of the selected student.
         * @param event
         * @return
         * @author Yushun Xiang
         * @date 2021/11/11 19:59
         */
        public void valueChanged(ListSelectionEvent event) {

            if (!catalogList.getValueIsAdjusting()) {

                String studentInfo = (String) catalogList.getSelectedValue();
                StringTokenizer token = new StringTokenizer(studentInfo, "_");
                student = studentCatalog.getStudent(token.nextToken());
            }
        }

    }

    /**
     * This inner class processes <code>generateExamPaperButton</code> events.
     */
    class generateExamPaperListener implements ActionListener {

        /**
         * Generate a random retest paper for the designated student.
         *
         * @param event
         *            the event object.
         */
        public void actionPerformed(ActionEvent event) {

            try{
                if(student.getExamPaper() == null) {
                    generateExamPaper();
                } else {
                    statusTextArea.setText("Test papers have been generated for " + student.getId());
                }

            } catch (Exception e) {
                statusTextArea.setText("Test paper generation failed for "+ student.getId());
            }
        }
    }

    /**
     * Generate a random retest paper for the designated student.
     */
    private void generateExamPaper() throws IOException {


            if (testDatabase.getNumberOfTests() < 10) {
                statusTextArea.setText("There are less than ten test questions in the test question bank, "
                        + "and the test paper cannot be generated.");
            } else {

                int[] testTypeNums = new int[3];
                for (int i = 0; i < testTypeNums.length; i++) {
                    testTypeNums[i] = 0;
                }
                Iterator<Test> iterator = testDatabase.iterator();
                while (iterator.hasNext()) {
                    Test test = iterator.next();
                    if (test instanceof EnglishTest) {
                        testTypeNums[0]++;
                    } else if (test instanceof MathTest) {
                        testTypeNums[1]++;
                    } else if (test instanceof ProfessionalTest) {
                        testTypeNums[2]++;
                    }
                }

                if (testTypeNums[0] < 3 || testTypeNums[1] < 3 || testTypeNums[2] < 4) {
                    statusTextArea.setText("There are not enough English questions or math questions or professional "
                            + "questions in the test database.");
                    return;
                }
                //采用随机生成试卷
                Random random = new Random();
                ExamPaper examPaper = new ExamPaper();

                for (int i = 0; i < testTypeNums.length; i++) {
                    testTypeNums[i] = 0;
                }

                int allTestCount = testDatabase.getNumberOfTests();

                boolean[] testIsChoose = new boolean[allTestCount];

                while (examPaper.getNumberOfTestItems() < 10) {

                    int target = random.nextInt(allTestCount);
                    Test test = testDatabase.getTest(target);

                    if (test instanceof EnglishTest) {
                        if (testTypeNums[0] < 3 && (!testIsChoose[target])) {
                            testTypeNums[0]++;
                            examPaper.addTestItem(new TestItem(test, 0));
                            testIsChoose[target] = true;
                        }
                    } else if (test instanceof MathTest) {
                        if (testTypeNums[1] < 3 && (!testIsChoose[target])) {
                            testTypeNums[1]++;
                            examPaper.addTestItem(new TestItem(test, 0));
                            testIsChoose[target] = true;
                        }
                    } else if (test instanceof ProfessionalTest) {
                        if (testTypeNums[2] < 4 && (!testIsChoose[target])) {
                            testTypeNums[2]++;
                            examPaper.addTestItem(new TestItem(test, 0));
                            testIsChoose[target] = true;
                        }
                    }

                }
                student.setExamPaper(examPaper);
                statusTextArea.setText("Test paper generated successfully for "+student.getId());
            }

    }

    /**
     * This inner class processes <code>displayExamPaperButton</code>events.
     */
    class DisplayExamPaperListener implements ActionListener {

        /**
         * Desc: Displays the students' exam paper information.
         * @param event
         * @return void
         * @author Yushun Xiang
         * @date 2021/11/11 15:35
         */
        public void actionPerformed(ActionEvent event) {

            if (plainRadioButton.isSelected()) {

                studentsFormatter = PlainTextStudentsFormatter.getSingletonInstance();
                statusTextArea.setText(studentsFormatter.formatStudents(studentCatalog));
            } else if (HTMLRadioButton.isSelected()) {

                studentsFormatter = HTMLStudentsFormatter.getSingletonInstance();
                statusTextArea.setText(studentsFormatter.formatStudents(studentCatalog));
            } else {

                studentsFormatter = XMLStudentsFormatter.getSingletonInstance();
                statusTextArea.setText(studentsFormatter.formatStudents(studentCatalog));
            }
        }
    }

    /**
     * This inner class processes <code>saveExamPaperButton</code> events.
     */
    class SaveExamPaperListener implements ActionListener {

        /**
         * Desc: Saves the students' exam paper information in a file.
         * @param event
         * @return void
         * @author Yushun Xiang
         * @date 2021/11/11 16:08
         */
        public void actionPerformed(ActionEvent event) {

            JFileChooser chooser = new JFileChooser();

            //下面的方法将阻塞，直到 [用户按下保存按钮且“文件名”文本框不为空] 或 [用户按下取消按钮]
            int option = chooser.showSaveDialog(null);
            if(option==JFileChooser.APPROVE_OPTION) {    //假如用户选择了保存
                File file = chooser.getSelectedFile();
                try {

                    PrintWriter printWriter = new PrintWriter(new FileWriter(file));
                    if (HTMLRadioButton.isSelected()) {

                        studentsFormatter = HTMLStudentsFormatter.getSingletonInstance();
                        printWriter.print(studentsFormatter.formatStudents(studentCatalog));
                    } else if (XMLRadioButton.isSelected()){

                        studentsFormatter = XMLStudentsFormatter.getSingletonInstance();
                        printWriter.print(studentsFormatter.formatStudents(studentCatalog));
                    } else {

                        /** 默认打印 Plain Text */
                        studentsFormatter = PlainTextStudentsFormatter.getSingletonInstance();
                        printWriter.print(studentsFormatter.formatStudents(studentCatalog));
                    }
                    printWriter.flush();
                    printWriter.close();
                } catch (IOException e) {

                    System.err.println("IO异常");
                    e.printStackTrace();
                }
            }
        }
    }

    /***
     * Desc: This inner class processes <code>plainRadioButton</code> events.
     * @see ActionListener
     * @see ActionEvent
     * @author Yushun Xiang
     * @date 2021/11/11 19:50
     */
    class PlainListener implements ActionListener {

        /**
         * Desc: Sets the students formatter to plain text.
         * @param event
         * @author Yushun Xiang
         * @date 2021/11/11 19:51
         */
        public void actionPerformed(ActionEvent event) {

            studentsFormatter = PlainTextStudentsFormatter.getSingletonInstance();
        }
    }

    /*
     * This inner class processes <code>HTMLRadioButton</code> events.
     */
    class HTMLListener implements ActionListener {

        /**
         * Sets the students formatter to HTML.
         *
         * @param event
         *            the event object.
         */
        public void actionPerformed(ActionEvent event) {

            studentsFormatter = HTMLStudentsFormatter.getSingletonInstance();
        }
    }
    /*
     * This inner class processes <code>XMLRadioButton</code> events.
     */
    class XMLListener implements ActionListener {

        /**
         * Sets the students formatter to XML.
         *
         * @param event
         *            the event object.
         */
        public void actionPerformed(ActionEvent event) {

            studentsFormatter = XMLStudentsFormatter.getSingletonInstance();
        }
    }
}