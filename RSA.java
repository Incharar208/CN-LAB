import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    private BigInteger e;
    private BigInteger d;
    private BigInteger n;

    public RSA(int bitLength) {
        generateKeyPairs(bitLength);
    }

    private void generateKeyPairs(int bitLength) {
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);

        n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // choosing e
        e = BigInteger.probablePrime(bitLength / 2, random);
    
        while(phi.gcd(e).intValue() > 1) {
            e = e.add(BigInteger.ONE);
        }

        // calculate d
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d,n);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bitLength = 1024;
        String originalMessage;
        RSA rsa = new RSA(bitLength);
        System.out.println("Enter a string:");
        originalMessage = in.nextLine();

        BigInteger message = new BigInteger(originalMessage.getBytes());
        
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + new String(decryptedMessage.toByteArray()));
    }

}
