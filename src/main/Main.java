/* @author SABIT */
package main;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    JPanel bluePanel, whitePanel;
    ImageIcon uitsLogo;
    JLabel labelForLogo, deptName, developedBy;
    JLabel questionName = new JLabel();
    JTextField yourName, yourSID;
    JButton next, x;

    ButtonGroup buttonGroup;
    JRadioButton radioButton[] = new JRadioButton[4];

    int runningQuestion = 1, totalCorrectAnswers = 0;

    Main() throws IOException {
        // The Frame
        setSize(1000, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Blue Panel
        bluePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 200, 230),
                        getWidth(), getHeight(), new Color(0, 80, 230));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bluePanel.setLayout(null);
        bluePanel.setBackground(new Color(0, 151, 230));
        bluePanel.setPreferredSize(new Dimension(400, 500));
        JRadioButton btn = new JRadioButton();
        bluePanel.add(btn);
        btn.requestFocusInWindow();

        // UITS Logo
        uitsLogo = new ImageIcon("uits.png");
        labelForLogo = new JLabel(uitsLogo);
        labelForLogo.setBounds(70, 50, 250, 180);
        bluePanel.add(labelForLogo);

        // Adding [Your Name]
        yourName = new JTextField("YOUR NAME HERE");
        yourName.setBounds(70, 300, 250, 40);
        yourName.setForeground(new Color(0, 151, 230));
        yourName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        yourName.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 8));
        yourName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                yourName.setText("");
                yourName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bluePanel.add(yourName);

        // Adding [Your ID]
        yourSID = new JTextField("YOUR STUDENT ID HERE");
        yourSID.setForeground(new Color(0, 151, 230));
        yourSID.setBounds(70, 350, 250, 40);
        yourSID.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        yourSID.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 8));
        yourSID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                yourSID.setText("");
                yourSID.setFont(new Font("Segoe UI", Font.PLAIN, 17));
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        });
        bluePanel.add(yourSID);

        // adding Dept Name To Blue Panel
        deptName = new JLabel("Department of Information Technology");
        deptName.setForeground(Color.white);
        deptName.setBounds(50, 450, 300, 30);
        deptName.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
        bluePanel.add(deptName);

        // White Panel
        whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(new Color(255, 255, 255));
        whitePanel.setPreferredSize(new Dimension(600, 500));
        
        // Adding window Exit Button
        x = new JButton("x");
        x.setLayout(new FlowLayout());
        x.setBorderPainted(false);
        x.setFocusPainted(false);
        x.setBackground(new Color(255, 255, 255));
