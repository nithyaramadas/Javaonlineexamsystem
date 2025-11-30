import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentExamPage extends JFrame {
    static int index = 0, score = 0;
    int timeLeft = 60;
    JLabel questionLabel, timerLabel;
    JButton nextButton;
    JRadioButton optA, optB, optC, optD;
    ButtonGroup bg;
    Timer timer;
    static HashMap<String, Integer> studentResults = new HashMap<>();
    String studentName;

    // List of questions directly in StudentExamPage
    ArrayList<Question> questions = new ArrayList<>();

    public StudentExamPage() {
        studentName = JOptionPane.showInputDialog("Enter your name:");
        if (studentName == null || studentName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty. Exiting.");
            System.exit(0);
        }

        // Add default 10 Java questions
        addQuestions();

        setTitle("Student Exam");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        questionLabel = new JLabel();
        questionLabel.setBounds(20, 20, 550, 50);
        add(questionLabel);

        optA = new JRadioButton(); optA.setBounds(20, 80, 550, 30); add(optA);
        optB = new JRadioButton(); optB.setBounds(20, 120, 550, 30); add(optB);
        optC = new JRadioButton(); optC.setBounds(20, 160, 550, 30); add(optC);
        optD = new JRadioButton(); optD.setBounds(20, 200, 550, 30); add(optD);

        bg = new ButtonGroup();
        bg.add(optA); bg.add(optB); bg.add(optC); bg.add(optD);

        timerLabel = new JLabel("Time left: 60");
        timerLabel.setBounds(450, 250, 120, 30);
        add(timerLabel);

        nextButton = new JButton("Next");
        nextButton.setBounds(250, 300, 100, 40);
        add(nextButton);

        showQuestion();

        nextButton.addActionListener(e -> nextQuestion());

        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft);
            if (timeLeft <= 0) nextQuestion();
        });
        timer.start();
    }

    // Method to add default questions
    void addQuestions() {
        questions.add(new Question("Which of these is not a Java feature?",
                                   "Object-oriented", "Use of pointers", "Portable", "Dynamic", "B"));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                                   "this", "super", "extends", "implements", "C"));
        questions.add(new Question("Which of the following is not a valid Java identifier?",
                                   "myVar", "var_1", "1var", "_myVar", "C"));
        questions.add(new Question("Which method is the entry point of a Java program?",
                                   "main()", "start()", "run()", "init()", "A"));
        questions.add(new Question("What is the size of int in Java?",
                                   "4 bytes", "2 bytes", "8 bytes", "Depends on OS", "A"));
        questions.add(new Question("Which of these is used for multithreading in Java?",
                                   "Runnable", "Thread", "Both A and B", "Interface", "C"));
        questions.add(new Question("Which exception is thrown when dividing by zero?",
                                   "IOException", "ArithmeticException", "ClassNotFoundException", "NullPointerException", "B"));
        questions.add(new Question("Which of these is a checked exception?",
                                   "IOException", "ArithmeticException", "NullPointerException", "ArrayIndexOutOfBoundsException", "A"));
        questions.add(new Question("Which of the following is not an access modifier in Java?",
                                   "private", "public", "protected", "package", "D"));
        questions.add(new Question("Which keyword is used to prevent inheritance of a class?",
                                   "final", "static", "abstract", "private", "A"));
    }

    void showQuestion() {
        if (index < questions.size()) {
            Question q = questions.get(index);
            questionLabel.setText("<html>Q" + (index + 1) + ": " + q.question + "</html>");
            optA.setText("A. " + q.optionA);
            optB.setText("B. " + q.optionB);
            optC.setText("C. " + q.optionC);
            optD.setText("D. " + q.optionD);
            bg.clearSelection();
            timeLeft = 60;
            timerLabel.setText("Time left: " + timeLeft);
        }
    }

    void nextQuestion() {
        timer.stop();

        Question q = questions.get(index);
        String selected = null;
        if (optA.isSelected()) selected = "A";
        else if (optB.isSelected()) selected = "B";
        else if (optC.isSelected()) selected = "C";
        else if (optD.isSelected()) selected = "D";

        if (selected != null && selected.equals(q.correctOption)) score++;

        index++;
        if (index < questions.size()) {
            showQuestion();
            timer.start();
        } else {
            JOptionPane.showMessageDialog(null, studentName + ", Exam finished!\nScore: " + score + "/" + questions.size());
            studentResults.put(studentName, score);
            // You can open StudentResultPage here if you have it
            dispose();
        }
    }

    public static void main(String[] args) {
        index = 0;
        score = 0;
        new StudentExamPage().setVisible(true);
    }
}

// Question class
class Question {
    String question, optionA, optionB, optionC, optionD, correctOption;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }
}
