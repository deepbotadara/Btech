import java.util.*;
public class Lab_3_1 {
    public static void main(String[] args) {
    System.out.println("Enter marks of 5 subjects:");
    Scanner sc=new Scanner(System.in);
    double marks[]=new double[5];
    int i;

    for(i=0;i<marks.length;i++){
        marks[i]=sc.nextDouble();
    }
    double sum=0;
    for(i=0;i<marks.length;i++){
        sum=sum+marks[i];
    }

    //System.out.println("Sum:"+sum);

    double percentage=sum/5;
    System.out.println("Percentage="+percentage+"%");

    if(percentage>=60){
        System.out.println("First Division");
    }
    else if(percentage>=50 && percentage<=59){
        System.out.println("Second Division");   
    }
    else if(percentage>=40 && percentage<=49){
        System.out.println("Third division");
    }
    else if(percentage<40){
        System.out.println("Fail");
    }
    else{
        System.out.println("Invalid input!");
    }

    }
}