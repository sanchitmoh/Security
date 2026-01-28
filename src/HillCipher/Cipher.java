package HillCipher;

public class Cipher {


        static int[][] key = {
                {3, 3},
                {2, 5}
        };

        // Encrypt function
        public static String encrypt(String text) {
            text = text.toUpperCase();
            StringBuilder cipher = new StringBuilder();

            for (int i = 0; i < text.length(); i += 2) {
                int[] block = new int[2];

                block[0] = text.charAt(i) - 'A';
                block[1] = text.charAt(i + 1) - 'A';

                int c1 = (key[0][0] * block[0] + key[0][1] * block[1]) % 26;
                int c2 = (key[1][0] * block[0] + key[1][1] * block[1]) % 26;

                cipher.append((char) (c1 + 'A'));
                cipher.append((char) (c2 + 'A'));
            }
            return cipher.toString();
        }


    }


