package examPaperCatalog;

import java.util.Vector;
import java.util.Iterator;

/**
 * Desc: A exam paper contains 10 testItems
 * @see TestItem
 * @author Yushun Xiang
 * @date 2021/10/17 9:08
 */
public class ExamPaper implements Iterable<TestItem>{
    private Vector<TestItem> testItems;

    /**
     * Desc:
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public ExamPaper() {
        testItems = new Vector<TestItem>();
    }

    /***
     * Desc:
     * @param
     * @return {@link Iterator<TestItem>}
     * @author Yushun Xiang
     * @date 2021/11/8 11:56
     */
    public Iterator<TestItem> iterator() {
        return testItems.iterator();
    }

    /**
     * Desc:
     * @param
     * @return {@link double}
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public double getTotalScore() {
        double totalScore = 0;
        for (TestItem testItem : testItems) {

            totalScore += testItem.getScore();
        }
        return totalScore;
    }

    /**
     * Desc:
     * @param testItem
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public void addTestItem(TestItem testItem) {
        testItems.add(testItem);
    }

    /**
     * Desc:
     * @param testItem
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public void removeTestItem(TestItem testItem) {
        testItems.remove(testItem);
    }

    /**
     * Desc:
     * @param index
     * @return {@link TestItem}
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public TestItem getTestItem(int index) {
        return testItems.get(index);
    }

    /**
     * Desc:
     * @param
     * @return {@link Vector< TestItem>}
     * @author Yushun Xiang
     * @date 2021/10/24 11:17
     */
    public Vector<TestItem> getTestItems() {
        return testItems;
    }

    /**
     * Desc:
     * @param
     * @return {@link int}
     * @author Yushun Xiang
     * @date 2021/10/17 8:44
     */
    public int getNumberOfTestItems() {
        return testItems.size();
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "testItems=" + testItems +
                '}';
    }
}