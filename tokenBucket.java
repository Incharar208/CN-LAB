import java.util.Scanner;
import java.util.*;

public class tokenBucket {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int tokenRequested, tokenSent, tokenRemaining = 0;
        System.out.println("Enter the bucket capacity:");
        int bucketCapacity = in.nextInt();
        System.out.println("Enter the token generation rate:");
        int tokenGeneration = in.nextInt();
        System.out.println("Enter the number of cycles:");
        int n = in.nextInt();
        System.out.println(String.format("%s\t%s\t%s\t%s","Time","Token Requested","Token Sent","Token Remaining"));
        for(int i = 0; i < n; i++ )
        {
            tokenRequested = tokenGeneration;
            if(tokenRequested + tokenRemaining > bucketCapacity)
            {
                tokenSent = bucketCapacity - tokenRemaining;
                tokenRemaining = bucketCapacity;
            }
            else 
            {
                tokenSent = tokenRequested;
                tokenRemaining = tokenRemaining + tokenRequested;
            }
            System.out.println(String.format("%d\t\t%d\t\t%d\t\t%d",i + 1, tokenRequested, tokenSent, tokenRemaining));
        }

    }
}
