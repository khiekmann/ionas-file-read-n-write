package io;

import java.io.File;

import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 */
public class CommonsOfReaderAndWriter_Writer_Test
{
	private static final String PATH = "src/test/resources/CommonsOfReaderAndWriterTest.";

	@Test
	public void assertThenSetFile() throws Exception
	{
		// arrange
		String filename = PATH + "assertThenSetFile";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		commons.assertThenSetFile(file);

		// assert
		assertEquals(file, commons.getFile());
	}

	@Test
	public void assertFile() throws Exception
	{
		// arrange
		String filename = PATH + "assertFile";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		commons.assertFile(file);

		// assert
	}

	@Test
	public void setFile() throws Exception
	{
		// arrange
		String filename = PATH + "setFile";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		commons.setFile(file);

		// assert
		assertEquals(file, commons.getFile());
	}

	@Test
	public void getFile() throws Exception
	{
		// arrange
		String filename = PATH + "getFile";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		commons.setFile(file);

		// assert
		assertEquals(file, commons.getFile());
	}

	@Test
	public void assertFileNotNull() throws Exception
	{
		// arrange
		String expectedExceptionMessage = "class java.lang.AssertionError null";
		String actualExceptionMessage = "";

		// act
		try {
			new StringFileWriter(null);
		} catch (Throwable t) {
			actualExceptionMessage = Eris.concatenateClassAndMessage(t);
		}

		// assert
		assertEquals(expectedExceptionMessage, actualExceptionMessage);
	}

	@Test
	public void throwExceptionIfFilenameIsEmpty() throws Exception
	{
		// arrange
		String expectedExceptionMessage = "class io.FileNameIsEmptyException null";
		String actualExceptionMessage = "";

		// act
		try {
			new StringFileWriter(new File(""));
		} catch (Throwable t) {
			actualExceptionMessage = Eris.concatenateClassAndMessage(t);
		}

		// assert
		assertEquals(expectedExceptionMessage, actualExceptionMessage);
	}

	@Test
	public void initializeBuffered() throws Exception
	{
		// arrange
		String filename = PATH + "initializeBuffered";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		StringFileWriter writer = (StringFileWriter) commons;
		writer.writeAndClose(filename); // must have used the initialized buffer

		// assert
	}

	@Test
	public void close() throws Exception
	{
		// arrange
		String filename = PATH + "close";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		commons.close();

		// assert
	}

	@Test
	public void createBufferedWriter() throws Exception
	{
		// arrange
		String filename = PATH + "initializeBuffered";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		StringFileWriter writer = (StringFileWriter) commons;
		writer.writeAndClose(filename); // must have created the initialized buffer

		// assert
	}
}