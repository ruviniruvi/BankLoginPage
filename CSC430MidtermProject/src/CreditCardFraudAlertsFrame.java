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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CreditCardFraudAlertsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textcreditcard_number;
	private JTextField textCreditcard_holder;
	private JTextField textTransaction_date;
	private JTextField textCredit_amount;

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

	/**
	 * Create the frame.
	 */
	public CreditCardFraudAlertsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Credit Card Fraud  Alerts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(193, 31, 287, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(42, 103, 68, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Credit Card Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(120, 103, 134, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Credit Card Holder Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(264, 103, 172, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Transaction Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(446, 104, 113, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(613, 104, 78, 14);
		contentPane.add(lblNewLabel_5);

		textID = new JTextField();
		textID.setBounds(28, 137, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		textcreditcard_number = new JTextField();
		textcreditcard_number.setBounds(130, 137, 124, 20);
		contentPane.add(textcreditcard_number);
		textcreditcard_number.setColumns(10);

		textCreditcard_holder = new JTextField();
		textCreditcard_holder.setBounds(264, 137, 158, 20);
		contentPane.add(textCreditcard_holder);
		textCreditcard_holder.setColumns(10);

		textTransaction_date = new JTextField();
		textTransaction_date.setBounds(446, 137, 134, 20);
		contentPane.add(textTransaction_date);
		textTransaction_date.setColumns(10);

		textCredit_amount = new JTextField();
		textCredit_amount.setBounds(605, 137, 86, 20);
		contentPane.add(textCredit_amount);
		textCredit_amount.setColumns(10);
	}
}
