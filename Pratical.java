import java.util.*;
public class Pratical{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter your name is :");
        String name=sc.nextLine();
        System.out.print(name);

        System.out.print("  Enter your total number of subject : ");
        int n=sc.nextInt();
        

        System.out.println(name+" Enter your "+n+" subject realated name : ");
        String subject[]=new String[n];
        for(int i=0;i<n;i++){
            if(i==0){
                subject[0]=sc.nextLine();
            }
             subject[i]=sc.nextLine();           
        }
        System.out.print(name+" Enter your Total marks each subject : ");
        int total_marks=sc.nextInt();
        System.out.println();
        
        
        System.out.println(name+" Enter Your "+n+" subject related obtain marks  : "); 
        // int n=sc.nextInt();
        int [] marks=new int[n];
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            System.out.println(i+" Index Subject is : "+subject[i]+" Total marks is : "+total_marks+" And Obtain Marks is : "+marks[i]);
        }
        
        int average=0;
        for(int i=0;i<n;i++){
            average+=marks[i];
        }
        int Total_add=0;
        for(int i=0;i<n;i++){
            Total_add+=total_marks;
        }
        System.out.println();
        System.out.println("Your Total marks sum is : "+Total_add);
        System.out.println();

        System.out.println("Your Total obtain marks sum is : "+average);
        System.out.println();

        double percentage =(double)((average*100)/Total_add);
        System.out.println(name+" Your percentege is : "+percentage);
        System.out.println();

        average/=n;
        System.out.println(" Your average is : "+average);
        System.out.println("Have A Nnice Day!");
       
    }
}