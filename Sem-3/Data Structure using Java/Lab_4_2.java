import java.util.*;
public class Lab_4_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[4];
        System.out.println("Enter array elements:");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        double sum=0;
        for(int i=0;i<arr.length;i++){
            sum=arr[i]+sum;
        }
        double avg=sum/arr.length;

        System.out.println("Sum of Array: "+sum+" Average: "+avg);
    }
}
