import java.util.*;
public class Lab_3_6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();

        if(year%100==0){
            if(year%400==0){
                System.out.println("Year is leap year");
            }
            else{
                System.out.println("Year is not a leap year");
            }
        }
        else if(year%4==0){
            System.out.println("Year is leap year");
        }
        else{
            System.out.println("Year is not a leap year");
        }
    }
}