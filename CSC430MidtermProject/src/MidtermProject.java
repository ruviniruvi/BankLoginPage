
//this program is designed for bank employees
//Bank employees can login using their username and password
//this code references a database which holds the bank employee information including username and password
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MidtermProject {

	JFrame frame;
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
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setBounds(100, 100, 773, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bank Management System");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(231, 41, 434, 53);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 102));
		panel.setBounds(56, 126, 665, 425);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(56, 87, 112, 46);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(55, 166, 98, 30);
		panel.add(lblNewLabel_2);

		txtUN = new JTextField();
		txtUN.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUN.setBackground(new Color(245, 245, 245));
		txtUN.setBounds(204, 97, 208, 30);
		panel.add(txtUN);
		txtUN.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UN = txtUN.getText();
				// @SuppressWarnings("deprecation")
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
						frame.dispose();
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
		btnNewButton.setBounds(48, 290, 105, 38);
		panel.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(220, 20, 60));
		btnClear.setBackground(new Color(211, 211, 211));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUN.setText(null);
				txtPW.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(177, 290, 105, 38);
		panel.add(btnClear);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(220, 20, 60));
		btnExit.setBackground(new Color(211, 211, 211));
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
		btnExit.setBounds(307, 290, 105, 38);
		panel.add(btnExit);

		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setForeground(new Color(220, 20, 60));
		btnAboutUs.setBackground(new Color(211, 211, 211));
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// linking to AboutUs page AboutUs

				// frame.dispose();
				AboutUs ab = new AboutUs();
				ab.setVisible(true);

				ab.toBack();
				ab.setVisible(true);

				ab.toFront();
				// frame.dispose();

			}
		});
		btnAboutUs.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAboutUs.setBounds(463, 91, 190, 38);
		panel.add(btnAboutUs);

		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(new Color(220, 20, 60));
		btnHelp.setBackground(new Color(211, 211, 211));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// frame.dispose();
				HelpFrame ab = new HelpFrame();
				ab.setVisible(true);

				ab.toBack();
				ab.setVisible(true);
				ab.toFront();

			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHelp.setBounds(463, 195, 190, 38);
		panel.add(btnHelp);

		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setForeground(new Color(220, 20, 60));
		btnForgotPassword.setBackground(new Color(211, 211, 211));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// linking to the ForgotPassword page
				ForgotPasswordFrame fp = new ForgotPasswordFrame();
				fp.setVisible(true);

				fp.toBack();
				fp.setVisible(true);
				fp.toFront();

			}
		});
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnForgotPassword.setBounds(463, 290, 190, 38);
		panel.add(btnForgotPassword);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 203, 1, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 203, 439, -13);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(192, 192, 192));
		separator_2.setBounds(56, 254, 356, 2);
		panel.add(separator_2);

		txtPW = new JPasswordField();
		txtPW.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPW.setBackground(new Color(245, 245, 245));
		txtPW.setBounds(204, 170, 208, 30);
		panel.add(txtPW);

		JLabel lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(87, 22, 72, 72);
		frame.getContentPane().add(lblNewLabel_3);

	}

	public void toBack() {
		// TODO Auto-generated method stub

	}

	public void toFront() {
		// TODO Auto-generated method stub

	}

	public void setState(int normal) {
		// TODO Auto-generated method stub

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
