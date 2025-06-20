package hackerrank.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner("HelloWorld");
        String word = scanner.next();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(word.getBytes());
        byte[] digest = md.digest();
        for (byte b : digest) {
            System.out.format("%02x", b);
        }


    }
}


class Sha256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner("HelloWorld");
        String word = scanner.next();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(word.getBytes());
        byte[] digest = md.digest();
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}
