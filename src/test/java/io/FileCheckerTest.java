package io;

import org.junit.Test;
import testframe.TestContext;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by HiekmaHe on 02.11.2016.
 *
 *
 */
public class FileCheckerTest {

    private static TestContext context = new TestContext("src/test/resources/", "FileCheckerTest");

    @Test
    public void deleteFile() throws IOException {
        // arrange
        context.createNewFile("deleteFile");
        Writer writer = new Writer(context.getFile());

        // act
        boolean isDeleted = writer.delete();

        // assert
        assertTrue("File expected to be deleted. Fails on Windows sometimes.", isDeleted);
    }
}
