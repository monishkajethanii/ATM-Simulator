package adv;

import javax.swing.*;

import ATM_Login.Login1;

import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    JLabel personal, religion, income, education, qua, occupation, pan;
    JTextField educationText, quaText, panText,occText;
    JButton submit,back;
    String[] incomechoices = { "Below < 7,00,000", "Below < 5,00,000", "Below < 2,00,000", "Below < 1,00,000",
            "Below < 50,000" };
    
            String[] religionchoice={"Hinduism","Islam","Christianity","Sikhism","Buddhism","Jainism",
         "Zoroastrianism","Judaism","Bahá'í Faith"};

    SignUpTwo() {
        // JFrame fields
        setLayout(null);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        // personal details
        personal = new JLabel("Page 3: Additional Details ");
        personal.setBounds(220, 80, 400, 30);
        personal.setFont(new Font("Arial", Font.BOLD, 22));
        add(personal);

        // religion
        religion = new JLabel("Religion ");
        religion.setBounds(100, 140, 200, 30);
        religion.setFont(new Font("Arial", Font.BOLD, 20));
        add(religion);
        JComboBox<String> myChoice1 = new JComboBox<>(religionchoice);
        myChoice1.setSelectedIndex(0);
        myChoice1.setBounds(330, 140, 200, 30);
        add(myChoice1);

        // income
        income = new JLabel("Income: ");
        income.setBounds(100, 180, 200, 30);
        income.setFont(new Font("Arial", Font.BOLD, 20));
        add(income);
        JComboBox<String> myChoice = new JComboBox<>(incomechoices);
        myChoice.setSelectedIndex(0);
        myChoice.setBounds(330, 180, 200, 30);
        add(myChoice);

        // education
        education = new JLabel("Educational: ");
        education.setBounds(100, 220, 200, 30);
        education.setFont(new Font("Arial", Font.BOLD, 20));
        add(education);
        educationText = new JTextField(20);
        educationText.setBounds(330, 220, 200, 30);
        educationText.setFont(new Font("Arial", Font.BOLD, 20));
        add(educationText);

        // occupation
        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Arial", Font.BOLD, 20));
        occupation.setBounds(100, 260, 200, 30);
        add(occupation);
        occText=new JTextField(20);
        occText.setBounds(330,260,200,30);
        occText.setFont(new Font("Arial", Font.BOLD, 20));
        add(occText);

        // Qualification
        qua = new JLabel("Qualification: ");
        qua.setFont(new Font("Arial", Font.BOLD, 20));
        qua.setBounds(100, 300, 200, 30);
        add(qua);
        quaText = new JTextField(20);
        quaText.setBounds(330, 300, 200, 30);
        quaText.setFont(new Font("Arial", Font.BOLD, 20));
        add(quaText);

        // pan
        pan = new JLabel("PAN no: ");
        pan.setFont(new Font("Arial", Font.BOLD, 20));
        pan.setBounds(100, 340, 200, 30);
        add(pan);
        panText = new JTextField(20);
        panText.setFont(new Font("Arial", Font.BOLD, 20));
        panText.setBounds(330, 340, 200, 30); // Adjust the bounds accordingly
        add(panText);

        // submit & next button
        submit = new JButton("Submit & Next");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(340,380, 150, 30);
        add(submit);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(150,380, 150, 30);
        add(back);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            SignUpFinal suf=new SignUpFinal();
            suf.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==back){
            SignUpOne suo=new SignUpOne();
            suo.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new SignUpTwo();
    }
}
