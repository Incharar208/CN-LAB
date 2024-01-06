import java.util.Random;
import java.util.Scanner;

public class RED {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.println("Enter the maximum packets:");
    int maxPackets = in.nextInt();
    System.out.println("Enter the queue size:");
    int queueSize = in.nextInt();
    System.out.println("Enter the maximum probability:");
    double maxProbability = in.nextDouble();
    System.out.println("Enter the minimum probability:");
    double minProbability = in.nextDouble();

    Random random = new Random(System.currentTimeMillis());
    int queueLength = 0;
    double dropProbability = minProbability;

    for(int i = 0; i < maxPackets; i++)
    {
      if(queueLength == queueSize)
      {
        System.out.println("Packet dropped as queue is full");
        dropProbability = minProbability;
      }
      else if(random.nextDouble() < dropProbability) 
      {
        System.out.println("Packet dropped (RANDOM)");
        dropProbability += (maxProbability - minProbability) / (maxPackets - 1);
      }
      else 
      {
        System.out.println("Packet accepted");
        queueLength = queueLength + 1;
        dropProbability = minProbability;
      }
    }
  }
}
