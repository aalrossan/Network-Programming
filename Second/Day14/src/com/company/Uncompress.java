package com.company;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Uncompress {

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException {
        long start = System.currentTimeMillis();

        String k = "123456789";
        DESKeySpec kk = new DESKeySpec(k.getBytes());
        SecretKeyFactory sk = SecretKeyFactory.getInstance("DES");
        SecretKey key = sk.generateSecret(kk);

        Cipher cf = Cipher.getInstance("DES");
        cf.init(Cipher.DECRYPT_MODE, key);

        FileInputStream in = new FileInputStream("Result/" + "Sample.zip");
        BufferedInputStream bin = new BufferedInputStream(in);
        ZipInputStream zin = new ZipInputStream(bin);
        ZipEntry z = zin.getNextEntry();

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileOutputStream out = new FileOutputStream("Result/" + z.getName());
        BufferedOutputStream bout = new BufferedOutputStream(out);
        CipherOutputStream cout = new CipherOutputStream(bout, cf);
        DigestOutputStream dout = new DigestOutputStream(cout, md);

        dout.write(zin.readAllBytes());

        byte[] hash = dout.getMessageDigest().digest();

        System.out.println(z.getName());
        zin.closeEntry();
        z = zin.getNextEntry();
        System.out.println(z.getName());

        out = new FileOutputStream("Result/" + z.getName());
        out.write(zin.readAllBytes());

        in = new FileInputStream("Result/" + z.getName());

        byte[] hash1 = in.readAllBytes();

        for (int i = 0; i < hash.length; i++) {
            System.out.print(hash[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < hash1.length; i++) {
            System.out.print(hash1[i] + " ");
        }
        System.out.println();

        boolean flag = true;
        for (int i = 0; i < hash1.length; i++) {
            if (hash[i] != hash1[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Two hash is same");
        } else {
            System.out.println("Two hash is NOT same");
        }

        zin.closeEntry();
        zin.close();
        dout.close();

        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }
}
