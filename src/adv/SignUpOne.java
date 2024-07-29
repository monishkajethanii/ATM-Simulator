package adv;

import adv.*;
import ATM_Login.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpOne extends JFrame implements ActionListener {
    JLabel formno, personal, name, dob, fname, gender, email, address, city, state, pincode;
    JTextField nameText, fnameText, emailText, cityText, stateText, pincodeText, addTextt;
    JRadioButton male, female;
    JButton submit,back;
    Random ran = new Random();
    Long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

    public SignUpOne() {
        // JFrame fields
        setLayout(null);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);
        // application form no
        formno = new JLabel("Application Form No: " + random);
        formno.setBounds(200, 20, 600, 40);
        formno.setFont(new Font("Arial", Font.BOLD, 24));
        add(formno);

        // personal details
        personal = new JLabel("Page 2: Personal Details ");
        personal.setBounds(220, 80, 400, 30);
        personal.setFont(new Font("Arial", Font.BOLD, 20));
        add(personal);

        // name
        name = new JLabel("Name: ");
        name.setBounds(100, 140, 200, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        add(name);
        nameText = new JTextField(20);
        nameText.setBounds(330, 140, 200, 30);
        nameText.setFont(new Font("Arial", Font.BOLD, 20));
        add(nameText);

        // father's name
        fname = new JLabel("Father's Name: ");
        fname.setBounds(100, 180, 200, 30);
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        add(fname);
        fnameText = new JTextField(20);
        fnameText.setBounds(330, 180, 200, 30);
        fnameText.setFont(new Font("Arial", Font.BOLD, 20));
        add(fnameText);

        // dob
        dob = new JLabel("Date of Birth: ");
        dob.setBounds(100, 220, 200, 30);
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        add(dob);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(330, 220, 200, 30);
        add(dateChooser);

        // gender
        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(330, 260, 200, 30);

        add(male);
        female = new JRadioButton("Female");
        female.setBounds(330 + male.getWidth(), 260, 200, 30);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);

        // email ID
        email = new JLabel("Enter Email ID: ");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(100, 300, 200, 30);
        add(email);
        emailText = new JTextField(20);
        emailText.setBounds(330, 300, 200, 30);
        emailText.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailText);

        // address
        address = new JLabel("Enter Address: ");
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(100, 340, 200, 30);
        add(address);
        addTextt = new JTextField(20); // Adjust the number of rows
        addTextt.setFont(new Font("Arial", Font.BOLD, 20));
        addTextt.setBounds(330, 340, 200, 30); // Adjust the bounds accordingly
        add(addTextt);

        // pincode
        pincode = new JLabel("Enter pincode: ");
        pincode.setFont(new Font("Arial", Font.BOLD, 20));
        pincode.setBounds(100, 380, 200, 30);
        add(pincode);
        pincodeText = new JTextField(20);
        pincodeText.setFont(new Font("Arial", Font.BOLD, 20));
        pincodeText.setBounds(330, 380, 200, 30); // Adjust the bounds accordingly
        add(pincodeText);

        // city
        city = new JLabel("Enter City: ");
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(100, 420, 200, 30);
        add(city);
        cityText = new JTextField(20);
        cityText.setFont(new Font("Arial", Font.BOLD, 20));
        cityText.setBounds(330, 420, 200, 30); // Adjust the bounds accordingly
        add(cityText);

        // state
        state = new JLabel("Enter State: ");
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(100, 460, 200, 30);
        add(state);
        stateText = new JTextField(20);
        stateText.setFont(new Font("Arial", Font.BOLD, 20));
        stateText.setBounds(330, 460, 200, 30); // Adjust the bounds accordingly
        add(stateText);

        // submit & next button
        submit = new JButton("Submit & Next");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(340, 500, 150, 30);
        add(submit);
        submit.addActionListener(this);
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 500, 150, 30);
        add(back);
        back.addActionListener(this);

        //setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            SignUpTwo sut = new SignUpTwo();
            sut.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==back)
        {
            Login1 log=new Login1();
            log.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new SignUpOne();
    }
}