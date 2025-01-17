import java.util.*;
public class Lab_3_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 3 numbers:");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();

        int ans=(n1>n2 && n1>n3)?n1:(n2>n3)?n2:n3;
        System.out.println("\nMaximum number:"+ans);
    }
}   
