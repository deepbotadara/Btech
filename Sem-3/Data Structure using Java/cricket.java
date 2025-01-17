import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Main class for the Cricket Scoreboard
public class CricketTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Input: Number of overs to play
        System.out.println("\033c");
        System.out.println("----------------------------------");
        System.out.println("Enter Number of Overs to Play: ");
        System.out.println("----------------------------------");
        int oversToPlay = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Display predefined teams
        String[] teamNames = { "India", "New Zealand", "Australia", "England", "Pakistan", "Afghanistan", "Africa" };
        List<List<String>> predefinedTeams = createPredefinedTeams();
        System.out.println("\033c");

        System.out.println("----------------------------------");
        System.out.println("Available Teams:");
        System.out.println("----------------------------------");
        for (int i = 0; i < teamNames.length; i++) {
            System.out.println((i + 1) + ". " + teamNames[i]);
        }

        // Input: Select teams
        System.out.println("----------------------------------");
        System.out.println("\nSelect Team 1 (Enter number 1-7): ");
        System.out.println("----------------------------------");
        int team1Index = scanner.nextInt() - 1;
        scanner.nextLine();
        List<String> team1Players = predefinedTeams.get(team1Index);

        System.out.println("----------------------------------");
        System.out.println("\nSelect Team 2 (Enter number 1-7): ");
        System.out.println("----------------------------------");
        int team2Index = scanner.nextInt() - 1;
        scanner.nextLine();
        List<String> team2Players = predefinedTeams.get(team2Index);

        // Display players of the selected teams in a tabular format
        System.out.println("\033c");

        System.out.printf("%-25s %25s\n", "Team 1 (" + teamNames[team1Index] + ")", "Team 2 (" + teamNames[team2Index] + ")");
        System.out.println("---------------------------------------------------------");
        int maxPlayers = Math.max(team1Players.size(), team2Players.size());
        for (int i = 0; i < maxPlayers; i++) {
            String team1Player = (i < team1Players.size()) ? team1Players.get(i) : "";
            String team2Player = (i < team2Players.size()) ? team2Players.get(i) : "";
            System.out.printf("%-25s %25s\n", team1Player, team2Player);
        }

        // Input: Choose heads or tails for the toss
        System.out.println("\nTeam 1, choose Heads or Tails for the toss (Enter '1' for Heads, '2' for Tails):");
        int userTossChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\033c");

        // Simulate the toss
        int tossOutcome = random.nextInt(2) + 1;
        String tossResult = (tossOutcome == 1) ? "Heads" : "Tails";
        System.out.println("Toss result: " + tossResult);
        System.out.println("\033c");

        String tossWinner;
        if (tossOutcome == userTossChoice) {
            tossWinner = teamNames[team1Index];
            System.out.println("Team 1 (" + teamNames[team1Index] + ") wins the toss.");
        } else {
            tossWinner = teamNames[team2Index];
            System.out.println("Team 2 (" + teamNames[team2Index] + ") wins the toss.");
        }

        // Toss winner decides to bat or bowl
        System.out.println(tossWinner + ", choose '1' to Bat first or '2' to Bowl first:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\033c");

        String battingTeam = (choice == 1) ? tossWinner
                : (tossWinner.equals(teamNames[team1Index]) ? teamNames[team2Index] : teamNames[team1Index]);
        String bowlingTeam = (battingTeam.equals(teamNames[team1Index])) ? teamNames[team2Index]
                : teamNames[team1Index];
        List<String> battingPlayers = (battingTeam.equals(teamNames[team1Index])) ? team1Players : team2Players;
        List<String> bowlingPlayers = (bowlingTeam.equals(teamNames[team1Index])) ? team1Players : team2Players;

        // Play first innings
        Match firstInnings = new Match(battingTeam, bowlingTeam, battingPlayers, oversToPlay);
        int target = firstInnings.startMatch(scanner);

        // Play second innings
        System.out.println(
                "\n+-+-+-+-+-+-+-+-+-Target for " + bowlingTeam + " is " + (target + 1) + "+-+-+-+-+-+-+-+-+-");
        Match secondInnings = new Match(bowlingTeam, battingTeam, bowlingPlayers, oversToPlay);
        int secondInningsScore = secondInnings.startMatch(scanner);

        // Determine winner
        if (secondInningsScore > target) {
            System.out
                    .println(bowlingTeam + " wins the match by " + (10 - secondInnings.getWicketsLost()) + " wickets!");
        } else if (secondInningsScore < target) {
            System.out.println(battingTeam + " wins the match by " + (target - secondInningsScore) + " runs!");
        } else {
            System.out.println("+-+-+-+-+-+-+-+-+- Match is a tie! +-+-+-+-+-+-+-+-+-");
        }

        // Display match statistics for both innings
        System.out.println("------------------------------");
        System.out.println("\nMatch Statistics:");
        System.out.println("------------------------------");
        firstInnings.displayStatistics(bowlingTeam);
        secondInnings.displayStatistics(battingTeam);

        scanner.close();
    }

    // Method to create predefined teams with player names
    public static List<List<String>> createPredefinedTeams() {
        List<List<String>> teams = new ArrayList<>();
        teams.add(List.of("Rohit Sharma", "Virat Kohli", "Shubman Gill", "Suryakumar Yadav", "Hardik Pandya",
                "Ravindra Jadeja", "Jasprit Bumrah", "Mohammed Shami", "Kuldeep Yadav",
                "KL Rahul", "Shardul Thakur")); // Team India
        teams.add(List.of("Kane Williamson", "Devon Conway", "Tom Latham", "Daryl Mitchell", "Glenn Phillips",
                "Mitchell Santner", "Trent Boult", "Matt Henry", "Ish Sodhi",
                "Lockie Ferguson", "Tim Southee")); // Team New Zealand
        teams.add(List.of("David Warner", "Steve Smith", "Marnus Labuschagne", "Travis Head", "Glenn Maxwell",
                "Marcus Stoinis", "Pat Cummins", "Mitchell Starc", "Adam Zampa",
                "Josh Hazlewood", "Alex Carey")); // Team Australia
        teams.add(List.of("Joe Root", "Ben Stokes", "Jonny Bairstow", "Jos Buttler", "Moeen Ali",
                "Chris Woakes", "Mark Wood", "Jofra Archer", "Adil Rashid",
                "Sam Curran", "Liam Livingstone")); // Team England
        teams.add(List.of("Babar Azam", "Fakhar Zaman", "Mohammad Rizwan", "Imam-ul-Haq", "Shadab Khan",
                "Shaheen Afridi", "Haris Rauf", "Naseem Shah", "Imad Wasim",
                "Mohammad Nawaz", "Iftikhar Ahmed")); // Team Pakistan
        teams.add(List.of("Rahmanullah Gurbaz", "Ibrahim Zadran", "Najibullah Zadran", "Hashmatullah Shahidi",
                "Mohammad Nabi",
                "Rashid Khan", "Mujeeb Ur Rahman", "Fazalhaq Farooqi", "Azmatullah Omarzai",
                "Qais Ahmad", "Gulbadin Naib")); // Team Afghanistan
        teams.add(List.of("Quinton de Kock", "David Miller", "Temba Bavuma", "Kagiso Rabada", "Rassie van der Dussen",
                "Aiden Markram", "Anrich Nortje", "Tabraiz Shamsi", "Lungi Ngidi",
                "Keshav Maharaj", "Heinrich Klaasen")); // Team Africa
        return teams;
    }
}

