package examPaperCatalog;

/**
 * Desc: A public class
 * @author Yushun Xiang
 * @date 2021/10/17 9:04
 */
public class Test {
    private String code;
    private String title;
    private int difficultyDegree;
    private String scoreCriteria;

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public String getCode() {
        return code;
    }

    /**
     * Desc:
     * @param code
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public String getTitle() {
        return title;
    }

    /**
     * Desc:
     * @param title
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Desc:
     * @param
     * @return {@link int}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public int getDifficultyDegree() {
        return difficultyDegree;
    }

    /**
     * Desc:
     * @param difficultyDegree
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public void setDifficultyDegree(int difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    /**
     * Desc:
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public String getScoreCriteria() {
        return scoreCriteria;
    }

    /**
     * Desc:
     * @param scoreCriteria
     * @return void
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public void setScoreCriteria(String scoreCriteria) {
        this.scoreCriteria = scoreCriteria;
    }

    /**
     * Desc: A method return test information in a specific form (HTML).
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:07
     */
    public String toHTMLString() {

        return getCode()
                + "|" + getTitle()
                + "|" + String.valueOf(getDifficultyDegree())
                + "|" + getScoreCriteria();
    }

    /**
     * Desc: toString method
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:06
     */
    @Override
    public String toString() {
        return "Test{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", difficultyDegree=" + difficultyDegree +
                ", scoreCriteria='" + scoreCriteria + '\'' +
                '}';
    }
}
