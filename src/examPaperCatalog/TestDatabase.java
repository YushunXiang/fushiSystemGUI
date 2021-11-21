package examPaperCatalog;

import java.util.Vector;
import java.util.Iterator;

/**
 * Desc: A database which contains exam papers.
 * @see Test
 * @see TestItem
 * @author Yushun Xiang
 * @date 2021/10/17 9:06
 */
public class TestDatabase implements Iterable<Test>{
    private Vector<Test> tests;

    /**
     * Desc:
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public TestDatabase() {
        tests = new Vector<Test>();
    }

    /**
     * Desc:
     * @param
     * @return {@link Iterator< Test>}
     * @author Yushun Xiang
     * @date 2021/11/9 2:31
     */
    public Iterator<Test> iterator() {
        return tests.iterator();
    }

    /**
     * Desc:
     * @param
     * @return {@link Vector< Test>}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public Vector<Test> getTests() {
        return tests;
    }

    /**
     * Desc:
     * @param test
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public void addTest(Test test) {
        tests.add(test);
    }

    /**
     * Desc:
     * @param test
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public void removeTest(Test test) {
        tests.remove(test);
    }

    /**
     * Desc:
     * @param code
     * @return {@link Test}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public Test getTest(String code) {
        for (Test test : tests) {

            if (test.getCode().equals(code)) {

                return test;
            }
        }
        return null;
    }

    /**
     * Desc:
     * @param index
     * @return {@link Test}
     * @author Yushun Xiang
     * @date 2021/10/17 8:53
     */
    public Test getTest(int index) {
        return tests.get(index);
    }

    public int getNumberOfTests() {
        return tests.size();
    }

    @Override
    public String toString() {
        return "TestDatabase{" +
                "tests=" + tests +
                '}';
    }
}
