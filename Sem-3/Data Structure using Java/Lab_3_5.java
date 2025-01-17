import java.util.*;

class Lab_3_5{
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int i,z=0;
        for(i=2;i<n;i++){
           if (n%i==0){
                z=z+1;
                break;
           }
        }
        if(z==1){
            System.out.println("Number is not prime");
        }
        else{
            System.out.println("Number is Prime");
        }
        }
}