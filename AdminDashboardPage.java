import javax.swing.*;
import java.util.ArrayList;

public class AdminDashboardPage extends JFrame {
    static ArrayList<Question> questions = new ArrayList<>();
    JTextField questionField, optionA, optionB, optionC, optionD, correctOptionField;
    JButton addButton, startExamButton;

    public AdminDashboardPage() {
        // Default questions
        if(questions.isEmpty()) {
            questions.add(new Question("Capital of India?", "Delhi","Mumbai","Kolkata","Chennai","A"));
            questions.add(new Question("Who developed Java?", "Dennis Ritchie","James Gosling","Bjarne Stroustrup","Guido van Rossum","B"));
            questions.add(new Question("2 + 2 = ?", "3","4","5","6","B"));
        }

        setTitle("Admin Dashboard");
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel qLabel = new JLabel("Question:");
        qLabel.setBounds(20, 20, 100, 25);
        add(qLabel);
        JLabel aLabel = new JLabel("Option A:");
        aLabel.setBounds(20, 60, 100, 25);
        add(aLabel);

// Option B Label
        JLabel bLabel = new JLabel("Option B:");
        bLabel.setBounds(20, 100, 100, 25);
        add(bLabel);

// Option C Label
        JLabel cLabel = new JLabel("Option C:");
        cLabel.setBounds(20, 140, 100, 25);
        add(cLabel);

// Option D Label
       JLabel dLabel = new JLabel("Option D:");
       dLabel.setBounds(20, 180, 100, 25);
       add(dLabel);

        questionField = new JTextField(); questionField.setBounds(120, 20, 300, 25); add(questionField);
        optionA = new JTextField(); optionA.setBounds(120, 60, 300, 25); add(optionA);
        optionB = new JTextField(); optionB.setBounds(120, 100, 300, 25); add(optionB);
        optionC = new JTextField(); optionC.setBounds(120, 140, 300, 25); add(optionC);
        optionD = new JTextField(); optionD.setBounds(120, 180, 300, 25); add(optionD);

        JLabel correctLabel = new JLabel("Correct Option (A/B/C/D):");
        correctLabel.setBounds(20, 220, 200, 25); add(correctLabel);
        correctOptionField = new JTextField(); correctOptionField.setBounds(220, 220, 50, 25); add(correctOptionField);

        addButton = new JButton("Add Question"); addButton.setBounds(120, 260, 150, 30); add(addButton);
        startExamButton = new JButton("Start Exam"); startExamButton.setBounds(120, 310, 200, 30); add(startExamButton);

        addButton.addActionListener(e -> {
            String q = questionField.getText().trim();
            String a = optionA.getText().trim(); String b = optionB.getText().trim();
            String c = optionC.getText().trim(); String d = optionD.getText().trim();
            String correct = correctOptionField.getText().trim().toUpperCase();
            if(!q.isEmpty() && !a.isEmpty() && !b.isEmpty() && !c.isEmpty() && !d.isEmpty() && "ABCD".contains(correct)) {
                questions.add(new Question(q,a,b,c,d,correct));
                JOptionPane.showMessageDialog(null,"Question added!");
                questionField.setText(""); optionA.setText(""); optionB.setText(""); optionC.setText(""); optionD.setText(""); correctOptionField.setText("");
            } else JOptionPane.showMessageDialog(null,"Please fill all fields correctly!");
        });

        startExamButton.addActionListener(e -> {
            if(questions.isEmpty()) { JOptionPane.showMessageDialog(null,"No questions to start exam!"); return; }
            StudentExamPage.index = 0; StudentExamPage.score = 0;
            JFrame examPage = new StudentExamPage();
            examPage.setLocationRelativeTo(null);
            examPage.setVisible(true);
            dispose();
        });
    }
}

class Question {
    String question, optionA, optionB, optionC, optionD, correctOption;
    public Question(String question,String a,String b,String c,String d,String correct) {
        this.question=question; this.optionA=a; this.optionB=b; this.optionC=c; this.optionD=d; this.correctOption=correct;
    }
}
