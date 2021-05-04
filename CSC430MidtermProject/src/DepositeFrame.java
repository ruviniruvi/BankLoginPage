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
	private JTextField textFN;
	private JTextField textLN;
	private JTextField textID;
	private JTextField textDate;

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
		setBounds(100, 100, 663, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Deposits");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(164, 34, 252, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter the Account Number");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(67, 122, 199, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurrentBalance.setBounds(67, 202, 200, 24);
		contentPane.add(lblCurrentBalance);

		JLabel lblNewLabel_2 = new JLabel("Deposit Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(67, 334, 200, 24);
		contentPane.add(lblNewLabel_2);

		txtacc = new JTextField();
		txtacc.setBounds(276, 125, 192, 20);
		contentPane.add(txtacc);
		txtacc.setColumns(10);

		JButton btnNewButton = new JButton("Find");
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
							"SELECT C.CUSTOMER_FIRST_NAME,C.CUSTOMER_LAST_NAME, C.CUSTOMER_ID, A.CURRENT_BALANCE FROM ACCOUNTS AS A, CUSTOMERS AS C WHERE ACCOUNT_NUMBER = ?");
					insert.setString(1, acNo);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String firstname = rs.getString(1);
						String balance = rs.getString(4);
						String lastname = rs.getString(2);
						String id = rs.getString(3);

						textblnc.setText(balance.trim());
						textFN.setText(firstname.trim());
						textLN.setText(lastname.trim());
						textID.setText(id.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect customer account number. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

				date();

			}
		});
		btnNewButton.setBounds(486, 124, 69, 23);
		contentPane.add(btnNewButton);

		textAmount = new JTextField();
		textAmount.setBounds(276, 334, 192, 20);
		contentPane.add(textAmount);
		textAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// This is not working yet

				try {
					// con.setAutoCommit(false); // both SQL queries should work for the deposit
					// money
					String acNo = txtacc.getText();

					String id = textID.getText();
					String firstname = textFN.getText();
					String lastname = textLN.getText();
					String date = textDate.getText();
					String depositAmount = textAmount.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"INSERT INTO TRANSACTIONS( ACCOUNT_NUMBER, CUSTOMER_FIRST_NAME,CUSTOMER_LAST_NAME,  CUSTOMER_ID, TRANSACTION_DATE,  DEPOSIT_AMOUNT) VALUES(?,?,?,?,?,?  )");

					insert.setString(1, acNo);
					insert.setString(2, firstname);
					insert.setString(3, lastname);
					insert.setString(4, id);
					insert.setString(5, date);
					insert.setString(6, depositAmount);

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
					/*
					 * try { con.rollback(); } catch (SQLException e2) { // TODO Auto-generated
					 * catch block e2.printStackTrace(); }
					 */
				}

			}
		});
		btnNewButton_1.setBounds(276, 364, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAmount.setText(null);

			}
		});
		btnNewButton_2.setBounds(390, 364, 89, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("Customer First Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(67, 237, 199, 18);
		contentPane.add(lblNewLabel_4);

		textblnc = new JTextField();
		textblnc.setBounds(277, 205, 189, 20);
		contentPane.add(textblnc);
		textblnc.setColumns(10);

		textFN = new JTextField();
		textFN.setBounds(279, 237, 189, 20);
		contentPane.add(textFN);
		textFN.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Customer Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(67, 263, 199, 24);
		contentPane.add(lblNewLabel_3);

		textLN = new JTextField();
		textLN.setBounds(279, 266, 189, 20);
		contentPane.add(textLN);
		textLN.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Customer ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(67, 298, 199, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setBounds(276, 296, 192, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(67, 172, 199, 14);
		contentPane.add(lblNewLabel_6);

		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		textDate.setBounds(279, 170, 86, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);

		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtacc.setText(null);
			}
		});
		btnNewButton_3.setBounds(568, 124, 69, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Back");
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
		btnNewButton_4.setBounds(164, 364, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
