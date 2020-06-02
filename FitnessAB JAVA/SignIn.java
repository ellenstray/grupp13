SignIn

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.*;
import org.sqlite.SQLiteConfig;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class signin extends JFrame {

	private JPanel contentPane;
	private JTextField memberphone;
	private JTextField memrbername;
	private JTextField membmail;
	private JTextField membpass;
	private JTextField memberaddress;
	private JTextField memberzip;
	private JTextField membercity;

	/**
	 * Launch the application.
	 */
	 public static final String DB_URL = "jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb";
	 public static final String DRIVER = "org.sqlite.JDBC";
	  
	public static void main(String[] args)  throws IOException {
		Connection conn = null;
		 try {
	         Class.forName(DRIVER);
	         SQLiteConfig config = new SQLiteConfig();  
	         config.enforceForeignKeys(true);
	         conn = DriverManager.getConnection(DB_URL,config.toProperties());  
	      } catch (Exception e) {
	    	  System.out.println( e.toString() );
	          System.exit(0);
	       }
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin frame = new signin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setBounds(198, 6, 61, 16);
		contentPane.add(lblNewLabel);
		
		memberphone = new JTextField();
		memberphone.setBounds(93, 186, 130, 26);
		contentPane.add(memberphone);
		memberphone.setColumns(10);
		
		memrbername = new JTextField();
		memrbername.setColumns(10);
		memrbername.setBounds(93, 72, 130, 26);
		contentPane.add(memrbername);
		
		membmail = new JTextField();
		membmail.setColumns(10);
		membmail.setBounds(93, 110, 130, 26);
		contentPane.add(membmail);
		
		membpass = new JTextField();
		membpass.setColumns(10);
		membpass.setBounds(93, 148, 130, 26);
		contentPane.add(membpass);
		
		memberaddress = new JTextField();
		memberaddress.setColumns(10);
		memberaddress.setBounds(314, 72, 130, 26);
		contentPane.add(memberaddress);
		
		memberzip = new JTextField();
		memberzip.setColumns(10);
		memberzip.setBounds(314, 110, 130, 26);
		contentPane.add(memberzip);
		
		membercity = new JTextField();
		membercity.setColumns(10);
		membercity.setBounds(314, 148, 130, 26);
		contentPane.add(membercity);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(6, 77, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel mamberemail = new JLabel("Email:");
		mamberemail.setBounds(6, 115, 61, 16);
		contentPane.add(mamberemail);
		
		JLabel memberpass = new JLabel("Password");
		memberpass.setBounds(6, 153, 61, 16);
		contentPane.add(memberpass);
		
		JLabel lblNewLabel_1_3 = new JLabel("PhoneNr:");
		lblNewLabel_1_3.setBounds(6, 191, 61, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address:");
		lblNewLabel_1_4.setBounds(235, 77, 61, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Zipcode:");
		lblNewLabel_1_5.setBounds(235, 115, 61, 16);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("City:");
		lblNewLabel_1_6.setBounds(235, 153, 61, 16);
		contentPane.add(lblNewLabel_1_6);
		
		JButton btnNewButton = new JButton("Sign Up!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
					PreparedStatement ps = conn.prepareStatement("insert into members(memberName, email, password, phone, address, zipcode, city) values(?,?,?,?,?,?,?)");
					ps.setString(1, memrbername.getText());
					ps.setString(2, membmail.getText());
					ps.setString(3, membpass.getText());
					ps.setString(4, memberphone.getText());
					ps.setString(5, memberaddress.getText());
					ps.setString(6, memberzip.getText());
					ps.setString(7, membercity.getText());
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("Registration done sucessfully!");
						Main second = new Main();
						second.setVisible(true);
						
						dispose();
						
					} else
						{System.out.println("Registration failed!");
						}
				}
				catch(Exception e1) {
					System.out.println(e1);
			}
		
		}
			
					
			
		});
		btnNewButton.setBounds(166, 224, 117, 29);
		contentPane.add(btnNewButton);
	}
}
