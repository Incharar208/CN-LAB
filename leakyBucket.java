import java.util.Scanner;

public class leakyBucket {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bucketRemaining = 0, sent, received;
        System.out.println("Enter the bucket capacity:");
        int bucketCapacity = in.nextInt();
        System.out.println("Enter the bucket rate, rate at which packets are sent from the bucket:");
        int bucketRate = in.nextInt();
        System.out.println("Enter the number of packets:");
        int n = in.nextInt();
        System.out.println("Enter the packet sizes:");
        int[] buf = new int[20];
        for(int i = 0; i < n; i++)
        {
            buf[i] = in.nextInt();
        }

        System.out.println(String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s","Time","PacketSize","Accepted","Sent","Remaining"));

        for(int i = 0; i < n;i++)
        {
            if(buf[i] != 0)
            {
                if(bucketRemaining + buf[i] > bucketCapacity)
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

            if(bucketRemaining != 0)
            {
                if(bucketRemaining < bucketRate)
                {
                    sent = bucketRemaining;
                    bucketRemaining = 0;
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
                System.out.println(String.format("%d\t%d\t%s\t%d\t%d",i + 1,buf[i],"Dropped",sent,bucketRemaining));
            }
            else 
            {
                System.out.println(String.format("%d\t%d\t%d\t%d\t%d",i + 1,buf[i],received,sent,bucketRemaining));
            }
        }

        
        }

    }
