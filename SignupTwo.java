package bank.management.sysetm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
    
         JTextField pan , aadhar;
         JRadioButton syes,sno,eyes,eno;
         JButton next;
         String formno;
         JComboBox religion , category , occupation , education , income;
    
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("PAGE 2 : Additional Details ");
        additionalDetails.setFont(new Font ("Raleway", Font.BOLD,24));
        additionalDetails.setBounds(290,80,400,30 );
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font ("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30 );
        add(name);
        
        String vR[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(vR);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
                
        
        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font ("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30 );
        add(fname);
        
        String vC[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(vC);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font ("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30 );
        add(dob);
        
        String vI[]={"NIL","<=1,00,000","<=2,50,000","<=5,00,000","<=10,00,000","> 10,00,000"};
        income = new JComboBox(vI);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font ("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30 );
        add(gender);
        
        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font ("Raleway", Font.BOLD,20));
        email.setBounds(100,315,200,30 );
        add(email);
        
        String eV[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(eV);
        education.setBounds(300,300,400,30);
        education .setBackground(Color.WHITE);
        add(education );
        
        
        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font ("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30 );
        add(marital);
        
        String oV[]={"Government Employee","Private Salaried Empolyee","Student","Retired","Self Employed","Business","Others"};
        occupation = new JComboBox(oV);
        occupation.setBounds(300,390,400,30);
        occupation .setBackground(Color.WHITE);
        add(occupation );
        
        JLabel address = new JLabel("PAN Number : ");
        address.setFont(new Font ("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30 );
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font ("Arial",Font.BOLD,16));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city = new JLabel("AADHAR Number : ");
        city.setFont(new Font ("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30 );
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font ("Arial",Font.BOLD,16));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior citizen : ");
        state.setFont(new Font ("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30 );
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pinc = new JLabel("Existing Account : ");
        pinc.setFont(new Font ("Raleway", Font.BOLD,20));
        pinc.setBounds(100,590,200,30 );
        add(pinc);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
 
        
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
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }
        else if (sno.isSelected())
            seniorcitizen = "no";
        String existingaccount = null;
        if(eyes.isSelected())
            existingaccount="Yes";
        else if(eno.isSelected())
            existingaccount="No";
        String span = pan.getText();
        String saadhar = aadhar.getText();
        try
        {
                Conn c =new Conn();
                String query1 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query1);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            
         catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main (String args[])
    {
        new SignupTwo("");
    }
}

