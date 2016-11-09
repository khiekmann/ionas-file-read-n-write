package io;

import org.junit.*;
import testframe.DataForObjectCreation;
import testframe.TestContext;
import testframe.TestHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * Functionality tests for Writer
 */
public class WriterTest {

    private static TestContext context = new TestContext("src/test/resources/", "WriterTest");

    @BeforeClass
    public static void beforeClass(){
        try {
            context.writeLargeFileIfNotExist();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void beforeTest() {
        context.reset();
    }

    @After
    public void afterTest(){
        context.deleteFile();
        context.reset();
    }

    @AfterClass
    public static void tearDown() {
        context.deleteLargeFile();
        context = null;
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
    public void createWriter_Fail_FilenameNull() throws IOException {
        // arrange
        DataForObjectCreation creation = new DataForObjectCreation(Writer.class, File.class);

        // act
        boolean isFilenameNullCaught = TestHelper.isExpectedExceptionThrownDuringCreation(new NullPointerException(), creation);

        // assert
        assertTrue(isFilenameNullCaught);
    }

    @Test
    public void createWriter_Fail_FilenameEmpty() throws IOException {
        // arrange
        DataForObjectCreation creation = new DataForObjectCreation(Writer.class, File.class, new File(""));

        // act
        boolean filenameEmptyCaught = TestHelper.isExpectedExceptionThrownDuringCreation(new FileNotFoundException(), creation);

        // assert
        assertTrue(filenameEmptyCaught);
    }

    @Test
    public void equalsFilename() throws IOException {
        // arrange
        context.createNewFile("equalsFilename");

        // act
        Writer writer = new Writer(context.getFile());

        // assert
        assertNotNull(writer);
        assertEquals(context.getAbsolutePath(), writer.getAbsolutePath());
    }

    @Test
    public void writeToFile() throws IOException {
        // arrange
        context.createNewFile("testWriteToFile");
        Writer writer = new Writer(context.getFile());
        context.addToEmptyList("hello world");
        writer.write(context.getList());
        Reader reader = new Reader(context.getFile());

        // act
        reader.readAllLines();

        // assert
        assertNotNull(writer);
        assertEquals(context.getList(), reader.getAllReadLinesAsList());
    }
}