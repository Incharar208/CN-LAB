/* 
Write a program for simple RSA algorithm to encrypt and decrypt the
data.
*/
import java.util.*;
import java.math.BigInteger;

public class RSA {
    private BigInteger e;
    private BigInteger d;
    private BigInteger n;

    public RSA(int bitLength) {
        generateKeyPairs(bitLength);
    }

    public void generateKeyPairs(int bitLength) {
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);
        n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLength / 2, random);
        while(phi.gcd(e).intValue() > 1) 
        {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d,n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bitLength = 1024;
        RSA rsa = new RSA(bitLength);
        String originalMessage;
        System.out.println("Enter the message:");
        originalMessage = in.next();
        BigInteger message = new BigInteger(originalMessage.getBytes());
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("The encrypted message is: " + encryptedMessage);
        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("The decrypted message is: " + new String(decryptedMessage.toByteArray()));
    }
}

//OUTPUT:
/*
Enter the message:
ComputerNetworks
The encrypted message is: 10179248975521388111985720989538435184492645346280710070453999114545798735534367705534214368953928518143009834742638722296928093959906601855974746857327336057922261631128327549438516737920573531336316159854027638892885780015970619181036419498360716112085009838170304462050289577307355969753565048129383703126564681566777645749682016914670743360106764262112688951300655794511798533748500791023219171191039819220663292715775722683892201499051641877820197208637189924863224268374878974518069788344016325348259033939059058478977979418831607873993458479732285607054869309168387049388627745351752236997795795664916715516058
The decrypted message is: ComputerNetworks
*/
