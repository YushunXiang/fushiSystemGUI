package formatterSettings;
import studentCatalog.*;
import examPaperCatalog.*;

/**
 * Desc: A public class which implements StudentsFormatter
 * @see StudentsFormatter
 * @see StudentCatalog
 * @return {@link null}
 * @author Yushun Xiang
 * @date 2021/11/8 16:06
 */
public class XMLStudentsFormatter implements StudentsFormatter{
    private static XMLStudentsFormatter singletonInstance;

    /**
     * Desc: Constructor
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/11/2 22:11
     */
    private XMLStudentsFormatter() {}

    /**
     * Desc: Get singleton instance.
     * @param
     * @return {@link XMLStudentsFormatter}
     * @author Yushun Xiang
     * @date 2021/11/2 22:11
     */
    public static synchronized XMLStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {

            singletonInstance = new XMLStudentsFormatter();
        }

        return singletonInstance;
    }

    /**
     * Desc: Get singleton instance.
     * @param studentCatalog
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/2 22:11
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {
        StringBuffer studentsInformation = new StringBuffer(3);
        studentsInformation.append("<StudentCatalog>\n");
        for(Student student : studentCatalog){
            studentsInformation.append("    <Student id=\""+student.getId()+"\" name=\""+student.getName()+"\">\n");
            if (student.getExamPaper() == null) {
                studentsInformation.append("    该学生还未生成试卷\n");
            }
            else {

                studentsInformation.append("        <ExamPaper>\n");
                for (TestItem testItem : student.getExamPaper()) {

                    studentsInformation.append("            <Test code=\"" + testItem.getTest().getCode() + "\">" + testItem.getTest().getTitle() + "</Test>\n");
                }
                studentsInformation.append("        </ExamPaper>\n");
            }
            studentsInformation.append("    </Student>\n");
        }
        studentsInformation.append("</StudentCatalog>\n");

        return studentsInformation.toString();
    }
}
