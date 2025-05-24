package homework5;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Main educational app to teach letters using animal pictures
public class PreschoolTraining {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Preschool Training - Animals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Load all animals
        List<Animals> animals = AnimalData.getAllAnimals();
        int[] currentIndex = {0};


        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Input guessing letter
        JTextField inputField = new JTextField(2);
        inputField.setFont(new Font("Arial", Font.BOLD, 20));
        inputField.setHorizontalAlignment(JTextField.CENTER);

        // Message label for feedback
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Buttons
        JButton checkButton = new JButton("Check Letter");
        JButton nextButton = new JButton("Next Animal");

        // Show the initial image
        updateAnimalImage(imageLabel, animals.get(currentIndex[0]));

        // Check button action
        checkButton.addActionListener(e -> {
            String guess = inputField.getText().trim().toUpperCase();
            Animals current = animals.get(currentIndex[0]);

            if (guess.equals(current.getFirstLetter())) {
                messageLabel.setText("Correct! '" + current.getFirstLetter() + "' is for " + current.getName());
                messageLabel.setForeground(Color.GREEN.darker());
                nextButton.setEnabled(true);
            } else {
                messageLabel.setText("Wrong. Try again.");
                messageLabel.setForeground(Color.RED);
            }
        });

        // Next button action
        nextButton.addActionListener(e -> {
            currentIndex[0] = (currentIndex[0] + 1) % animals.size();
            updateAnimalImage(imageLabel, animals.get(currentIndex[0]));
            inputField.setText("");
            messageLabel.setText("");
            nextButton.setEnabled(false);
        });

        // JPanel for inputs and buttons
        JPanel controlPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputRow = new JPanel(new FlowLayout());
        inputRow.add(new JLabel("Enter first letter:"));
        inputRow.add(inputField);
        inputRow.add(checkButton);

        JPanel messageRow = new JPanel(new FlowLayout());
        messageRow.add(messageLabel);

        JPanel buttonRow = new JPanel(new FlowLayout());
        buttonRow.add(nextButton);

        controlPanel.add(inputRow);
        controlPanel.add(messageRow);
        controlPanel.add(buttonRow);

        // Add everything to a frame
        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Show window
        frame.setVisible(true);
    }


    private static void updateAnimalImage(JLabel label, Animals animal) {
        String imagePath = "/" + animal.getImagePath();
        java.net.URL imgURL = PreschoolTraining.class.getResource(imagePath);

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage();
            Image resized = img.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(resized));
            label.setText(null);
            System.out.println("Image loaded: " + imgURL);
        } else {
            System.out.println("Image not found at: " + imagePath);
            label.setText("Image not found");
            label.setIcon(null);
        }
    }

}