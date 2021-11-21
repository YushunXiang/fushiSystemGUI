package IO;

import examPaperCatalog.TestDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Desc: A public interface
 * @see TestDatabase
 * @author Yushun Xiang
 * @date 2021/11/8 16:11
 */
public interface FushiTestDatabaseLoader {

    /**
     * Desc: A abstract class
     * @param fileName
     * @return {@link TestDatabase}
     * @author Yushun Xiang
     * @date 2021/11/8 16:14
     */
    TestDatabase loadTestDatabase(String fileName) throws IOException, FileNotFoundException, DataFormatException;
}
