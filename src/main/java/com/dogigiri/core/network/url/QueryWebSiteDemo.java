package com.dogigiri.core.network.url;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.*;

public class QueryWebSiteDemo {
    // query 30nama.com
    public static void main(String[] args) throws Exception {
        String query = "pine";
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        URL url = new URL("https://30nama.com/search?q=" + query);
        URLConnection connection = url.openConnection(proxy);
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int c;
        while ((c = bufferedInputStream.read()) != -1) {
            System.out.print((char) c);
        }
        bufferedInputStream.close();
        inputStream.close();
    }
}
