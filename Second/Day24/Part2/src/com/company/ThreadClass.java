package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class ThreadClass implements Runnable {
    private String line;

    public ThreadClass(String line) {
        this.line = line;
    }

    public void calculation() {
        try {
            InetAddress ip=InetAddress.getByName(line);
            if(ip.equals(InetAddress.getLocalHost())) {
                NetworkInterface nic = NetworkInterface.getByInetAddress(ip);
                System.out.println(nic.getDisplayName());
            } else {
                if (ip.isReachable(1000)) {
                    System.out.println("Host Name: " + ip.getHostName());
                    // System.out.println("Host Address: " + ip.getHostAddress());
                }
            }

        } catch (UnknownHostException e) {
            System.err.println(line + ": invalid IP, will Try with URL");
            try {
                URL url = new URL(line);

                InetAddress[] ips = InetAddress.getAllByName(url.getHost());
                for (int i = 0; i < ips.length; i++ ) {
                    System.out.println(ips[i]);
                }
                if (!url.getFile().isEmpty()) {
                    String[] str = url.getFile().split("/");
                    InputStream in1 = url.openStream();
                    FileOutputStream out = new FileOutputStream(str[str.length - 1]);
                    out.write(in1.readAllBytes());
                    in1.close();
                    out.close();
                }


            } catch (MalformedURLException e1) {
                System.err.println(line + ": invalid IP and URL");
            } catch (UnknownHostException e1) {
                System.err.println("ERROR2");
            } catch (IOException e1) {
                System.err.println("ERROR3");
            }
        } catch (SocketException e) {
            System.err.println("ERROR4");
        } catch (IOException e) {
            System.err.println("ERROR5");
        }
    }

    @Override
    public void run() {
        calculation();
    }

}
