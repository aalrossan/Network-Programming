package com.company;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidKeySpecException, IOException  {
        long start = System.currentTimeMillis();

        String k = "123456789";
        DESKeySpec kk = new DESKeySpec(k.getBytes());
        SecretKeyFactory sk = SecretKeyFactory.getInstance("DES");
        SecretKey key = sk.generateSecret(kk);

        Cipher cf = Cipher.getInstance("DES");
        cf.init(Cipher.ENCRYPT_MODE, key);

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream("Sample.txt");
        BufferedInputStream bin = new BufferedInputStream(in);
        CipherInputStream cin = new CipherInputStream(bin, cf);
        DigestInputStream din = new DigestInputStream(cin, md);

        FileOutputStream out = new FileOutputStream("Result/Sample.zip");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ZipOutputStream zout = new ZipOutputStream(bout);
        ZipEntry z = new ZipEntry("Sample.txt");

        zout.putNextEntry(z);
        zout.write(din.readAllBytes());

        byte[] hash = din.getMessageDigest().digest();

        for (int i = 0; i < hash.length; i++) {
            System.out.print(hash[i] + " ");
        }
        System.out.println();

        zout.closeEntry();
        z = new ZipEntry("hash.txt");
        zout.putNextEntry(z);
        zout.write(hash);

        din.close();
        zout.closeEntry();
        zout.close();

        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }
}
