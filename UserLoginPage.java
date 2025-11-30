import javax.swing.*;
import java.util.HashMap;

public class UserLoginPage extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    HashMap<String, String[]> users = new HashMap<>();

    public UserLoginPage() {
        users.put("admin", new String[]{"admin123", "admin"});
        users.put("student", new String[]{"stud123", "student"});

        setTitle("Login Page");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 20, 150, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 150, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 120, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if(users.containsKey(username) && users.get(username)[0].equals(password)) {
                String role = users.get(username)[1];
                JFrame nextPage;
                if(role.equals("admin")) nextPage = new AdminDashboardPage();
                else nextPage = new StudentExamPage();

                nextPage.setLocationRelativeTo(null);
                nextPage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login!");
            }
        });
    }
}
