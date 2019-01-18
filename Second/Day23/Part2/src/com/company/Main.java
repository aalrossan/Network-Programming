package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        URL url = null;

        try {
            url = new URL("http://www.just.edu.jo");
            System.out.println(url.getProtocol());
            System.out.println(url.getPort());
            System.out.println(url.getDefaultPort());
            String host = url.getHost();
            InetAddress[] ips = InetAddress.getAllByName(host);
            for (int i = 0; i < ips.length; i++) {
                System.out.println(ips[i] + " , " + host);
            }
            System.out.println(url.getFile());
            InputStream in = url.openStream();
            FileOutputStream out = new FileOutputStream("just.txt");
            out.write(in.readAllBytes());
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
