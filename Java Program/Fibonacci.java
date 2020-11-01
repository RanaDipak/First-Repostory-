import java.util.Scanner;

class Fibonacci{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number : ");
        int n=sc.nextInt();
        int a=0 ,b=1,c;
        for(int i=0;i<n;i++){
            System.out.println(a);
            c=a+b;
            a=b;
            b=c;
        }

    }
}