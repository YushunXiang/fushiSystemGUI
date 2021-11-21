package studentCatalog;

import examPaperCatalog.ExamPaper;

/**
 * Desc: A student class which contains id, name, and exam paper.
 * @see ExamPaper
 * @author Yushun Xiang
 * @date 2021/10/17 9:09
 */
public class Student {
    private String id;
    private String name;
    private ExamPaper examPaper;

    /**
     * Desc:
     * @param id
     * @param name
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public String getId() {
        return id;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public String getName() {
        return name;
    }

    /**
     * Desc:
     * @param
     * @return {@link ExamPaper}
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public ExamPaper getExamPaper() {
        return examPaper;
    }

    /**
     * Desc:
     * @param examPaper
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    /**
     * Desc:
     * @param student
     * @return {@link boolean}
     * @author Yushun Xiang
     * @date 2021/10/17 9:59
     */
    public boolean equals(Student student) {
        return student.id.equals(this.id) &&
                student.name.equals(this.name);
    }

    /***
     * Desc:
     * @TODO
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/10 0:24
     */
    @Override
    public String toString() {
        return this.getId() + "_" + this.getName();
    }
}
