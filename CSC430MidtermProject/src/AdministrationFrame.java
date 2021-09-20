import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrationFrame frame = new AdministrationFrame();
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
	public AdministrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Administration");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 25, 516, 50);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CreateAccountFrame crt = new CreateAccountFrame();
				crt.setVisible(true);

				crt.toBack();
				crt.setVisible(true);
				crt.toFront();

			}
		});
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(90, 128, 190, 38);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Manage Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManageAccount mg = new ManageAccount();
				mg.setVisible(true);

				mg.toBack();
				mg.setVisible(true);
				mg.toFront();

			}
		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(90, 220, 190, 38);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Transactions");
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewTransactions view = new ViewTransactions();
				view.setVisible(true);

				view.toBack();
				view.setVisible(true);
				view.toFront();

			}
		});
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(90, 333, 190, 38);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Deposits");
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// linking to the fraud alerts page
				DepositeFrame df = new DepositeFrame();
				df.setVisible(true);

				df.toBack();
				df.setVisible(true);
				df.toFront();
			}
		});
		btnNewButton_3.setBackground(new Color(245, 245, 245));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(471, 128, 190, 38);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Fraud Alerts");
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// linking to the fraud alerts page
				FraudAlertFrame fd = new FraudAlertFrame();
				fd.setVisible(true);

				fd.toBack();
				fd.setVisible(true);
				fd.toFront();
			}
		});
		btnNewButton_4.setBackground(new Color(245, 245, 245));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(471, 220, 190, 38);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Customer Contacts");
		btnNewButton_5.setForeground(new Color(220, 20, 60));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustomerContacts cus = new CustomerContacts();
				cus.setVisible(true);

				cus.toBack();
				cus.setVisible(true);
				cus.toFront();

			}
		});
		btnNewButton_5.setBackground(new Color(245, 245, 245));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(471, 333, 190, 38);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setForeground(new Color(220, 20, 60));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				MidtermProject window = new MidtermProject();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_6.setBackground(new Color(220, 220, 220));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_6.setBounds(314, 489, 190, 38);
		contentPane.add(btnNewButton_6);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_1.setBounds(90, 25, 72, 72);
		contentPane.add(lblNewLabel_1);
	}
}
