package revise;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import io.StringFileReader;
import io.StringFileWriter;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by HiekmaHe on 25.10.2016.
 */
public class ReaderPerformanceTest {

    private static final long ONE_SECOND_IN_NANOS = 1000000000;
    private static final String FILENAMELARGE = "src/test/resources/ReaderPerformanceTest.beforeClass";

    @BeforeClass
    public static void beforeClass() throws IOException {
        String filename = FILENAMELARGE;
        File file = new File(filename);
        if (!file.exists()) {
            StringFileWriter writer = new StringFileWriter(file);
            int max = 1000000;
            for ( int i = 0; i < max; i++) {
                writer.write("Text" + i + ".N");
            }
            writer.close();
        }
    }

    @Test
    public void testReaderPerformanceReadLine() throws IOException {
        // arrange
        String filename = FILENAMELARGE;
        File file = new File(filename);
        long timestampStart;
        StringFileReader reader = null;
        try {
            reader = new StringFileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timestampEnd;
        long timeDelta;

        // act
        timestampStart = System.nanoTime();
//        reader.readOneLine();
        timestampEnd = System.nanoTime();
        timeDelta = timestampEnd - timestampStart;

        // assert
        assertTrue(timeDelta < ONE_SECOND_IN_NANOS);
    }

    @Test
    public void testReaderPerformanceReadAllLinesThenReset() {
        // arrange
        String filename = FILENAMELARGE;
        File file = new File(filename);
        long timestampStart;
        StringFileReader reader = null;
        try {
            reader = new StringFileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timestampEnd;
        long timeDelta;

        // act
        timestampStart = System.nanoTime();
/*        try {
            reader.readAllLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/        timestampEnd = System.nanoTime();
        timeDelta = timestampEnd - timestampStart;

        // assert
        assertTrue(timeDelta < ONE_SECOND_IN_NANOS);
    }
}