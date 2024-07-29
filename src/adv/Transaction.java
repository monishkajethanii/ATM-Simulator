package adv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener
{
    JButton exiButton,deposit,withdrawl,fastcash,ministatement,pinchangeButton,balanceEnquiry;
    public Transaction()
    {
        // JFrame fields
        setLayout(null);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon img=new ImageIcon("C:/Users/Monishka/OneDrive/Documents/Programs/AJP_Microproject/ATM_Simulator/src/adv/atm.jpg");
        Image img1=img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel atmimage=new JLabel(img2);
        atmimage.setBounds(0,0,900,900);
        add(atmimage);

        //label please select transaction
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(170,285,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,23));
        atmimage.add(text);

        //deposit button
        deposit=new JButton("Deposit");
        deposit.setBounds(170,350,150,30);
        atmimage.add(deposit);
        deposit.addActionListener(this);

        //withdrawl button
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,350,150,30);
        atmimage.add(withdrawl);
        withdrawl.addActionListener(this);

        //fast cash
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,390,150,30);
        atmimage.add(fastcash);
        fastcash.addActionListener(this);

        //mini statement
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,390,150,30);
        atmimage.add(ministatement);
        ministatement.addActionListener(this);

        //pin change
        pinchangeButton=new JButton("Pin Change");
        pinchangeButton.setBounds(170,430,150,30);
        atmimage.add(pinchangeButton);
        pinchangeButton.addActionListener(this);

        //balance enquiry
        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,430,150,30);
        atmimage.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);


        //exit
        exiButton=new JButton("Exit");
        exiButton.setBounds(265,470,150,30);
        atmimage.add(exiButton);
        exiButton.addActionListener(this);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exiButton) {
            JOptionPane.showMessageDialog(this, "Thanks, Have a nice day");
            System.exit(0);
        }
        if(ae.getSource()== deposit){
            Deposit des=new Deposit();
            des.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==withdrawl){
            Withdrawl with=new Withdrawl();
            with.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==fastcash){
            FastCash ds=new FastCash();
            ds.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==pinchangeButton){
            PinChange pcn=new PinChange();
            pcn.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==balanceEnquiry){
            BalanceEnquiry bec=new BalanceEnquiry();
            bec.setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==ministatement){
            MiniStatement ms=new MiniStatement();
            ms.setVisible(true);
            setVisible(false);
        }

    }
    
    public static void main(String ags[]){
        new Transaction();
    }
}
