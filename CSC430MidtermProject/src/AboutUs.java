import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

//About us page

public class AboutUs {

	private JFrame frame;

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

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the application.
	 */
	public AboutUs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 102));
		frame.setBounds(100, 100, 574, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ABOUT US");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 24));
		lblNewLabel.setBounds(218, 39, 115, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/bank-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(136, 50, 55, 32);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/piggy-bank-icon.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(326, 72, 218, 228);
		frame.getContentPane().add(lblNewLabel_2);

		JTextArea txtrUsBankIs = new JTextArea();
		txtrUsBankIs.setBackground(new Color(255, 51, 102));
		txtrUsBankIs.setText("Introducing banking with utmost security!");
		txtrUsBankIs.setBounds(12, 172, 332, 22);
		frame.getContentPane().add(txtrUsBankIs);

		JLabel lblNewLabel_3 = new JLabel("Mission Statement");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(149, 116, 205, 37);
		frame.getContentPane().add(lblNewLabel_3);

		JTextArea txtrAndOurEmployees = new JTextArea();
		txtrAndOurEmployees.setBackground(new Color(255, 51, 102));
		txtrAndOurEmployees.setText("Served by the very best");
		txtrAndOurEmployees.setBounds(12, 207, 194, 22);
		frame.getContentPane().add(txtrAndOurEmployees);

		JTextArea txtrUseTheLink = new JTextArea();
		txtrUseTheLink.setBackground(new Color(255, 51, 102));
		txtrUseTheLink.setText("Please reach out to us for any assistance...");
		txtrUseTheLink.setBounds(12, 238, 363, 43);
		frame.getContentPane().add(txtrUseTheLink);

	}
}
