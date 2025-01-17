import java.util.Random;
import java.util.Scanner;

// Interface for match rules
interface MatchRules {
    void showScoreboard();
    void incrementLegalBall();
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
    protected String bowlingTeam;
    protected int totalRuns;
    protected int wickets;
    protected int fours;
    protected int sixes;
    protected int wideBalls;
    protected int noBalls;
    protected int legalBallCount;
    protected int totalBallCount;
    protected int oversPlayed;
    protected static final int BALLS_PER_OVER = 6;
    protected static final int TOTAL_PLAYERS = 11;

    public CricketMatch(String battingTeam, String bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.totalRuns = 0;
        this.wickets = 0;
        this.fours = 0;
        this.sixes = 0;
        this.wideBalls = 0;
        this.noBalls = 0;
        this.legalBallCount = 0;
        this.totalBallCount = 0;
        this.oversPlayed = 0;
    }

    public void incrementLegalBall(int balls) {
        legalBallCount += balls;
        totalBallCount += balls;
        if (legalBallCount >= BALLS_PER_OVER) {
            oversPlayed += legalBallCount / BALLS_PER_OVER;
            legalBallCount %= BALLS_PER_OVER;
        }
    }

    public void incrementLegalBall() {
        incrementLegalBall(1);
    }

    public void incrementNonLegalBall() {
        totalBallCount++;
    }

    public abstract void endMatch();
}

// Inherited class for T20 match
class T20Match extends CricketMatch {

    public T20Match(String battingTeam, String bowlingTeam) {
        super(battingTeam, bowlingTeam);
    }

    @Override
    public void showScoreboard() {
        double strikeRate = (totalBallCount == 0) ? 0 : (double) totalRuns / (totalBallCount);
        int leftPlayers = TOTAL_PLAYERS - wickets;

        System.out.println("\n===============================");
        System.out.println("   Scoreboard for " + battingTeam);
        System.out.println("===============================");
        System.out.printf("Overs Played     : %d.%d\n", oversPlayed, legalBallCount);
        System.out.println("Total Runs       : " + totalRuns);
        System.out.println("Wickets          : " + wickets);
        System.out.println("Players Left     : " + leftPlayers);
        System.out.printf("Strike Rate      : %.2f\n", strikeRate);
        System.out.println("Fours            : " + fours);
        System.out.println("Sixes            : " + sixes);
        System.out.println("Wide Balls       : " + wideBalls);
        System.out.println("No Balls         : " + noBalls);
        System.out.println("===============================\n");
    }

    @Override
    public void endMatch() {
        System.out.println("T20 match has ended.");
    }
}

