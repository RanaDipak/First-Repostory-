import java.util.Scanner;

public class Digit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbe : ");
        int num = sc.nextInt();
        // int count=1;
        int power = 1;
        int temp = num;
        // while (temp >= 0) {
        while (temp >= 10) {
            temp = temp / 10;
            // count++;
            power *= 10;
        }
        // int div=(int)Math.pow(10, count-1);
        // while(div!=0){
        temp = num;
        while (power != 0) {
            int digit = temp / power;
            System.out.println(digit);
            temp = temp % power;
            // num=num%div;
            power = power / 10;
            // div=div/10;
        }
    }
}
