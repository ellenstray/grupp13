Classes

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class classes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classes frame = new classes();
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
	public classes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose class:");
		lblNewLabel.setBounds(173, 26, 121, 16);
		contentPane.add(lblNewLabel);
		
		JButton yogabutton = new JButton("Yoga");
		yogabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yoga second = new Yoga();
				second.setVisible(true);
			}
		});
		yogabutton.setBounds(42, 107, 117, 29);
		contentPane.add(yogabutton);
		
		JButton strenghtbutton = new JButton("Strenght");
		strenghtbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strenght second = new Strenght();
				second.setVisible(true);
			}
		});
		strenghtbutton.setBounds(269, 107, 117, 29);
		contentPane.add(strenghtbutton);
		
		JButton btnSpinning = new JButton("Spinning");
		btnSpinning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSpinning.setBounds(42, 181, 117, 29);
		contentPane.add(btnSpinning);
		
		JButton btnBack = new JButton("Cancel");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main second = new Main();
				second.setVisible(true);
			}
		});
		btnBack.setBounds(269, 181, 117, 29);
		contentPane.add(btnBack);
	}
}
