package io;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertTrue;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class DeleteOnWindowsFailsTest
{
	private String PATH = "src/test/resources/DeleteOnWindowsFailsTest.";

	@Test
	public void delete_Writer() throws Exception
	{
		// arrange
		String filename = PATH + "close";
		File file = new File(filename);
		CommonsOfReaderAndWriter commons = new StringFileWriter(file);

		// act
		boolean isDeleted = commons.delete();

		// assert
		assertTrue(Eris.FILEDELETIONONWINDOWS, isDeleted);
	}

	@Test
	public void delete_Reader() throws Exception
	{
		// arrange
		String filename = PATH + "close";
		File file = new File(filename);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(filename);
		fileWriter.flush();
		fileWriter.close();
		CommonsOfReaderAndWriter commons = new StringFileReader(file);

		// act
		boolean isDeleted = commons.delete();

		// assert
		assertTrue(isDeleted);
	}
}