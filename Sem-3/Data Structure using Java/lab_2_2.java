import java.util.*;
public class lab_2_2{
    public static void main(String[] args){
        System.out.println("Enter number 1:");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println("Enter number 2:");
        int b=sc.nextInt();
        System.out.println("Enter operator:");
        String op=sc.next();
        double ans=1;
        switch(op){
            case "+":
                ans=a+b;
                break;
            case "-":
                ans=a-b;
                break;
            case "*":
                ans=a*b;
                break;
            case "/":
                ans=a/b;
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
        System.out.println(ans);
    }
}