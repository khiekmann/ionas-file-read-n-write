package io;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * SRP: not yet
 * collectiong commons
 */
public abstract class CommonsOfReaderAndWriter implements Closeable
{
	private File file;

	public void assertThenSetFile(File fileToBeAsserted) throws IOException
	{
		assertFile(fileToBeAsserted);
		setFile(fileToBeAsserted);
	}

	public void assertFile(File fileToBeAsserted) throws IOException
	{
		assertFileNotNull(fileToBeAsserted);
		throwExceptionIfFilenameIsEmpty(fileToBeAsserted);
	}

	public void setFile(File fileToSet) {
		file = fileToSet;
	}

	public File getFile()
	{
		return file;
	}

	public void assertFileNotNull(File fileToBeAsserted)
	{
		assert fileToBeAsserted != null;
	}

	public void throwExceptionIfFilenameIsEmpty(File fileToBeAsserted) throws FileNameIsEmptyException
	{
		if (fileToBeAsserted.getName().equals("")) {
			throw new FileNameIsEmptyException();
		}
	}

	public abstract void initializeBuffered() throws IOException;

	public abstract void close() throws IOException;

	public boolean delete()
	{
		return file.delete();
	}

	public WrappedBufferedReader createBufferedReader() throws IOException
	{
		return new WrappedBufferedReader(file);
	}

	public WrappedBufferedWriter createBufferedWriter() throws IOException
	{
		return new WrappedBufferedWriter(file);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
