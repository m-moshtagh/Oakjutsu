package com.dogigiri.core.network.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SplitURLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL(new Scanner(System.in).nextLine());
            System.out.println("The URL is " + url);
            System.out.println("The scheme is " + url.getProtocol());
            System.out.println("The user info is " + url.getUserInfo());
            String host = url.getHost();
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1) host = host.substring(atSign+1);
                System.out.println("The host is " + host);
            } else {
                System.out.println("The host is null.");
            }
            System.out.println("The port is " + url.getPort());
            System.out.println("The path is " + url.getPath());
            System.out.println("The ref is " + url.getRef());
            System.out.println("The query string is " + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