//        x.setBackground(Color.red);
        x.setForeground(new Color(0, 130, 230));
        x.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        x.setBounds(550, -5, 50, 50);
        x.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        whitePanel.add(x);

        // Adding radio Buttons to whitePanel
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
            radioButton[i].setBorderPainted(false);
            radioButton[i].setFocusPainted(false);
            radioButton[i].setBackground(Color.white);
            radioButton[i].setForeground(new Color(44, 62, 80));
            radioButton[i].setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
            buttonGroup.add(radioButton[i]);
            whitePanel.add(radioButton[i]);
        }
        radioButton[0].setBounds(50, 100, 600, 50);
        radioButton[1].setBounds(50, 150, 600, 50);
        radioButton[2].setBounds(50, 200, 600, 50);
        radioButton[3].setBounds(50, 250, 600, 50);

        // Setting Question
        setQuestion();

        // Add Next Button
        next = new JButton("NEXT");
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        next.setBounds(250, 330, 100, 38);
        next.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        next.setBackground(new Color(0, 130, 230));
        next.setForeground(new Color(255, 255, 255));
        next.addActionListener(this);
        next.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                next.setBackground(new Color(54, 157, 236));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                next.setBackground(new Color(0, 130, 230));
            }

        });
        whitePanel.add(next);

        // adding Copyright
        developedBy = new JLabel("Developed by Salfi Sabit");
        developedBy.setForeground(new Color(0, 120, 230));
        developedBy.setBounds(210, 450, 300, 30);
        developedBy.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
        whitePanel.add(developedBy);

        // Adding Blue+White into the Frame
        add(bluePanel, BorderLayout.WEST);
        add(whitePanel, BorderLayout.EAST);

        // Removing the decoration of the Frame
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (CheckAnswer()) {
                totalCorrectAnswers++;
            }
            runningQuestion++;
            setQuestion();

            if (runningQuestion == 10) {
                next.setText("RESULT");
            }
        }
        if (e.getActionCommand().equals("RESULT")) {
            if (CheckAnswer()) {
                totalCorrectAnswers++;
            }

            // Dialog
            JWindow window = new JWindow();
            window.setBackground(new Color(0, 0, 0, 0));
            JLabel resultMessage = new JLabel("Total Correct Answer : " + totalCorrectAnswers);
            resultMessage.setForeground(Color.white);
            resultMessage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            resultMessage.setBounds(170, 70, 300, 38);

            JButton close = new JButton("CLOSE");
            close.setBorderPainted(false);
            close.setFocusPainted(false);
            close.setBounds(220, 140, 100, 38);
            close.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            close.setForeground(new Color(0, 130, 230));
            close.setBackground(new Color(255, 255, 255));
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.setVisible(false);
                }
            });
            close.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    close.setBackground(new Color(238, 238, 238));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    close.setBackground(new Color(255, 255, 255));
                }

            });

            // create a panel
            JPanel dialogPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 200, 230),
                            getWidth(), getHeight(), new Color(0, 80, 230), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            dialogPanel.setLayout(null);

            dialogPanel.add(resultMessage);
            dialogPanel.add(close);

            window.add(dialogPanel);
            window.setSize(540, 270);
            window.setLocation(890, 310);
            window.show();
        }
    }

    void setQuestion() {
        if (runningQuestion == 1) {
            questionName.setText("Q1. Number of main OOP concepts in java -");

            radioButton[0].setText("  3");
            radioButton[1].setText("  4");
            radioButton[2].setText("  5");
            radioButton[3].setText("  7");
        }
        if (runningQuestion == 2) {
            questionName.setText("Q2. Code reusability has increased by using _____");

            radioButton[0].setText("  Polymorphism");
            radioButton[1].setText("  Method Overloading");
            radioButton[2].setText("  Inheritance");
            radioButton[3].setText("  Multithreading");
        }
        if (runningQuestion == 3) {
            questionName.setText("Q3. Which one is an invalid loop declaration? ");

            radioButton[0].setText("  for(int i = 77; i < 77; i *= 55);");
            radioButton[1].setText("  for(int i = 83; i >= 1; i/5);");
            radioButton[2].setText("  for(int i = 32; i <= 392; i *= 23);");
            radioButton[3].setText("  for(int i = 2; i > 2; i--);");
        }
        if (runningQuestion == 4) {
            questionName.setText("Q4. _____ is used for accessing the feature of a package.");

            radioButton[0].setText("  Import");
            radioButton[1].setText("  Export");
            radioButton[2].setText("  Implements");
            radioButton[3].setText("  Extends");
        }
        if (runningQuestion == 5) {
            questionName.setText("Q5. Java compiler javac, translates java source code into ____");

            radioButton[0].setText("  Machine code");
            radioButton[1].setText("  Bit code");
            radioButton[2].setText("  Byte code");
            radioButton[3].setText("  Assembly language");
        }
        if (runningQuestion == 6) {
            questionName.setText("Q6. Which of the following doesn't have a body?");

            radioButton[0].setText("  Interface");
            radioButton[1].setText("  Constructor");
            radioButton[2].setText("  Private class");
            radioButton[3].setText("  Abstract Method");
        }
        if (runningQuestion == 7) {
            questionName.setText("Q7. If one object acquires the properties of another object, it is called");

            radioButton[0].setText("  Polymorphism");
            radioButton[1].setText("  Inheritance");
            radioButton[2].setText("  Encapsulation");
            radioButton[3].setText("  Abstraction");
        }
        if (runningQuestion == 8) {
            questionName.setText("Q8. Who is known as the father of Java programming language?");

            radioButton[0].setText("  James Gosling");
            radioButton[1].setText("  Blais Pascal");
            radioButton[2].setText("  Dennis Ritchie");
            radioButton[3].setText("  M.P Java");
        }
        if (runningQuestion == 9) {
            questionName.setText("Q9. Which feature of OOP has a super-class subclass-concept?");

            radioButton[0].setText("  Multilevel inheritance");
            radioButton[1].setText("  Single inheritance");
            radioButton[2].setText("  Multiple inheritance");
            radioButton[3].setText("  Hierarchical inheritance");
        }
        if (runningQuestion == 10) {
            questionName.setText("Q10. An abstract class - ");

            radioButton[0].setText("  can be instantiated");
            radioButton[1].setText("  Mustn't have abstract methods");
            radioButton[2].setText("  Allows normal method declaration");
            radioButton[3].setText("  None of the above");
        }
        questionName.setBounds(50, 50, 600, 50);
        questionName.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
        questionName.setForeground(new Color(44, 62, 80));
        whitePanel.add(questionName);
    }

    boolean CheckAnswer() {
        if (runningQuestion == 1) {
            return (radioButton[1].isSelected());
        }
        if (runningQuestion == 2) {
            return (radioButton[2].isSelected());
        }
        if (runningQuestion == 3) {
            return (radioButton[1].isSelected());
        }
        if (runningQuestion == 4) {
            return (radioButton[0].isSelected());
        }
        if (runningQuestion == 5) {
            return (radioButton[2].isSelected());
        }
        if (runningQuestion == 6) {
            return (radioButton[3].isSelected());
        }
        if (runningQuestion == 7) {
            return (radioButton[1].isSelected());
        }
        if (runningQuestion == 8) {
            return (radioButton[0].isSelected());
        }
        if (runningQuestion == 9) {
            return (radioButton[3].isSelected());
        }
        if (runningQuestion == 10) {
            return (radioButton[2].isSelected());
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Main();
    }

}
 