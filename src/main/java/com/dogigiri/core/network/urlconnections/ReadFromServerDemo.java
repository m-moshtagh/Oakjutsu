package com.dogigiri.core.network.urlconnections;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ReadFromServerDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);
            URLConnection urlConnection = url.openConnection();
            try(InputStream inputStream = urlConnection.getInputStream()){
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                Reader reader = new InputStreamReader(bufferedInputStream);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.println((char) c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
