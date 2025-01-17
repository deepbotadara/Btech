import java.util.Scanner;

public class CricketGame1 {
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
        int totalRuns = 0, wickets = 0, noBalls = 0, wideBalls = 0;
        int fours = 0, sixes = 0;
        boolean isFreeHit = false;

        int ballsPlayed = 0;  // Keeps track of legitimate balls bowled
        for (int i = 0; i < totalBalls; i++) {
            System.out.println("Enter run/wide-ball/wicket/no-ball for ball " + (ballsPlayed + 1) + ": ");
            String ballEvent = sc.next();

            switch (ballEvent.toLowerCase()) {
                case "w":
                    if (isFreeHit) {
                        System.out.println("Wicket attempt on Free Hit! No wicket.");
                    } else {
                        System.out.println("Wicket!");
                        wickets++;
                        ballsPlayed++; // Wicket is counted as a legitimate ball
                    }
                    isFreeHit = false;  // Reset free-hit status after the ball
                    ballsPlayed++; // Ensure to move to the next ball after free-hit
                    break;
                case "wd":
                    System.out.println("Wide Ball! +1 run");
                    totalRuns++;
                    wideBalls++;
                    totalBalls++; // Add an extra ball for the wide but don't increment ballsPlayed
                    break;
                case "nb":
                    System.out.println("No Ball! +1 run and free-hit");
                    totalRuns++;
                    noBalls++;
                    totalBalls++; // Add an extra ball for the no-ball
                    isFreeHit = true;  // Activate free-hit on the next ball
                    i--; // Allow current ball to be replayed (no-ball doesn't increase ball count)
                    break;
                default:
                    int runs = Integer.parseInt(ballEvent);
                    totalRuns += runs;
                    if (runs == 4) {
                        fours++;
                    } else if (runs == 6) {
                        sixes++;
                    }
                    isFreeHit = false;  // Reset free-hit status after the ball
                    ballsPlayed++; // Count legitimate balls
                    break;
            }

            // Display scoreboard after every ball
            displayScoreboard(battingTeam, totalRuns, wickets, fours, sixes, wideBalls, noBalls, ballsPlayed);

            if (wickets == 10) {
                System.out.println("All out!");
                break;
            }
        }

        sc.close();
    }

    // Function to display scoreboard
    public static void displayScoreboard(String team, int runs, int wickets, int fours, int sixes, int wideBalls, int noBalls, int ballsPlayed) {
        int oversCompleted = ballsPlayed / 6;
        int ballsInCurrentOver = ballsPlayed % 6;

        System.out.println("\nScoreboard after " + oversCompleted + " overs and " + ballsInCurrentOver + " balls:");
        System.out.println("Batting team: " + team);
        System.out.println("Total runs: " + runs);
        System.out.println("Wickets: " + wickets);
        System.out.println("Fours: " + fours);
        System.out.println("Sixes: " + sixes);
        System.out.println("Wide Balls: " + wideBalls);
        System.out.println("No Balls: " + noBalls);
        System.out.println("-----------------------");
    }
}
