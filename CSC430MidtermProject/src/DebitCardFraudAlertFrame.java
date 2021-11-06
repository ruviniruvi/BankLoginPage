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
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 772, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Debit Card Fraud Alerts");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(202, 48, 416, 48);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please Enter the Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(34, 142, 203, 25);
		contentPane.add(lblNewLabel_1);

		txtDate = new JTextField();
		txtDate.setForeground(new Color(245, 245, 245));
		txtDate.setBackground(new Color(245, 245, 245));
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDate.setBounds(259, 137, 200, 38);
		contentPane.add(txtDate);
		txtDate.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setForeground(new Color(178, 34, 34));
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(579, 135, 107, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(47, 202, 74, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Debit Card Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(179, 202, 133, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Debit Card Holder SSN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(391, 202, 168, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(616, 202, 74, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setBackground(new Color(245, 245, 245));
		textID.setFont(new Font("Tahoma", Font.BOLD, 11));
		textID.setBounds(34, 251, 113, 38);
		contentPane.add(textID);
		textID.setColumns(10);

		textDebitCardNumber = new JTextField();
		textDebitCardNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDebitCardNumber.setBackground(new Color(245, 245, 245));
		textDebitCardNumber.setBounds(157, 251, 189, 38);
		contentPane.add(textDebitCardNumber);
		textDebitCardNumber.setColumns(10);

		textDCHSSN = new JTextField();
		textDCHSSN.setBackground(new Color(245, 245, 245));
		textDCHSSN.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDCHSSN.setBounds(373, 251, 200, 38);
		contentPane.add(textDCHSSN);
		textDCHSSN.setColumns(10);

		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAmount.setBackground(new Color(245, 245, 245));
		textAmount.setBounds(599, 251, 133, 38);
		contentPane.add(textAmount);
		textAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FraudAlertFrame fd = new FraudAlertFrame();
				fd.toBack();
				setVisible(false);
				fd.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(76, 505, 189, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageAccount ndmg = new ManageAccount();
				ndmg.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(513, 505, 189, 38);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_6.setBounds(91, 48, 74, 68);
		contentPane.add(lblNewLabel_6);
	}

}
