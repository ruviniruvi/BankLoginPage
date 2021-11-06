import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DepositeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtacc;
	private JTextField textAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositeFrame frame = new DepositeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;

	private JTextField textblnc;
	private JTextField textDate;
	private JTextField textWAmount;

	public void Connect() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}
	}

	// show current date before deposit money to the account
	public void date() {

		DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime currentTime = LocalDateTime.now();
		String date = currentDate.format(currentTime);

		textDate.setText(date);
	}

	/**
	 * Create the frame.
	 */
	public DepositeFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Deposits");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(285, 32, 252, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter the Account Number");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(37, 145, 232, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentBalance.setBounds(37, 270, 200, 24);
		contentPane.add(lblCurrentBalance);

		JLabel lblNewLabel_2 = new JLabel("Deposit Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(37, 343, 200, 24);
		contentPane.add(lblNewLabel_2);

		txtacc = new JTextField();
		txtacc.setBackground(new Color(245, 245, 245));
		txtacc.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtacc.setBounds(266, 149, 227, 38);
		contentPane.add(txtacc);
		txtacc.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				// this is for the account search before deposit to the customer account
				try {

					String acNo = txtacc.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							
							"SELECT 	A.CURRENT_BALANCE FROM ACCOUNTS AS A WHERE ACCOUNT_NUMBER = ?");
					insert.setString(1, acNo);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						
						String balance = rs.getString(1);
						textblnc.setText(balance.trim());
						
					} else
						JOptionPane.showMessageDialog(null, " Incorrect customer account number. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

				date();

			}
		});
		btnNewButton.setBounds(503, 147, 107, 40);
		contentPane.add(btnNewButton);

		textAmount = new JTextField();
		textAmount.setBackground(new Color(245, 245, 245));
		textAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAmount.setBounds(266, 345, 227, 38);
		contentPane.add(textAmount);
		textAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// con.setAutoCommit(false); // both SQL queries should work for the deposit
					// money
					String acNo = txtacc.getText();

					String date = textDate.getText();
					String depositAmount = textAmount.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"INSERT INTO TRANSACTIONS( ACCOUNT_NUMBER, TRANSACTION_DATE,  DEPOSIT_AMOUNT) VALUES(?,?,?  )");

					insert.setString(1, acNo);
					insert.setString(2, date);
					insert.setString(3, depositAmount);

					insert.executeUpdate();

					// update the current balance when customer deposited

					update = con.prepareStatement(
							"UPDATE ACCOUNTS SET CURRENT_BALANCE = CURRENT_BALANCE + ? WHERE ACCOUNT_NUMBER =? ");

					update.setString(1, depositAmount);

					update.setString(2, acNo);
					update.executeUpdate();

					JOptionPane.showMessageDialog(null, "  Successfully deposited! .");
					con.commit();

					con.close();
				} catch (Exception e1) {
					System.out.print(e);
					
				}

			}
		});
		btnNewButton_1.setBounds(503, 336, 189, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAmount.setText(null);
				textWAmount.setText(null);

			}
		});
		btnNewButton_2.setBounds(543, 544, 189, 38);
		contentPane.add(btnNewButton_2);

		textblnc = new JTextField();
		textblnc.setBackground(new Color(245, 245, 245));
		textblnc.setFont(new Font("Tahoma", Font.BOLD, 11));
		textblnc.setBounds(266, 272, 227, 38);
		contentPane.add(textblnc);
		textblnc.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(37, 211, 199, 14);
		contentPane.add(lblNewLabel_6);

		textDate = new JTextField();
		textDate.setBackground(new Color(245, 245, 245));
		textDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDate.setBounds(266, 208, 227, 38);
		contentPane.add(textDate);
		textDate.setColumns(10);

		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBackground(new Color(255, 228, 225));
		btnNewButton_3.setForeground(new Color(178, 34, 34));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtacc.setText(null);
			}
		});
		btnNewButton_3.setBounds(626, 145, 106, 38);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setBackground(new Color(255, 228, 225));
		btnNewButton_4.setForeground(new Color(178, 34, 34));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// back to the administration page
				AdministrationFrame ad = new AdministrationFrame();
				ad.toBack();
				setVisible(false);
				ad.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);

			}

		});
		btnNewButton_4.setBounds(37, 544, 189, 38);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_7.setBounds(119, 32, 72, 72);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Withdrawal Amount");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(37, 409, 170, 24);
		contentPane.add(lblNewLabel_8);
		
		textWAmount = new JTextField();
		textWAmount.setBackground(new Color(245, 245, 245));
		textWAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textWAmount.setBounds(266, 411, 227, 38);
		contentPane.add(textWAmount);
		textWAmount.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.setBackground(new Color(255, 228, 225));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// con.setAutoCommit(false); // both SQL queries should work for the withdraw
					// money
					String acNo = txtacc.getText();

					String date = textDate.getText();
					String withdrawAmount = textWAmount.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"INSERT INTO TRANSACTIONS( ACCOUNT_NUMBER,  TRANSACTION_DATE,  WITHDRAWAL_AMOUNT) VALUES(?,?,?  )");

					insert.setString(1, acNo);
					insert.setString(2, date);
					insert.setString(3,withdrawAmount);

					insert.executeUpdate();

					// update the current balance when customer withdraw

					update = con.prepareStatement(
							"UPDATE ACCOUNTS SET CURRENT_BALANCE = CURRENT_BALANCE - ? WHERE ACCOUNT_NUMBER =? ");

					update.setString(1, withdrawAmount);

					update.setString(2, acNo);
					update.executeUpdate();

					JOptionPane.showMessageDialog(null, "  You have successfully withdrawn! .");
					con.commit();

					con.close();
				} catch (Exception e1) {
					System.out.print(e);
					
				}
				
				
				
			}
		});
		btnNewButton_5.setForeground(new Color(178, 34, 34));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(503, 402, 189, 38);
		contentPane.add(btnNewButton_5);
	}
}
