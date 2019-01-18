package com.company;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        long size1 = 0, size2 = 0;
        String[] files = { "Sample1.pptx", "Sample2.txt", "Sample3.pptx", "Sample4.txt" };

        FileOutputStream out = new FileOutputStream("Text.zip");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ZipOutputStream zout = new ZipOutputStream(bout);

        BufferedInputStream bin = null;
        ZipEntry z = null;

        for (int i = 0; i < files.length; i++) {
            long start1 = System.currentTimeMillis();
            System.out.println("Start Compressing file: " + files[i]);
            bin = new BufferedInputStream(new FileInputStream(files[i]));
            z = new ZipEntry(files[i]);
            zout.putNextEntry(z);
            while (true) {
                int b = bin.read();
                if (b == -1) break;
                zout.write(b);
            }
            System.out.println("End Comprising file: " + files[i]);
            bin.close();
            zout.closeEntry();
            size1 += z.getSize();
            size2 += z.getCompressedSize();
            System.out.println("Size file Before Compressing" + files[i] + " : " +  z.getSize());
            System.out.println("Size file After Compressing" + files[i] + " : " +  z.getCompressedSize());
            long end1 = System.currentTimeMillis();
            System.err.println("Time " + files[i] + " is " + (end1-start1));
            System.out.println("---------------------------------------------");
        }
        bin.close();
        zout.close();
        long end = System.currentTimeMillis();
        System.out.println("---------------------------------------------");
        System.err.println("Time is: " + (end-start));
        System.out.println("Size all files is Before Compressing " + size1);
        System.out.println("Size all files is After Compressing " + size2);
    }
}
