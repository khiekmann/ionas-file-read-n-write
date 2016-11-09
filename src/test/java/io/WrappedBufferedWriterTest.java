package io;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class WrappedBufferedWriterTest
{
	private String PATH = "src/test/resources/WrappedBufferedWriterTest.";
	private File file;
	private WrappedBufferedWriter writer;
	private String message = this.getClass().getCanonicalName();

	@Before
	public void before() throws Exception
	{
		file = new File(PATH + ".before");
		writer = new WrappedBufferedWriter(file);
	}

	@After
	public void after() throws Exception {
		writer.close();
		file.deleteOnExit();
	}

	@Test
	public void write_OneLine() throws Exception
	{
		// arrange

		// act
		writer.write(message);

		// assert
	}

	@Test
	public void flush() throws Exception
	{
		// arrange

		// act
		writer.flush();

		// assert
	}

	@Test
	public void close() throws Exception
	{
		// arrange

		// act
		writer.close();

		// assert
	}

	@Test
	public void close_failOnWriteAfter() throws Exception
	{
		// arrange
		final String expectedExceptionMessage = "class java.io.IOException Stream closed";
		String actualExceptionMessage = null;

		// act
		writer.close();
		try {
			writer.write(message);
		} catch(IOException e) {
			actualExceptionMessage = Eris.concatenateClassAndMessage(e);;
		}

		// assert
		assertEquals(expectedExceptionMessage, actualExceptionMessage);
	}
}