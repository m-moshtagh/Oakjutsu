package com.dogigiri.core.network.url;

import java.io.*;
import java.net.*;

public class SecureSourceViewer {
    public static void main (String[] args) {
        Authenticator.setDefault(new DialogAuthenticator());
        for (String arg : args) {
            try {
// Open the URL for reading
                URL u = new URL(arg);
                try (InputStream in = new BufferedInputStream(u.openStream())) {
// chain the InputStream to a Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
// print a blank line to separate pages
            System.out.println();
        }
// Since we used the AWT, we have to explicitly exit.
        System.exit(0);
    }
}
