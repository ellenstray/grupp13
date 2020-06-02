Strenght

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
import org.sqlite.SQLiteConfig;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Strenght extends JFrame {
	
	public static final String DB_URL = "jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb";
	public static final String DRIVER = "org.sqlite.JDBC";

	private JPanel contentPane;
	private JTextField strenght_text;

	/**
	 * Launch the application.
	 */

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
					Strenght frame = new Strenght();
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
	public Strenght() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Book Course");
		
		strenght_text = new JTextField();
		strenght_text.setColumns(10);
		try 
		{ 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
			String sql = "SELECT * from courses where courseID=2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String out ="";
				
					out = (rs.getString(1)) + "\t" + (rs.getString(2)) + "\t" + (rs.getString(3)) + "\t" + (rs.getString(4)) + "\t" + (rs.getString(5)) + "\t" + (rs.getString(6));
				
				strenght_text.setText(out);
				conn.close();
				
		}
		catch(Exception e1) {
			System.out.println(e1);
	}
		
		JButton book_class_2 = new JButton("Book class");
		book_class_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt = null;
				String ID = JOptionPane.showInputDialog(null, "Enter your MemberID");
			
				Statement stm= null;
				
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/danielcuracica/Databas/fitnessABdb");
					String SQL = "INSERT INTO courseEnrollment (memberID, spot, courseID) VALUES ('"+ ID.toString() + "','" + "Majorna" + "','" + 2  + "');";
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
		
		JLabel lblNewLabel_2_1 = new JLabel("InstructorID");
		
		JLabel lblNewLabel_2_2 = new JLabel("Time");
		
		JLabel lblNewLabel_2_3 = new JLabel("Location");
		
		JLabel lblNewLabel_2_4 = new JLabel("Level");
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		
		JButton book_class_2_1 = new JButton("Cancel");
		book_class_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes second = new classes();
				second.setVisible(true);
				
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(60)
									.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(47)
									.addComponent(lblNewLabel_2_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(69))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
									.addGap(168))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(strenght_text, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(book_class_2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(book_class_2_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addGap(52))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2_1)
						.addComponent(lblNewLabel_2_3)
						.addComponent(lblNewLabel_2_4)
						.addComponent(lblNewLabel_2_2))
					.addGap(37)
					.addComponent(strenght_text, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(book_class_2)
						.addComponent(book_class_2_1))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

