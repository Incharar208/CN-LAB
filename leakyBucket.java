/*
Write a program for congestion control using leaky bucket algorithm
*/

import java.util.*;

public class leakyBucket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bucketRemaining = 0, sent, received;
        System.out.println("Enter the bucket capacity:");
        int bucketCapacity = in.nextInt();
        System.out.println("Enter the bucket rate:");
        int bucketRate = in.nextInt();
        System.out.println("Enter the number of packets:");
        int n = in.nextInt();
        System.out.println("Enter the packets one by one:");
        int[] buf = new int[30];
        for(int i = 0; i < n; i++)
        {
            buf[i] = in.nextInt();
        }

        System.out.println(String.format("Time\tPacketSize\tAccepted\tSent\tReceived"));
        for(int i = 0; i < n; i++)
        {
            if(buf[i] != 0)
            {
                if(buf[i] + bucketRemaining > bucketCapacity)
                {
                    received = -1;   
                }
                else 
                {
                    received = buf[i];
                    bucketRemaining = bucketRemaining + buf[i];
                }
            }
            else 
            {
                received = 0;
            }

            if(bucketRemaining != 0 )
            {
                if(bucketRemaining < bucketRate)
                {
                    sent = bucketRemaining;
                    bucketRemaining = bucketRemaining - bucketRate;
                }
                else 
                {
                    sent = bucketRate;
                    bucketRemaining = bucketRemaining - bucketRate;
                }
            }
            else 
            {
                sent = 0;
            }

            if(received == -1)
            {
                System.out.println(String.format("%d\t%d\t\t%s\t\t%d\t%d",i + 1,buf[i],"Dropped",sent,bucketRemaining));
            }
            else 
            {
                System.out.println(String.format("%d\t%d\t\t%d\t\t%d\t%d",i + 1,buf[i],received,sent,bucketRemaining));
            }
        }
    }
}

//OUTPUT:
/*
Enter the bucket capacity:
6
Enter the bucket rate:
2
Enter the number of packets:
4
Enter the packets one by one:
2
3
4
6
Time    PacketSize      Accepted        Sent    Received
1       2               2               2       0
2       3               3               2       1
3       4               4               2       3
4       6               Dropped         2       1
*/
