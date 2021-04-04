import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MidtermProject {

	private JFrame frame;
	private JTextField txtUN;
	private JTextField txtPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MidtermProject window = new MidtermProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MidtermProject() {
		initialize();
	}
	
	Connection con;
	PreparedStatement pst;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 769, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bank Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(267, 41, 398, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 119, 665, 308);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 81, 112, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(12, 143, 98, 30);
		panel.add(lblNewLabel_2);
		
		txtUN = new JTextField();
		txtUN.setBounds(122, 94, 208, 30);
		panel.add(txtUN);
		txtUN.setColumns(10);
		
		txtPW = new JTextField();
		txtPW.setColumns(10);
		txtPW.setBounds(122, 140, 208, 30);
		panel.add(txtPW);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(48, 218, 105, 38);
		panel.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(171, 218, 105, 38);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(288, 218, 105, 38);
		panel.add(btnExit);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAboutUs.setBounds(496, 81, 137, 38);
		panel.add(btnAboutUs);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHelp.setBounds(496, 139, 147, 38);
		panel.add(btnHelp);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnForgotPassword.setBounds(496, 200, 157, 38);
		panel.add(btnForgotPassword);
	}
}
