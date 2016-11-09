package io;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class StringFileReaderCreationTest
{
	private static final String PATH = "src/test/resources/StringFileReaderCreationTest.";

	@Test
	public void create() throws Exception {
		// arrange
		String filename = PATH + "create";
		File file = new File(filename);
		FileWriter writer = new FileWriter(file);
		writer.write("create");
		writer.flush();
		writer.close();

		// act
		StringFileReader reader = new StringFileReader(file);

		// assert
		assertNotNull(reader);
	}

	@Test
	public void create_failOnFileEqualsNull() throws  Exception
	{
		// arrange
		String expectedErrorMessage = "class java.lang.AssertionError null";
		String actualErrorMessage = null;

		// act
		try {
			new StringFileReader(null);
		} catch (Error e) {
			actualErrorMessage = Eris.concatenateClassAndMessage(e);
		}

		// assert
		assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@Test
	public void create_failOnFilenameIsEmpty() throws  Exception
	{
		// arrange
		String expectedErrorMessage = "class io.FileNameIsEmptyException null";
		String actualErrorMessage = null;

		// act
		try {
			new StringFileReader(new File(""));
		} catch (FileNameIsEmptyException e) {
			actualErrorMessage = Eris.concatenateClassAndMessage(e);
		}

		// assert
		assertEquals(expectedErrorMessage, actualErrorMessage);
	}
}