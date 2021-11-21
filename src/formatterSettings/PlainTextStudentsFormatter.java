package formatterSettings;
import studentCatalog.*;
import examPaperCatalog.*;

/**
 * Desc: A public class which implements StudentsFormatter
 * @see StudentsFormatter
 * @see StudentCatalog
 * @author Yushun Xiang
 * @date 2021/11/2 22:07
 */
public class PlainTextStudentsFormatter implements StudentsFormatter{
    private static PlainTextStudentsFormatter singletonInstance;

    /**
     * Desc: Constructor
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/11/2 22:09
     */
    private PlainTextStudentsFormatter() {}

    /**
     * Desc: Get singleton instance.
     * @param
     * @return {@link PlainTextStudentsFormatter}
     * @author Yushun Xiang
     * @date 2021/11/2 22:09
     */
    public static synchronized PlainTextStudentsFormatter getSingletonInstance() {

        if (singletonInstance == null) {

            singletonInstance = new PlainTextStudentsFormatter();
        }

        return singletonInstance;
    }

    /**
     * Desc: Format students' information.
     * @param studentCatalog
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/2 22:10
     */
    @Override
    public String formatStudents(StudentCatalog studentCatalog) {
        StringBuffer studentsInformation = new StringBuffer(3);
        studentsInformation.append("Student Catalog");
        for (Student student : studentCatalog) {

            studentsInformation.append("\n" + student.getId() + "_" + student.getName());
            if (student.getExamPaper() == null) {

                studentsInformation.append("_该学生还未生成试卷");
            }else {

                for (TestItem testItem : student.getExamPaper()) {

                    studentsInformation.append("_" + testItem.getTest().getCode());
                }
            }
        }

        return studentsInformation.toString();
    }
}
