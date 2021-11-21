package examPaperCatalog;

/**
 * Desc: A public class which extends Test
 * @see Test
 * @author Yushun Xiang
 * @date 2021/10/17 9:07
 */
public class MathTest extends Test{
    private String photoURL;
    private String calculationProcess;

    /**
     * Desc:
     * @param code
     * @param title
     * @param difficultyDegree
     * @param scoreCriteria
     * @param photoURL
     * @param calculationProcess
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:49
     */
    public MathTest(String code,
                    String title,
                    int difficultyDegree,
                    String scoreCriteria,
                    String photoURL,
                    String calculationProcess) {

        this.setCode(code);
        this.setTitle(title);
        this.setDifficultyDegree(difficultyDegree);
        this.setScoreCriteria(scoreCriteria);
        this.photoURL = photoURL;
        this.calculationProcess = calculationProcess;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:49
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public String getCalculationProcess() {
        return calculationProcess;
    }

    /**
     * Desc:
     * @param photoURL
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /**
     * Desc:
     * @param calculationProcess
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public void setCalculationProcess(String calculationProcess) {
        this.calculationProcess = calculationProcess;
    }

    /**
     * Desc: A method return test information in a specific form (HTML).
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:12
     */
    @Override
    public String toHTMLString() {

        return getCode()
                + "|" + getTitle()
                + "|" + String.valueOf(getDifficultyDegree())
                + "|" + getScoreCriteria()
                + "|" + getPhotoURL()
                + "|" + getCalculationProcess();
    }

    /**
     * Desc: toString method
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:12
     */
    @Override
    public String toString() {
        return "MathTest{" +
                "photoURL='" + photoURL + '\'' +
                ", calculationProcess='" + calculationProcess + '\'' +
                '}' + super.toString();
    }
}
