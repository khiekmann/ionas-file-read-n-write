package eris;

/**
 * Created by HiekmaHe on 09.11.2016.
 *
 * Helper test methods outsourced here.
 *
 * Ever inspection and adaptation.
 *
 * Eris, the godess of discordia.
 *
 */
public class Eris
{
	public static final String FILEDELETIONONWINDOWS = "File deletion sometimes fails on Windows.";

	public static String concatenateClassAndMessage(Throwable t)
	{
		return t.getClass() + " " + t.getMessage();
	}
}
