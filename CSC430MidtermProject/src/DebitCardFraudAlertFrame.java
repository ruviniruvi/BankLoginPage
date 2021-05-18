import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DebitCardFraudAlertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField textID;
	private JTextField textDebitCardNumber;
	private JTextField textDCHSSN;
	private JTextField textAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebitCardFraudAlertFrame frame = new DebitCardFraudAlertFrame();
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
	public DebitCardFraudAlertFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Debit Card Fraud Alerts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(77, 35, 416, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Enter the Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(49, 107, 161, 25);
		contentPane.add(lblNewLabel_1);
		
		txtDate = new JTextField();
		txtDate.setBounds(248, 111, 200, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					String date = txtDate.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT DEBIT_FRAUD_ID , TRANSACTION_AMOUNT , CUSTOMER_SSN , DEBIT_CARD_NUMBER FROM DEBITCARDS_FRAUD_ALERTS WHERE TRANSACTION_DATE = ?");
					insert.setString(1, date);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String userID = rs.getString(1);
						String userIDcreditCNo = rs.getString(4);
						String SSN = rs.getString(3);
						String amount = rs.getString(2);
						
						
						

						textID.setText(userID.trim());
						textDebitCardNumber.setText(userIDcreditCNo.trim());
						textDCHSSN.setText(SSN.trim());
						textAmount.setText(amount.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect date format. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}
				
				
				
				
			}
				
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(498, 110, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(49, 184, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Debit Card Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(171, 184, 133, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Debit Card Holder SSN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(343, 184, 150, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(513, 185, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		textID = new JTextField();
		textID.setBounds(33, 232, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textDebitCardNumber = new JTextField();
		textDebitCardNumber.setBounds(154, 232, 161, 20);
		contentPane.add(textDebitCardNumber);
		textDebitCardNumber.setColumns(10);
		
		textDCHSSN = new JTextField();
		textDCHSSN.setBounds(341, 232, 150, 20);
		contentPane.add(textDCHSSN);
		textDCHSSN.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setBounds(501, 232, 103, 20);
		contentPane.add(textAmount);
		textAmount.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FraudAlertFrame fd = new FraudAlertFrame ();
				fd.toBack();
				setVisible(false);
				fd.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(65, 333, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(436, 334, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
