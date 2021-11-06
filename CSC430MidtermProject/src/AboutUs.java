import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 204, 204));
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("About Us");
		lblNewLabel.setBackground(new Color(220, 220, 220));
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(224, 51, 418, 47);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_1.setBounds(60, 48, 72, 72);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mission Statement");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(40, 188, 206, 38);
		contentPane.add(lblNewLabel_2);

		JTextArea txtrIntroducingBankingWith = new JTextArea();
		txtrIntroducingBankingWith.setBackground(new Color(220, 220, 220));
		txtrIntroducingBankingWith.setForeground(new Color(0, 0, 0));
		txtrIntroducingBankingWith.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		txtrIntroducingBankingWith.setText(
				"Introducing banking with utmost security!\r\nServed by the very best, to the best\r\nPlease reach out to us for any \r\nassistance...");
		txtrIntroducingBankingWith.setBounds(40, 255, 454, 142);
		contentPane.add(txtrIntroducingBankingWith);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MidtermProject md = new MidtermProject();
				md.toBack();
				setVisible(false);
				md.toFront();
				new MidtermProject().setState(java.awt.Frame.NORMAL);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(310, 525, 190, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\piggy-bank-icon.png"));
		lblNewLabel_3.setBounds(502, 188, 245, 227);
		contentPane.add(lblNewLabel_3);
	}
}
