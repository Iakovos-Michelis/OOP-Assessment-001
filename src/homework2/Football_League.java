package homework2;

import java.util.Scanner;

public class Football_League {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TeamPerformance stats = new TeamPerformance();

        while (true) {
            // Show menu options
            System.out.println("=== Football League Menu ===");
            System.out.println("1. Add a match result");
            System.out.println("2. View team performance");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine(); // Read user's choice

            switch (choice) {
                case "1":
                    // Adding a match
                    System.out.print("Enter name of first team: ");
                    String teamA = input.nextLine();

                    System.out.print("Enter name of second team: ");
                    String teamB = input.nextLine();

                    System.out.print("Enter score for " + teamA + ": ");
                    int scoreA = Integer.parseInt(input.nextLine());

                    System.out.print("Enter score for " + teamB + ": ");
                    int scoreB = Integer.parseInt(input.nextLine());

                    stats.addMatch(teamA, teamB, scoreA, scoreB);
                    System.out.println("Match added successfully!\n");
                    break;

                case "2":
                    // Analyzing a team's performance
                    System.out.print("Enter team name: ");
                    String team = input.nextLine();
                    stats.analyzeTeam(team);
                    break;

                case "3":
                    // Exiting
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}