// Main class for match setup and rules
public class CricketGame5 {
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] teams = {"India", "Australia", "New Zealand", "England", "Pakistan"};

    public static void main(String[] args) {
        System.out.println("Select your team:");
        for (int i = 0; i < teams.length; i++) {
            System.out.println((i + 1) + ". " + teams[i]);
        }

        int userTeamChoice = getUserChoice(1, teams.length) - 1;
        String userTeam = teams[userTeamChoice];
        String opponentTeam = selectOpponentTeam(userTeamChoice);
        System.out.println("\nYour team: " + userTeam);
        System.out.println("Opponent team: " + opponentTeam);

        String tossWinner = conductToss(userTeam, opponentTeam);
        System.out.println("\n" + tossWinner + " won the toss!");

        String decision = getBattingDecision(tossWinner);

        String battingTeam, bowlingTeam;
        if (decision.equals("bat")) {
            battingTeam = tossWinner;
            bowlingTeam = (tossWinner.equals(userTeam)) ? opponentTeam : userTeam;
        } else {
            bowlingTeam = tossWinner;
            battingTeam = (tossWinner.equals(userTeam)) ? opponentTeam : userTeam;
        }

        // Setup match
        CricketMatch match = new T20Match(battingTeam, bowlingTeam);
        System.out.print("\nEnter number of overs to be played: ");
        int overs = sc.nextInt();
        sc.nextLine(); // Consume newline

        // First innings
        playMatch(match, overs);
        int firstInningsRuns = match.totalRuns;

        // Swap teams for second innings
        CricketMatch secondInnings = new T20Match(bowlingTeam, battingTeam);
        System.out.println("\nSecond innings begins! " + bowlingTeam + " needs " + (firstInningsRuns + 1) + " to win.");
        playMatch(secondInnings, overs);

        // Display result
        displayResult(firstInningsRuns, secondInnings.totalRuns, battingTeam, bowlingTeam);
    }

    private static int getUserChoice(int min, int max) {
        int choice;
        while (true) {
            choice = sc.nextInt();
            if (choice >= min && choice <= max) break;
            System.out.println("Invalid choice. Please select again:");
        }
        return choice;
    }

    private static String selectOpponentTeam(int userTeamChoice) {
        Random rand = new Random();
        int opponentChoice;
        do {
            opponentChoice = rand.nextInt(teams.length);
        } while (opponentChoice == userTeamChoice);
        return teams[opponentChoice];
    }

    private static String conductToss(String userTeam, String opponentTeam) {
        Random rand = new Random();
        return (rand.nextBoolean()) ? userTeam : opponentTeam;
    }

    private static String getBattingDecision(String tossWinner) {
        System.out.print(tossWinner + ", choose to bat or bowl (bat/bowl): ");
        String decision;
        while (true) {
            decision = sc.nextLine().toLowerCase();
            if (decision.equals("bat") || decision.equals("bowl")) break;
            System.out.println("Invalid input. Please choose 'bat' or 'bowl': ");
        }
        return decision;
    }

    private static void playMatch(CricketMatch match, int maxOvers) {
        boolean isFreeHit = false;
        for (int over = 0; over < maxOvers; over++) {
            for (int ball = 0; ball < CricketMatch.BALLS_PER_OVER;) {
                try {
                    if (match.wickets >= CricketMatch.TOTAL_PLAYERS - 1) {
                        System.out.println("All players are out. Innings ended.");
                        match.endMatch();
                        return;
                    }

                    System.out.print("Enter run/wide-ball/wicket/no-ball for ball " + (ball + 1) + ": ");
                    String event = sc.nextLine().toLowerCase();

                    if (event.equals("wd")) {
                        match.totalRuns += 1;
                        match.wideBalls += 1;
                        match.incrementNonLegalBall();
                        System.out.println("Wide Ball! +1 run");
                    } else if (event.equals("nb")) {
                        match.totalRuns += 1;
                        match.noBalls += 1;
                        isFreeHit = true;
                        match.incrementNonLegalBall();
                        System.out.println("No Ball! +1 run and free-hit");
                    } else if (event.equals("w")) {
                        if (isFreeHit) {
                            throw new FreeHitException("Wicket not allowed on Free Hit!");
                        } else {
                            match.wickets += 1;
                            System.out.println("Wicket!");
                        }
                        match.incrementLegalBall();
                        ball++;
                    } else {
                        try {
                            int runs = Integer.parseInt(event);
                            match.totalRuns += runs;

                            if (runs == 4) {
                                match.fours += 1;
                            } else if (runs == 6) {
                                match.sixes += 1;
                            }

                            match.incrementLegalBall();
                            ball++;
                            isFreeHit = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid run count.");
                        }
                    }

                    match.showScoreboard();

                } catch (FreeHitException e) {
                    System.out.println(e.getMessage());
                }

                if (match.wickets >= CricketMatch.TOTAL_PLAYERS - 1) {
                    System.out.println("All players are out. Innings ended.");
                    match.endMatch();
                    return;
                }
            }
        }
        System.out.println("Innings completed.");
        match.endMatch();
    }

    private static void displayResult(int firstInningsRuns, int secondInningsRuns, String battingTeam, String bowlingTeam) {
        System.out.println("\n===============================");
        System.out.println("   Match Result");
        System.out.println("===============================");
        System.out.println("First Innings Total: " + firstInningsRuns);
        System.out.println("Second Innings Total: " + secondInningsRuns);
        if (secondInningsRuns > firstInningsRuns) {
            System.out.println(bowlingTeam + " wins!");
        } else if (secondInningsRuns < firstInningsRuns) {
            System.out.println(battingTeam + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println("===============================\n");
    }
}
