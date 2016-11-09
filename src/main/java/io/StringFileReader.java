package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * SRP: Reading files and returning list of Strings
 *
 */
public class StringFileReader extends CommonsOfReaderAndWriter
{
	private WrappedBufferedReader reader;

	public StringFileReader(File fileToBeAsserted) throws IOException
	{
		assertThenSetFile(fileToBeAsserted);
		initializeBuffered();
	}

	@Override
	public void assertFile(File fileToBeAsserted) throws IOException
	{
		super.assertFile(fileToBeAsserted);
		throwExceptionIfFileDoesNotExist(fileToBeAsserted);
	}

	private void throwExceptionIfFileDoesNotExist(File fileToBeAsserted) throws FileNotFoundException
	{
		if (! fileToBeAsserted.exists()) {
			throw new FileNotFoundException(fileToBeAsserted.getAbsolutePath() + " does not exist");
		}
	}

	@Override
	public void initializeBuffered() throws IOException
	{
		reader = createBufferedReader();
	}

	@Override
	public void close() throws IOException
	{
		reader.close();
	}

	public String getFirstLine() throws IOException
	{
		String firstLine = reader.readLine();
		reset();
		return firstLine;
	}

	public Collection<String> getAllLines() throws IOException
	{
		Collection<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		while (line != null) {
			lines.add(line);
			line = reader.readLine();
		}
		reset();
		return lines;
	}

	private void reset() throws IOException
	{
		reader.close();
		this.initializeBuffered();
	}
}