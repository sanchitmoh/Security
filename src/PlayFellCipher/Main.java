package PlayFellCipher;

import java.util.Arrays;

import static PlayFellCipher.Cipher.*;

public class Main {
    public static void main(String[] args) {
        String key = "BESTKEY";
        String text = "TUTORIALSPOINT";

        System.out.println("The Key text: " + key);
        text = preprocessText(text);
        text = prepareDigraphs(text);

        char[][] matrix = generateKeyMatrix(key);
        System.out.println("The Plain Text: " + text);

        String cipherText = encryptText(text, matrix);
        System.out.println("The CipherText: " + cipherText);
    }


}

