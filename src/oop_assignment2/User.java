package oop_assignment2;

public class User {
    private int ID;
    private String Username;
    private int Score;

    public User(int ID, String Username, int Score) {
        this.ID = ID;
        this.Username = Username;
        this.Score = Score;
    }

    public int getId() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

    public int getScore() {
        return Score;
    }

    public void addScore(int points) {
        this.Score += points;
    }

    public void resetScore() {
        this.Score = 0;
    }
}