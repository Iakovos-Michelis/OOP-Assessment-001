package oop_assignment2;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField UsernameField;
    private JPasswordField PasswordField;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        UsernameField = new JTextField();
        PasswordField = new JPasswordField();

        JButton LoginButton = new JButton("Login");
        JButton RegisterButton = new JButton("Register");

        panel.add(new JLabel("Username: "));
        panel.add(UsernameField);
        panel.add(new JLabel("Password: "));
        panel.add(PasswordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(LoginButton);
        buttonPanel.add(RegisterButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        LoginButton.addActionListener(e -> handleLogin());
        RegisterButton.addActionListener(e -> handleRegister());

        setVisible(true);
    }

    private void handleLogin() {
        String username = UsernameField.getText().trim();
        String password = new String(PasswordField.getPassword());

        User user = Database.login(username, password);
        if (user != null) {
            dispose();
            new GameFrame(user);
        } else {
            JOptionPane.showMessageDialog(this, "Login failed");
        }
    }

    private void handleRegister() {
        String username = UsernameField.getText().trim();
        String password = new String(PasswordField.getPassword());

        boolean success = Database.register(username, password);
        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful");
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed");
        }
    }
}