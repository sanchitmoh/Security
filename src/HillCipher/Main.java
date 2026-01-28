package HillCipher;

import static HillCipher.Cipher.encrypt;

public class Main {
    public static void main(String[] args) {
        String plaintext = "HI";
        System.out.println("Plain Text: " + plaintext);
        System.out.println("Cipher Text: " + encrypt(plaintext));
    }
}
