import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("Please enter url: ");
            String u = input.nextLine();

            try {
                URL url = new URL(u);
                System.out.println("Port: " + url.getPort());
                System.out.println("Default Port: " + url.getDefaultPort());
                System.out.println("Protocol: " + url.getProtocol());
                System.out.println("Host is: " + url.getHost());
                String host = url.getHost();
//            InetAddress[] ips = InetAddress.getAllByName(host);
//            for (int i = 0; i < ips.length; i++) {
//                System.out.println(ips[i]);
//            }
                InetAddress ip = InetAddress.getByName(host);
                System.out.println("Host IP: " + ip.getHostAddress());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
