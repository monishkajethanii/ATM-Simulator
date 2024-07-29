package adv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniStatement extends JFrame implements ActionListener {
    JTextArea statementArea;
    JButton generateStatement, back;

    public MiniStatement() {
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

        // mini statement label
        JLabel text = new JLabel("MINI STATEMENT");
        text.setBounds(230, 285, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 22));
        image.add(text);

        // text area for displaying statement
        statementArea = new JTextArea();
        statementArea.setEditable(false); // Make it non-editable
        JScrollPane scrollPane = new JScrollPane(statementArea);
        scrollPane.setOpaque(false); 
        scrollPane.setBounds(150, 325, 370, 230);
        image.add(scrollPane);

        // button for generating statement
        generateStatement = new JButton("Generate Statement");
        generateStatement.setBounds(220, 575, 210, 25);
        image.add(generateStatement);

        // button for back
        back = new JButton("Back");
        back.setBounds(220, 600, 210, 25);
        image.add(back);

        generateStatement.addActionListener(this);
        back.addActionListener(this);

        //setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Transaction trans = new Transaction();
            trans.setVisible(true);
            setVisible(false);
        }
        if (ae.getSource() == generateStatement) {
            // Replace the following lines with actual mini statement retrieval logic
            String statementText = "Transaction 1: -Rs1250.00\nTransaction 2: +Rs5100.00\nTransaction 3: -Rs120.00\nSalary : +Rs25000";
            statementArea.setText(statementText);
        }
    }

    public static void main(String[] args) {
        new MiniStatement();
    }
}
