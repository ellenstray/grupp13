Yoga

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
import org.sqlite.SQLiteConfig;
import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Yoga extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static final String DB_URL = "jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb";
	 public static final String DRIVER = "org.sqlite.JDBC";
	 private JTextArea courseType;
	 
	 
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
					Yoga frame = new Yoga();
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
	public Yoga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea courseType = new JTextArea();
		try 
		{ 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
			String sql = "SELECT * from courses where courseID=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String out ="";
				
					out = (rs.getString(1)) + "\t" + (rs.getString(2)) + "\t" + (rs.getString(3)) + "\t" + (rs.getString(4)) + "\t" + (rs.getString(5)) + "\t" + (rs.getString(6));
				
				courseType.setText(out);
				conn.close();
				
		}
		catch(Exception e1) {
			System.out.println(e1);
	}
		
		
		JLabel lblNewLabel = new JLabel("Book Course");
		
		JButton btnNewButton = new JButton("Book Class");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt = null;
			String ID = JOptionPane.showInputDialog(null, "Enter your MemberID");
		
			Statement stm= null;
			
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
				String SQL = "INSERT INTO courseEnrollment (memberID, spot, courseID) VALUES ('"+ ID.toString() + "','" + "City" + "','" + 1  + "');";
				stm=conn.createStatement();
				stm.executeUpdate(SQL);
				conn.close();
				}catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, sqle.getMessage());
				}
			finally {
			    try { if (stmt != null) stmt.close(); } catch (Exception e1) {};
			   
			    }
			}
		}
			
		
	
	);
		
		JLabel lblNewLabel_2 = new JLabel("CourseID");
		
		JLabel lblNewLabel_2_1 = new JLabel("Course");
		
		JLabel lblNewLabel_2_2 = new JLabel("InstructorID");
		
		JLabel lblNewLabel_2_3 = new JLabel("Time");
		
		JLabel lblNewLabel_2_4 = new JLabel("Location");
		
		JLabel lblNewLabel_2_5 = new JLabel("Level");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes second = new classes();
				second.setVisible(true);
				
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(208))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(lblNewLabel_2_4, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(lblNewLabel_2_5, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
							.addGap(66)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(courseType, GroupLayout.PREFERRED_SIZE, 509, Short.MAX_VALUE)))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_2_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_4)
							.addComponent(lblNewLabel_2_5))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_2)
							.addComponent(lblNewLabel_2_3)))
					.addGap(9)
					.addComponent(courseType, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(119))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
