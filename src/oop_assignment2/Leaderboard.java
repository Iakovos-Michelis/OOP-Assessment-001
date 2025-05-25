package oop_assignment2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Leaderboard extends JFrame {

    public Leaderboard() {
        setTitle("Leaderboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false);
        leaderboardArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(leaderboardArea));

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT username, score FROM users ORDER BY score DESC LIMIT 10")) {

            StringBuilder sb = new StringBuilder("Top Players:\n\n");
            int rank = 1;
            while (rs.next()) {
                sb.append(rank++)
                        .append(". ")
                        .append(rs.getString("username"))
                        .append(" - ")
                        .append(rs.getInt("score"))
                        .append("\n");
            }
            leaderboardArea.setText(sb.toString());
        } catch (SQLException e) {
            leaderboardArea.setText("Error loading leaderboard.");
            e.printStackTrace();
        }

        setVisible(true);
    }
}

