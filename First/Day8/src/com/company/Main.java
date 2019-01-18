package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("Sample.zip");
        BufferedInputStream bin = new BufferedInputStream(in);
        ZipInputStream zin = new ZipInputStream(bin);
        ZipEntry z = zin.getNextEntry();

        FileOutputStream out = new FileOutputStream(z.getName());
        BufferedOutputStream bout = new BufferedOutputStream(out);

        while (true) {
            int b = zin.read();
            if (b == -1) break;
            bout.write(b);
        }

        zin.closeEntry();
        zin.close();
        bout.close();
    }
}
