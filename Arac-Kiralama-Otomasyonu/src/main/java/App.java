import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class App {

	private JFrame frame;
	private JTextField tcField;
	private JPasswordField passwordField;

	Personal personal = new Personal();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);	
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Kullan\u0131c\u0131 Ad\u0131");
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 864, 45);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel logInTitleLabel = new JLabel("Personel Giriþ Sayfasý");
		logInTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		logInTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(logInTitleLabel);
		
		JButton buttonNewPersonal = new JButton("Personel Kaydý");
		buttonNewPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				PersonalRegistration personalRegistration = new PersonalRegistration();
			}
		});
		frame.setVisible(true);
		buttonNewPersonal.setBounds(467, 388, 123, 23);
		frame.getContentPane().add(buttonNewPersonal);
		
		JButton buttonForgotPassword = new JButton("Þifremi Unuttum");
		buttonForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				ForgotPassword forgotPass = new ForgotPassword();
			}
		});
		
		frame.setVisible(true);
		buttonForgotPassword.setBounds(330, 388, 134, 23);
		frame.getContentPane().add(buttonForgotPassword);
		
		JLabel tcLabel = new JLabel("T.C. Kimlik Numarasý :");
		tcLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tcLabel.setBounds(191, 250, 129, 33);
		frame.getContentPane().add(tcLabel);
		
		JLabel passwordLabel = new JLabel("Þifre :");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(284, 294, 36, 33);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(330, 294, 260, 33);
		frame.getContentPane().add(passwordField);
		
		
		tcField = new JTextField();
		tcField.setBounds(330, 250, 260, 33);
		frame.getContentPane().add(tcField);
		tcField.setColumns(10);
		
		JButton buttonLogin = new JButton("Giriþ Yap");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String tcFieldText = tcField.getText();
				String passwordFieldText = String.valueOf(passwordField.getPassword());
				
				AuthPersonal authPersonal = new AuthPersonal();
				boolean isValid = authPersonal.findPersonal(tcFieldText, passwordFieldText);
				
				if(isValid == true ) {
					JOptionPane.showMessageDialog(frame, "Giriþ Doðrulandý","Giriþ Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					MainPage mainPage = new MainPage();
					mainPage.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frame, "T.C. kimlik numarasý veya þifre yanlýþ.","Giriþ Baþarýsýz", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		buttonLogin.setBounds(330, 338, 260, 33);
		frame.getContentPane().add(buttonLogin);
		
		
	}
}
