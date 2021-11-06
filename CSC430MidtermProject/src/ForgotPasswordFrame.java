import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class ForgotPasswordFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textSQ;
	private JTextField textSA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordFrame frame = new ForgotPasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;
	private JPasswordField newPass;

	public void Connect() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}
	}

	/**
	 * Create the frame.
	 */
	public ForgotPasswordFrame() {
		setBackground(new Color(255, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(234, 24, 337, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter Your Email Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(41, 127, 210, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Security Question");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(41, 241, 164, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Answer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(41, 317, 157, 26);
		contentPane.add(lblNewLabel_3);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		textEmail.setBackground(new Color(245, 245, 245));
		textEmail.setBounds(295, 132, 339, 36);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textSQ = new JTextField();
		textSQ.setBackground(new Color(245, 245, 245));
		textSQ.setFont(new Font("Tahoma", Font.BOLD, 11));
		textSQ.setBounds(295, 246, 339, 36);
		contentPane.add(textSQ);
		textSQ.setColumns(10);

		textSA = new JTextField();
		textSA.setFont(new Font("Tahoma", Font.BOLD, 11));
		textSA.setBackground(new Color(245, 245, 245));
		textSA.setBounds(295, 322, 339, 36);
		contentPane.add(textSA);
		textSA.setColumns(10);

		JButton btnNewButton = new JButton("Update Password");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// connection to the database to get and verify data for update password

					String email = textEmail.getText();
					String securityAnswer = textSA.getText();
					String sequrityQ = textSQ.getText();
					String newPassword = newPass.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					// update the password when customer enter new password

					// update = con.prepareStatement("UPDATE USERS SET EMPLOYEE_PASSWORD =?" +
					// newPassword
					// + " WHERE BANKER_EMAIL = ?" + email + " AND SECURITY_QUESTION_ANSWER = ?" +
					// securityAnswer);

					update = con.prepareStatement(
							"UPDATE USERS SET EMPLOYEE_PASSWORD =?  WHERE BANKER_EMAIL = ? AND SECURITY_QUESTION_ANSWER = ? ");
					// update = con.prepareStatement("UPDATE USERS SET EMPLOYEE_PASSWORD = ?"
					// WHERE BANKER_EMAIL = ?" + textEmail.getText() + " AND
					// SECURITY_QUESTION_ANSWER = '" + textSQ.getText());

					update.setString(1, newPassword);

					update.executeUpdate();

					// PreparedStatement st = (PreparedStatement) con.prepareStatement ("UPDATE
					// USERS SET EMPLOYEE_PASSWORD = '"+ newPass.getText().toString()
					// + " WHERE BANKER_EMAIL = '" + textEmail.getText() + " AND
					// SECURITY_QUESTION_ANSWER = '" + textSQ.getText());

					// st.setString(1, newPassword);
					// st.setString(2, email);
					// st.setString(3, sequrityQ);

					// st.executeUpdate();
					JOptionPane.showMessageDialog(null, "  Successfully updated! .");
					// con.commit();

					con.close();
				} catch (Exception e1) {
					System.out.print(e);
					/*
					 * try { con.rollback(); } catch (SQLException e2) { // TODO Auto-generated
					 * catch block e2.printStackTrace(); }
					 */
				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(445, 499, 189, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MidtermProject md = new MidtermProject();
				md.toBack();
				setVisible(false);
				md.toFront();
				new MidtermProject().setState(java.awt.Frame.NORMAL);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(129, 499, 189, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String email = textEmail.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement("SELECT   SECURITY_QUESTION FROM USERS WHERE BANKER_EMAIL = ?");
					insert.setString(1, email);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String sequrityQ = rs.getString(1);

						textSQ.setText(sequrityQ.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect email address. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(296, 179, 189, 36);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("New Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(41, 386, 161, 26);
		contentPane.add(lblNewLabel_4);

		newPass = new JPasswordField();
		newPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		newPass.setBackground(new Color(245, 245, 245));
		newPass.setBounds(295, 391, 339, 36);
		contentPane.add(newPass);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_5.setBounds(62, 26, 69, 72);
		contentPane.add(lblNewLabel_5);
	}
}
