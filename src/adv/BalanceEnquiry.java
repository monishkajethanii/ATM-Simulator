package adv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JTextField balanceField;
    JButton checkBalance, back;

    public BalanceEnquiry() {
        // JFrame fields
        setLayout(null);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        // setting background image
        ImageIcon img = new ImageIcon("C:/Users/Monishka/OneDrive/Documents/Programs/AJP_Microproject/ATM_Simulator/src/adv/atm.jpg");
        Image img1 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel image = new JLabel(img2);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // balance enquiry label
        JLabel text = new JLabel("BALANCE ENQUIRY");
        text.setBounds(230, 285, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 22));
        image.add(text);

        // textfield for displaying balance
        balanceField = new JTextField();
        balanceField.setBounds(280, 335, 180, 25);
        image.add(balanceField);
        balanceField.setEditable(false); // Make it non-editable

        // button for checking balance
        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(280, 375, 180, 25);
        image.add(checkBalance);

        // button for back
        back = new JButton("Back");
        back.setBounds(280, 415, 180, 25);
        image.add(back);

        checkBalance.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Transaction trans = new Transaction();
            trans.setVisible(true);
            setVisible(false);
        }
        if (ae.getSource() == checkBalance) {
            // Replace the following line with actual balance retrieval logic
            double balanceAmount = 1000.00; // Sample balance amount
            balanceField.setText("Rs " + balanceAmount);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry();
    }
}
