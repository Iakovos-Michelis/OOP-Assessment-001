package homework2;

public class Game {

    private String FirstTeam;
    private String SecondTeam;
    private int FirstScore;
    private int SecondScore;

    // Creating a match between two teams and their scores
    public Game(String FirstTeam, String SecondTeam, int FirstScore, int SecondScore) {
        this.FirstTeam = FirstTeam;
        this.SecondTeam = SecondTeam;
        this.FirstScore = FirstScore;
        this.SecondScore = SecondScore;
    }


    public String getFirstTeam() {
        return FirstTeam;
    }

    public String getSecondTeam() {
        return SecondTeam;
    }

    public int getFirstScore() {
        return FirstScore;
    }

    public int getSecondScore() {
        return SecondScore;
    }
}