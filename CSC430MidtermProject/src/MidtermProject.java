
//this program is designed for bank employees
//Bank employees can login using their username and password
//this code references a database which holds the bank employee information including username and password
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Color;

public class MidtermProject {

	private JFrame frame;
	private JTextField txtUN;

	
	// Launch the application.
	 
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

	private JFrame MidtermProject; // sets it for exit button purpose

	
	 // Create the application.
	 
	public MidtermProject() {
		initialize();
		Connect();
	}

	Connection con;
	PreparedStatement pst;
	private JPasswordField txtPW;

	public void Connect() {
		try {
			// insert your own for this line and con; it's just an example
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}
	}

	
	 // Initialize the contents of the frame.
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 773, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bank Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(231, 41, 434, 53);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 102));
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

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UN = txtUN.getText();
				//@SuppressWarnings("deprecation")
				//String PW = txtPW.getText();
				String PW = txtPW.getText();
				try {
					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select * from USERS where EMPLOYEE_USER_NAME='" + txtUN.getText()
							+ "' and EMPLOYEE_PASSWORD='" + txtPW.getText().toString() + "'";
					ResultSet rs = stmt.executeQuery(sql);

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, " Login Sucessfully.");
						// when login success link to the Administration page
						AdministrationFrame ad = new AdministrationFrame();
						ad.setVisible(true);

					} else
						JOptionPane.showMessageDialog(null, " Incorrect Username or Password.");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(48, 218, 105, 38);
		panel.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUN.setText(null);
				txtPW.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(171, 218, 105, 38);
		panel.add(btnClear);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MidtermProject = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(MidtermProject, "Are you sure you want to exit",
						"Bank Management Login", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});

		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(288, 218, 105, 38);
		panel.add(btnExit);

		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAboutUs.setBounds(484, 89, 169, 30);
		panel.add(btnAboutUs);

		JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHelp.setBounds(484, 143, 169, 30);
		panel.add(btnHelp);

		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnForgotPassword.setBounds(463, 200, 190, 38);
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

		txtPW = new JPasswordField();
		txtPW.setBackground(Color.WHITE);
		txtPW.setBounds(122, 144, 208, 30);
		panel.add(txtPW);

		JLabel lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(94, 54, 82, 25);
		frame.getContentPane().add(lblNewLabel_3);

	}
}






