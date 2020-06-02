Fitness AB Kod

addRegistration

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.io.*;
import org.sqlite.SQLiteConfig;

public class addRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField email;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	 public static final String DB_URL = "jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb";
	 public static final String DRIVER = "org.sqlite.JDBC";
	 
	 
	
	public static void main(String[] args)  throws IOException {
		try {
	         Class.forName(DRIVER);
	         SQLiteConfig config = new SQLiteConfig();  
	         config.enforceForeignKeys(true);
	         Connection conn = DriverManager.getConnection(DB_URL,config.toProperties());  
	      } catch (Exception e) {
	    	  System.out.println( e.toString() );
	          System.exit(0);
	       }

	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addRegistration frame = new addRegistration();
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
	public addRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(162, 92, 130, 26);
		contentPane.add(user);
		user.setColumns(10);
		
		email = new JTextField();
		email.setBounds(162, 130, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(162, 168, 130, 26);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setBounds(52, 97, 98, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(52, 135, 98, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(52, 173, 98, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setBounds(193, 24, 67, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt = null;
				Connection conn = null;
				ResultSet rs = null;
				String SQL = "SELECT * from members WHERE memberName= '"+user.getText()+"' AND password='"+pass.getText() + "'";
				String out= null;
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
					stmt = conn.createStatement();
					rs=	stmt.executeQuery(SQL); 

										

					if(rs.next()) { 
						JOptionPane.showMessageDialog(null,"Login sucessfull!");
						
						Main second = new Main();
						second.setVisible(true);
						dispose();
						conn.close();
		
					}else
						JOptionPane.showMessageDialog(null,"Wrong username or password!");
					conn.close();
					
					}
				

				catch(Exception e1) {
					System.out.println(e1);
				}
				finally {
					try { if (stmt != null) stmt.close(); } catch (Exception e1) {};
					try { if (conn != null) conn.close(); } catch (Exception e1) {};
				}
			}
		

		}	);
		btnNewButton.setBounds(33, 229, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin second = new signin();
				second.setVisible(true);
			}
			
		});
		btnSignUp.setBounds(175, 229, 117, 29);
		contentPane.add(btnSignUp);
		
		JButton btnCansle = new JButton("Cancel");
		btnCansle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCansle.setBounds(316, 229, 117, 29);
		contentPane.add(btnCansle);
		
		JLabel lblNewLabel_2 = new JLabel("Not a customer?");
		lblNewLabel_2.setBounds(182, 206, 110, 26);
		contentPane.add(lblNewLabel_2);
	}
}
