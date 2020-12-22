import java.util.Scanner;

public class Fibonacci{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fibn = fib(n);
        System.out.println(fibn);
    }
    public static int fib(int n ){
        if(n == 0 || n == 1){
            return n;
        }
        int fibnm1 = fib(n - 1);
        int fibnm2 = fib(n - 2);
        int fibn = fibnm1 + fibnm2;
        return  fibn;
    }
}