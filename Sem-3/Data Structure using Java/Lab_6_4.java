import java.util.*;
class Counter{
    static int totalCount = 0;

    String takeString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    int countVowel(String str){
        int c = 0;

        for(char ch : str.toCharArray()){
            if(isVowel(ch)){
                c++;
            }
        }

        return c;
    }

    boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return true;
        return false;
    }

    void start(){
        while(true){
            String str = takeString();
            if(str.toLowerCase().equals("quit")) break;
            int c = countVowel(str.toLowerCase());
            totalCount += c;
        }

        System.out.println(totalCount-2);
    }
}

public class Lab_6_4 {
    public static void main(String args[]){
        Counter c1 = new Counter();
        c1.start();
    }
}
