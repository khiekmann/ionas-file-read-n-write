package io;

import java.io.File;
import java.io.IOException;


/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * Class for writing messages and lists of messages to files.
 */
public class StringFileWriter extends CommonsOfReaderAndWriter
{

	private static final String LINESEPARATOR = System.getProperty("line.separator");
	private WrappedBufferedWriter writer;

	public StringFileWriter(File fileToBeAsserted) throws IOException
	{
		assertThenSetFile(fileToBeAsserted);
		initializeBuffered();
	}

	@Override
	public void initializeBuffered() throws IOException
	{
		writer = createBufferedWriter();
	}

 	public void write(String messages) throws IOException {
		writer.write(messages);
		writer.flush();
	}

	public void writeAndClose(String message) throws IOException {
		write(message);
		close();
	}

	public void close() throws IOException
	{
		writer.close();
	}
}