package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream in = new FileInputStream("Test.zip");
        BufferedInputStream bin = new BufferedInputStream(in);
        ZipInputStream zin = new ZipInputStream(bin);
        ZipEntry z = zin.getNextEntry();

        FileOutputStream out = null;
        BufferedOutputStream bout = null;

        while (z != null) {
            long s = System.currentTimeMillis();

            System.out.println("Uncompress file: " + z.getName());

            out = new FileOutputStream(z.getName());
            bout = new BufferedOutputStream(out);

            bout.write(zin.readAllBytes());

            System.out.println("Size Before Compress: " + z.getCompressedSize());
            System.out.println("Size After Compress: " + z.getSize());

            bout.close();

            long e = System.currentTimeMillis();
            System.out.println("Time file " + z.getName() + ": " + (e-s));
            System.out.println("---------------------------");

            zin.closeEntry();
            z = zin.getNextEntry();
        }

        zin.close();

        long end = System.currentTimeMillis();
        System.out.println("Total Time is: " + (end-start));

    }
}
