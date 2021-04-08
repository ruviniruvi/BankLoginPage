import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

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
	private JFrame MidtermProject;
	

	/**
	 * Create the application.
	 */
	public MidtermProject() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	
	public void Connect() {
		try {
			//insert your own for this line and con; it's just an example
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bankLogin", "root","");
		}
		catch (ClassNotFoundException ex)
		{
			
		}
		catch (SQLException ex)
		{
			
		}
	}

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
		panel.setBounds(55, 121, 665, 308);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			/*public void actionPerformed(ActionEvent e) {
				if(txtUN.getText().isEmpty() || txtPW.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Input Username and Password." + "!");
				} else if (txtUN.getText().equals("admin") && txtPW.getText().equals("ThisIsMyPass")) {
				} else {
					JOptionPane.showMessageDialog(null,  "Incorrect Username and Password. " + "!");
				}
				
			} */
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(48, 218, 105, 38);
		panel.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUN.setText(null);
				txtPW.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(171, 218, 105, 38);
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MidtermProject = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(MidtermProject, "Are you sure you want to exit","Bank Management Login", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
						System.exit(0);
					}
				}
		});
			
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 203, 1, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 203, 439, -13);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 203, 356, 2);
		panel.add(separator_2);
	}
}
