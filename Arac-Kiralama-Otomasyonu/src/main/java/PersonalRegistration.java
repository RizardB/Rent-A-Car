import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.time.Year;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField tcSignUpTextField;
	private JTextField firstNameSignUpTextField;
	private JTextField lastNameSignUpTextField;
	private JTextField textField_5;
	private JTextField phoneNumberSignUpTextField;
	private JTextField emailSignUpTextField;
	private JPasswordField signUpPasswordField;
	private JPasswordField signUpAgainPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalRegistration frame = new PersonalRegistration();
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
	public PersonalRegistration() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				App app = new App();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 964, 39);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel signUpTitleLabel = new JLabel("Personel Kayýt Sayfasý");
		signUpTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		signUpTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(signUpTitleLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 61, 452, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel tcLabel = new JLabel("T.C. Kimlik Numarasý :");
		tcLabel.setBounds(10, 50, 129, 15);
		panel_1.add(tcLabel);
		tcLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel firstNameLabel = new JLabel("Ýsim :");
		firstNameLabel.setBounds(105, 100, 33, 15);
		panel_1.add(firstNameLabel);
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lastNameLabel = new JLabel("Soyisim :");
		lastNameLabel.setBounds(84, 150, 54, 15);
		panel_1.add(lastNameLabel);
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel birthdayLabel = new JLabel("Doðum Tarihi :");
		birthdayLabel.setBounds(50, 256, 89, 15);
		panel_1.add(birthdayLabel);
		birthdayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel genderLabel = new JLabel("Cinsiyet :");
		genderLabel.setBounds(83, 381, 56, 15);
		panel_1.add(genderLabel);
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tcSignUpTextField = new JTextField();
		tcSignUpTextField.setBounds(149, 48, 205, 20);
		panel_1.add(tcSignUpTextField);
		tcSignUpTextField.setColumns(10);
		
		firstNameSignUpTextField = new JTextField();
		firstNameSignUpTextField.setColumns(10);
		firstNameSignUpTextField.setBounds(148, 98, 206, 20);
		panel_1.add(firstNameSignUpTextField);
		
		lastNameSignUpTextField = new JTextField();
		lastNameSignUpTextField.setColumns(10);
		lastNameSignUpTextField.setBounds(148, 148, 206, 20);
		panel_1.add(lastNameSignUpTextField);
		
		JCalendar birthdaySignUpCalendar = new JCalendar();
		birthdaySignUpCalendar.setBounds(148, 198, 191, 153);
		panel_1.add(birthdaySignUpCalendar);
		
		JRadioButton femaleGenderSignUpRadio = new JRadioButton("Kadýn");
		femaleGenderSignUpRadio.setBounds(151, 378, 82, 23);
		panel_1.add(femaleGenderSignUpRadio);
		
		JRadioButton maleGenderSignUpRadio = new JRadioButton("Erkek");
		maleGenderSignUpRadio.setBounds(235, 378, 65, 23);
		panel_1.add(maleGenderSignUpRadio);
		
		ButtonGroup radioGenderGroup = new ButtonGroup();
		radioGenderGroup.add(maleGenderSignUpRadio);
		radioGenderGroup.add(femaleGenderSignUpRadio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(472, 61, 502, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel phoneNumberLabel = new JLabel("Telefon Numarasý :");
		phoneNumberLabel.setBounds(10, 50, 112, 15);
		panel_2.add(phoneNumberLabel);
		phoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setBounds(83, 100, 39, 15);
		panel_2.add(emailLabel);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel addressLabel = new JLabel("Adres :");
		addressLabel.setBounds(79, 178, 43, 15);
		panel_2.add(addressLabel);
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel passwordLabel = new JLabel("Þifre :");
		passwordLabel.setBounds(86, 268, 36, 15);
		panel_2.add(passwordLabel);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel passwordAgainLabel = new JLabel("Þifre Tekrarý :");
		passwordAgainLabel.setBounds(41, 318, 81, 15);
		panel_2.add(passwordAgainLabel);
		passwordAgainLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		phoneNumberSignUpTextField = new JTextField();
		phoneNumberSignUpTextField.setText("+90");
		phoneNumberSignUpTextField.setActionCommand("");
		phoneNumberSignUpTextField.setBounds(132, 48, 216, 20);
		panel_2.add(phoneNumberSignUpTextField);
		phoneNumberSignUpTextField.setColumns(10);
		
		emailSignUpTextField = new JTextField();
		emailSignUpTextField.setBounds(132, 98, 216, 20);
		panel_2.add(emailSignUpTextField);
		emailSignUpTextField.setColumns(10);
		
		signUpPasswordField = new JPasswordField();
		signUpPasswordField.setBounds(132, 266, 216, 20);
		panel_2.add(signUpPasswordField);
		
		signUpAgainPasswordField = new JPasswordField();
		signUpAgainPasswordField.setBounds(132, 316, 216, 20);
		panel_2.add(signUpAgainPasswordField);
		
		TextArea addressrSignUpTextArea = new TextArea();
		addressrSignUpTextArea.setBounds(132, 145, 340, 88);
		panel_2.add(addressrSignUpTextArea);
		
		JButton singUpButton = new JButton("Kaydý Tamamla");
		singUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tcText = tcSignUpTextField.getText();
				String firstNameText = firstNameSignUpTextField.getText();
				String lastNameText = lastNameSignUpTextField.getText();
				java.util.Date birthdayText = birthdaySignUpCalendar.getDate();
				
				String genderText = "";
				
				String phoneNumberText = phoneNumberSignUpTextField.getText();
				String emailText = emailSignUpTextField.getText();
				String addressText = addressrSignUpTextArea.getText();
				String passwordText = String.valueOf(signUpPasswordField.getPassword());
				String againPasswordText = String.valueOf(signUpAgainPasswordField.getPassword());

				if(femaleGenderSignUpRadio.isSelected()) {
					genderText = femaleGenderSignUpRadio.getText();
				}else if (maleGenderSignUpRadio.isSelected()) {
					genderText = maleGenderSignUpRadio.getText();
				}
				
				if(tcText.length() != 11) {
					JOptionPane.showMessageDialog(PersonalRegistration.this, "T.C. kimlik numarasý 11 haneli olmalý.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidEmailAddress(emailText)) {
					JOptionPane.showMessageDialog(PersonalRegistration.this, "Email adresinizi kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidPhoneNumber(phoneNumberText)) {
					JOptionPane.showMessageDialog(PersonalRegistration.this, "Telefon Numaranýzý kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if ( !Arrays.equals(signUpPasswordField.getPassword(), signUpAgainPasswordField.getPassword())) {
					JOptionPane.showMessageDialog(PersonalRegistration.this, "Þifreleriniz Eþleþmiyor.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (genderText == "") {
						JOptionPane.showMessageDialog(PersonalRegistration.this, "Cinsiyetinizi Seçiniz","Hata", JOptionPane.INFORMATION_MESSAGE);
					}else {
						Personal personal = new Personal(tcText, passwordText, firstNameText, lastNameText, emailText, phoneNumberText, addressText, birthdayText, genderText);
						Session session = HibernateUtilPersonal.getSessionFactory().openSession();
						Transaction tx =  session.beginTransaction();
						
						AuthPersonal authPersonal = new AuthPersonal();
						boolean isAlreadyTc = authPersonal.findPersonalTc(tcText);
						boolean isAlreadyEmail = authPersonal.findPersonalEmail(emailText);
						boolean isAlreadyPhoneNumber = authPersonal.findPersonalPhoneNumber(phoneNumberText);
						
						if ( isAlreadyTc ) {
							JOptionPane.showMessageDialog(PersonalRegistration.this, "T.C. kimlik numaranýz sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						} else if ( isAlreadyEmail ) {
							JOptionPane.showMessageDialog(PersonalRegistration.this, "Email sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						} else if ( isAlreadyPhoneNumber ) {
							JOptionPane.showMessageDialog(PersonalRegistration.this, "Telefon numarasý sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						}else {
							session.save(personal);
							tx.commit();
							JOptionPane.showMessageDialog(PersonalRegistration.this, "Kayýt baþarýlý. \n Giriþ yapabilirsiniz.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
							PersonalRegistration.this.dispose();
						}
					}
				
			}
		});
		singUpButton.setBounds(360, 507, 132, 25);
		contentPane.add(singUpButton);
		
		JButton signUpLoginButton = new JButton("Giriþ Yap");
		signUpLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalRegistration.this.dispose();
			}
		});
		signUpLoginButton.setBounds(500, 507, 132, 25);
		contentPane.add(signUpLoginButton);
		
	}

	public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
	}
	
	public boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		 
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}
}
