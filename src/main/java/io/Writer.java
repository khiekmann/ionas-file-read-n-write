package io;

import java.io.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * Class for writing to and reading from files.
 */
public class Writer extends FileChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);
    private BufferedWriter writer;

    public Writer(File inFile) throws FileNotFoundException {
        setFileIfExistsElseException(inFile);
        initializeWriterOrLogError();
    }

    private void initializeWriterOrLogError() {
        try {
            writer = new BufferedWriter(new FileWriter(getFile()));
        } catch (IOException e) {
            logException(e);
        }
    }

    private void logException(Exception e) {
        LOGGER.error(e.getClass() + ": " + e.getLocalizedMessage());
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            logException(e);
        }
    }

    public void write(List<String> messages) throws IOException {
        for (String message : messages) {
            write(message + Constants.N);
        }
    }

    public void write(String messages) throws IOException {
        writer.write(messages);
        writer.flush();
    }


    public void writeAndClose(List<String> messages) throws IOException {
        write(messages);
        close();
    }

    public void writeThenClose(String message) throws IOException {
        this.write(message);
        this.close();
    }

    public void writeThenClose(List<String> testData) throws IOException {
        for (String message : testData) {
            write(message + Constants.N);
        }
    }
}