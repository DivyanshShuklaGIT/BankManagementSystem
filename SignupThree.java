
package bank.management.sysetm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener
{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        
      JLabel l1 = new JLabel("PAGE 3: Account Details");
      l1.setFont(new Font("Arial",Font.BOLD,22));
      l1.setBounds(280,40,400,40);
      add(l1);
      
      JLabel type = new JLabel("Account Type");
      type.setFont(new Font("Arial",Font.BOLD,22));
      type.setBounds(100,140,200,30);
      add(type);
      
      r1 = new JRadioButton("Savings Account");
      r1.setFont(new Font("Raleway",Font.BOLD,16));
      r1.setBackground(Color.WHITE);
      r1.setBounds(100,190,250,20);
      add(r1);
      
      r2= new JRadioButton("Fixed deposit Account");
      r2.setFont(new Font("Raleway",Font.BOLD,16));
      r2.setBackground(Color.WHITE);
      r2.setBounds(100,230,250,20);
      add(r2);
      
      r3 = new JRadioButton("Current Account");
      r3.setFont(new Font("Raleway",Font.BOLD,16));
      r3.setBackground(Color.WHITE);
      r3.setBounds(350,190,250,20);
      add(r3);
      
      r4 = new JRadioButton("Reccuring Deposit Account");
      r4.setFont(new Font("Raleway",Font.BOLD,16));
      r4.setBackground(Color.WHITE);
      r4.setBounds(350,230,250,20);
      add(r4);
      
      ButtonGroup accountType = new ButtonGroup();
        accountType.add(r1);
        accountType.add(r2);
        accountType.add(r3);
        accountType.add(r4);
        
      JLabel card = new JLabel("Card Number :");
      card.setFont(new Font("Arial",Font.BOLD,22));
      card.setBounds(100,300,200,30);
      add(card);  
      
      JLabel CNumber = new JLabel("XXXX-XXXX-XXXX-4104");
      CNumber.setFont(new Font("Raleway",Font.BOLD,22));
      CNumber.setBounds(330,300,300,30);
      add(CNumber); 
      
      JLabel pin = new JLabel("PIN :");
      pin .setFont(new Font("Raleway",Font.BOLD,22));
      pin .setBounds(100,340,200,30);
      add(pin ); 
        
      JLabel PNumber = new JLabel("XXXX");
      PNumber .setFont(new Font("Raleway",Font.BOLD,22));
      PNumber .setBounds(330,340,200,30);
      add(PNumber);
      
      JLabel SR = new JLabel("Services Required :");
      SR .setFont(new Font("Raleway",Font.BOLD,22));
      SR .setBounds(100,410,250,30);
      add(SR);
      
      c1 = new JCheckBox("ATM card");
      c1.setBackground(Color.WHITE);
      c1 .setFont(new Font("Raleway",Font.PLAIN,16));
      c1.setBounds(100,460,200,20);
      add(c1);
      
      c2 = new JCheckBox("Internet Banking");
      c2.setBackground(Color.WHITE);
      c2 .setFont(new Font("Raleway",Font.PLAIN,16));
      c2.setBounds(350,460,200,20);
      add(c2);
      
      c3 = new JCheckBox("Mobile Banking");
      c3.setBackground(Color.WHITE);
      c3 .setFont(new Font("Raleway",Font.PLAIN,16));
      c3.setBounds(100,490,200,20);
      add(c3);
      
      c4 = new JCheckBox("E-mail & SMS alert");
      c4.setBackground(Color.WHITE);
      c4.setFont(new Font("Raleway",Font.PLAIN,16));
      c4.setBounds(350,490,200,20);
      add(c4);
      
      c5 = new JCheckBox("Cheque book");
      c5.setBackground(Color.WHITE);
      c5 .setFont(new Font("Raleway",Font.PLAIN,16));
      c5.setBounds(100,520,200,20);
      add(c5);
      
      c6 = new JCheckBox("E-statement");
      c6.setBackground(Color.WHITE);
      c6 .setFont(new Font("Raleway",Font.PLAIN,16));
      c6.setBounds(350,520,200,20);
      add(c6);
      
      c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
      c7.setBackground(Color.WHITE);
      c7.setFont(new Font("Raleway",Font.PLAIN,12));
      c7.setBounds(100,570,600,20);
      add(c7);
      
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway" , Font.BOLD,14));
        submit.setBounds(620,680,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway" , Font.BOLD,14));
        cancel.setBounds(80,680,100,30);
        cancel.addActionListener(this);
        add(cancel);
    }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource() == submit)
       {
         String aT =  null;
         if(r1.isSelected())
             aT="Saving Account";
         if(r2.isSelected())
             aT="Fixed Deposit Account";
         if(r3.isSelected())
             aT="Current Account";
         if(r4.isSelected())
             aT="Recurring Deposit Account";
         if(aT==null)
                 {
                 JOptionPane.showMessageDialog(null,"Account Type is Required");
                 return;
                 }  
         
         Random ran = new Random();
         String cardnumber =""+Math.abs((ran.nextLong() % 90000000L)+ 5040936000000000L);
         
         String pinnumber = ""+Math.abs((ran.nextLong() % 9000L) + 1000L);
         String facility = "";
         if(c1.isSelected())
             facility = facility + "ATM Card";
         if(c2.isSelected())
             facility = facility + " Internet Banking";
         if(c3.isSelected())
             facility = facility + " Mobile Banking";
         if(c4.isSelected())
             facility = facility + " E-mail &SMS alert";
         if(c5.isSelected())
             facility = facility + " Cheque Book";
         if(c6.isSelected())
             facility = facility + " E-Statement";
             
         if(!c7.isSelected())
         {
             JOptionPane.showMessageDialog(null,"Please Declare that the Entered details are correct.");
             return;
         }
         try {
            Conn c = new Conn();
            String query1 = "insert into signupthree values('" + formno + "', '" + aT + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
            String query2 = "insert into login values('" + formno + "','" + cardnumber + "', '" + pinnumber + "')";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);

            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
        new SignupTwo(formno).setVisible(true);
    }
}    
    public static void main(String Args[])
    {
        new SignupThree("");
    }  
}
