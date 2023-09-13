import java.util.Scanner;
public class prime {
    public static void main(String[] args){
        int num;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number:");
        num=in.nextInt();
        boolean flag=false;
        for(int i=2;i<=num/2;i++)
        {
            if(num%i==0)
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            System.out.println("The given number is a prime number.");
        }
        else
        {
            System.out.println("The given number is not a prime number.");
        }

    }


}



