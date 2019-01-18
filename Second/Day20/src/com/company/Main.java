package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        String[] files = { "Sample1.pptx", "Sample2.txt", "Sample3.pptx", "Sample4.txt", "Sample5.txt" };

        ExecutorService ex  = Executors.newFixedThreadPool(2);
        for (int i = 0; i < files.length; i++) {
            Compress compress = new Compress(files[i]);
            Future<ZipOutputStream> f = ex.submit(compress);
            System.out.println("finish " + files[i]);
        }
        ex.shutdown();
    }
}
