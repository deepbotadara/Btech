import java.util.*;

public class Lab_4_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=s.toLowerCase();
        char c;
        int vowel=0,consonants=0;
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                vowel=vowel+1;
            }

            else{
                consonants+=1;
            }
        }
        
        System.out.println("String "+s+ " contains "+ vowel + " vowels and "+ consonants+" consonants");
        
    }
}
