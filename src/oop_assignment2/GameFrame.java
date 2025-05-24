package oop_assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private HangmanGame game;
    private JTextField guessField;
    private JLabel wordLabel, wrongGuessesLabel, resultLabel;
    private JButton guessButton, tryAgainButton, logoutButton;
    private User User;

    public GameFrame(User User) {
        this.User = User;
        setTitle("Hangman Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startNewGame();

        setVisible(true);
    }

    private void startNewGame() {
        String word = WordProvider.fetchRandomWord();
        game = new HangmanGame(word);

        getContentPane().removeAll();

        // Panel creation
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Show word
        wordLabel = new JLabel(game.getDisplayWord());
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(wordLabel);

        guessField = new JTextField();
        panel.add(guessField);

        // Guess button
        guessButton = new JButton("Guess Letter");
        guessButton.addActionListener(new GuessButtonListener());
        panel.add(guessButton);

        // Show wrong guesses
        wrongGuessesLabel = new JLabel("Wrong guesses: 0");
        panel.add(wrongGuessesLabel);

        // Result message
        resultLabel = new JLabel("");
        panel.add(resultLabel);

        // Try again button
        tryAgainButton = new JButton("Try Again");
        tryAgainButton.setVisible(false);
        tryAgainButton.addActionListener(e -> startNewGame());
        panel.add(tryAgainButton);

        // Logout button
        logoutButton = new JButton("Logout");
        logoutButton.setVisible(false);
        logoutButton.addActionListener(e -> {
            dispose();
            new Login();
        });
        panel.add(logoutButton);

        add(panel);
        revalidate();
        repaint();
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = guessField.getText().trim().toLowerCase();
            guessField.setText("");

            if (input.length() == 1 && input.matches("[a-z]")) {
                char letter = input.charAt(0);

                if (game.guess(letter)) {
                    wordLabel.setText(game.getDisplayWord());
                    resultLabel.setText("");
                } else {
                    wrongGuessesLabel.setText("Wrong guesses: " + game.getWrongGuesses());
                }

                // Check if the game is won
                if (game.isWon()) {
                    resultLabel.setText("You won! The word was: " + game.getOriginalWord());
                    endGame();
                } else if (game.isLost()) {
                    resultLabel.setText("You lost! The word was: " + game.getOriginalWord());
                    endGame();
                }

            } else {
                resultLabel.setText("Please enter a valid letter.");
            }
        }
    }

    private void endGame() {
        guessField.setEnabled(false);
        guessButton.setEnabled(false);

        tryAgainButton.setVisible(true);
        logoutButton.setVisible(true);
    }
}
