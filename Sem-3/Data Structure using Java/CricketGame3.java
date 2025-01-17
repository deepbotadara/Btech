import java.util.Scanner;

// Interface for match rules
interface MatchRules {
    void showScoreboard();
    void incrementLegalBall();  // Abstract method defined in interface
    void incrementNonLegalBall();
}

// Custom exception for invalid wicket on free hit
class FreeHitException extends Exception {
    public FreeHitException(String message) {
        super(message);
    }
}

// Abstract class for common match-related properties
abstract class CricketMatch implements MatchRules {
    protected String battingTeam;
    protected int totalRuns;
    protected int wickets;
    protected int fours;
    protected int sixes;
    protected int wideBalls;
    protected int noBalls;
    protected int legalBallCount; // Legal ball count (for overs and balls display)
    protected int totalBallCount; // Total ball count (for calculating no-balls and wide-balls correctly)
    protected int oversPlayed;
    protected static final int BALLS_PER_OVER = 6;  // Final constant
    protected static final int TOTAL_PLAYERS = 11;  // Total players in a cricket team

    // Constructor using "this"
    public CricketMatch(String battingTeam) {
        this.battingTeam = battingTeam;
        this.totalRuns = 0;
        this.wickets = 0;
        this.fours = 0;
        this.sixes = 0;
        this.wideBalls = 0;
        this.noBalls = 0;
        this.legalBallCount = 0;
        this.totalBallCount = 0; // Total deliveries bowled (legal + no-balls + wide balls)
        this.oversPlayed = 0;
    }

    // Method overloading: overloaded method for incrementing legal ball with an argument
    public void incrementLegalBall(int balls) {
        legalBallCount += balls;
        totalBallCount += balls;
        if (legalBallCount >= BALLS_PER_OVER) {
            oversPlayed += legalBallCount / BALLS_PER_OVER;
            legalBallCount %= BALLS_PER_OVER;
        }
    }

    // Override abstract method from interface
    @Override
    public void incrementLegalBall() {
        incrementLegalBall(1);  // Calls the overloaded method
    }

    // Increment for wide/no-ball, which does not count as a legal delivery
    @Override
    public void incrementNonLegalBall() {
        totalBallCount++;  // Increment total balls for wide/no-balls, but not legal count
    }

    // Additional method to override (for customization in subclasses)
    public void endMatch() {
        System.out.println("Match has ended.");
    }
}

// Inherited class for T20 match (Inheritance and Polymorphism)
class T20Match extends CricketMatch {

    public T20Match(String battingTeam) {
        super(battingTeam);  // Call parent class constructor
    }

    // Override the abstract method (Polymorphism)
    @Override
    public void showScoreboard() {
        // Correct calculation for total overs faced
        double oversFaced = oversPlayed + (legalBallCount / (double) BALLS_PER_OVER);
        double strikeRate = (oversFaced == 0) ? 0 : (double) totalRuns / oversFaced * 100; // Calculate strike rate
        int leftPlayers = TOTAL_PLAYERS - wickets;

        System.out.println("Scoreboard after " + oversPlayed + " overs and " + legalBallCount + " balls:");
        System.out.println("Batting team: " + battingTeam);
        System.out.println("Total runs: " + totalRuns);
        System.out.println("Wickets: " + wickets);
        System.out.println("Left Players: " + leftPlayers);
        System.out.printf("Strike Rate: %.2f%n", strikeRate);
        System.out.println("Fours: " + fours);
        System.out.println("Sixes: " + sixes);
        System.out.println("Wide Balls: " + wideBalls);
        System.out.println("No Balls: " + noBalls);
        System.out.println("-----------------------");
    }

    // Override endMatch method to provide custom message
    @Override
    public void endMatch() {
        System.out.println("T20 match has ended.");
    }
}

// Main class for match setup and rules
public class CricketGame3 {
    private static final Scanner sc = new Scanner(System.in);  // Static keyword for class-level property

    public static void main(String[] args) {
        System.out.print("Select type of match (T20/ODI): ");
        String matchType = sc.nextLine();
        
        System.out.print("Select batting team: ");
        String battingTeam = sc.nextLine();
        
        CricketMatch match;
        if (matchType.equalsIgnoreCase("T20")) {
            match = new T20Match(battingTeam);  // Polymorphism
        } else {
            match = new T20Match(battingTeam);  // For simplicity, using T20 as default
        }

        System.out.print("Enter number of overs to be played: ");
        int overs = sc.nextInt();
        sc.nextLine();  // Consume newline

        playMatch(match, overs);
    }

    // Encapsulation using private access modifier
    private static void playMatch(CricketMatch match, int maxOvers) {
        boolean isFreeHit = false;  // For free-hit scenario
        for (int over = 0; over < maxOvers; over++) {
            for (int ball = 0; ball < CricketMatch.BALLS_PER_OVER; ) { // Remove the ball increment here
                try {
                    if (match.wickets >= CricketMatch.TOTAL_PLAYERS - 1) {
                        System.out.println("All players are out. Innings ended.");
                        match.endMatch();  // Call the overridden method for match end
                        return; // End if all players are out
                    }

                    System.out.print("Enter run/wide-ball/wicket/no-ball for ball " + (ball + 1) + ": ");
                    String event = sc.nextLine();

                    if (event.equals("wd")) {
                        match.totalRuns += 1;   // Add 1 run for wide ball
                        match.wideBalls += 1;
                        match.incrementNonLegalBall();  // Wide ball does not count as legal
                        System.out.println("Wide Ball! +1 run");
                    } else if (event.equals("nb")) {
                        match.totalRuns += 1;   // Add 1 run for no-ball
                        match.noBalls += 1;
                        isFreeHit = true;  // Set free hit for the next ball
                        match.incrementNonLegalBall();  // No ball does not count as legal
                        System.out.println("No Ball! +1 run and free-hit");
                    } else if (event.equals("w")) {
                        if (isFreeHit) {
                            throw new FreeHitException("Wicket not allowed on Free Hit!");
                        } else {
                            match.wickets += 1;
                            System.out.println("Wicket!");
                        }
                        match.incrementLegalBall();
                        ball++; // Increment the ball count only here
                    } else {
                        int runs = Integer.parseInt(event);
                        match.totalRuns += runs;

                        if (runs == 4) {
                            match.fours += 1;
                        } else if (runs == 6) {
                            match.sixes += 1;
                        }

                        match.incrementLegalBall();
                        ball++; // Increment the ball count only here
                        isFreeHit = false;  // Reset free hit after the legal ball
                    }

                    match.showScoreboard();  // Show scoreboard after every ball

                } catch (FreeHitException e) {
                    System.out.println(e.getMessage());
                }

                if (match.wickets >= CricketMatch.TOTAL_PLAYERS - 1) {
                    System.out.println("All players are out. Innings ended.");
                    match.endMatch();  // Call the overridden method for match end
                    return; // End if all players are out
                }
            }
        }
        System.out.println("Innings completed.");
        match.endMatch();  // Call the overridden method for match end
    }
}
