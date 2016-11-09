package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 */
public class WrappedBufferedReaderTest
{
	private File file;
	private WrappedBufferedReader reader;
	private String expectedReadLine = "WrappedBufferedReaderTest";

	@Before
	public void before() throws Exception
	{
		String filename = "src/test/resources/WrappedBufferedReaderTest";
		file = new File(filename);
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(expectedReadLine);
		bufferedWriter.close();
		reader = new WrappedBufferedReader(file);
	}

	@After
	public void after() throws Exception {
		reader.close();
		file.deleteOnExit();
	}

	@Test
	public void readLine() throws Exception
	{
		// arrange

		// act
		String actualReadLine = reader.readLine();
		reader.close();

		// assert
		assertEquals(expectedReadLine, actualReadLine);
	}

	@Test
	public void close() throws Exception
	{
		// arrange

		// act
		reader.close();

		// assert
	}

	@Test
	public void close_failOnReadAfterClose() throws Exception
	{
		// arrange
		String expectedExceptionMessage = "class java.io.IOException Stream closed";
		String actualExceptionMessage = "";

		// act
		reader.readLine();
		reader.close();
		try {
			reader.readLine();
		} catch(Throwable t) {
			actualExceptionMessage = Eris.concatenateClassAndMessage(t);
		}

		// assert
		assertEquals(expectedExceptionMessage, actualExceptionMessage);
	}
}