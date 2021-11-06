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

public class CreateAccountFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtZip;
	private JTextField txtEID;
	private JTextField txtID;
	private JTextField txtSSN;
	private JTextField txtPhone;
	//private JTextField txtACN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountFrame frame = new CreateAccountFrame();
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
	public CreateAccountFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create Customer Profile");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setBackground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(303, 41, 340, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 144, 136, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(445, 144, 101, 29);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(33, 276, 75, 29);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("ZIP Code");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(33, 333, 89, 29);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Employee ID");
		lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(33, 472, 124, 29);
		contentPane.add(lblNewLabel_1_4);

		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(245, 245, 245));
		txtFirstName.setForeground(new Color(245, 245, 245));
		txtFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFirstName.setBounds(246, 149, 177, 38);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBackground(new Color(245, 245, 245));
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastName.setColumns(10);
		txtLastName.setBounds(571, 149, 177, 38);
		contentPane.add(txtLastName);

		txtAddress = new JTextField();
		txtAddress.setBackground(new Color(245, 245, 245));
		txtAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAddress.setColumns(10);
		txtAddress.setBounds(246, 281, 283, 38);
		contentPane.add(txtAddress);

		txtZip = new JTextField();
		txtZip.setBackground(new Color(245, 245, 245));
		txtZip.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtZip.setColumns(10);
		txtZip.setBounds(246, 330, 283, 38);
		contentPane.add(txtZip);

		txtEID = new JTextField();
		txtEID.setBackground(new Color(245, 245, 245));
		txtEID.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEID.setColumns(10);
		txtEID.setBounds(246, 477, 283, 38);
		contentPane.add(txtEID);

		JLabel lblNewLabel_1_4_1 = new JLabel("ID number");
		lblNewLabel_1_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBounds(444, 206, 102, 29);
		contentPane.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_4_2 = new JLabel("Social Security Number");
		lblNewLabel_1_4_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_2.setBounds(33, 206, 201, 29);
		contentPane.add(lblNewLabel_1_4_2);

		JLabel lblNewLabel_1_4_3 = new JLabel("Phone Number");
		lblNewLabel_1_4_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_3.setBounds(33, 386, 136, 29);
		contentPane.add(lblNewLabel_1_4_3);

		txtID = new JTextField();
		txtID.setBackground(new Color(245, 245, 245));
		txtID.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtID.setColumns(10);
		txtID.setBounds(571, 211, 177, 38);
		contentPane.add(txtID);

		txtSSN = new JTextField();
		txtSSN.setBackground(new Color(245, 245, 245));
		txtSSN.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSSN.setColumns(10);
		txtSSN.setBounds(246, 210, 177, 39);
		contentPane.add(txtSSN);

		txtPhone = new JTextField();
		txtPhone.setBackground(new Color(245, 245, 245));
		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPhone.setColumns(10);
		txtPhone.setBounds(246, 391, 283, 38);
		contentPane.add(txtPhone);
		
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

					String SSN = txtSSN.getText();
					String ID = txtID.getText();
					//String AC = txtACN.getText();
					String First_Name = txtFirstName.getText();
					String Last_Name = txtLastName.getText();
					String Address = txtAddress.getText();
					String Zip = txtZip.getText();
					String PhoneNum = txtPhone.getText();
					String EID = txtEID.getText();

					// connecting with the sql server
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://localhost:1433;database=BANK_DATABASE;integratedSecurity=true;");
					// insert new customers into database
					insert = con.prepareStatement(
							"INSERT INTO CUSTOMERS( CUSTOMER_SSN, CUSTOMER_ID, CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, CUSTOMER_ADDRESS,CUSTOMER_ZIP_CODE,CUSTOMER_PHONE_NUMBER, BANKER_EMPLOYEE_ID)  VALUES(?,?,?,?,?,?,?,? )");

					insert.setString(1, SSN);
					insert.setString(2, ID);
					
					insert.setString(3, First_Name);
					insert.setString(4, Last_Name);
					insert.setString(5, Address);
					insert.setString(6, Zip);
					insert.setString(7, PhoneNum);
					insert.setString(8, EID);
					//insert.setString(9, AC);
					insert.executeUpdate();
					JOptionPane.showMessageDialog(null, "Customer Added");

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
		lblNewLabel_3.setBounds(18, 432, 151, 29);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
