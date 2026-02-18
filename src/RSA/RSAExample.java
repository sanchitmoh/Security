package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAExample {

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();

        // Step 1: Generate two large prime numbers
        BigInteger p = BigInteger.probablePrime(512, random);
        BigInteger q = BigInteger.probablePrime(512, random);

        // Step 2: Compute n and phi
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Step 3: Choose e
        BigInteger e = BigInteger.valueOf(65537); // Common public exponent

        // Step 4: Compute d
        BigInteger d = e.modInverse(phi);

        // Display Keys
        System.out.println("Public Key (e, n): ");
        System.out.println(e + ", " + n);

        System.out.println("\nPrivate Key (d, n): ");
        System.out.println(d + ", " + n);

        // Message
        String message = "HELLO";
        BigInteger M = new BigInteger(message.getBytes());

        // Encryption

        BigInteger C = M.modPow(e, n);
        System.out.println("\nEncrypted Message: " + C);

        // Decryption
        BigInteger decrypted = C.modPow(d, n);
        String decryptedMessage = new String(decrypted.toByteArray());

        System.out.println("\nDecrypted Message: " + decryptedMessage);
    }
}
