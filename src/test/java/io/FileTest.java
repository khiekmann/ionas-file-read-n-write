package io;

import java.io.File;

import org.junit.Test;

import eris.Eris;

import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * Testing behavior of external class
 *
 */
public class FileTest
{
	@Test
	public void create_failOnFilenameIsNull() throws  Exception
	{
		// arrange
		String expectedErrorMessage = "class java.lang.NullPointerException null";
		String filenameIsNull = null;
		String actualErrorMessage = null;

		// act
		try {
			new File(filenameIsNull);
		} catch (NullPointerException e) {
			actualErrorMessage = Eris.concatenateClassAndMessage(e);
		}

		// assert
		assertEquals(expectedErrorMessage, actualErrorMessage);
	}
}
