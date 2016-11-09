package io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 */
@RunWith(Parameterized.class)
public class CommonsOfReaderAndWriterTest
{

	private static final String PATH = "src/test/resources/CommonsOfReaderAndWriterTest.Parameterized";
	private static File file = new File(PATH);

	@Parameterized.Parameters( name = "{index}: {0}, {1}" )
	public static Collection<Object[]> commons() throws IOException
	{
		return Arrays.asList(new Object[][] {
				{new StringFileWriter(file), file},
				{new StringFileReader(file), file}
		});
	}

	@Parameterized.Parameter
	public CommonsOfReaderAndWriter oneCommon;

	@Parameterized.Parameter(value = 1)
	public File gottenFile;


	@Test
	public void assertThenSetFile() throws Exception
	{
		// arrange

		// act

		// assert
		assertEquals(gottenFile, oneCommon.getFile());
	}

	@Test
	public void assertThenSetFile_old() throws Exception
	{
		// arrange

		// act
		oneCommon.assertThenSetFile(file);

		// assert
	}

	@Test
	public void assertFile() throws Exception
	{
		// arrange

		// act
		oneCommon.assertFile(file);

		// assert
	}

	@Test
	public void setFile() throws Exception
	{
		// arrange

		// act
		oneCommon.setFile(file);

		// assert
		assertEquals(file, oneCommon.getFile());
	}

	@Test
	public void getFile() throws Exception
	{
		// arrange

		// act
		oneCommon.setFile(file);

		// assert
		assertEquals(file, oneCommon.getFile());
	}
}