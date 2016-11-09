package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HiekmaHe on 21.10.2016.
 *
 * Class for writing to and reading from files.
 */
public class Reader extends FileChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileChecker.class);

    private BufferedReader reader;
    private String oneLine = null;
    private List<String> allLines = new ArrayList<String>();
    private int lineCount = 0;

    public Reader(File inFile) throws IOException {
        setFileIfExistsElseException(inFile);
        initializeReader();
    }

    private void initializeReader() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(getFile()));
    }

    public void readAllLines() throws IOException {
        reset();
        readOneLine();
        while (oneLine != null) {
            addAndReadOneLine();
        }
        close();
    }

    public void readOneLine() throws IOException {
        oneLine = reader.readLine();
    }

    private void addAndReadOneLine() throws IOException {
        allLines.add(oneLine);
        readOneLine();
    }

    public void reset() throws IOException {
        close();
        initializeReader();
        oneLine = "";
        allLines = new ArrayList<String>();
        lineCount = 0;
    }

    public long getLineCount() {
        return lineCount;
    }

    public void countLines() throws IOException {
        doCountLines();
    }

    private void doCountLines() throws IOException {
        reset();
        while(reader.readLine() != null) {
            lineCount++;
        }
        close();
    }

    public List<String> getAllReadLinesAsList()
    {
        return allLines;
    }

    public void close() throws IOException {
        reader.close();
    }

    public void closeLogEventualIOException(){
        try {
            close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}