// Match class to handle the match logic
class Match {
    private String battingTeam;
    private String bowlingTeam;
    private List<String> battingPlayers;
    private int overs;
    private int totalRuns;
    private int wicketsLost;
    private int[] playerScores;

    public Match(String battingTeam, String bowlingTeam, List<String> battingPlayers, int overs) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.battingPlayers = battingPlayers;
        this.overs = overs;
        this.totalRuns = 0;
        this.wicketsLost = 0;
        this.playerScores = new int[battingPlayers.size()];
    }

    public int startMatch(Scanner scanner) {
        int ballsPerOver = 6;
        int maxBalls = overs * ballsPerOver;
        int strikerIndex = 0;
        int nonStrikerIndex = 1;
        boolean freeHit = false;
        int ballsBowled = 0;
        int[] ballsFaced = new int[battingPlayers.size()]; // To track balls faced by each player
    
        System.out.println("---------------------------------------------------");
        System.out.println("Match Start: " + battingTeam + " vs " + bowlingTeam);
        System.out.println("---------------------------------------------------\n");
    
        for (int ball = 1; ball <= maxBalls && wicketsLost < battingPlayers.size(); ) {
            int currentOver = (ball - 1) / ballsPerOver + 1;
            int currentBallInOver = (ball - 1) % ballsPerOver + 1;
    
            System.out.println("\n===========================");
            System.out.println("Over " + currentOver + ", Ball " + currentBallInOver);
            System.out.println("===========================");
            System.out.println("Striker: " + battingPlayers.get(strikerIndex));
            System.out.println("Non-Striker: " + battingPlayers.get(nonStrikerIndex));
    
            System.out.println("\nEnter runs scored on this ball:");
            System.out.println("Choices: 0-6 for runs, 'w' for wicket, 'wd' for wide, 'nb' for no-ball, 'lb' for leg byes, 'b' for byes:");
            String input = scanner.nextLine();
    
            switch (input) {
                case "w":
                    if (!freeHit) {
                        System.out.println("WICKET! " + battingPlayers.get(strikerIndex) + " is out!");
                        wicketsLost++;
                        strikerIndex = (wicketsLost < battingPlayers.size()) ? wicketsLost : strikerIndex;
                    } else {
                        System.out.println("Free Hit! No wicket falls.");
                        freeHit = false; // Reset free hit after it is used
                    }
                    ball++;
                    ballsBowled++;
                    break;
                case "wd":
                    totalRuns++;
                    System.out.println("Wide Ball! 1 run added to the total.");
                    break;
                case "nb":
                    totalRuns++;
                    freeHit = true;
                    System.out.println("No-Ball! 1 run added, and the next ball is a Free Hit.");
                    break;
                case "lb":
                    System.out.println("Enter runs for leg byes:");
                    int legByes = scanner.nextInt();
                    scanner.nextLine();
                    totalRuns += legByes;
                    System.out.println("Leg Byes: " + legByes + " run(s) added.");
                    ball++;
                    ballsBowled++;
                    break;
                case "b":
                    System.out.println("Enter runs for byes:");
                    int byes = scanner.nextInt();
                    scanner.nextLine();
                    totalRuns += byes;
                    System.out.println("Byes: " + byes + " run(s) added.");
                    ball++;
                    ballsBowled++;
                    break;
                default:
                    try {
                        int runs = Integer.parseInt(input);
                        if (runs >= 0 && runs <= 6) {
                            totalRuns += runs;
                            playerScores[strikerIndex] += runs;
                            ballsFaced[strikerIndex]++; // Increase balls faced by the striker
    
                            System.out.println(battingPlayers.get(strikerIndex) + " scores " + runs + " run(s).");
    
                            // Change strike if odd runs are scored
                            if (runs % 2 != 0) {
                                int temp = strikerIndex;
                                strikerIndex = nonStrikerIndex;
                                nonStrikerIndex = temp;
                            }
    
                            ball++;
                            ballsBowled++;
                        } else {
                            System.out.println("Invalid input. Enter runs between 0-6.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter runs between 0-6, 'w', 'wd', 'nb', 'lb', or 'b'.");
                    }
                    break;
            }
    
            // Change strike and display completed over message at the end of each over
            if (ball % ballsPerOver == 0) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("End of Over " + currentOver + " | " + battingTeam + ": " + totalRuns + "/" + wicketsLost);
                System.out.println("---------------------------------------------------\n");
                int temp = strikerIndex;
                strikerIndex = nonStrikerIndex;
                nonStrikerIndex = temp;
                System.out.println("Strike has been changed for the new over.");
            }
    
            // Calculate run rate
            double oversFaced = ballsBowled / 6.0;
            double runRate = (oversFaced > 0) ? totalRuns / oversFaced : 0.0;
            System.out.println("Current Run Rate: " + String.format("%.2f", runRate));
    
            // Calculate and display strike rate for the current striker
            double strikeRate = (ballsFaced[strikerIndex] > 0) ? 
                    (playerScores[strikerIndex] / (double) ballsFaced[strikerIndex]) * 100 : 0.0;
            System.out.println(battingPlayers.get(strikerIndex) + " Strike Rate: " + String.format("%.2f", strikeRate));
    
            System.out.println("\nCurrent Score: " + battingTeam + " " + totalRuns + "/" + wicketsLost + " in " + oversFaced + " overs.");
        }
    
        System.out.println("\n===================================================");
        System.out.println("Innings Complete: " + battingTeam + " scored " + totalRuns + "/" + wicketsLost + " in " + overs + " overs.");
        System.out.println("===================================================\n");
        return totalRuns;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    public void displayStatistics(String opponentTeam) {
        System.out.printf("%-25s %25s\n", battingTeam + " Innings", opponentTeam + " Bowling");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < battingPlayers.size(); i++) {
            System.out.println("\033c");
            System.out.printf("%-25s %25s\n", battingPlayers.get(i) + ": " + playerScores[i] + " runs", "");
        }
        System.out.print("Total: " + totalRuns + "/" + wicketsLost);
        
    }
}