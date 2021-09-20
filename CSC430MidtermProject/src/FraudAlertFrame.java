import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FraudAlertFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FraudAlertFrame frame = new FraudAlertFrame();
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
	public FraudAlertFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Fraud Alerts");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(286, 45, 226, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_1.setBounds(39, 34, 74, 72);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Credit Card Fraud Alerts");
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// link to the Credit Card Fraud Alerts page
				CreditCardFraudAlertsFrame cr = new CreditCardFraudAlertsFrame();
				cr.setVisible(true);

				cr.toBack();
				cr.setVisible(true);
				cr.toFront();

			}
		});
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(66, 200, 250, 72);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Debit Card Fraud Alerts");
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DebitCardFraudAlertFrame db = new DebitCardFraudAlertFrame();
				db.setVisible(true);

				db.toBack();
				db.setVisible(true);
				db.toFront();

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(456, 201, 250, 71);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdministrationFrame ad = new AdministrationFrame();
				ad.toBack();
				setVisible(false);
				ad.toFront();
				new AdministrationFrame().setState(java.awt.Frame.NORMAL);

			}
		});
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(300, 451, 191, 39);
		contentPane.add(btnNewButton_2);
	}

}
