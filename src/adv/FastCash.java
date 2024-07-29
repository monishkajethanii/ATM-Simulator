package adv;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener
{
    JButton rs100,rs200,rs500,rs1000,exitButton,back;
    FastCash()
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
    
        //label please select withdrawl amount
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(170,285,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,23));
        atmimage.add(text);
    
        //Rs 100
        rs100=new JButton("Rs 100");
        rs100.setBounds(170,350,150,30);
        atmimage.add(rs100);
        rs100.addActionListener(this);
    
        //Rs 200
        rs200=new JButton("Rs 200");
        rs200.setBounds(355,350,150,30);
        atmimage.add(rs200);
        rs200.addActionListener(this);
    
        //Rs 500
        rs500=new JButton("Rs 500");
        rs500.setBounds(170,390,150,30);
        atmimage.add(rs500);
        rs500.addActionListener(this);
    
        //Rs 1000
        rs1000=new JButton("Rs 1000");
        rs1000.setBounds(355,390,150,30);
        atmimage.add(rs1000);
        rs1000.addActionListener(this);    
    
        //exit
        exitButton=new JButton("Exit");
        exitButton.setBounds(265,470,150,30);
        atmimage.add(exitButton);
        exitButton.addActionListener(this);

        //back button
        back=new JButton("Back");
        back.setBounds(265,510,150,30);
        atmimage.add(back);
        back.addActionListener(this);
    
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String amount=((JButton)ae.getSource()).getText();//Rs 200
        amount=amount.substring(3);
        int balance=1000;
        if(ae.getSource()!=exitButton && balance<(Integer.parseInt(amount))){
            JOptionPane.showMessageDialog(this,"Please maintain sufficient balance");
        }
        if(ae.getSource()!=exitButton && ae.getSource()!= back){
            JOptionPane.showMessageDialog(this,"Rs "+amount+" is debited");
        }
        if(ae.getSource()==exitButton){
            JOptionPane.showMessageDialog(this,"Please wait for few seconds.");
            JOptionPane.showMessageDialog(this,"Thankyou, Have a nice day.");
            System.exit(0);
        }
        if(ae.getSource()==back){
            Transaction ts=new Transaction();
            ts.setVisible(true);
            setVisible(false);
        }

    }
    public static void main(String args[])
    {
        new FastCash();
    }
}
