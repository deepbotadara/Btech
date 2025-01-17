import java.util.*;
public class meter2feet{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter in meter:");
        double meter=sc.nextDouble();
        double feet= meter*3.28;
        System.out.println("Feet="+feet);

    }
}