import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainLandingPage extends JFrame {
    public MainLandingPage() {
        setTitle("Online Exam System - Home");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 255)); // Metallic blue
        setLocationRelativeTo(null); // Center

        JLabel logoLabel = new JLabel("ONLINE EXAM SYSTEM"); // Simple text logo
        logoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setBounds(120, 50, 300, 50);
        add(logoLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(175, 150, 150, 50);
        add(loginButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(175, 220, 150, 50);
        add(aboutButton);

        loginButton.addActionListener(e -> {
            new UserLoginPage().setVisible(true);
            dispose();
        });

        aboutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Exam System v1.0\nCreated using Java Swing\nAdmin can add questions\nStudents can take exams with timer.");
        });
    }

    public static void main(String[] args) {
        new MainLandingPage().setVisible(true);
    }
}
