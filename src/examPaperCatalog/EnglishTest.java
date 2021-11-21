package examPaperCatalog;

/**
 * Desc: A public class which extends Test
 * @see Test
 * @author Yushun Xiang
 * @date 2021/10/17 9:07
 */
public class EnglishTest extends Test{
    private String type;

    /**
     * Desc:
     * @param code
     * @param title
     * @param difficultyDegree
     * @param scoreCriteria
     * @param type
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:43
     */
    public EnglishTest(String code,
                       String title,
                       int difficultyDegree,
                       String scoreCriteria,
                       String type) {

        this.setCode(code);
        this.setTitle(title);
        this.setDifficultyDegree(difficultyDegree);
        this.setScoreCriteria(scoreCriteria);
        this.type = type;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:43
     */
    public String getType() {
        return type;
    }

    /**
     * Desc:
     * @param type
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:43
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Desc: A method return test information in a specific form (HTML).
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:13
     */
    @Override
    public String toHTMLString() {

        return getCode()
                + "|" + getTitle()
                + "|" + String.valueOf(getDifficultyDegree())
                + "|" + getScoreCriteria()
                + "|" + getType();
    }

    @Override
    public String toString() {
        return "EnglishTest{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
