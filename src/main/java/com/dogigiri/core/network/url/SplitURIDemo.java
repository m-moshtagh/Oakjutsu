package com.dogigiri.core.network.url;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class SplitURIDemo {
    public static void main(String[] args) {
        try {
            URI uri = new URI(new Scanner(System.in).nextLine());
            System.out.println("The URI is " + uri);
            if (uri.isOpaque()) {
                System.out.println("This is an opaque URI.");
                System.out.println("The scheme is " + uri.getScheme());
                System.out.println("The scheme specific part is "
                        + uri.getSchemeSpecificPart());
                System.out.println("The fragment ID is " + uri.getFragment());
            } else {
                System.out.println("This is a hierarchical URI.");
                System.out.println("The scheme is " + uri.getScheme());
                try {
                    uri.parseServerAuthority();
                    System.out.println("The host is " + uri.getHost());
                    System.out.println("The user info is " + uri.getUserInfo());
                    System.out.println("The port is " + uri.getPort());
                } catch (URISyntaxException ex) {
// Must be a registry based authority
                    System.out.println("The authority is " + uri.getAuthority());
                }
                System.out.println("The path is " + uri.getPath());
                System.out.println("The query string is " + uri.getQuery());
                System.out.println("The fragment ID is " + uri.getFragment());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.err.println(" does not seem to be a URI.");
        }
    }
}
