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
	private JTextField textFN;
	private JTextField textLN;
	private JTextField textID;
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
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Deposits");
		lblNewLabel.setForeground(new Color(245, 245, 245));
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
		lblCurrentBalance.setBounds(37, 224, 200, 24);
		contentPane.add(lblCurrentBalance);

		JLabel lblNewLabel_2 = new JLabel("Deposit Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(37, 418, 200, 24);
		contentPane.add(lblNewLabel_2);

		txtacc = new JTextField();
		txtacc.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtacc.setBounds(266, 149, 227, 24);
		contentPane.add(txtacc);
		txtacc.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBackground(new Color(245, 245, 245));
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
		btnNewButton.setBounds(507, 138, 107, 38);
		contentPane.add(btnNewButton);

		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAmount.setBounds(266, 420, 227, 24);
		contentPane.add(textAmount);
		textAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
					
				}

			}
		});
		btnNewButton_1.setBounds(525, 411, 189, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAmount.setText(null);
				textWAmount.setText(null);

			}
		});
		btnNewButton_2.setBounds(525, 544, 189, 38);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("Customer First Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(37, 277, 199, 18);
		contentPane.add(lblNewLabel_4);

		textblnc = new JTextField();
		textblnc.setFont(new Font("Tahoma", Font.BOLD, 11));
		textblnc.setBounds(266, 226, 227, 24);
		contentPane.add(textblnc);
		textblnc.setColumns(10);

		textFN = new JTextField();
		textFN.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFN.setBounds(266, 276, 224, 24);
		contentPane.add(textFN);
		textFN.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Customer Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(37, 317, 199, 24);
		contentPane.add(lblNewLabel_3);

		textLN = new JTextField();
		textLN.setFont(new Font("Tahoma", Font.BOLD, 11));
		textLN.setBounds(269, 319, 224, 24);
		contentPane.add(textLN);
		textLN.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Customer ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(38, 377, 199, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.BOLD, 11));
		textID.setBounds(266, 374, 227, 24);
		contentPane.add(textID);
		textID.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(37, 193, 199, 14);
		contentPane.add(lblNewLabel_6);

		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDate.setBounds(266, 190, 227, 25);
		contentPane.add(textDate);
		textDate.setColumns(10);

		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtacc.setText(null);
			}
		});
		btnNewButton_3.setBounds(641, 138, 106, 38);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setBackground(new Color(245, 245, 245));
		btnNewButton_4.setForeground(new Color(220, 20, 60));
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
		lblNewLabel_8.setBounds(37, 477, 170, 24);
		contentPane.add(lblNewLabel_8);
		
		textWAmount = new JTextField();
		textWAmount.setBackground(new Color(248, 248, 255));
		textWAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textWAmount.setBounds(266, 477, 227, 24);
		contentPane.add(textWAmount);
		textWAmount.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("OK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// con.setAutoCommit(false); // both SQL queries should work for the withdraw
					// money
					String acNo = txtacc.getText();

					String id = textID.getText();
					String firstname = textFN.getText();
					String lastname = textLN.getText();
					String date = textDate.getText();
					String withdrawAmount = textWAmount.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"INSERT INTO TRANSACTIONS( ACCOUNT_NUMBER, CUSTOMER_FIRST_NAME,CUSTOMER_LAST_NAME,  CUSTOMER_ID, TRANSACTION_DATE,  WITHDRAWAL_AMOUNT) VALUES(?,?,?,?,?,?  )");

					insert.setString(1, acNo);
					insert.setString(2, firstname);
					insert.setString(3, lastname);
					insert.setString(4, id);
					insert.setString(5, date);
					insert.setString(6,withdrawAmount);

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
		btnNewButton_5.setForeground(new Color(220, 20, 60));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(525, 472, 189, 38);
		contentPane.add(btnNewButton_5);
	}
}
