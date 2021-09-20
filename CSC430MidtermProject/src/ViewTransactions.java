import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ViewTransactions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccountId;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtTransacDate;
	private JTextField txtDepositAmnt;
	private JTextField txtWithdrawalAmnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTransactions frame = new ViewTransactions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;

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
	public ViewTransactions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("View Transactions");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(329, 49, 347, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(125, 36, 72, 72);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Enter Account Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(31, 135, 202, 23);
		contentPane.add(lblNewLabel_2);

		txtAccountId = new JTextField();
		txtAccountId.setBackground(new Color(248, 248, 255));
		txtAccountId.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAccountId.setBounds(321, 137, 225, 22);
		contentPane.add(txtAccountId);
		txtAccountId.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String AccountId = txtAccountId.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT TOP 1 CUSTOMER_FIRST_NAME , CUSTOMER_LAST_NAME , TRANSACTION_DATE , DEPOSIT_AMOUNT  FROM TRANSACTIONS WHERE ACCOUNT_NUMBER = ? ORDER BY TRANSACTIONS_ID DESC");
					insert.setString(1, AccountId);

					ResultSet rs = insert.executeQuery();

					if (rs.next()) {
						String FirstName = rs.getString(1);
						String LastName = rs.getString(2);
						String TransactionDate = rs.getString(3);
						String DepositAmount = rs.getString(4);
						// String WithdrawalAmount = rs.getString(5);

						txtFirstName.setText(FirstName.trim());
						txtLastName.setText(LastName.trim());
						txtTransacDate.setText(TransactionDate.trim());
						txtDepositAmnt.setText(DepositAmount.trim());
						//txtWithdrawalAmnt.setText(WithdrawalAmount.trim());

					} else
						JOptionPane.showMessageDialog(null, " This Account ID doesn't exist! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}
				
				
				///////////////////
				
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(623, 134, 111, 24);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(31, 204, 189, 23);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Last Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(31, 255, 189, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Last Transaction Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(31, 310, 189, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Last Deposited Amount ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(31, 372, 202, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Last Withdrawal Amount");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(31, 449, 216, 16);
		contentPane.add(lblNewLabel_7);

		txtLastName = new JTextField();
		txtLastName.setBackground(new Color(248, 248, 255));
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastName.setBounds(321, 254, 225, 22);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);

		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(248, 248, 255));
		txtFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFirstName.setBounds(321, 206, 225, 22);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtTransacDate = new JTextField();
		txtTransacDate.setBackground(new Color(248, 248, 255));
		txtTransacDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTransacDate.setBounds(321, 311, 225, 22);
		contentPane.add(txtTransacDate);
		txtTransacDate.setColumns(10);

		txtDepositAmnt = new JTextField();
		txtDepositAmnt.setBackground(new Color(248, 248, 255));
		txtDepositAmnt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDepositAmnt.setBounds(321, 373, 225, 22);
		contentPane.add(txtDepositAmnt);
		txtDepositAmnt.setColumns(10);

		txtWithdrawalAmnt = new JTextField();
		txtWithdrawalAmnt.setBackground(new Color(248, 248, 255));
		txtWithdrawalAmnt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtWithdrawalAmnt.setBounds(321, 448, 225, 22);
		contentPane.add(txtWithdrawalAmnt);
		txtWithdrawalAmnt.setColumns(10);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministrationFrame fd = new AdministrationFrame();
				fd.toBack();
				setVisible(false);
				fd.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);
			}

		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(342, 525, 189, 39);
		contentPane.add(btnNewButton_1);
	}
}