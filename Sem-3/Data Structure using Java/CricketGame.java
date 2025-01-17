import java.util.Scanner;

public class CricketGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Select match type
        System.out.println("Select type of match (ODI/T20): ");
        String matchType = sc.nextLine();

        // Input: Select team for batting
        System.out.println("Select batting team: ");
        String battingTeam = sc.nextLine();

        // Input: Number of overs to be played
        System.out.println("Enter number of overs to be played: ");
        int overs = sc.nextInt();

        int totalBalls = overs * 6;
        int[] runsPerBall = new int[totalBalls];
        int totalRuns = 0, wickets = 0, noBalls = 0, wideBalls = 0;
        int fours = 0, sixes = 0;

        for (int i = 0; i < totalBalls; i++) {
            System.out.println("Enter run/wide-ball/wicket/no-ball for ball " + (i + 1) + ": ");
            String ballEvent = sc.next();

            switch (ballEvent.toLowerCase()) {
                case "w":
                    System.out.println("Wicket!");
                    wickets++;
                    break;
                case "wd":
                    System.out.println("Wide Ball! +1 run");
                    totalRuns++;
                    wideBalls++;
                    totalBalls++; // extra ball
                    break;
                case "nb":
                    System.out.println("No Ball! +1 run and free-hit");
                    totalRuns++;
                    noBalls++;
                    totalBalls++; // extra ball
                    i--; // repeat the current ball due to free-hit
                    break;
                default:
                    int runs = Integer.parseInt(ballEvent);
                    runsPerBall[i] = runs;
                    totalRuns += runs;
                    if (runs == 4) {
                        fours++;
                    } else if (runs == 6) {
                        sixes++;
                    }
                    break;
            }

            if (wickets == 10) {
                System.out.println("All out!");
                break;
            }
        }

        // Output statistics
        System.out.println("\nMatch Summary:");
        System.out.println("Batting team: " + battingTeam);
        System.out.println("Total runs: " + totalRuns);
        System.out.println("Total wickets: " + wickets);
        System.out.println("No Balls: " + noBalls);
        System.out.println("Wide Balls: " + wideBalls);
        System.out.println("Fours: " + fours);
        System.out.println("Sixes: " + sixes);

        // Calculate average run per over
        double averageRunRate = (double) totalRuns / overs;
        System.out.println("Average run rate: " + averageRunRate);

        sc.close();
    }
}
