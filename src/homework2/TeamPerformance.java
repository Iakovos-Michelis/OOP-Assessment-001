package homework2;

import java.util.ArrayList;

public class TeamPerformance {

    private ArrayList<Game> MatchHistory = new ArrayList<>();

    // Add a match result
    public void addMatch(String teamA, String teamB, int scoreA, int scoreB) {
        MatchHistory.add(new Game(teamA, teamB, scoreA, scoreB));
    }

    // Analyze a team's performance in the match history
    public void analyzeTeam(String teamName) {
        int wins = 0, losses = 0, draws = 0;

        for (Game m : MatchHistory) {

            // If this team was in the first (home) position
            if (m.getFirstTeam().equals(teamName)) {
                if (m.getFirstScore() > m.getSecondScore()) {
                    wins++;
                } else if (m.getFirstScore() < m.getSecondScore()) {
                    losses++;
                } else {
                    draws++;
                }

                // If this team was in the second (away) position
            } else if (m.getSecondTeam().equals(teamName)) {
                if (m.getSecondScore() > m.getFirstScore()) {
                    wins++;
                } else if (m.getSecondScore() < m.getFirstScore()) {
                    losses++;
                } else {
                    draws++;
                }
            }
        }

        // Show results
        System.out.println("Performance for team: " + teamName);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println();
    }
}