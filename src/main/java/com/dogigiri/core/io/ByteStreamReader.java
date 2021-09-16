package com.dogigiri.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *
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
