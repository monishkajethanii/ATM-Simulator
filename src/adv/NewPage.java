package adv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewPage extends JFrame {
    private JTextField mpinField;
    private JButton checkBalanceButton;
    private JLabel balanceLabel;

    // Simulated account balance
    private double accountBalance = 1000.0;

    public NewPage() {
        setTitle("ATM Balance Check");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Create components
        mpinField = new JTextField(10);
        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBackground(Color.BLACK);
        checkBalanceButton.setForeground(Color.WHITE);
        balanceLabel = new JLabel("Balance: N/A",JLabel.CENTER);

        // Add components to the frame
        JPanel topPanel = new JPanel(); 
        topPanel.add(new JLabel("Enter MPIN:"));
        topPanel.add(mpinField);
        topPanel.add(checkBalanceButton);

        add(topPanel, BorderLayout.NORTH);
        add(balanceLabel, BorderLayout.CENTER);
        setVisible(true);

        // Action listener for the Check Balance button
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredMPIN = mpinField.getText();
                // Simulated MPIN (for demonstration purposes)
                String correctMPIN = "1234";

                if (enteredMPIN.equals(correctMPIN)) {
                    balanceLabel.setText("Balance: $" + accountBalance);
                } else {
                    balanceLabel.setText("Invalid MPIN");
                }
            }
        });
    }

    public static void main(String[] args) {
        new NewPage();
    }
}
