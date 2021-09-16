package com.dogigiri.core.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamReader {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/hkm/Desktop/inStreamRead.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/hkm/Desktop/outStreamWrite.txt", true))) {
            int ascii;
            while ((ascii = bufferedReader.read()) != -1) {
                bufferedWriter.append((char) ascii);
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
