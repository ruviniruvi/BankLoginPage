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

public class HelpFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFrame frame = new HelpFrame();
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
	public HelpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Help");
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(238, 57, 309, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator.INTERGY14\\Desktop\\bank-icon.png"));
		lblNewLabel_1.setBounds(72, 50, 78, 72);
		contentPane.add(lblNewLabel_1);

		JTextArea txtrNeedSupportCant = new JTextArea();
		txtrNeedSupportCant.setBackground(new Color(220, 220, 220));
		txtrNeedSupportCant.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		txtrNeedSupportCant.setForeground(new Color(0, 0, 0));
		txtrNeedSupportCant.setText(
				"Need Support?\r\n\r\nCan't find what you are looking for? No worries, \r\nwe got your back.\r\nCheck out our FAQ and if you are still troubled\r\nContact us:   \tITCompany@help.com\r\n\t\tor call our support line\r\n\t\t(888)-456-1200");
		txtrNeedSupportCant.setBounds(57, 195, 593, 190);
		contentPane.add(txtrNeedSupportCant);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 228, 225));
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
		btnNewButton.setBounds(299, 482, 189, 38);
		contentPane.add(btnNewButton);
	}

}
