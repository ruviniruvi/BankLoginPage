import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AccountFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtACN;
	private JTextField txtEID;
	private JTextField txtSSN;
	private JTextField txtCat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountFrame frame = new AccountFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement insert;
	//private JTextField txtACN;

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

	/**
	 * Create the frame.
	 */
	public AccountFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create  Account");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(303, 41, 340, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Account Number");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(33, 276, 175, 29);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_4 = new JLabel("Employee ID");
		lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(33, 472, 124, 29);
		contentPane.add(lblNewLabel_1_4);

		txtACN = new JTextField();
		txtACN.setBackground(new Color(255, 245, 238));
		txtACN.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtACN.setColumns(10);
		txtACN.setBounds(246, 281, 283, 38);
		contentPane.add(txtACN);

		txtEID = new JTextField();
		txtEID.setBackground(new Color(255, 245, 238));
		txtEID.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEID.setColumns(10);
		txtEID.setBounds(246, 477, 283, 38);
		contentPane.add(txtEID);

		JLabel lblNewLabel_1_4_2 = new JLabel("Social Security Number");
		lblNewLabel_1_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_2.setBounds(33, 206, 201, 29);
		contentPane.add(lblNewLabel_1_4_2);

		JLabel lblNewLabel_1_4_3 = new JLabel("Current Balance");
		lblNewLabel_1_4_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_3.setBounds(33, 371, 136, 29);
		contentPane.add(lblNewLabel_1_4_3);

		txtSSN = new JTextField();
		txtSSN.setBackground(new Color(255, 245, 238));
		txtSSN.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSSN.setColumns(10);
		txtSSN.setBounds(246, 210, 283, 38);
		contentPane.add(txtSSN);

		txtCat = new JTextField();
		txtCat.setBackground(new Color(255, 245, 238));
		txtCat.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCat.setColumns(10);
		txtCat.setBounds(246, 376, 283, 38);
		contentPane.add(txtCat);
		
//		txtACN = new JTextField();
//		txtACN.setBounds(246, 243, 177, 20);
//		contentPane.add(txtACN);
//		txtACN.setColumns(10);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { // insert the new data into the customer table

					
					
					String acountNo = txtACN.getText();
					//String depositAmount = textAmount.getText();
					String curBl = txtCat.getText();
					String SSN = txtSSN.getText();
					String EID = txtEID.getText();

					// connecting with the sql server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
					// insert new customers into database
					insert = con.prepareStatement(
							"INSERT INTO ACCOUNTS(  CUSTOMER_SSN,  ACCOUNT_NUMBER,CURRENT_BALANCE, BANKER_EMPLOYEE_ID)  VALUES(?,?,?,? )");

					
					
					insert.setString(2, acountNo);
					insert.setString(3, curBl);
					insert.setString(1, SSN);
					
					insert.setString(4, EID);
					
					insert.executeUpdate();
					JOptionPane.showMessageDialog(null, "Account number created.");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(520, 542, 189, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(138, 30, 70, 63);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministrationFrame ad = new AdministrationFrame();
				ad.toBack();
				setVisible(false);
				ad.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(103, 542, 189, 38);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("For Employees :");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(33, 432, 136, 29);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
