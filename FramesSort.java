/*
Write a program to sort frames using appropriate sorting techniques
*/
import java.util.*;

public class sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<int[]> frame = new ArrayList<>(); 
        System.out.println("Enter the number of frames:");
        int n = in.nextInt();

        for(int i = 0; i < n; i++)
        {
            Random random = new Random();
            int seqNum = random.nextInt(1000) + 1;
            System.out.printf("Enter the data for %dth frame:", i + 1);
            int data = in.nextInt();
            frame.add(new int[]{seqNum, data});
        }
        System.out.println("Before sorting:");
        for(int[] i : frame)
        {
            System.out.printf("SeqNum = %d , Data = %d\n", i[0], i[1]);
        }

        frame = sortFrame(frame);

        System.out.println("After sorting:");
        for(int[] i : frame)
        {
            System.out.printf("SeqNum = %d , Data = %d\n", i[0], i[1]);
        }

    }

    public static List<int[]> sortFrame(List<int[]> frame)
    {
        Collections.sort(frame, (a , b) -> Integer.compare(a[0],b[0]));
        return frame;
    }
}

// OUTPUT:
/*
Enter the number of frames:
5
Enter the data for 1th frame:45
Enter the data for 2th frame:21
Enter the data for 3th frame:56
Enter the data for 4th frame:98
Enter the data for 5th frame:4
Before sorting:
SeqNum = 555 , Data = 45
SeqNum = 46 , Data = 21
SeqNum = 469 , Data = 56
SeqNum = 62 , Data = 98
SeqNum = 191 , Data = 4
After sorting:
SeqNum = 46 , Data = 21
SeqNum = 62 , Data = 98
SeqNum = 191 , Data = 4
SeqNum = 469 , Data = 56
SeqNum = 555 , Data = 45
*/
