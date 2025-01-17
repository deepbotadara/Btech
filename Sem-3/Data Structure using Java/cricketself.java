import java.util.*;

public class cricketself {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ball = 0;
        long run = 0;
        int players = 11;
        System.out.println("Enter the number of overs");
        int over = sc.nextInt();

        for (int i = 1; i <= over * 6 && players > 0; i++) {
            System.out.println("Enter runs (0-6) or w for wicket, wd for wide ball, n for no ball");
            String s = sc.next();
            
            if (s.equals("w")) {
                ball++;
                players--;
            } else if (s.equals("wd") || s.equals("n")) {
                run++;
                ball++;  
            } else {
                int runs = Integer.parseInt(s);
                run += runs;
                ball++;
            }
            
            System.out.println("Score board: Players left: " + players + " Balls: " + ball + " Runs: " + run);
        }
    }
}

class cricket {

}
