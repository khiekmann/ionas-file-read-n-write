package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.*;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 */
public class StringFileReaderTest
{
	private static String LINESEPARATOR = System.getProperty("line.separator");

	private String filename;
	private File file;
	private StringFileReader reader;

	@Before
	public void before() throws Exception
	{
		filename = "src/test/resources/StringFileReaderTest.before";
		file = new File(filename);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(filename);
		reader = new StringFileReader(file);
	}

	@After
	public void after() throws Exception
	{
		reader.close();
		reader = null;
		file.deleteOnExit();
	}

	@Test
	public void throwExceptionIfFileDoesNotExist() throws Exception
	{
		// arrange
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(filename);
		StringFileReader reader = new StringFileReader(file);

		// act
		reader.throwExceptionIfFilenameIsEmpty(file);

		// assert
	}

	@Test
	public void throwExceptionIfFileDoesNotExist_Thrown() throws Exception
	{
		// arrange
		File fileWithEmptyFilename = new File("");
		String expectedMessage = "class io.FileNameIsEmptyException null";
		String actualErrorMessage = "";

		// act
		try {
			StringFileReader reader = new StringFileReader(fileWithEmptyFilename);
			reader.throwExceptionIfFilenameIsEmpty(fileWithEmptyFilename);
		} catch (FileNameIsEmptyException e) {
			actualErrorMessage = Eris.concatenateClassAndMessage(e);
		}

		// assert
		assertEquals(expectedMessage, actualErrorMessage);
	}

	@Test
	public void getFirstLine() throws IOException
	{
		// arrange
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(filename);
		fileWriter.flush();
		fileWriter.close();
		String actualFirstLine;

		// act
		StringFileReader reader = new StringFileReader(file);
		actualFirstLine = reader.getFirstLine();

		// assert
		assertEquals(filename, actualFirstLine);
	}

	@Test
	public void getFirstLine_Twice() throws IOException
	{
		// arrange
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(filename);
		fileWriter.flush();
		fileWriter.close();

		// act
		StringFileReader reader = new StringFileReader(file);
		String firstGottenFirstLine = reader.getFirstLine();
		String secondGottenFirstLine = reader.getFirstLine();

		// assert
		assertEquals(firstGottenFirstLine, secondGottenFirstLine);
	}

	@Test
	public void getAllLines() throws IOException
	{
		// arrange
		Collection<String> expectedLines = new ArrayList<String>();
		expectedLines.add(filename);
		expectedLines.add(filename);
		expectedLines.add(filename);
		File file = new File(filename);
		FileWriter fileWriter = new FileWriter(file);
		for (String line : expectedLines) {
			fileWriter.write(line + LINESEPARATOR);
		}
		fileWriter.flush();
		fileWriter.close();
		StringFileReader reader = new StringFileReader(file);

		// act
		Collection<String> actualLines = reader.getAllLines();

		// assert
		assertArrayEquals(expectedLines.toArray(), actualLines.toArray());
	}

	@Test
	public void getAllLines_Twice() throws IOException
	{
		// arrange
		Collection<String> expectedLines = new ArrayList<String>();
		expectedLines.add(filename);
		expectedLines.add(filename);
		expectedLines.add(filename);
		FileWriter fileWriter = new FileWriter(file);
		for (String line : expectedLines) {
			fileWriter.write(line + LINESEPARATOR);
		}
		fileWriter.flush();
		fileWriter.close();
		StringFileReader reader = new StringFileReader(file);

		// act
		Collection<String> firstGottenLines = reader.getAllLines();
		Collection<String> secondGottenLines = reader.getAllLines();

		// assert
		assertArrayEquals(firstGottenLines.toArray(), secondGottenLines.toArray());
	}

	@Test
	public void assertFile() throws Exception
	{
		// arrange
		boolean nothingThrown = true;

		// act
		try {
			reader.assertFile(file);
		} catch (Throwable throwable) {
			nothingThrown = false;
		}

		// assert
		assertTrue(nothingThrown);
	}

	@Test
	public void assertFile_Thrown() throws Exception
	{
		// arrange
		String filenameFail = "hakune matata";
		File fileFail = new File(filenameFail);
		StringFileReader reader = new StringFileReader(file);
		String actualMessage = "";

		// act
		try {
			reader.assertFile(fileFail);
		} catch(Throwable throwable) {
			actualMessage = Eris.concatenateClassAndMessage(throwable);
		}

		// assert
		assertTrue(actualMessage.contains("FileNotFoundException"));
	}

	@Test
	public void initializeBuffered() throws Exception
	{
		// arrange
		String filenameFail = "hakuna matata";
		File fileFail = new File(filenameFail);
		StringFileReader reader = new StringFileReader(file);
		String actualMessage ="";

		// act
		try {
			reader.assertFile(fileFail);
		} catch(Throwable throwable) {
			actualMessage = Eris.concatenateClassAndMessage(throwable);
		}

		// assert
		assertTrue(actualMessage.contains("FileNotFoundException"));
	}

	@Test
	public void close() throws Exception
	{
		// arrange
		StringFileReader reader = new StringFileReader(file);

		// act

		// assert

	}
}