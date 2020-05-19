import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import org.sqlite.SQLiteConfig;
import java.util.*;


class MyFrame 
    extends JFrame 
    implements ActionListener { 
    
    
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel mno; 
    private JLabel payment;
    private JRadioButton ccreditcard;
    private JRadioButton invoice;
    private JTextField temail;
    private JTextField tmno;  
    private JLabel email;  
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JComboBox creditmonth;
    private JComboBox credityear;  
    private JLabel add; 
    private JTextArea tadd; 
    private JTextField tcreditcard; 
    private JTextField tcvv; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JLabel expire;
    private JLabel cvv; 
    private JLabel creditcard;
    private JTextArea resadd; 
    private JLabel street; 
    private JLabel zipcode; 
    private JLabel city; 
    private JTextField tstreet; 
    private JTextField tzipcode; 
    private JTextField tcity; 
   

  
  //  private String dates[] 
  //      = { "1", "2", "3", "4", "5", 
   //         "6", "7", "8", "9", "10", 
  //          "11", "12", "13", "14", "15", 
   //         "16", "17", "18", "19", "20", 
   //         "21", "22", "23", "24", "25", 
    //        "26", "27", "28", "29", "30", 
    //        "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "2020", "2021", "2022", "2023", "2024",
            "2025", "2026", "2027", "2028", "2029" }; 
  
    // constructor, to initialize the components 
    // with default values. 
    public MyFrame() 
    { 
        setTitle("Sign Up"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Sign Up - Fitness AB"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("Full name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 15)); 
        name.setSize(100, 20); 
        name.setLocation(100, 75); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(200, 75); 
        c.add(tname); 
  
        mno = new JLabel("Mobile"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mno.setSize(100, 20); 
        mno.setLocation(100, 100); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(200, 100); 
        c.add(tmno); 
  
        email = new JLabel("Email-address"); 
        email.setFont(new Font("Arial", Font.PLAIN, 15)); 
        email.setSize(100, 20); 
        email.setLocation(100, 125); 
        c.add(email); 
  
        temail = new JTextField(); 
        temail.setFont(new Font("Arial", Font.PLAIN, 15)); 
        temail.setSize(150, 20); 
        temail.setLocation(200, 125); 
        c.add(temail);
        
        payment = new JLabel("Payment"); 
        payment.setFont(new Font("Arial", Font.PLAIN, 15)); 
        payment.setSize(100, 20); 
        payment.setLocation(100, 175); 
        c.add(payment); 
  
        invoice = new JRadioButton("Invoice"); 
        invoice.setFont(new Font("Arial", Font.PLAIN, 10)); 
        invoice.setSelected(true); 
        invoice.setSize(75, 20); 
        invoice.setLocation(200, 175); 
        c.add(invoice); 
  
        ccreditcard = new JRadioButton("CreditCard"); 
        ccreditcard.setFont(new Font("Arial", Font.PLAIN, 10)); 
        ccreditcard.setSelected(false); 
        ccreditcard.setSize(80, 20); 
        ccreditcard.setLocation(275, 175); 
        c.add(ccreditcard); 
        
        
        creditcard = new JLabel("CreditCard Nr"); 
        creditcard.setFont(new Font("Arial", Font.PLAIN, 15)); 
        creditcard.setSize(100, 20); 
        creditcard.setLocation(100, 200); 
        c.add(creditcard); 
        
        tcreditcard = new JTextField(); 
        tcreditcard.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tcreditcard.setSize(150, 20); 
        tcreditcard.setLocation(200, 200); 
        c.add(tcreditcard);
        
        expire = new JLabel("Expires"); 
        expire.setFont(new Font("Arial", Font.PLAIN, 15)); 
        expire.setSize(100, 20); 
        expire.setLocation(100, 250); 
        c.add(expire);
  
        creditmonth = new JComboBox(months); 
        creditmonth.setFont(new Font("Arial", Font.PLAIN, 15)); 
        creditmonth.setSize(50, 20); 
        creditmonth.setLocation(200, 250); 
        c.add(creditmonth); 
  
        credityear = new JComboBox(years); 
        credityear.setFont(new Font("Arial", Font.PLAIN, 15)); 
        credityear.setSize(60, 20); 
        credityear.setLocation(250, 250); 
        c.add(credityear); 
        
        gengp = new ButtonGroup(); 
        gengp.add(invoice); 
        gengp.add(ccreditcard);
        
        cvv = new JLabel("CVV/CVC"); 
        cvv.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cvv.setSize(100, 20); 
        cvv.setLocation(100, 275); 
        c.add(cvv); 
        
        tcvv = new JTextField(); 
        tcvv.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tcvv.setSize(150, 20); 
        tcvv.setLocation(200, 275); 
        c.add(tcvv);
  
       // dob = new JLabel("DOB"); 
       // dob.setFont(new Font("Arial", Font.PLAIN, 15)); 
       // dob.setSize(100, 20); 
      //  dob.setLocation(100, 325); 
       // c.add(dob); 
  
      //  date = new JComboBox(dates); 
      //  date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        //date.setSize(50, 20); 
       // date.setLocation(200, 325); 
       // c.add(date); 
  
        //month = new JComboBox(months); 
       // month.setFont(new Font("Arial", Font.PLAIN, 15)); 
       // month.setSize(60, 20); 
       // month.setLocation(250, 325); 
       // c.add(month); 
  
       // year = new JComboBox(years); 
       // year.setFont(new Font("Arial", Font.PLAIN, 15)); 
       // year.setSize(60, 20); 
       // year.setLocation(320, 325); 
       // c.add(year); 
  
        street = new JLabel("Street Name"); 
        street.setFont(new Font("Arial", Font.PLAIN, 15)); 
        street.setSize(100, 20); 
        street.setLocation(100, 375); 
        c.add(street); 
  
        tstreet = new JTextField(); 
        tstreet.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tstreet.setSize(150, 20); 
        tstreet.setLocation(200, 375); 
        c.add(tstreet); 
        
        
        zipcode = new JLabel("Zip Code"); 
        zipcode.setFont(new Font("Arial", Font.PLAIN, 15)); 
        zipcode.setSize(100, 20); 
        zipcode.setLocation(100, 400); 
        c.add(zipcode); 
  
        tzipcode = new JTextField(); 
        tzipcode.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tzipcode.setSize(50, 20); 
        tzipcode.setLocation(200, 400); 
        c.add(tzipcode); 
        
        city = new JLabel("City"); 
        city.setFont(new Font("Arial", Font.PLAIN, 15)); 
        city.setSize(100, 20); 
        city.setLocation(275, 400); 
        c.add(city); 
  
        tzipcode = new JTextField(); 
        tzipcode.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tzipcode.setSize(150, 20); 
        tzipcode.setLocation(300, 400); 
        c.add(tzipcode); 
       
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(150, 475); 
        c.add(term); 
  
        sub = new JButton("Sign up"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 500); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 500); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 15)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
  
        resadd = new JTextArea(); 
        resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resadd.setSize(200, 75); 
        resadd.setLocation(580, 175); 
        resadd.setLineWrap(true); 
        c.add(resadd); 
  
        setVisible(true); 
    } 
    
    public class Connect {
     /**
     * Connect to a sample database
     */
    public static void connect(); {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite://Users/ellenstray/desktop/java/fitnessdb.sqlite"; ;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
            if (term.isSelected()) { 
                String data1; 
                String data 
                    = "Full name : "
                      + tname.getText() + "\n"
                      + "Mobile : "
                      + tmno.getText() + "\n"; 
                if (invoice.isSelected()) 
                    data1 = "Payment : Invoice"
                            + "\n"; 
                else
                    data1 = "Payment : ccreditcard"
                            + "\n"; 
                            
                String data2 
                    = "Credit Card Number : "
                      + (String)tcreditcard.getText() 
                      + "/" + (String)creditmonth.getSelectedItem() 
                      + "/" + (String)credityear.getSelectedItem()
                      + "/" + (String)tcvv.getText()
                      + "\n"; 
                      
                String data3 
                    = "Date of birth : "
                      + (String)date.getSelectedItem() 
                      + "/" + (String)month.getSelectedItem() 
                      + "/" + (String)year.getSelectedItem() 
                      + "\n"; 
  
                String data4 = "Address : " + tstreet.getText() + 
                tzipcode.getText() + tcity.getText(); 
                tout.setText(data + data1 + data2 + data3 + data4); 
                tout.setEditable(false); 
                res.setText("Welcome to Fitness AB, " + tname.getText() ); 
            } 
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            } 
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tstreet.setText(def); 
            tzipcode.setText(def); 
            tcity.setText(def); 
            tmno.setText(def); 
            temail.setText(def);
            res.setText(def); 
            tout.setText(def); 
            term.setSelected(false); 
            tcreditcard.setText(def); 
            creditmonth.setSelectedIndex(0);
            credityear.setSelectedIndex(0);
            tcvv.setText(def); 
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            resadd.setText(def); 
        } 
    } 
} 
  
// Driver Code 
class SignUp { 

     public static void main(String[] args) throws IOException {
  connect();
    
    
        MyFrame f = new MyFrame(); 
                 
    } 
    
    }
}