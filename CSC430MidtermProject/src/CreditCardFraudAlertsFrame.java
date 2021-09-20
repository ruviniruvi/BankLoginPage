import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CreditCardFraudAlertsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textcreditcard_number;
	private JTextField textCredit_amount;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCardFraudAlertsFrame frame = new CreditCardFraudAlertsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;
	private JTextField textCSSN;

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
	public CreditCardFraudAlertsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Credit Card Fraud  Alerts");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setBackground(new Color(245, 245, 245));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(230, 28, 395, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(46, 206, 68, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Credit Card Number");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(177, 206, 165, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Credit Card Holder SSN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(385, 199, 172, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(627, 206, 78, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setBackground(new Color(255, 250, 250));
		textID.setFont(new Font("Tahoma", Font.BOLD, 11));
		textID.setBounds(27, 247, 133, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textcreditcard_number = new JTextField();
		textcreditcard_number.setFont(new Font("Tahoma", Font.BOLD, 11));
		textcreditcard_number.setBounds(170, 247, 214, 20);
		contentPane.add(textcreditcard_number);
		textcreditcard_number.setColumns(10);

		textCredit_amount = new JTextField();
		textCredit_amount.setBackground(new Color(255, 250, 250));
		textCredit_amount.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCredit_amount.setBounds(600, 247, 133, 20);
		contentPane.add(textCredit_amount);
		textCredit_amount.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Please Enter the Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(29, 149, 204, 20);
		contentPane.add(lblNewLabel_6);

		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDate.setBackground(new Color(255, 250, 250));
		txtDate.setBounds(269, 147, 204, 28);
		contentPane.add(txtDate);
		txtDate.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String date = txtDate.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT CREDIT_FRAUD_ID ,CREDIT_CARD_NUMBER, CUSTOMER_SSN  ,TRANSACTION_AMOUNT FROM CREDITCARDS_FRAUD_ALERTS WHERE TRANSACTION_DATE = ?");
					insert.setString(1, date);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String userID = rs.getString(1);
						String userIDcreditCNo = rs.getString(2);
						String SSN = rs.getString(3);
						String amount = rs.getString(4);

						textID.setText(userID.trim());
						textcreditcard_number.setText(userIDcreditCNo.trim());
						textCSSN.setText(SSN.trim());
						textCredit_amount.setText(amount.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect date format. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(573, 147, 110, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
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
		btnNewButton_1.setBounds(92, 478, 190, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ManageAccount nmg = new ManageAccount();
				nmg.setVisible(true);
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(534, 486, 185, 38);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_4.setBounds(71, 42, 78, 66);
		contentPane.add(lblNewLabel_4);

		textCSSN = new JTextField();
		textCSSN.setBackground(new Color(255, 250, 250));
		textCSSN.setFont(new Font("Tahoma", Font.BOLD, 11));
		textCSSN.setBounds(405, 247, 165, 20);
		contentPane.add(textCSSN);
		textCSSN.setColumns(10);
	}
}
