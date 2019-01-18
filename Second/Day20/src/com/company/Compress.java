package com.company;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress implements Callable<ZipOutputStream> {
    private String file_name;

    public Compress(String file_name) {
        this.file_name = file_name;
    }

    public ZipOutputStream calculationCompress() throws IOException {
        FileInputStream in = new FileInputStream("Samples/" + file_name);
        BufferedInputStream bin = new BufferedInputStream(in);

        FileOutputStream out = new FileOutputStream("Compress/" + file_name + ".zip");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ZipOutputStream zout = new ZipOutputStream(bout);
        ZipEntry z = new ZipEntry(file_name);
        zout.putNextEntry(z);
        zout.write(bin.readAllBytes());

        bin.close();
        zout.closeEntry();
        zout.close();

        return zout;
    }

    @Override
    public ZipOutputStream call() throws Exception {
        return calculationCompress();
    }
}
