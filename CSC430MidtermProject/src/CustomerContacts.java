import java.awt.EventQueue;
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

public class CustomerContacts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField textZip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerContacts frame = new CustomerContacts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert, update;

	private JTextField texLN;

	private JTextField textAdr;
	private JTextField textCFN;

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

	public CustomerContacts() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer Contacts");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(217, 45, 408, 32);

		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Enter Customer ID Number");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 174, 226, 24);
		contentPane.add(lblNewLabel_1);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtID.setBackground(new Color(248, 248, 255));
		txtID.setBounds(300, 178, 192, 24);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				// This serch customer id
				try {

					String ID = txtID.getText();

					// Connect java code with the SQL server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");

					insert = con.prepareStatement(
							"SELECT CUSTOMER_FIRST_NAME,CUSTOMER_LAST_NAME, CUSTOMER_ADDRESS, CUSTOMER_ZIP_CODE FROM  CUSTOMERS WHERE CUSTOMER_ID = ?");
					insert.setString(1, ID);
					ResultSet rs = insert.executeQuery();

					if (rs.next()) {

						String firstname = rs.getString(1);
						String lastname = rs.getString(2);
						String address = rs.getString(3);
						String zipcode = rs.getString(4);

						textCFN.setText(firstname.trim());
						texLN.setText(lastname.trim());
						textAdr.setText(address.trim());
						textZip.setText(zipcode.trim());

					} else
						JOptionPane.showMessageDialog(null, " Incorrect customer ID number. Please try again! .");
					con.close();
				} catch (Exception e1) {
					System.out.print(e);
				}
			}
		});

		JLabel lblSecondName = new JLabel("Customer Last Name");
		lblSecondName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSecondName.setBounds(53, 308, 200, 24);
		contentPane.add(lblSecondName);

		JLabel lblNewLabel_2 = new JLabel("Zip Code");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(53, 440, 200, 24);
		contentPane.add(lblNewLabel_2);

		btnNewButton.setBounds(521, 176, 104, 24);
		contentPane.add(btnNewButton);

		textZip = new JTextField();
		textZip.setFont(new Font("Tahoma", Font.BOLD, 11));
		textZip.setBackground(new Color(248, 248, 255));
		textZip.setBounds(300, 444, 192, 24);
		contentPane.add(textZip);
		textZip.setColumns(10);

		texLN = new JTextField();
		texLN.setFont(new Font("Tahoma", Font.BOLD, 11));
		texLN.setBackground(new Color(248, 248, 255));
		texLN.setBounds(300, 312, 189, 24);
		contentPane.add(texLN);
		texLN.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(53, 378, 199, 19);
		contentPane.add(lblNewLabel_5);

		textAdr = new JTextField();
		textAdr.setBackground(new Color(248, 248, 255));
		textAdr.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAdr.setBounds(300, 379, 325, 24);
		contentPane.add(textAdr);
		textAdr.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Customer First Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(53, 258, 199, 14);
		contentPane.add(lblNewLabel_6);

		textCFN = new JTextField();
		textCFN.setBackground(new Color(248, 248, 255));
		textCFN.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCFN.setBounds(300, 256, 189, 24);
		contentPane.add(textCFN);
		textCFN.setColumns(10);

		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
			}
		});
		btnNewButton_3.setBounds(643, 176, 104, 24);
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
		btnNewButton_4.setBounds(310, 545, 189, 38);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_3.setBounds(66, 45, 70, 65);
		contentPane.add(lblNewLabel_3);

	}
}