package io;

import java.io.*;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * SRP: Wrapping BufferedReader to capsulate unwanted methods.
 */
public class WrappedBufferedReader
{
	private final BufferedReader bufferedReader;

	public WrappedBufferedReader(File file) throws IOException
	{
		FileReader fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
	}

	public String readLine() throws IOException
	{
		return bufferedReader.readLine();
	}

	public void close() throws IOException
	{
		bufferedReader.close();
	}
}
