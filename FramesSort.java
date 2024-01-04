import java.util.*;

public class sort {
    public static void main(String args[]) {
        // number of frames required
        Scanner sc = new Scanner(System.in);
        List<int[]> frame = new ArrayList<>();
        System.out.println("Enter the number of frames:");
        int n = sc.nextInt();

        // taking random values to each frame's seqNum and inputting the corresponding data
        for(int i = 0; i < n; i++) {
            Random random = new Random();
            int seqNum = random.nextInt(1000)+1;
            System.out.printf("Enter the data for the %dth frame:",i + 1);
            int data = sc.nextInt();
            frame.add(new int[]{seqNum,data});
        }

        // displaying before sorting
        System.out.println("\n\nBefore Sorting:");
        for(int[] i: frame){
            System.out.printf("seqNum: %d, Data: %d\n", i[0], i[1]);
        }

        // function call to sort the frame
        frame = sortFrame(frame);

        // displaying after sorting
        System.out.println("\nAfter Sorting:");
        for(int[] i: frame) {
            System.out.printf("seqNum: %d, Data: %d\n",i[0],i[1]);
        }
         sc.close();
    }

        public static List<int[]> sortFrame(List<int[]> frame) {
            Collections.sort(frame, (a, b) -> Integer.compare(a[0], b[0]));
            return frame;
        }
}



