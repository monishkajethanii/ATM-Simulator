package adv;

import javax.swing.*;

import ATM_Login.Login1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignIn extends JFrame implements ActionListener {
    JLabel iconLabel, title, cardLabel, pinLabel;
    ImageIcon icon;
    JButton next, back, clear;
    JTextField t1;
    JPasswordField t2;
    Conn c;

    public SignIn() {
        // JFrame fields
        setLayout(null);
        setSize(800, 480);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        // setting icon
        icon = new ImageIcon(
                "C:/Users/Monishka/OneDrive/Documents/Programs/AJP_Microproject/ATM_Simulator/src/adv/bankicon.png");
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon newicon = new ImageIcon(img);
        iconLabel = new JLabel(newicon);
        iconLabel.setBounds(100, 20, 100, 100);
        add(iconLabel);

        // display title
        title = new JLabel("Welcome to ATM");
        title.setBounds(300, 55, 400, 40);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        // card no label
        cardLabel = new JLabel("Enter card no: ");
        cardLabel.setBounds(120, 150, 200, 40);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardLabel);

        // pin no label
        pinLabel = new JLabel("Enter PIN: ");
        pinLabel.setBounds(120, 220, 200, 40);
        pinLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinLabel);

        // input textfield for cardno & pin
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        t1.setBounds(300, 150, 230, 40);
        t2.setBounds(300, 220, 230, 40);
        t2.setEchoChar('*');
        add(t1);
        add(t2);

        // Associate the tooltip with the actual text field (t1)
        JToolTip tp = t1.createToolTip();
        t1.setToolTipText("16 digit no only");

        // next button
        next = new JButton("Next");
        next.setBounds(300, 300, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);

        // back button
        back = new JButton("Back");
        back.setBounds(300, 350, 230, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        // clear button
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);

        next.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Login1 log = new Login1();
            log.setVisible(true);
            setVisible(false);
        }
        if (ae.getSource() == clear) {
            t1.setText("");
            t2.setText("");
        }
        if (ae.getSource() == next) {
            String card = t1.getText();
            String pin = t2.getText();
            c = new Conn();
            String selectQuery = "SELECT * FROM signin WHERE cardno='" + card + "'";
            try (ResultSet rs = c.stm.executeQuery(selectQuery)) {
                String query = "INSERT INTO signin (cardno, pinno) VALUES ('" + card + "', '" + pin + "')";
                

                if (card.equals("")) {
                    JOptionPane.showMessageDialog(null, "Card no cannot be empty");
                } else if (card.length() != 16) {
                    JOptionPane.showMessageDialog(null, "Card no must be 16 digits");
                } else if (pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pin cannot be empty");
                } else if (pin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "Pin no must be 4 digits");
                } else {
                    try {
                        if (rs.next()) {

                            c.stm.executeUpdate(query);
                            Transaction trans = new Transaction();
                            trans.setVisible(true);
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid user");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (HeadlessException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new SignIn();
    }
}
