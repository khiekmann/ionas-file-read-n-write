package io;

import org.junit.*;
import testframe.DataForObjectCreation;
import testframe.TestContext;
import testframe.TestHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * Testing Reader
 */
public class ReaderTest {

    private static final TestContext context = new TestContext("src/test/resources/", "ReaderTest");

    @BeforeClass
    public static void beforeClass(){
        try {
            context.writeLargeFileIfNotExist();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeTest() { }

    @After
    public void afterTest(){
    }

    @AfterClass
    public static void tearDown() {
        boolean isDeleted = context.deleteLargeFile();
        assertTrue(context.getLargeFilePath() + " expected to be deleted. Fails sometimes on Windows.", isDeleted);
    }

    @Test
    public void createWriter() throws IOException {
        // arrange
        context.createNewFile("testCreateWriter");

        // act
        Writer writer = new Writer(context.getFile());

        // assert
        assertNotNull(writer);
    }

    @Test
    public void createReader_Fail_FilenameNull() {
        // arrange
        DataForObjectCreation creation = new DataForObjectCreation(Reader.class, File.class); // TODO: Understand InvokeTargetException

        // act
        boolean isFilenameNullCaught = TestHelper.isExpectedExceptionThrownDuringCreation(new NullPointerException(), creation);

        // assert
        assertTrue("Filename is expected to be null and caught.", isFilenameNullCaught);
    }

    @Test
    public void createReader_Fail_FilenameEmpty() throws IOException {
        // arrange
        DataForObjectCreation creation = new DataForObjectCreation(Reader.class, File.class, new File(""));

        // act
        boolean isFilenameEmptyCaught = TestHelper.isExpectedExceptionThrownDuringCreation(new FileNotFoundException(), creation);

        // assert
        assertTrue("Filename is expected to be empty and caught.", isFilenameEmptyCaught);
    }


    @Test
    public void equalsAbsolutePath() throws IOException {
        // arrange
        context.createNewFile("testAbsolutePath");
        Writer writer = new Writer(context.getFile());
        Reader reader = new Reader(context.getFile());
        String expectedFilename = context.getFile().getAbsolutePath();

        // act
        String actualFilename = reader.getAbsolutePath();
        writer.delete();

        // assert
        assertEquals(expectedFilename, actualFilename);
    }

    @Test
    public void countLines_EmptyFile() throws IOException {
        // arrange
        context.createNewFile("countLines_EmptyFile");
        Reader reader = new Reader(context.getFile());
        long expectedLineCount = 0;

        // act
        reader.countLines();
        long actualLineCount = reader.getLineCount();

        // assert
        assertEquals(expectedLineCount, actualLineCount);
    }

    @Test
    public void countLines_LargeFile() throws IOException {
        // arrange
        context.createNewFile("countLines_LargeFile");
        Reader reader = new Reader(context.getLargeFile());

        // act
        reader.countLines();
        long actualLineCount = reader.getLineCount();

        // assert
        assertEquals(context.getLargeFileLineCount(), actualLineCount);
    }
}