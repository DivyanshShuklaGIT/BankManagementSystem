package bank.management.sysetm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener
{
         long random;
         JTextField nameTextField , fnameTextField, emailTextField , addressTextField ,cityTextField ,stateTextField , pincTextField;
         JDateChooser datechooser;
         JRadioButton male,female,married,unmarried;
         JButton next;
    
    
    SignupOne()
    {
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+ 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NUMBER : " + random);
        formno.setFont(new Font ("Roboto", Font.BOLD,34));
        formno.setBounds(140,20,800,40 );
        add(formno);
        
        JLabel personalDetails = new JLabel("PAGE 1 : Personal Details ");
        personalDetails.setFont(new Font ("Raleway", Font.BOLD,24));
        personalDetails.setBounds(290,80,400,30 );
        add(personalDetails);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font ("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30 );
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font ("Arial",Font.BOLD,16));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font ("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30 );
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font ("Arial",Font.BOLD,16));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font ("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30 );
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        add(datechooser);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font ("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30 );
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font ("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30 );
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font ("Arial",Font.BOLD,16));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital status : ");
        marital.setFont(new Font ("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30 );
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font ("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30 );
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font ("Arial",Font.BOLD,16));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font ("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30 );
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font ("Arial",Font.BOLD,16));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font ("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30 );
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font ("Arial",Font.BOLD,16));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pinc = new JLabel("Pincode : ");
        pinc.setFont(new Font ("Raleway", Font.BOLD,20));
        pinc.setBounds(100,590,200,30 );
        add(pinc);
        
        pincTextField = new JTextField();
        pincTextField.setFont(new Font ("Arial",Font.BOLD,16));
        pincTextField.setBounds(300,590,400,30);
        add(pincTextField);
        
        next = new JButton("Next");
        next.setFont(new Font("Copper Black" , Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
       
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno =""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email= emailTextField.getText();
        String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if (female.isSelected())
            gender = "Female";
        String marital = null;
        if(married.isSelected())
            marital="Married";
        else if(unmarried.isSelected())
            marital="Unmarried";
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinc = pincTextField.getText();
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else
            {
                Conn c =new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main (String args[])
    {
        new SignupOne();
    }
}
