package IO;

import examPaperCatalog.EnglishTest;
import examPaperCatalog.MathTest;
import examPaperCatalog.ProfessionalTest;
import examPaperCatalog.TestDatabase;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Desc: A public class which implements FushiTestDatabaseLoader
 * @see EnglishTest
 * @see MathTest
 * @see ProfessionalTest
 * @see TestDatabase
 * @author Yushun Xiang
 * @date 2021/11/8 16:13
 */
public class FileFushiTestDatabaseLoader implements FushiTestDatabaseLoader{

    /**
     * Desc: Load test database from a specified file
     * @param fileName
     * @return {@link TestDatabase}
     * @author Yushun Xiang
     * @date 2021/11/8 17:31
     */
    @Override
    public TestDatabase loadTestDatabase(String fileName) throws IOException, FileNotFoundException, DataFormatException {

        TestDatabase testDatabase = new TestDatabase();
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = input.readLine()) != null) {

            if (line.startsWith("EnglishTest") == true) {

                testDatabase.addTest(readEnglishTest(line));
            } else if (line.startsWith("MathTest") == true) {

                testDatabase.addTest(readMathTest(line));
            } else {

                if (line.startsWith("ProfessionalTest") == false) {

                    throw new DataFormatException(line);
                }
                testDatabase.addTest(readProfessionalTest(line));
            }
        }

        input.close();
        return testDatabase;
    }

    /**
     * Desc: Read English test from a line.
     * @param line
     * @return {@link EnglishTest}
     * @author Yushun Xiang
     * @date 2021/11/8 17:30
     */
    public EnglishTest readEnglishTest(String line) throws DataFormatException {

        StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() != 6) {

            throw new DataFormatException(line);
        } else {
            try {
                String TestKind = stringTokenizer.nextToken();
                String code = stringTokenizer.nextToken();
                String title = stringTokenizer.nextToken();
                int difficultyDegree = Integer.parseInt(stringTokenizer.nextToken());
                String scoreCriteria = stringTokenizer.nextToken();
                String type = stringTokenizer.nextToken();
                EnglishTest englishTest = new EnglishTest(code,
                        title,
                        difficultyDegree,
                        scoreCriteria,
                        type);
                return englishTest;
            } catch (NumberFormatException e) {

                throw new DataFormatException(line);
            }
        }
    }
    /**
     * Desc: Read math test from a line
     * @param line
     * @return {@link MathTest}
     * @author Yushun Xiang
     * @date 2021/11/8 17:30
     */
    public MathTest readMathTest(String line) throws DataFormatException {

        StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() != 7) {

            throw new DataFormatException(line);
        } else {
            try {
                String TestKind = stringTokenizer.nextToken();
                String code = stringTokenizer.nextToken();
                String title = stringTokenizer.nextToken();
                int difficultyDegree = Integer.parseInt(stringTokenizer.nextToken());
                String scoreCriteria = stringTokenizer.nextToken();
                String photoURL = stringTokenizer.nextToken();
                String calculationProcess = stringTokenizer.nextToken();
                MathTest mathTest = new MathTest(code,
                        title,
                        difficultyDegree,
                        scoreCriteria,
                        photoURL,
                        calculationProcess);
                return mathTest;
            } catch (NumberFormatException e) {

                throw new DataFormatException(line);
            }
        }
    }

    /**
     * Desc: Read professional test from a line
     * @param line
     * @return {@link ProfessionalTest}
     * @author Yushun Xiang
     * @date 2021/11/8 17:29
     */
    public ProfessionalTest readProfessionalTest(String line) throws DataFormatException{

        StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
        if (stringTokenizer.countTokens() != 8) {

            throw new DataFormatException(line);
        } else {

            try {

                String TestKind = stringTokenizer.nextToken();
                String code = stringTokenizer.nextToken();
                String title = stringTokenizer.nextToken();
                int difficultyDegree = Integer.parseInt(stringTokenizer.nextToken());
                String scoreCriteria = stringTokenizer.nextToken();
                String programInstruction = stringTokenizer.nextToken();
                String programming = stringTokenizer.nextToken();
                String photoURL = stringTokenizer.nextToken();
                ProfessionalTest professionalTest = new ProfessionalTest(code,
                        title,
                        difficultyDegree,
                        scoreCriteria,
                        programInstruction,
                        programming,
                        photoURL);
                return professionalTest;
            } catch (NumberFormatException e) {

                throw new DataFormatException(line);
            }
        }
    }
}
