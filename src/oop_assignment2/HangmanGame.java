package oop_assignment2;

public class HangmanGame {
    private String OriginalWord;
    private char[] DisplayWord;
    private int WrongGuesses;
    private final int maxWrongGuesses = 6;

    public HangmanGame(String word) {
        this.OriginalWord = word.toLowerCase();
        this.DisplayWord = new char[word.length()];
        this.WrongGuesses = 0;

        // Show only the first and last letter
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 || i == word.length() - 1) {
                DisplayWord[i] = word.charAt(i);
            } else {
                DisplayWord[i] = '-';
            }
        }
    }

    // Returns the word with the right letters given from the user
    public String getDisplayWord() {
        return new String(DisplayWord);
    }

    // Returns the original word
    public String getOriginalWord() {
        return OriginalWord;
    }

    // Returns the number of mistakes made by the user
    public int getWrongGuesses() {
        return WrongGuesses;
    }

    // Check if the given letter is in the word
    public boolean guess(char letter) {
        boolean found = false;

        for (int i = 1; i < OriginalWord.length() - 1; i++) {
            if (OriginalWord.charAt(i) == letter && DisplayWord[i] == '-') {
                DisplayWord[i] = letter;
                found = true;
            }
        }

        if (!found) {
            WrongGuesses++;
        }

        return found;
    }

    // Check if the user won
    public boolean isWon() {
        return OriginalWord.equals(getDisplayWord());
    }

    // Check if the user lost
    public boolean isLost() {
        return WrongGuesses >= maxWrongGuesses;
    }
}
