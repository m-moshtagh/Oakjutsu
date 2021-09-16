package com.dogigiri.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *  IO refers to input output. so whenever we want do some input and output operations we use Java IO API.
 * Streams: Java converts Data into 0 & 1 and sends to the source. this sequence of data is called stream of Data.
 * We have two types of streams in java. Byte streams and Char streams.
 * Whenever we are going to deal with text sources it's recommended to use Char streams. Other files are better to use
 * with Byte Streams like images, XML and so on.
 * Java IO is implemented in decorator design pattern so we can add features depending on classes.
 * Char streams classes are derived from Reader And Writer classes and their implementation's names end with reader or writer
 * Byte Streams classes are derived from InputStream and OutputStream and their implementation's names end with inputStream or outputSteam
 * It is Good to use buffered implementations to be more efficient.
 */
public class ByteStreamReader {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/home/hkm/Desktop/inStreamRead.txt"));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/home/hkm/Desktop/outStreamWrite.txt", true))) {
            int ascii;
            while((ascii = inputStream.read()) != -1){
                outputStream.write((byte) ascii);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
