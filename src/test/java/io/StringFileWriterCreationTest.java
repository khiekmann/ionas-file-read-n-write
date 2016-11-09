package io;

import java.io.File;

import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class StringFileWriterCreationTest
{

	private static final String PATH = "src/test/resources/StringFileWriterCreationTest.";

	@Test
	public void create() throws Exception {
		// arrange
		String filename = PATH + "create";
		File file = new File(filename);

		// act
		StringFileWriter writer = new StringFileWriter(file);

		// assert
		assertNotNull(writer);
	}

	@Test
	public void create_failOnFileEqualsNull() throws  Exception
	{
		// arrange
		String expectedErrorMessage = "class java.lang.AssertionError null";
		String actualErrorMessage = null;

		// act
		try {
			new StringFileWriter(null);
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
			new StringFileWriter(new File(""));
		} catch (FileNameIsEmptyException e) {
			actualErrorMessage = Eris.concatenateClassAndMessage(e);
		}

		// assert
		assertEquals(expectedErrorMessage, actualErrorMessage);
	}
}