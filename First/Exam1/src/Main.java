import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        long start = System.currentTimeMillis();
        long size1 = 0, size2 = 0;

        String[] files = { "ahmad.jpg", "ibrahim.jpg" };

        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream in1 = new FileInputStream("ahmad.jpg");
        BufferedInputStream bin1 = new BufferedInputStream(in1);
        DigestInputStream din1 = new DigestInputStream(bin1, md);

        FileInputStream in2 = new FileInputStream("ibrahim.jpg");
        BufferedInputStream bin2 = new BufferedInputStream(in2);
        DigestInputStream din2 = new DigestInputStream(bin2, md);

        byte[] array1 = bin1.readAllBytes();
        byte[] array2 = bin2.readAllBytes();

        FileOutputStream out1 = new FileOutputStream("ahmad.jpg");
        BufferedOutputStream bout1 = new BufferedOutputStream(out1);

        FileOutputStream out2 = new FileOutputStream("ibrahim.jpg");
        BufferedOutputStream bout2 = new BufferedOutputStream(out2);

        FileOutputStream out3 = new FileOutputStream("Images.zip");
        BufferedOutputStream bout3 = new BufferedOutputStream(out3);
        ZipOutputStream zout = new ZipOutputStream(bout3);
        ZipEntry z = null;

        BufferedInputStream bin3 = null;

        bout1.write(array2);
        bout2.write(array1);

        for (int i = 0; i < files.length; i++) {
            long start1 = System.currentTimeMillis();
            System.out.println("Start Compressing file: " + files[i]);

            bin3 = new BufferedInputStream(new FileInputStream(files[i]));
            z = new ZipEntry(files[i]);
            zout.putNextEntry(z);

            zout.write(bin3.readAllBytes());

            bin3.close();
            zout.closeEntry();

            size1 += z.getSize();
            size2 += z.getCompressedSize();

            System.out.println("Size file Before Compressing" + files[i] + " : " +  z.getSize());
            System.out.println("Size file After Compressing" + files[i] + " : " + z.getCompressedSize());

            long end1 = System.currentTimeMillis();
            System.out.println("Time File " + files[i] + " : " + (end1-start1));
            System.out.println("End Compressing file: " + files[i]);
            System.out.println("-------------------------------------------------");
        }

        din1.readAllBytes();
        byte[] hash1 = din1.getMessageDigest().digest();
        for (int i = 0; i < hash1.length; i++) {
            System.out.print(hash1[i] + " ");
        }
        System.out.println();

        din2.readAllBytes();
        byte[] hash2 = din2.getMessageDigest().digest();
        for (int i = 0; i < hash2.length; i++) {
            System.out.print(hash2[i] + " ");
        }
        System.out.println();

        boolean flag = false;

        flag = hash1.equals(hash2);
        System.out.println("Flag is: " + flag);

        bin1.close();
        bin2.close();
        bin3.close();
        bout1.close();
        bout2.close();
        zout.close();

        System.out.println("Size all file Before Compressing: " +  size1);
        System.out.println("Size all file After Compressing: " + size2);
        long end = System.currentTimeMillis();
        System.err.println("Time is: " + (end-start));
    }
}
