package com.company;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Decrypt {

    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        long start = System.currentTimeMillis();

        String k = "0123456789";
        DESKeySpec kk = new DESKeySpec(k.getBytes());
        SecretKeyFactory sk = SecretKeyFactory.getInstance("DES");
        SecretKey key = sk.generateSecret(kk);

        Cipher cf = Cipher.getInstance("DES");
        cf.init(Cipher.DECRYPT_MODE, key);

        FileInputStream in = new FileInputStream("Encrypt.txt");
        BufferedInputStream bin = new BufferedInputStream(in);
        // CipherInputStream cin = new CipherInputStream(bin, cf);

        FileOutputStream out = new FileOutputStream("Decrypt.txt");
        BufferedOutputStream bout = new BufferedOutputStream(out);
        CipherOutputStream cout = new CipherOutputStream(out, cf);

        // bout.write(cin.readAllBytes());
        cout.write(bin.readAllBytes());
        // cin.close();
        // bout.close();
        bin.close();
        cout.close();


        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end-start));
    }
}
