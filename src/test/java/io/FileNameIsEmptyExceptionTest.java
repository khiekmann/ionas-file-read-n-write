package io;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Created by HiekmaHe on 09.11.2016.
 */
public class FileNameIsEmptyExceptionTest
{
	@Test
	public void create() {
		// arrange

		// act
		FileNotFoundException exception = new FileNotFoundException();

		// assert
	}

	@Test
	public void instanceOfIOException() {
		// arrange

		// act
		FileNotFoundException exception = new FileNotFoundException();

		// assert
		assertTrue(exception instanceof IOException);
	}

}