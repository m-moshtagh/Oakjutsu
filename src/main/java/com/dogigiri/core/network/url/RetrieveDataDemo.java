package com.dogigiri.core.network.url;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RetrieveDataDemo {
    public static void main(String[] args) throws IOException {
        URL url; // dispose pattern in order to access a statement we externalize the variable.
        try {
            url = new URL("https://github.com/springframeworkguru");
            try (InputStreamReader reader = new InputStreamReader(new BufferedInputStream(url.openStream()))) {
                int readData;
                while ((readData = reader.read()) != -1) {
                    System.out.print((char) readData);
                }
            }
        } catch (IOException e) {
            System.out.print("Thi URL doesn't exists!");
        }
    }
}
