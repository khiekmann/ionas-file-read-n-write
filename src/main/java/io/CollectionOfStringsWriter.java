package io;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * SRP: writing a list of messages to a file.
 */
public class CollectionOfStringsWriter
{

	private static final String LINESEPARATOR = System.getProperty("line.separator");
	private StringFileWriter writer;

	public CollectionOfStringsWriter(File fileToBeAsserted) throws IOException
	{
		writer = new StringFileWriter(fileToBeAsserted);
	}

    public void write(Collection<String> messages) throws IOException {
		 for (String message : messages) {
			 writer.write(message + LINESEPARATOR);
		 }
    }

    public void close() throws IOException
	 {
		 writer.close();
	 }
}