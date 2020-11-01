import java.util.Scanner;

public class ReverseNo {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number : ");
        int n=sc.nextInt();
        while(n!=0){
            int add=n%10;
            System.out.println(add);
            n=n/10;
        }
    }
}
