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

	/**
	 * 
	 */
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
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Administration");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 23, 252, 50);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(23, 96, 181, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Manage Account");
		btnNewButton_1.setBackground(new Color(220, 220, 220));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(23, 144, 181, 29);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Transactions");
		btnNewButton_2.setBackground(new Color(220, 220, 220));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(23, 198, 181, 29);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Deposites");
		btnNewButton_3.setBackground(new Color(220, 220, 220));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(336, 96, 167, 29);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Fraud Alerts");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FraudAlertFrame fd = new FraudAlertFrame();
				fd.setVisible(true);

			}
		});
		btnNewButton_4.setBackground(new Color(220, 220, 220));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(336, 144, 167, 29);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Customer Contacts");
		btnNewButton_5.setBackground(new Color(220, 220, 220));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setBounds(336, 198, 167, 29);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setBackground(new Color(220, 220, 220));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_6.setBounds(231, 292, 89, 23);
		contentPane.add(btnNewButton_6);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_1.setBounds(68, 25, 65, 50);
		contentPane.add(lblNewLabel_1);
	}
}
