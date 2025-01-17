import java.util.*;

class Bank_Account{
    int acc_no;
    String name,email,acc_type;
    double balance;
  
    void getAccountDetails(){
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter Account no:");
        acc_no=sc.nextInt();
        System.out.println("Enter Name:");
        name=sc.next();
        System.out.println("Enter Email:");
        email=sc.next();
        System.out.println("Enter Account Type:");
        acc_type=sc.next();
        System.out.println("Enter Balance:");
        balance=sc.nextInt();

    }

    void displayAccountDetails(){
        System.out.println("Account no.= "+acc_no+"\nName= "+name+"\nEmail "+email+"\nAcc_Type= "+acc_type+"\nBalance= "+balance );
    }

}

public class Lab_6_3{
    public static void main(String args[]){
        Bank_Account b=new Bank_Account();
        b.getAccountDetails();
        b.displayAccountDetails();
    }
}
