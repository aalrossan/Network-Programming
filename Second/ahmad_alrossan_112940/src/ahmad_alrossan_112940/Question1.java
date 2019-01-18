/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmad_alrossan_112940;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csexam
 */
public class Question1 {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        //InetAddress ip = InetAddress.getLocalHost();
        //String add = ip.getHostAddress();
        String host = "10.243.1.1";
        byte[] add = host.getBytes();
///        InetAddress[] ips = InetAddress.getAllByName(add);
        for(int i = 1; i < 11; i++) {
            add[add.length-1] = (byte) i;
            host = new String(add);
            System.out.println(host);
            InetAddress ip = InetAddress.getByAddress(add);
            if(ip.isReachable(1500)) {
                System.out.println(ip.getHostName());
            } else {
                NetworkInterface nic = NetworkInterface.getByInetAddress(ip);
                System.out.println(nic.getDisplayName());
                System.out.println("MAC: " + nic.getHardwareAddress());
                
            }
            //System.out.println(ip.getHostAddress());
        }
        //System.out.println("");
    }
    
}
