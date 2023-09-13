import java.util.Scanner;
public class oddEven {
    public static void main(String[] args){
        int num;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number:");
        num=in.nextInt();
        if(num%2==0)
        {
            System.out.println("The given number is an even number. ");
        }
        else
        {
            System.out.println("The given number is an odd number. ");
        }
    }
}
