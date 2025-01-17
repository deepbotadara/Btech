import java.util.*;
public class lab_2_4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Fahrenheit:");
        double f=sc.nextDouble();

        double c=(f-32)*5/9;
        double f2=(c*9/5.0)+32;

        System.out.println("Celcuis:"+c);
        System.out.println("Fahrenheit:"+f2);
    }
}