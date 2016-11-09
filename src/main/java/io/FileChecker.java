package io;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by HiekmaHe on 02.11.2016.
 */
public abstract class FileChecker {

    private File file;

    public File getFile() {
        return file;
    }

    public String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    public void setFileIfExistsElseException(File inFile) throws FileNotFoundException {
        if (!inFile.getName().isEmpty()) {
            file = inFile;
        } else {
            throw new FileNotFoundException("File '" + inFile.getAbsolutePath() + "' is empty filename.");
        }
    }

    public boolean delete() {
        return file.delete();
    }
}
