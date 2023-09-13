import java.util.Scanner;

public class fib{
    public static void main(String[] args){
        int num,n1,n2,n3;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number:");
        num=in.nextInt();
        n1=0;
        n2=1;
        System.out.println("The fibonacci numbers are:");
        for(int i=1;i<=num;i++)
        {
            System.out.println(n1+"\t");
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }

    }
}