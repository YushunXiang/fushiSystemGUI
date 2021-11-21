package formatterSettings;
import studentCatalog.*;
import examPaperCatalog.*;

/**
 * Desc: A public class which implements StudentsFormatter
 * @see StudentsFormatter
 * @see StudentCatalog
 * @author Yushun Xiang
 * @date 2021/11/2 22:01
 */
public class HTMLStudentsFormatter implements StudentsFormatter{
    private static HTMLStudentsFormatter singletonInstance;

    /**
     * Desc: Constructor
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/11/2 22:01
     */
    private HTMLStudentsFormatter() {}

    /**
     * Desc: Get singleton instance
     * @param
     * @return {@link HTMLStudentsFormatter}
     * @author Yushun Xiang
     * @date 2021/11/2 22:01
     */
    public static synchronized HTMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {

            singletonInstance = new HTMLStudentsFormatter();
        }

        return singletonInstance;
    }

    /**
     * Desc: Format students' information.
     * @param studentCatalog
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/2 22:06
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {
        StringBuffer studentsInformation = new StringBuffer(3);
        studentsInformation.append("<html>\n");
        studentsInformation.append("    <body>\n");
        studentsInformation.append("        <center><h2>StudentCatalog</h2></center>\n");
        studentsInformation.append("        <hr/>\n");
        for(Student student : studentCatalog){
            studentsInformation.append("        <h4>");
            studentsInformation.append(student.getId()+" "+student.getName());
            studentsInformation.append("</h4>\n");
            if (student.getExamPaper() == null) {

                studentsInformation.append("        该学生还未生成试卷\n");
            } else {

                studentsInformation.append("            <blockquote>\n");
                for (TestItem testItem : student.getExamPaper()) {

                    studentsInformation.append("                " + testItem.getTest().toHTMLString() + "<br/>\n");
                }
                studentsInformation.append("            </blockquote>\n");
            }
            studentsInformation.append("        <hr/>\n");
        }
        studentsInformation.append("    </body>\n");
        studentsInformation.append("</html>\n");
        return studentsInformation.toString();
    }
}
