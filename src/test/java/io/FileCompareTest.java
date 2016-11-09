package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HiekmaHe on 25.10.2016.
 */
public class FileCompareTest {

    @Test
    public void testCompareContent() {
        // arrange
        String filename1 = "src/test/resources/testCompareContent1";
        File file1 = new File(filename1);
        Writer writer1 = null;
        try {
            writer1 = new Writer(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String content1 = "hello" + Constants.N + "world";
        try{
            writer1.writeThenClose(content1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader1 = null;
        try {
            reader1 = new Reader(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> read1;
        String filename2 = "src/test/resources/testCompareContent2";
        File file2 = new File(filename2);
        Writer writer2 = null;
        try {
            writer2 = new Writer(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String content2 = "hello" + Constants.N + "world";
        try {
            writer2.write(content2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader2 = null;
        try {
            reader2 = new Reader(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> read2;

        // act
        try {
            reader1.readAllLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader2.readAllLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        read1 = reader1.getAllReadLinesAsList();
        read2 = reader2.getAllReadLinesAsList();

        // assert
        Assert.assertEquals(read1, read2);
    }
}
