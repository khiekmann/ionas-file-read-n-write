package io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 */
public class StringFileWriterTest
{
	private String filename;
	private File file;
	private StringFileWriter writer;
	private String expectedMessage = this.getClass().getCanonicalName();
	private Collection<String> messages;

	@Before
	public void before() throws Exception
	{
		filename = "src/test/resources/StringFileReaderTest.before";
		file = new File(filename);
		writer = new StringFileWriter(file);
		messages = new ArrayList<String>();
		messages.add(expectedMessage + "1");
		messages.add(expectedMessage + "2");
		messages.add(expectedMessage + "3");
	}

	@After
	public void after() throws Exception
	{
		writer.close();
		writer = null;
		file.deleteOnExit();
	}

	@Test
	public void write_Message() throws Exception
	{
		// arrange

		// act
		writer.write(expectedMessage);

		// assert
	}

	@Test
	public void writeAndClose() throws Exception
	{
		// arrange

		// act
		writer.writeAndClose(expectedMessage);

		// assert
	}

	@Test
	public void close() throws Exception
	{
		// arrange

		// act
		writer.write(expectedMessage);
		writer.close();

		// assert
	}

	@Test
	public void delete() throws Exception {
		// arrange

		// act
		writer.delete();

		// assert
	}
}