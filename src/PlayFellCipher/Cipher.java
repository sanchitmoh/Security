package PlayFellCipher;

import jdk.dynalink.beans.StaticClass;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cipher {

    static final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        // Function to preprocess text (convert to lowercase, remove spaces, replace 'j' with 'i')
        static String preprocessText(String text) {
            text = text.toUpperCase().replaceAll(" ", "").replace('J', 'I');
            return text;
        }

        // Function to insert 'X' between duplicate letters in digraphs
        static String prepareDigraphs(String text) {
            StringBuilder newText = new StringBuilder(text);
            for (int i = 0; i < newText.length() - 1; i += 2) {
                if (newText.charAt(i) == newText.charAt(i + 1)) {
                    newText.insert(i + 1, 'X');
                }
            }
            if (newText.length() % 2 != 0) {
                newText.append('Z'); // Append 'Z' if length is odd
            }
            return newText.toString();
        }

        // Function to create a 5x5 key matrix
        static char[] @org.jetbrains.annotations.NotNull [] generateKeyMatrix(String key) {
            Set<Character> used = new LinkedHashSet<>();
            for (char c : key.toUpperCase().toCharArray()) {
                if (!used.contains(c) && ALPHABET.indexOf(c) != -1) {
                    used.add(c);
                }
            }
            for (char c : ALPHABET.toCharArray()) {
                if (!used.contains(c)) {
                    used.add(c);
                }
            }
            char[][] matrix = new char[5][5];
            Iterator<Character> it = used.iterator();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    matrix[i][j] = it.next();
                }
            }
            return matrix;
        }

        // Function to find the row and column of a letter in the matrix
        static int[] searchElement(char[][] matrix, char letter) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matrix[i][j] == letter) {
                        return new int[]{i, j};
                    }
                }
            }
            return null; // Should never happen if input is valid
        }

        // Function to encrypt digraphs using Playfair rules
        static String encryptText(String text, char[][] matrix) {
            StringBuilder cipherText = new StringBuilder();
            for (int i = 0; i < text.length(); i += 2) {
                char char1 = text.charAt(i);
                char char2 = text.charAt(i + 1);
                int[] pos1 = searchElement(matrix, char1);
                int[] pos2 = searchElement(matrix, char2);

                if (pos1 == null || pos2 == null) { // Safety check
                    throw new IllegalArgumentException("Invalid character found in text.");
                }

                if (pos1[0] == pos2[0]) { // Same row
                    cipherText.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);
                    cipherText.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);
                } else if (pos1[1] == pos2[1]) { // Same column
                    cipherText.append(matrix[(pos1[0] + 1) % 5][pos1[1]]);
                    cipherText.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);
                } else { // Rectangle rule
                    cipherText.append(matrix[pos1[0]][pos2[1]]);
                    cipherText.append(matrix[pos2[0]][pos1[1]]);
                }
            }
            return cipherText.toString();
        }



    }