import java.util.*;
class circle{
    double r;
    

    circle(double r){
        this.r=r;
    }
    double area;
    void area(){
        area= Math.PI*r*r;
    }
    void display(){
        System.out.println("Area of circle= "+area );
    }

}

public class Lab_6_1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter radius of circle:");
        double r=sc.nextDouble();
        circle c1=new circle(r);
        c1.area();
        c1.display();
    }
}
