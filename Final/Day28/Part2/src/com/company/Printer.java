package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Printer implements Runnable {
    private Socket client;
    private BufferedReader bf;

    public Printer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String Id = bf.readLine();
            FileOutputStream out = new FileOutputStream(Id + ".txt");
            out.write(bf.readLine().getBytes());
            out.write('\n');
            out.write(bf.readLine().getBytes());
            out.write('\n');
            out.write("CS441 Final Exam".getBytes());
            out.write('\n');
            out.write((new Date()).toString().getBytes());
            out.write('\n');
            if (Id.equals("112940")) {
                out.write("Hello احمد عبدالله محمد توفيق الروسان".getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
