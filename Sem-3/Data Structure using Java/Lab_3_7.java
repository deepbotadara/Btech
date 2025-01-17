import java.util.*;
public class Lab_3_7{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();

		int n=number;
		int reverse=0,first;
		while(n!=0){
			first=n%10;
			reverse=reverse*10+first;
			n=n/10;
		}

		if(number==reverse){
			System.out.println("Number is Palindrome");
		}
		else{
			System.out.println("Number is not Palindrome");
		}
	}
}