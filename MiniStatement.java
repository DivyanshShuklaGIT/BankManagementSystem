package bank.management.sysetm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class MiniStatement extends JFrame implements ActionListener {
    
    
    String pinnumber;
    MiniStatement(String pinnumber)
    {
        this.pinnumber=pinnumber;
      getContentPane().setBackground(Color.WHITE);
      setTitle("Mini-Statement");  
      setSize(400,600);
      setLocation(20,20);
      setLayout(null);
      setVisible(true);
      
          JLabel bank = new JLabel("YOUR bank ");
          bank.setFont(new Font("Raleway",Font.BOLD,20));
          bank.setBounds(130,20,200,20);
          add(bank);
          
          JLabel mini = new JLabel();
          mini.setBounds(20,140,400,200);
          add(mini);
          
          JLabel card = new JLabel();
           card.setBounds(20,80,300,20);
          add(card);
          
          JLabel balance = new JLabel();
          balance.setBounds(20,400,300,20);
          add(balance);
          
          try
          {
           Conn c= new Conn();   
           ResultSet rs= c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
           while(rs.next())
               card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("cardNumber").substring(12));
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          try
          {
           Conn c= new Conn();   
           int bal =0;
           ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           while(rs.next())
           {
               mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            if (rs.getString("type").equals("Deposit"))
                    bal+=Integer.parseInt(rs.getString("amount"));
                else
                    bal-=Integer.parseInt(rs.getString("amount"));
           }
           balance.setText("Your current account balance is Rs. "+bal);
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
    }
         public void actionPerformed(ActionEvent ae)
     {
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    public static void main(String args[])
    {
        new MiniStatement("");
    }
    
}