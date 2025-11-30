import javax.swing.*;

public class StudentResultPage extends JFrame {
    public StudentResultPage(String studentName,int score) {
        setTitle("Result");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel resultLabel = new JLabel(studentName+"'s Score: "+score);
        resultLabel.setBounds(50,50,200,30);
        add(resultLabel);
    }
}
