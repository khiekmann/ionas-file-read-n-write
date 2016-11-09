package revise;

import java.io.File;
import java.io.IOException;

import io.StringFileWriter;


/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * Test supporting functionality
 *
 */
public class TestHelper {

	private String testfolder;

	public TestHelper(String folder) {
		assert folder != null;
		testfolder = folder;
	}

	public File createFile(String filename)
	{
		assert filename != null;
		return new File(testfolder + filename);
	}

	public boolean tearDown()
	{
		File folder = createFile("");
		return folder.delete();
	}

	public StringFileWriter createWriterOrExit(String filename)
	{
		StringFileWriter writer = null;
		try {
			writer = new StringFileWriter(createFile(filename));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return writer;
	}
}