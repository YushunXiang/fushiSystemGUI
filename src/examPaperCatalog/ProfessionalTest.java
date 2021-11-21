package examPaperCatalog;

/**
 * Desc: A public class which extends Test
 * @see Test
 * @author Yushun Xiang
 * @date 2021/10/17 9:07
 */
public class ProfessionalTest extends Test{
    private String programInstruction;
    private String programming;
    private String photoURL;

    /**
     * Desc:
     * @param code
     * @param title
     * @param difficultyDegree
     * @param scoreCriteria
     * @param programInstruction
     * @param programming
     * @param photoURL
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public ProfessionalTest(String code,
                            String title,
                            int difficultyDegree,
                            String scoreCriteria,
                            String programInstruction,
                            String programming,
                            String photoURL) {

        this.setCode(code);
        this.setTitle(title);
        this.setDifficultyDegree(difficultyDegree);
        this.setScoreCriteria(scoreCriteria);
        this.programInstruction = programInstruction;
        this.programming = programming;
        this.photoURL = photoURL;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/8 17:29
     */
    public String getProgramInstruction() {
        return programInstruction;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public String getProgramming() {
        return programming;
    }

    /**
     * Desc:
     * @param
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * Desc:
     * @param programInstruction
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public void setProgramInstruction(String programInstruction) {
        this.programInstruction = programInstruction;
    }

    /**
     * Desc:
     * @param programming
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:50
     */
    public void setProgramming(String programming) {
        this.programming = programming;
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
     * Desc: A method return test information in a specific form (HTML).
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:10
     */
    @Override
    public String toHTMLString() {

        return getCode()
                + "|" + getTitle()
                + "|" + String.valueOf(getDifficultyDegree())
                + "|" + getScoreCriteria()
                + "|" + getProgramInstruction()
                + "|" + getProgramming()
                + "|" + getPhotoURL();
    }

    /**
     * Desc: toString method
     * @return {@link String}
     * @author Yushun Xiang
     * @date 2021/11/9 19:11
     */
    @Override
    public String toString() {
        return "ProfessionalTest{" +
                "programInstruction='" + programInstruction + '\'' +
                ", programming='" + programming + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}' + super.toString();
    }
}