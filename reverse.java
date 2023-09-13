import java.util.Scanner;

public class reverse{
    public static void main(String[] args){
        int num,reverseNum=0,n;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number:");
        num=in.nextInt();
        while(num!=0)
        {
            n=num%10;
            reverseNum=reverseNum*10+n;
            num=num/10;
        }
        System.out.println("The reversed number is: "+reverseNum);
    }
}