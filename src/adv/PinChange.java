package adv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class PinChange extends JFrame implements ActionListener,KeyListener
{
    JPasswordField newpin,repin,currentpintext;
    JButton submit,back;
    public PinChange()
    {
         // JFrame fields
         setLayout(null);
         setSize(900, 900);
         setLocationRelativeTo(null);
         setTitle("Automated Teller Machine");
         getContentPane().setBackground(Color.WHITE);
 
         //setting background image
         ImageIcon img=new ImageIcon("C:/Users/Monishka/OneDrive/Documents/Programs/AJP_Microproject/ATM_Simulator/src/adv/atm.jpg");
         Image img1=img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon img2=new ImageIcon(img1);
         JLabel image=new JLabel(img2);
         image.setBounds(0,0,900,900);
         add(image);

        //change your pin
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(230,285,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,22));
        image.add(text);

        //current pin
        JLabel currentpin=new JLabel("Current PIN: ");
        currentpin.setBounds(170,335,500,25);
        currentpin.setForeground(Color.WHITE);
        currentpin.setFont(new Font("Arial",Font.BOLD,18));
        image.add(currentpin);

        //textfield of current pin
        currentpintext = new JPasswordField(20);
        currentpintext.setBounds(310,335,180,25);
        image.add(currentpintext);
        currentpintext.setEchoChar('*');
        currentpintext.addKeyListener(this);

        //new pin 
        JLabel pintext=new JLabel("New PIN: ");
        pintext.setBounds(170,375,200,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Arial",Font.BOLD,18));
        image.add(pintext);

        //textfield of new pin
        newpin=new JPasswordField(20);
        newpin.setBounds(310,375,180,25);
        image.add(newpin);
        newpin.setEchoChar('*');
        newpin.addKeyListener(this);

        //label for re-enter pin
        JLabel repinJLabel=new JLabel("Re-enter PIN: ");
        repinJLabel.setBounds(170,415,200,25);
        repinJLabel.setForeground(Color.WHITE);
        repinJLabel.setFont(new Font("Arial",Font.BOLD,18));
        image.add(repinJLabel);

        //textfield for re-pin pin
        repin=new JPasswordField(20);
        repin.setEchoChar('*');
        repin.setBounds(310,415,180,25);
        image.add(repin);

        //button for back 
        back=new JButton("Back");
        back.setBounds(210,455,100,25);
        image.add(back);

        //submit button
        submit=new JButton("Submit");
        submit.setBounds(340,455,100,25);
        image.add(submit);

        back.addActionListener(this);
        submit.addActionListener(this);

       // setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Transaction trans = new Transaction();
            trans.setVisible(true);
            setVisible(false);
        }
        if (ae.getSource() == submit) {
            String currentPin = currentpintext.getText();
            String newPin = newpin.getText();
            String reenteredPin = repin.getText();
    
            if (currentPin.equals("") || newPin.equals("") || reenteredPin.equals(""))
            {
                JOptionPane.showMessageDialog(this,"Please enter details");
            }
            if (currentPin.equals(newPin)) {
                JOptionPane.showMessageDialog(this, "Current and New Pin cannot be the same");
                newpin.setText("");
                currentpintext.setText("");
                repin.setText("");
            } else {
                if (newPin.equals(reenteredPin)) {
                    JOptionPane.showMessageDialog(this, "Pin Changed Successfully");
                    // Additional logic for changing the pin if needed
                } else {
                    JOptionPane.showMessageDialog(this, "New pin and Re-entered pin don't match");
                    newpin.setText("");
                    repin.setText("");
                }
            }
        }
    }
    public void keyPressed(KeyEvent e) 
    {
        if(e.getSource()==currentpintext)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Move focus to the next JTextField (newpin)
                newpin.requestFocus();
            }
        }
        if(e.getSource()==newpin)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Move focus to the next JTextField (newpin)
                repin.requestFocus();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        // Unused, required by KeyListener interface
    }

    public void keyReleased(KeyEvent e) {
        // Unused, required by KeyListener interface
    }
    
    public static void main(String args[])
    {
        new PinChange();
    }
}
