package VernamCipher;
import java.util.*;
public class Vernam{

    // Encryption method
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char encryptedChar = (char) (text.charAt(i) ^ key.charAt(i));
            result.append(encryptedChar);
        }
        return result.toString();
    }

    // Decryption method (same as encryption)
    public static String decrypt(String cipher, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            char decryptedChar = (char) (cipher.charAt(i) ^ key.charAt(i));
            result.append(decryptedChar);
        }
        return result.toString();
    }


}
