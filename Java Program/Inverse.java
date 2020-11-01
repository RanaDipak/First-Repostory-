import java.util.Scanner;

public class Inverse {
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int inv=0;
            int op=1;
            while(n!=0){
                int od=n%10;
                int id=op;
                int ip=od;
                inv=inv+id*(int)Math.pow(10, ip-1);
                n=n/10;
                op++;
            }
            System.out.println(inv);


                                         //second Method
                                         
            // Scanner scn = new Scanner(System.in);
            // int n = scn.nextInt();
    
            // int i = 0;
            // int p = 1;
            // while(n > 0){
            //     int dig = n % 10;
            //     n = n / 10;
            //     i += p * Math.pow(10, dig - 1);
            //     p++;
            // }
    
            // System.out.println(i);
        }
}

