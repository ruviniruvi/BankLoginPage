import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CreateAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(54, 11, 321, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account Number");
		lblNewLabel_1.setBounds(54, 55, 171, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Account catagory");
		lblNewLabel_2.setBounds(54, 90, 171, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Current Balance");
		lblNewLabel_3.setBounds(54, 115, 171, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Opening Date");
		lblNewLabel_4.setBounds(54, 150, 171, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Customer Social Security Number");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(54, 180, 171, 30);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Banker Employee ID");
		lblNewLabel_6.setBounds(54, 221, 171, 14);
		contentPane.add(lblNewLabel_6);
	}
}
