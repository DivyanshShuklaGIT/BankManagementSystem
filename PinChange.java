package bank.management.sysetm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    PinChange(String pinnumber)
    {
         setLayout(null);
        this.pinnumber=pinnumber;
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));  
      Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add (image);
      
        JLabel text=new JLabel("Change your Pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext=new JLabel("New Pin :");
        pintext.setBounds(165,330,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
         
        pin = new JPasswordField();
        pin.setBounds(330,330,180,25 );
        pin.setFont(new Font("Arial",Font.BOLD,14));
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter New Pin :");
        repintext.setBounds(165,370,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(330,370,180,25);
        repin.setFont(new Font("Arial",Font.BOLD,14));
        image.add(repin);
        
        change=new JButton("CHANGE");
        change.setBounds(350,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("BACK");
        back.setBounds(350,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==change)
        {
        try
        {
            String npin = pin.getText();
            String rpin = repin.getText(); 
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter new PIN ");
                return;
            }
            if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please  re-enter new PIN ");
                return;
            }
            Conn c = new Conn();
            String query = "update bank set pin'"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin'"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signupthree set pin'"+rpin+"' where pin='"+pinnumber+"'";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"PIN changed successfully ");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }
        else 
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
