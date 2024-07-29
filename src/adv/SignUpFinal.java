package adv;
import adv.SignUpTwo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpFinal extends JFrame
{
    JLabel li,type, card, cardsam;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JRadioButton r1,r2,r3,r4;
    JButton back, submit;

    SignUpFinal() {
        // JFrame fields
        setLayout(null);
        setSize(800, 680);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        getContentPane().setBackground(Color.WHITE);

        //title
        li=new JLabel("Page 3: Account Details");
        li.setFont(new Font("Arial",Font.BOLD,24));
        li.setBounds(250,80,400,40);
        add(li);

        //account type
        type=new JLabel("Account Type: ");
        type.setFont(new Font("Arial",Font.BOLD,18));
        type.setBounds(100,150,200,30);
        add(type);

        //radiobuttons for account type
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial",Font.BOLD,15));
        r1.setBounds(100,180,250,50);
        add(r1);

        r2=new JRadioButton("Recurring Deposit Account");
        r2.setFont(new Font("Arial",Font.BOLD,15));
        r2.setBounds(350,180,250,50);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Arial",Font.BOLD,15));
        r3.setBounds(100,220,250,50);
        add(r3);

        r4=new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Arial",Font.BOLD,15));
        r4.setBounds(350,220,250,50);
        add(r4);
        r1.setBackground(Color.WHITE);
        r2.setBackground(Color.WHITE);
        r3.setBackground(Color.WHITE);
        r4.setBackground(Color.WHITE);
        
        //Button Group
        ButtonGroup bgac=new ButtonGroup();
        bgac.add(r1);
        bgac.add(r2);
        bgac.add(r3);
        bgac.add(r4);

        //label card
        card=new JLabel("Card Number");
        card.setFont(new Font("Arial",Font.BOLD,18));
        card.setBounds(100,300,200,30);
        add(card);

        //card sample
        cardsam=new JLabel("XXXX-XXXX-XXXX-7320");
        cardsam.setFont(new Font("Arial",Font.BOLD,18));
        cardsam.setBounds(300,300,300,30);
        add(cardsam);

        JLabel cardetails=new JLabel("Your 16 digit card no");
        cardetails.setFont(new Font("Arial",Font.BOLD,12));
        cardetails.setBounds(100,330,300,30);
        add(cardetails);

        //pin
        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Arial",Font.BOLD,18));
        pin.setBounds(100,360,200,30);
        add(pin);

        //sample pin
        JLabel pindetails=new JLabel("XXXX");
        pindetails.setFont(new Font("Arial",Font.BOLD,18));
        pindetails.setBounds(300,360,200,30);
        add(pindetails);

        //inform user
        JLabel pinabv=new JLabel("Your 4 digit pin no");
        pinabv.setFont(new Font("Arial",Font.BOLD,12));
        pinabv.setBounds(100,390,300,30);
        add(pinabv);

        //services required
        JLabel service=new JLabel("Services Required: ");
        service.setFont(new Font("Arial",Font.BOLD,18));
        service.setBounds(100,420,300,30);
        add(service);

        //creating checkbox for services
        //atm card
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,450,300,30);
        c1.setFont(new Font("Arial",Font.BOLD,15));
        add(c1);

        //internet banking
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(400,450,400,30);
        c2.setFont(new Font("Arial",Font.BOLD,15));
        add(c2);
        
        //email & sms alerts?
        c3=new JCheckBox("Email & SMS Alert");
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,480,300,30);
        c3.setFont(new Font("Arial",Font.BOLD,15));
        add(c3);

        //mobile banking
        c4=new JCheckBox("Mobile Banking");
        c4.setBackground(Color.WHITE);
        c4.setBounds(400,480,400,30);
        c4.setFont(new Font("Arial",Font.BOLD,15));
        add(c4);

        //Cheque book
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,510,300,30);
        c5.setFont(new Font("Arial",Font.BOLD,15));
        add(c5);

        //e-statement
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setBounds(400,510,400,30);
        c6.setFont(new Font("Arial",Font.BOLD,15));
        add(c6);

        //agree terms and conditions
        c7=new JCheckBox("I hereby confirm above details are correct");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,550,500,30);
        c7.setFont(new Font("Arial",Font.BOLD,12));
        add(c7);

        //back & submit button
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,590,150,30);
        add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                SignUpTwo sut=new SignUpTwo();
                sut.setVisible(true);
                setVisible(false);
            }
        });

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(370,590,150,30);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCheckboxValidation();
                String accountType=null;
                if(r1.isSelected()){
                    accountType="Saving Account";
                }
                else if(r2.isSelected()){
                    accountType="Recurring Deposit Account";
                }
                else if(r3.isSelected()){
                    accountType="Current Account";
                }
                else if(r4.isSelected()){
                    accountType="Fixed Deposit Account";
                }

                Random random=new Random();
                String cardno=""+Math.abs(random.nextLong()%9000000L)+50409360L;
                String pinno=""+Math.abs(random.nextLong()%90000L)+1000L;
                String facilities="";
                if(c1.isSelected()){
                    facilities=facilities+" ATM Card";
                }
                if(c2.isSelected()){
                    facilities=facilities+" Internet Banking";
                }
                if(c3.isSelected()){
                    facilities=facilities+" Email & SMS Alert";
                }
                if(c4.isSelected()){
                    facilities=facilities+" Mobile Banking";
                }
                if(c5.isSelected()){
                    facilities=facilities+" Cheque Book";
                }
                if(c6.isSelected()){
                    facilities=facilities+" E-Statement";
                }

            }
        });

        setVisible(true);
    }
    private void handleCheckboxValidation() {
        if (c7.isSelected()) {
            JOptionPane.showMessageDialog(this, "Form submitted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please check the checkbox before submitting the form");
        }
    }

    public static void main(String args[]) {
        new SignUpFinal();
    }
}