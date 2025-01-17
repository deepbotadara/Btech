import java.util.*;
public class lab_2_5{
    public static void main(String[] args){
        System.out.println("Enter 3 numbers:");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        int max=((a>b && a>c)?a:(b>c)?b:c);
        System.out.println("Maximum no is:"+max);
    }
}