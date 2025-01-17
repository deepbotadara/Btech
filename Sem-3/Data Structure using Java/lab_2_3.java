import java.util.*;
public class lab_2_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int s=sc.nextInt();
        int arr[]=new int[s];

        System.out.println("Enter array elements:");
        
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        
        int arr2[]=new int[arr.length];
        
        for(int i=arr.length;i>=0;i--){
            for(int j=0;j<=arr.length;j++){
                arr2[j]=arr[i];
            }
        }
        for(int k=0;k<=arr2.length;k++){
            System.out.println("Reverse Array: "+arr2[k]);
        }
    }
}
