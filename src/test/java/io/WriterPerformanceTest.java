package io;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by HiekmaHe on 25.10.2016.
 *
 */
public class WriterPerformanceTest {

    private static final long ONE_SECOND_IN_NANOS = 1000000000;

    @Test
    public void testWriterPerformanceWrite() throws IOException {
        // arrange
        String filename = "src/test/resources/testWriterPerformance";
        File file = new File(filename);
        Writer writer = new Writer(file);
        String message = "hello" + Constants.N + "world";
        long timestampStart;
        long timestampEnd;
        long timeDelta;

        // act
        timestampStart = System.nanoTime();
        writer.write(message);
        timestampEnd = System.nanoTime();
        timeDelta = timestampEnd - timestampStart;

        // assert
        assertTrue(timeDelta < ONE_SECOND_IN_NANOS);
    }
}
