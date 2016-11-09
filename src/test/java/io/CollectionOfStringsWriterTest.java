package io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class CollectionOfStringsWriterTest
{
	private File file;
	private CollectionOfStringsWriter writer;
	private String expectedMessage = this.getClass().getCanonicalName();
	private Collection<String> messages;

	@Before
	public void before() throws Exception
	{
		String filename = "src/test/resources/MessageAndMessagesWriterTest.before";
		file = new File(filename);
		writer = new CollectionOfStringsWriter(file);
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
	public void write() throws Exception
	{
		// arrange

		// act
		writer.write(messages);

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
}