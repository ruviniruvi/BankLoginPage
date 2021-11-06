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
import javax.swing.*;

public class ManageAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAccount frame = new ManageAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;
	private JTextField txtSSN;
	private JTextField txtCardNum;
	private JTextField txtCreditLimit;
	private JTextField txtExpDate;

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
	public ManageAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(279, 37, 329, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please select the card type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 159, 226, 29);
		contentPane.add(lblNewLabel_1);

		JComboBox cmbCardType = new JComboBox();
		cmbCardType.setForeground(new Color(0, 0, 0));
		cmbCardType.setBackground(new Color(245, 245, 245));
		cmbCardType.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbCardType.addItem("Credit Card");
		cmbCardType.addItem("Debit Card");
		cmbCardType.setSelectedItem(null);
		cmbCardType.setToolTipText("");
		cmbCardType.setBounds(304, 164, 174, 39);
		contentPane.add(cmbCardType);

		JLabel lblNewLabel_2 = new JLabel("Card Number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(25, 307, 197, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Credit Limit (if CC)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(25, 391, 214, 29);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Social Security Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(25, 235, 226, 16);
		contentPane.add(lblNewLabel_4);

		txtSSN = new JTextField();
		txtSSN.setBackground(new Color(245, 245, 245));
		txtSSN.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSSN.setBounds(304, 232, 174, 39);
		contentPane.add(txtSSN);
		txtSSN.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String SSN = txtSSN.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT CREDIT_CARD_NUMBER, CREDIT_LIMIT , EXPIRE_DATE FROM CREDITCARDS WHERE CUSTOMER_SSN = ?");
					insert.setString(1, SSN);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String CardNumber = rs.getString(1);
						String CreditLimit = rs.getString(2);
						String ExpireDate = rs.getString(3);

						txtCardNum.setText(CardNumber.trim());
						txtCreditLimit.setText(CreditLimit.trim());
						txtExpDate.setText(ExpireDate.trim());

					} else
						JOptionPane.showMessageDialog(null, " SSN not found! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}

			}

		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(590, 237, 147, 39);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_5 = new JLabel("Expiration Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(25, 458, 214, 19);
		contentPane.add(lblNewLabel_5);

		txtCardNum = new JTextField();
		txtCardNum.setBackground(new Color(245, 245, 245));
		txtCardNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCardNum.setBounds(304, 304, 174, 39);
		contentPane.add(txtCardNum);
		txtCardNum.setColumns(10);

		txtCreditLimit = new JTextField();
		txtCreditLimit.setBackground(new Color(245, 245, 245));
		txtCreditLimit.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCreditLimit.setBounds(304, 388, 174, 39);
		contentPane.add(txtCreditLimit);
		txtCreditLimit.setColumns(10);

		txtExpDate = new JTextField();
		txtExpDate.setBackground(new Color(245, 245, 245));
		txtExpDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtExpDate.setBounds(304, 455, 174, 39);
		contentPane.add(txtExpDate);
		txtExpDate.setColumns(10);

		JButton btnNewButton_1 = new JButton("Put on Hold");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HoldAccount ha = new HoldAccount();
				ha.setVisible(true);

				ha.toBack();
				ha.setVisible(true);
				ha.toFront();

			}
		});
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(590, 458, 146, 39);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_6 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		lblNewLabel_6.setBounds(87, 37, 77, 64);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministrationFrame ad = new AdministrationFrame();
				ad.toBack();
				setVisible(false);
				ad.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.setBounds(304, 532, 188, 39);
		contentPane.add(btnNewButton_2);
	}
}