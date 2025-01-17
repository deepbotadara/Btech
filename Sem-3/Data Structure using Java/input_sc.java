import java.util.*;
public class input_sc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name:");
        String name=sc.nextLine();
        System.out.println("Enter rollno:");
        int roll=sc.nextInt();
        System.out.println("Enter spi:");
        double spi=sc.nextDouble();
        System.out.println("Name:"+name+"Roll:"+roll+"SPI:"+spi);
    }
}
