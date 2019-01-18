/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampleexam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cslab3
 */
public class SampleExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SocketException, UnknownHostException, IOException
    {
        FileInputStream in = new FileInputStream("list.txt");
        InputStreamReader inn = new InputStreamReader(in);
        BufferedReader bf= new BufferedReader(inn);
        
        
        while(true)
        {
            String line=null;
            try {
                line = bf.readLine();
            } catch (IOException ex) {
                Logger.getLogger(SampleExam.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(line ==null) break;
            try
            {
                InetAddress ip=InetAddress.getByName(line);
                if(ip.equals(InetAddress.getLocalHost()))
                {
                    NetworkInterface nic = NetworkInterface.getByInetAddress(ip);
                    System.out.println(nic.getDisplayName());
                }
                else
                 System.out.println(ip);
            } 
            catch (UnknownHostException ex) 
            {
                try 
                {
                   // System.out.println("It is a invalid IP");
                    URL url= new URL(line);
                   // System.out.println("It is a valid URL");
                    String host=url.getHost();
                    InetAddress[] ips= InetAddress.getAllByName(host);
                    for (int i = 0; i < ips.length; i++) 
                    {
                        System.err.println(ips[i]);
                    }
                    if(!url.getFile().isEmpty())
                    {
                      String[] str= url.getFile().split("/");
                      String filename=str[str.length-1];
                      InputStream innn = url.openStream();
                      FileOutputStream out= new FileOutputStream(filename);
                      while(true)
                      {
                          int b= innn.read();
                          if(b==-1) break;
                          out.write(b);
                      }
                        
                        System.out.println("there is a file");
                    }
                    else
                    {
                        System.out.println("url is general");
                    }
                    System.out.println(url.getHost());
                    
                }
                catch (MalformedURLException ex1) 
                {
                    System.out.println("invalid IP and URL");
                }
                
            }
            
            
        }
       
    }
    
}
