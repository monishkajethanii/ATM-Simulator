package adv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amt;
    JButton withdrawlButton, clear, back;

    public Withdrawl() {
        // JFrame fields
        setLayout(null);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        // setting up background image
        ImageIcon img = new ImageIcon(
                "C:/Users/Monishka/OneDrive/Documents/Programs/AJP_Microproject/ATM_Simulator/src/adv/atm.jpg");
        Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel image = new JLabel(img2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // label for amount withdrawl
        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setBounds(155, 285, 400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(text);

        // setting up amount textfield
        amt = new JTextField(20);
        amt.setBounds(160, 325, 350, 25);
        amt.setFont(new Font("Arial", Font.BOLD, 20));
        image.add(amt);

        // buttons
        withdrawlButton = new JButton("Withdrawl");
        withdrawlButton.setBounds(300, 450, 200, 25);
        image.add(withdrawlButton);

        // back button
        back = new JButton("Back");
        back.setBounds(300, 480, 200, 25);
        image.add(back);

        // clear button
        clear = new JButton("Clear");
        clear.setBounds(300, 510, 200, 25);
        // clear.setBorder(new RoundedBorder(10));
        image.add(clear);

        withdrawlButton.addActionListener(this);
        back.addActionListener(this);
        clear.addActionListener(this);

         setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            amt.setText("");
        }
        if (ae.getSource() == back) {
            Transaction ts = new Transaction();
            ts.setVisible(true);
            setVisible(false);
        }
        if (ae.getSource() == withdrawlButton) {
            String number = amt.getText();
            // Date date=new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter amount to be withdrawn");
            } else
                JOptionPane.showMessageDialog(this, number+" is withdrawn");

        }
    }

    public static void main(String args[]) {
        new Withdrawl();
    }
}
