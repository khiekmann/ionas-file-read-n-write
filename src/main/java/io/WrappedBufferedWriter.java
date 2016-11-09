package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * SRP: Wrapping the Buffered Writer to encapsulate not needed functionality.
 */
public class WrappedBufferedWriter
{
	private final BufferedWriter bufferedWriter;

	public WrappedBufferedWriter(File file) throws IOException
	{
		FileWriter fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);
	}

	public void write(String message) throws IOException
	{
		bufferedWriter.write(message);
	}

	public void flush() throws IOException
	{
		bufferedWriter.flush();
	}

	public void close() throws IOException
	{
		bufferedWriter.close();
	}
}