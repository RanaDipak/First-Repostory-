import java.util.Scanner;

public class Prime {
    public static void main(String args[]) {
        // I am found out to prime number
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your low and higher number : ");
        int low = sc.nextInt();
        int high = sc.nextInt();
        for (int n = low; n < high; n++) {
            int div = 2;
            while (div * div <= n) {
                if (n % div == 0) {
                    break;
                }
                div++;
            }
            if (div * div > n) {
                System.out.println(n);
            }
        }
    }
}
