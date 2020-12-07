import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField forgotPassTcText;
	private JTextField forgotPassEmailPhoneNumberText;
	private JTextField forgotPassEmailText;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				App app = new App();
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		panel.setLayout(null);
		
		forgotPassTcText = new JTextField();
		forgotPassTcText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassTcText.setBounds(222, 164, 221, 20);
		panel.add(forgotPassTcText);
		forgotPassTcText.setColumns(10);
		
		JLabel forgotPassTcLabel = new JLabel("T.C. Kimlik Numarasý :");
		forgotPassTcLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassTcLabel.setBounds(84, 167, 128, 14);
		panel.add(forgotPassTcLabel);
		
		forgotPassEmailPhoneNumberText = new JTextField();
		forgotPassEmailPhoneNumberText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassEmailPhoneNumberText.setColumns(10);
		forgotPassEmailPhoneNumberText.setBounds(222, 195, 221, 20);
		panel.add(forgotPassEmailPhoneNumberText);
		
		forgotPassEmailText = new JTextField();
		forgotPassEmailText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassEmailText.setColumns(10);
		forgotPassEmailText.setBounds(222, 226, 221, 20);
		panel.add(forgotPassEmailText);
		
		JLabel forgotPassPhoneNumberlLabel = new JLabel("Telefon Numarasý :");
		forgotPassPhoneNumberlLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassPhoneNumberlLabel.setBounds(102, 198, 110, 14);
		panel.add(forgotPassPhoneNumberlLabel);
		
		JLabel forgotPassEmailLabel = new JLabel("Email :");
		forgotPassEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		forgotPassEmailLabel.setBounds(173, 229, 236, 14);
		panel.add(forgotPassEmailLabel);
		
		btnNewButton = new JButton("Þifre Bul");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AuthPersonal authPersonalPass = new AuthPersonal();
				String findPassword = authPersonalPass.findPersonalForgotPassword(forgotPassTcText.getText(), forgotPassEmailText.getText(), forgotPassEmailPhoneNumberText.getText());
				
				if(findPassword.length()<1) {
					JOptionPane.showMessageDialog(ForgotPassword.this, "Bu bilgilere ait kayýt bulunamadý.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(ForgotPassword.this, "Þifreniz : "+ findPassword,"Önemli", JOptionPane.INFORMATION_MESSAGE);
					ForgotPassword.this.dispose();
				}
			}
		});
		btnNewButton.setBounds(222, 269, 221, 23);
		panel.add(btnNewButton);
	}
}
