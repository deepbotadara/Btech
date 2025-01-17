import java.util.*;
public class lab_4_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int s=sc.nextInt();
        int arr[]=new int[s];

        System.out.println("Enter array elements:");
        
        for(int i=0;i<s;i++){
            arr[i]=sc.nextInt();
        }
        
        for(int j=s-1;j>=0;j--){
            System.out.println("Reverse Array: "+arr[j]);
        }
    }
}
