/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmad_alrossan_112940;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csexam
 */
public class Question2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream("url-List.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader bf = new BufferedReader(isr);
        
        String line = null;
        while(true) {
            try {
                line = bf.readLine();
            } catch (IOException ex) {
                System.out.println("ERROR");
            }
            if (line == null) break;
            try {
                URL url = new URL(line);
                String host = url.getHost();
                InetAddress ip = InetAddress.getByName(host);
                //System.out.println(url);
                InetAddress[] ips = InetAddress.getAllByName(host);
                if (ips.length > 1) {
                System.out.println(url.getHost() + " many IP(s)");
                for (int i = 0; i < ips.length; i++) {
                    System.out.println(ips[i]);
                }
                }
                else {
                    System.out.println(url.getHost() + "has One IP");
                    if(!url.getFile().isEmpty()) {
                        InputStream in1 = url.openStream();
                        String[] split = url.getFile().split("/");
                        FileOutputStream out = new FileOutputStream(split[split.length-1]);
                        while(true) {
                            int b = in1.read();
                            if(b == -1) break;
                            out.write(b);
                        }
                        in1.close();
                        out.close();
                        System.out.println(url.getHost() + " has file: " + split[split.length-1]);
                    } else {
                        System.out.println(url.getHost() + " has no file");
                        System.out.println("Protocol: " + url.getProtocol());
                    }
                }
                
                System.out.println("-------------------Downloading----------------------");
            } catch (MalformedURLException ex) {
                System.out.println("ERROR2");
            } catch (UnknownHostException ex) {
                System.out.println("ERROR3");
            }
                
            
        }
    }
}
