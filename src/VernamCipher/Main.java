package VernamCipher;

import static VernamCipher.Vernam.*;


public class Main {
    public static void main(String[] args) {
        String plainText = "HELLO";
        String key = "XMCKL";

        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted Text: " + cipherText);

        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
