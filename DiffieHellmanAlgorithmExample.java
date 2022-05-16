package com.JavaBasics.Random;
import java.util.*;

// create class DiffieHellmanAlgorithmExample to calculate the key for two persons
public class DiffieHellmanAlgorithmExample {

    public static void main(String[] args) {
        long P, G, x, a, y, b, ka, kb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Both the users should be agreed upon the public keys G and P");
        System.out.println("Enter value for public key G:");
        G = sc.nextLong();
        System.out.println("Enter value for public key P:");
        P = sc.nextLong();
        System.out.println("Enter value for private key a selected by user1:");
        a = sc.nextLong();
        System.out.println("Enter value for private key b selected by user2:");
        b = sc.nextLong();

        x = calculatePower(G, a, P);
        y = calculatePower(G, b, P);

        ka = calculatePower(y, a, P);
        kb = calculatePower(x, b, P);

        System.out.println("Secret key for User1 is:" + ka);
        System.out.println("Secret key for User2 is:" + kb);

        System.out.println("enter the secret key:");
        int Skey = sc.nextInt();
        String text = "Gain Java Knowledge";
        System.out.println("original_value : " + text);

        String encrypt = getEncryptedValue(text, Skey);
        System.out.println("encrypted value: " + encrypt);
        String decrypt = getDecryptedValue(encrypt, Skey);
        System.out.println("decrypted value: " + decrypt);
    }

    // create calculatePower() method to find the value of x ^ y mod P
    private static long calculatePower(long x, long y, long P) {
        long result = 0;
        if (y == 1) {
            return x;
        } else {
            result = ((long) Math.pow(x, y)) % P;
            return result;
        }
    }

    private static String getDecryptedValue(String encrypt, int Skey) {
        String decrypted = "";
        for (int i = 0; i < encrypt.length(); i++) {
            char ch = encrypt.charAt(i);
            ch -= Skey;
            decrypted = decrypted + ch;
        }
        return decrypted;
    }

    private static String getEncryptedValue(String value, int Skey) {
        String encrypt = "";
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            ch += Skey;
            encrypt = encrypt + ch;
        }
        return encrypt;
    }
}