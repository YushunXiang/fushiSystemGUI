package examPaperCatalog;

/**
 * Desc: a test with score
 * @see Test
 * @author Yushun Xiang
 * @date 2021/10/17 9:05
 */
public class TestItem {
    private double score;
    private Test test;

    /**
     * Desc:
     * @param test
     * @param score
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:54
     */
    public TestItem(Test test, double score) {
        this.test = test;
        this.score = score;
    }

    /**
     * Desc:
     * @param
     * @return {@link double}
     * @author Yushun Xiang
     * @date 2021/10/17 8:54
     */
    public double getScore() {
        return score;
    }

    /**
     * Desc:
     * @param score
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:54
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Desc:
     * @param
     * @return {@link Test}
     * @author Yushun Xiang
     * @date 2021/10/17 8:54
     */
    public Test getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "TestItem{" +
                "score=" + score +
                ", test=" + test +
                '}';
    }
}
