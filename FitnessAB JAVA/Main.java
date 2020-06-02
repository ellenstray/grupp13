Main

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.io.*;
import org.sqlite.SQLiteConfig;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

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
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select an action");
		lblNewLabel.setBounds(171, 6, 121, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnBookAClass = new JButton("Book a class");
		btnBookAClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes second = new classes();
				second.setVisible(true);
				
				dispose();
			}
		});
		btnBookAClass.setBounds(16, 130, 155, 29);
		contentPane.add(btnBookAClass);
		
		JButton btnView = new JButton("View your calsses");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = JOptionPane.showInputDialog(null, "Enter MemberID:");
				String SQL = "SELECT courseEnrollment.memberID, courseEnrollment.spot, courseEnrollment.courseID, members.memberName, courses.courseName from courseEnrollment JOIN members on courseEnrollment.memberID = members.memberID join courses on courses.courseID = courseEnrollment.courseID WHERE courseEnrollment.memberID= '" + ID + "';";
				Statement stmt= null;
				Connection conn = null;
				ResultSet rs = null;
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
					stmt=conn.createStatement();
					rs=	stmt.executeQuery(SQL);
					String out ="";
			        while (rs.next()){
			        out +=(rs.getString("memberName")  + "\t" + rs.getString("spot") + "\t" + rs.getString("courseName")+ "\n");
			        }
			        JOptionPane.showMessageDialog(null, "Booked classes: \n" + out);
			        
				}catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null,  sqle.getMessage());
					
					
				}
			}
		});
		btnView.setBounds(258, 130, 155, 29);
		contentPane.add(btnView);
		
		JButton removebtn = new JButton("Remove Class");
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removebtn.setBounds(258, 193, 155, 29);
		contentPane.add(removebtn);
		
		JButton btnMessage = new JButton("Messages");
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No new messages.");
			}
		});
		btnMessage.setBounds(16, 193, 155, 29);
		contentPane.add(btnMessage);
	}
}


