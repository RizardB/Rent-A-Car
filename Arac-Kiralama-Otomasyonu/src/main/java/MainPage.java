import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JCalendar;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import java.awt.FlowLayout;

public class MainPage extends JFrame {

	private JPanel rootPane;
	private JTextField addCustomerTcText;
	private JTextField addCustomerLastNameText;
	private JTextField addCustomerJobText;
	private JTextField addCustomerFirstNameText;
	private JTextField addCustomerPhoneNumberText;
	private JTextField addCustomerEmailText;
	private JTextField addCustomerLicenceText;
	private JTextField addCustomerLicenceNoText;
	private JTable listCustomerTable;
	private JTextField listCustomerTextFieldTc;
	private JTextField listCustomerTextFieldFirstName;
	private JTextField listCustomerTextFieldLastName;
	private JTextField listCustomerTextFieldBirthDate;
	private JTextField listCustomerTextFieldGender;
	private JTextField listCustomerTextFieldPhoneNumber;
	private JTextField listCustomerTextFieldEmail;
	private JTextField listCustomerTextFieldJob;
	private JTextField listCustomerTextFieldLicence;
	private JTextField listCustomerTextFieldLicenceNo;
	private JTextField searchTcTextField;
	private JTextField searchEmailTextField;
	private JTextField searchNameTextField;
	private JTable listCarsTable;
	private JTextField carPlateTextField;
	private JTextField carBrandTextField;
	private JTextField carModelTextField;
	private JTextField carYearTextField;
	private JTextField carFuelTextField;
	private JTextField carEngineTextField;
	private JTextField carTractionTextField;
	private JTextField carDoorTextField;
	private JTextField carColorTextField;
	private JTextField carKmTextField;
	private JTextField searchPlateTextField;
	private JTextField searchBrandTextField;
	private JTextField searchModelTextField;
	private JTextField carGearTextField;
	private JTextField carBodyTextField;
	private JTextField carDamageStatusTextField;
	private JTextField addCarPlateTextField;
	private JTextField addCarBrandTextField;
	private JTextField addCarModelTextField;
	private JTextField addCarYearTextField;
	private JTextField addCarGearTextField;
	private JTextField addCarFuelTextField;
	private JTextField addCarEngineTextField;
	private JTextField addCarDoorTextField;
	private JTextField addCarColorTextField;
	private JTextField addCarKmTextField;
	private JTextField addCarDamageStatusTextField;
	private JTextField addCarTractionTextField;
	private JTextField addCarBodyTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu CustomerMenu = new JMenu("Müþteri Ýþlemleri");
		menuBar.add(CustomerMenu);
		
		JMenu CarMenu = new JMenu("Araç Ýþlemleri");
		menuBar.add(CarMenu);
		
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setBackground(Color.lightGray);
		rootPane.setLayout(null);
		
		ImageIcon backgroundPicture = new ImageIcon(MainPage.class.getResource("rentacar.png"));

		JPanel listCarPanel = new JPanel();
		listCarPanel.setBounds(10, 11, 964, 518);
		rootPane.add(listCarPanel);
		listCarPanel.setLayout(null);
		
		JPanel addCustomerPanel = new JPanel();
		addCustomerPanel.setBounds(10, 11, 964, 518);
		rootPane.add(addCustomerPanel);
		addCustomerPanel.setLayout(null);
		
		Panel listCustomerPanel = new Panel();
		listCustomerPanel.setBounds(10, 11, 964, 518);
		rootPane.add(listCustomerPanel);
		listCustomerPanel.setLayout(null);
		
		Panel listCustomers = new Panel();
		listCustomers.setBounds(10, 314, 944, 195);
		listCustomerPanel.add(listCustomers);
		listCustomers.setLayout(null);
		
		JPanel rentCarPanel = new JPanel();
		rentCarPanel.setBounds(10, 11, 964, 518);
		rootPane.add(rentCarPanel);
		rentCarPanel.setLayout(null);
		
		listCustomerTable = new JTable();
		listCustomerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCustomerTable.setBounds(10, 11, 924, 173);
		//listCustomerTable.change
		listCustomers.add(listCustomerTable);
		
		JScrollPane listCustomerScrollPane = new JScrollPane();
		listCustomerScrollPane.setBounds(10, 10, 924, 174);
		listCustomers.add(listCustomerScrollPane);
		
		JPanel listCustomerShowTextPanel = new JPanel();
		listCustomerShowTextPanel.setBounds(75, 11, 800, 263);
		listCustomerPanel.add(listCustomerShowTextPanel);
		listCustomerShowTextPanel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("T.C. Kimlik Numarasý :");
		lblNewLabel_12.setBounds(10, 11, 128, 14);
		listCustomerShowTextPanel.add(lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_13 = new JLabel("Ad :");
		lblNewLabel_13.setBounds(114, 36, 24, 14);
		listCustomerShowTextPanel.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_14 = new JLabel("Soyad :");
		lblNewLabel_14.setBounds(94, 61, 44, 14);
		listCustomerShowTextPanel.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_15 = new JLabel("Email :");
		lblNewLabel_15.setBounds(527, 36, 40, 14);
		listCustomerShowTextPanel.add(lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_16 = new JLabel("Telefon Numarasý :");
		lblNewLabel_16.setBounds(457, 11, 110, 14);
		listCustomerShowTextPanel.add(lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_17 = new JLabel("Doðum Tarihi :");
		lblNewLabel_17.setBounds(52, 86, 86, 14);
		listCustomerShowTextPanel.add(lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_18 = new JLabel("Cinsiyet :");
		lblNewLabel_18.setBounds(85, 111, 53, 14);
		listCustomerShowTextPanel.add(lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_19 = new JLabel("Meslek :");
		lblNewLabel_19.setBounds(519, 61, 48, 14);
		listCustomerShowTextPanel.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_20 = new JLabel("Ehliyet Türü :");
		lblNewLabel_20.setBounds(490, 86, 77, 14);
		listCustomerShowTextPanel.add(lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_21 = new JLabel("Ehliyet Numarasý :");
		lblNewLabel_21.setBounds(463, 111, 104, 14);
		listCustomerShowTextPanel.add(lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		listCustomerTextFieldTc = new JTextField();
		listCustomerTextFieldTc.setBounds(148, 11, 217, 18);
		listCustomerShowTextPanel.add(listCustomerTextFieldTc);
		listCustomerTextFieldTc.setColumns(10);
		
		listCustomerTextFieldFirstName = new JTextField();
		listCustomerTextFieldFirstName.setBounds(148, 36, 217, 18);
		listCustomerShowTextPanel.add(listCustomerTextFieldFirstName);
		listCustomerTextFieldFirstName.setColumns(10);
		
		listCustomerTextFieldLastName = new JTextField();
		listCustomerTextFieldLastName.setBounds(148, 59, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldLastName);
		listCustomerTextFieldLastName.setColumns(10);
		
		listCustomerTextFieldBirthDate = new JTextField();
		listCustomerTextFieldBirthDate.setBounds(148, 84, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldBirthDate);
		listCustomerTextFieldBirthDate.setColumns(10);
		listCustomerTextFieldBirthDate.setEditable(false);
		
		listCustomerTextFieldGender = new JTextField();
		listCustomerTextFieldGender.setBounds(148, 111, 217, 18);
		listCustomerShowTextPanel.add(listCustomerTextFieldGender);
		listCustomerTextFieldGender.setColumns(10);
		
		listCustomerTextFieldPhoneNumber = new JTextField();
		listCustomerTextFieldPhoneNumber.setBounds(577, 11, 217, 18);
		listCustomerShowTextPanel.add(listCustomerTextFieldPhoneNumber);
		listCustomerTextFieldPhoneNumber.setColumns(10);
		
		listCustomerTextFieldEmail = new JTextField();
		listCustomerTextFieldEmail.setBounds(577, 34, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldEmail);
		listCustomerTextFieldEmail.setColumns(10);
		
		listCustomerTextFieldJob = new JTextField();
		listCustomerTextFieldJob.setBounds(577, 59, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldJob);
		listCustomerTextFieldJob.setColumns(10);
		
		listCustomerTextFieldLicence = new JTextField();
		listCustomerTextFieldLicence.setBounds(577, 84, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldLicence);
		listCustomerTextFieldLicence.setColumns(10);
		
		listCustomerTextFieldLicenceNo = new JTextField();
		listCustomerTextFieldLicenceNo.setBounds(577, 109, 217, 20);
		listCustomerShowTextPanel.add(listCustomerTextFieldLicenceNo);
		listCustomerTextFieldLicenceNo.setColumns(10);
		
		TextArea listCustomerTextAreaNotes = new TextArea();
		listCustomerTextAreaNotes.setBounds(577, 135, 217, 73);
		listCustomerShowTextPanel.add(listCustomerTextAreaNotes);
		
		JLabel noteslbl = new JLabel("Not :");
		noteslbl.setBounds(539, 165, 28, 14);
		listCustomerShowTextPanel.add(noteslbl);
		noteslbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel addresslbl = new JLabel("Adres :");
		addresslbl.setBounds(96, 165, 42, 14);
		listCustomerShowTextPanel.add(addresslbl);
		addresslbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		TextArea listCustomerTextAreaAddress = new TextArea();
		listCustomerTextAreaAddress.setBounds(148, 135, 217, 73);
		listCustomerShowTextPanel.add(listCustomerTextAreaAddress);
		
		searchTcTextField = new JTextField();
		searchTcTextField.setBounds(55, 288, 154, 20);
		listCustomerPanel.add(searchTcTextField);
		searchTcTextField.setColumns(10);
		
		searchEmailTextField = new JTextField();
		searchEmailTextField.setBounds(318, 288, 154, 20);
		listCustomerPanel.add(searchEmailTextField);
		searchEmailTextField.setColumns(10);
		
		searchNameTextField = new JTextField();
		searchNameTextField.setBounds(579, 288, 154, 20);
		listCustomerPanel.add(searchNameTextField);
		searchNameTextField.setColumns(10);
		
		JPanel addCarPanel = new JPanel();
		addCarPanel.setBounds(10, 11, 964, 518);
		rootPane.add(addCarPanel);
		addCarPanel.setLayout(null);
		
		JPanel addCarDetailsPanel = new JPanel();
		addCarDetailsPanel.setBounds(10, 11, 630, 400);
		addCarPanel.add(addCarDetailsPanel);
		addCarDetailsPanel.setLayout(null);
		
		JLabel addCarLblPlate = new JLabel("Plaka :");
		addCarLblPlate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblPlate.setBounds(50, 50, 39, 14);
		addCarDetailsPanel.add(addCarLblPlate);
		
		JLabel addCarLblBrand = new JLabel("Marka :");
		addCarLblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblBrand.setBounds(45, 100, 44, 14);
		addCarDetailsPanel.add(addCarLblBrand);
		
		JLabel addCarLblModel = new JLabel("Model :");
		addCarLblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblModel.setBounds(46, 150, 43, 14);
		addCarDetailsPanel.add(addCarLblModel);
		
		JLabel addCarLblYear = new JLabel("Y\u0131l :");
		addCarLblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblYear.setBounds(67, 200, 22, 14);
		addCarDetailsPanel.add(addCarLblYear);
		
		JLabel addCarLblGear = new JLabel("Vites :");
		addCarLblGear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblGear.setBounds(52, 250, 37, 14);
		addCarDetailsPanel.add(addCarLblGear);
		
		JLabel addCarLblFuel = new JLabel("Yakýt :");
		addCarLblFuel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblFuel.setBounds(53, 300, 36, 14);
		addCarDetailsPanel.add(addCarLblFuel);
		
		JLabel addCarLblTraction = new JLabel("Çekiþ :");
		addCarLblTraction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblTraction.setBounds(372, 252, 39, 14);
		addCarDetailsPanel.add(addCarLblTraction);
		
		JLabel addCarLblDoor = new JLabel("Kapý :");
		addCarLblDoor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblDoor.setBounds(378, 52, 33, 14);
		addCarDetailsPanel.add(addCarLblDoor);
		
		JLabel addCarLblColor = new JLabel("Renk :");
		addCarLblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblColor.setBounds(374, 102, 37, 14);
		addCarDetailsPanel.add(addCarLblColor);
		
		JLabel addCarLblKm = new JLabel("Kilometre :");
		addCarLblKm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblKm.setBounds(348, 152, 63, 14);
		addCarDetailsPanel.add(addCarLblKm);
		
		JLabel addCarLblDamageStatus = new JLabel("Hasar Durumu :");
		addCarLblDamageStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblDamageStatus.setBounds(320, 202, 91, 14);
		addCarDetailsPanel.add(addCarLblDamageStatus);
		
		JLabel addCarLblBody = new JLabel("Kasa :");
		addCarLblBody.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblBody.setBounds(375, 302, 36, 14);
		addCarDetailsPanel.add(addCarLblBody);
		
		JLabel addCarLblEngine = new JLabel("Motor :");
		addCarLblEngine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addCarLblEngine.setBounds(47, 350, 42, 14);
		addCarDetailsPanel.add(addCarLblEngine);
		
		addCustomerPanel.setVisible(false);
		listCustomerPanel.setVisible(false);
		listCarPanel.setVisible(false);
		addCarPanel.setVisible(false);
		rentCarPanel.setVisible(false);
		
		
		addCarPlateTextField = new JTextField();
		addCarPlateTextField.setBounds(99, 48, 155, 20);
		addCarDetailsPanel.add(addCarPlateTextField);
		addCarPlateTextField.setColumns(10);
		
		addCarBrandTextField = new JTextField();
		addCarBrandTextField.setColumns(10);
		addCarBrandTextField.setBounds(99, 98, 155, 20);
		addCarDetailsPanel.add(addCarBrandTextField);
		
		addCarModelTextField = new JTextField();
		addCarModelTextField.setColumns(10);
		addCarModelTextField.setBounds(99, 148, 155, 20);
		addCarDetailsPanel.add(addCarModelTextField);
		
		addCarYearTextField = new JTextField();
		addCarYearTextField.setColumns(10);
		addCarYearTextField.setBounds(99, 198, 155, 20);
		addCarDetailsPanel.add(addCarYearTextField);
		
		addCarGearTextField = new JTextField();
		addCarGearTextField.setColumns(10);
		addCarGearTextField.setBounds(99, 248, 155, 20);
		addCarDetailsPanel.add(addCarGearTextField);
		
		addCarFuelTextField = new JTextField();
		addCarFuelTextField.setColumns(10);
		addCarFuelTextField.setBounds(99, 298, 155, 20);
		addCarDetailsPanel.add(addCarFuelTextField);
		
		addCarEngineTextField = new JTextField();
		addCarEngineTextField.setColumns(10);
		addCarEngineTextField.setBounds(99, 348, 155, 20);
		addCarDetailsPanel.add(addCarEngineTextField);
		
		addCarDoorTextField = new JTextField();
		addCarDoorTextField.setColumns(10);
		addCarDoorTextField.setBounds(421, 50, 155, 20);
		addCarDetailsPanel.add(addCarDoorTextField);
		
		addCarColorTextField = new JTextField();
		addCarColorTextField.setColumns(10);
		addCarColorTextField.setBounds(421, 100, 155, 20);
		addCarDetailsPanel.add(addCarColorTextField);
		
		addCarKmTextField = new JTextField();
		addCarKmTextField.setColumns(10);
		addCarKmTextField.setBounds(421, 150, 155, 20);
		addCarDetailsPanel.add(addCarKmTextField);
		
		addCarDamageStatusTextField = new JTextField();
		addCarDamageStatusTextField.setColumns(10);
		addCarDamageStatusTextField.setBounds(421, 200, 155, 20);
		addCarDetailsPanel.add(addCarDamageStatusTextField);
		
		addCarTractionTextField = new JTextField();
		addCarTractionTextField.setColumns(10);
		addCarTractionTextField.setBounds(421, 250, 155, 20);
		addCarDetailsPanel.add(addCarTractionTextField);
		
		addCarBodyTextField = new JTextField();
		addCarBodyTextField.setColumns(10);
		addCarBodyTextField.setBounds(421, 300, 155, 20);
		addCarDetailsPanel.add(addCarBodyTextField);
		
		JLabel lblPricePerDay = new JLabel("G\u00FCnl\u00FCk Fiyat :");
		lblPricePerDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPricePerDay.setBounds(333, 350, 78, 14);
		addCarDetailsPanel.add(lblPricePerDay);
		
		addCarPricePerDayTextField = new JTextField();
		addCarPricePerDayTextField.setColumns(10);
		addCarPricePerDayTextField.setBounds(421, 348, 155, 20);
		addCarDetailsPanel.add(addCarPricePerDayTextField);
		
		JPanel addCarPicturePanel = new JPanel();
		addCarPicturePanel.setBackground(UIManager.getColor("Panel.background"));
		addCarPicturePanel.setBounds(678, 64, 250, 200);
		addCarPanel.add(addCarPicturePanel);
		addCarPicturePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton addCarChoosePictureButton = new JButton("Resim Seç");
		addCarChoosePictureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser carPictureChooser = new JFileChooser();
				carPictureChooser.showOpenDialog(null);
				File file = carPictureChooser.getSelectedFile();
				
				try {
					Image carPicture = ImageIO.read(file);
					
					ImageIcon carPictureImageIcon = new ImageIcon(carPicture);
					
					carPictureImageIcon = resizePic(carPictureImageIcon);
					
					addCarPicturePanel.removeAll();
					addCarPicturePanel.revalidate();
					addCarPicturePanel.repaint();
					
					JLabel label = new JLabel(carPictureImageIcon);
		        	
					addCarPicturePanel.add(label);
							
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				
			}
		});
		addCarChoosePictureButton.setBounds(736, 275, 143, 23);
		addCarPanel.add(addCarChoosePictureButton);
		
		JPanel addCarButtonPanel = new JPanel();
		addCarButtonPanel.setBounds(193, 422, 280, 23);
		addCarPanel.add(addCarButtonPanel);
		addCarButtonPanel.setLayout(null);
		

		
		JButton addCarClearButton = new JButton("Temizle");
		addCarClearButton.setBounds(191, 0, 89, 23);
		addCarButtonPanel.add(addCarClearButton);
		
		
		JButton addCarAddButton = new JButton("Araç Ekle");
		addCarAddButton.setBounds(0, 0, 89, 23);
		addCarButtonPanel.add(addCarAddButton);
		addCarAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Blob blob = null;
				try {
					blob = imageIcon2Blob(addCarPicturePanel);
				} catch (InterruptedException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
				
				boolean isNum = isNumeric(addCarYearTextField.getText());
				
				int pricePerDay = 0;
				
				boolean rented = false;
				
				if((!isNum) || Integer.parseInt(addCarYearTextField.getText())<1001 || Integer.parseInt(addCarYearTextField.getText())>9999 ) {
					JOptionPane.showMessageDialog(MainPage.this, "Tarihi kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if(Integer.parseInt(addCarPricePerDayTextField.getText())<1 || Integer.parseInt(addCarPricePerDayTextField.getText())>999999){
					JOptionPane.showMessageDialog(MainPage.this, "FÝyatý kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if(addCarPicturePanel.getComponentCount()<=0){
					JOptionPane.showMessageDialog(MainPage.this, "Resim Ekleyiniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
					Car car = new Car(addCarPlateTextField.getText(), addCarBrandTextField.getText(), addCarModelTextField.getText(), Integer.parseInt(addCarYearTextField.getText())
							, addCarFuelTextField.getText(), addCarGearTextField.getText(), addCarEngineTextField.getText(), addCarTractionTextField.getText()
							, addCarDoorTextField.getText(), addCarColorTextField.getText(), addCarKmTextField.getText(), addCarBodyTextField.getText(),
							addCarDamageStatusTextField.getText(), blob, rented, Integer.parseInt(addCarPricePerDayTextField.getText()));
					
					Session session = HibernateUtilCar.getSessionFactory().openSession();
						
					Transaction tx = session.beginTransaction();
						
					FindCars findCars = new FindCars();
					
					List authPlate = findCars.getCarPlate(addCarPlateTextField.getText());
					
					if ( authPlate.size()>0 ) {
						JOptionPane.showMessageDialog(MainPage.this, "Plaka sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
					}else {
						session.save(car);
						tx.commit();
						JOptionPane.showMessageDialog(MainPage.this, "Kayýt baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
					}
						
				}
							
			}
		});
		addCarClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addCarPlateTextField.setText("");
				addCarBrandTextField.setText("");
				addCarModelTextField.setText("");
				addCarYearTextField.setText("");
				addCarGearTextField.setText("");
				addCarFuelTextField.setText("");
				addCarTractionTextField.setText("");
				addCarDoorTextField.setText("");
				addCarColorTextField.setText("");
				addCarKmTextField.setText("");
				addCarDamageStatusTextField.setText("");
				addCarBodyTextField.setText("");
				addCarEngineTextField.setText("");
				
				addCarPicturePanel.removeAll();
				addCarPicturePanel.revalidate();
				addCarPicturePanel.repaint();
				
				
			}
		});
		
		JButton searchTcButton = new JButton("Tc Ara");
		searchTcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchEmailTextField.setText("");
				searchNameTextField.setText("");
				
				FindCustomers findCustomerTc = new FindCustomers();
				List searchTcCustomer = findCustomerTc.searchTcCustomerResults(searchTcTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchTcCustomer.iterator(); iterator.hasNext();i++){
					
		            Customer newCustomer = (Customer) iterator.next(); 
		            
		            
					
					String[] kolon = { "Tc Kimlik Numarasý" , "Ad" , "Soyad" , "Email" , "Telefon Numarasý" , "Adres" , "Cinsiyet" , "Meslek" , "Doðum Tarihi" , "Ehliyet Türü" , 
							"Ehliyet Numarasý" , "Not"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() ,
		            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
		            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
					
					if( i == 0 ) {
			        	listCustomerTextFieldTc.setText(newCustomer.getcustomerTc());
			        	listCustomerTextFieldFirstName.setText(newCustomer.getcustomerFirstName());
			        	listCustomerTextFieldLastName.setText(newCustomer.getcustomerLastName());
			        	listCustomerTextFieldEmail.setText(newCustomer.getcustomerEmail());
			        	listCustomerTextFieldBirthDate.setText(newCustomer.getcustomerBirthdate().toGMTString());
			        	listCustomerTextFieldPhoneNumber.setText(newCustomer.getcustomerPhoneNumber());
			        	listCustomerTextFieldGender.setText(newCustomer.getcustomerGender());
			        	listCustomerTextFieldJob.setText(newCustomer.getcustomerJob());
			        	listCustomerTextFieldLicence.setText(newCustomer.getcustomerLicence());
			        	listCustomerTextFieldLicenceNo.setText(newCustomer.getcustomerLicenceNo());
			        	listCustomerTextAreaNotes.setText(newCustomer.getcustomerNotes());
			        	listCustomerTextAreaAddress.setText(newCustomer.getcustomerAddress());
		            }
				}
				
				
				listCustomerTable.setModel(tableModel);
				listCustomerScrollPane.setViewportView(listCustomerTable);
				
				listCustomerTable.changeSelection(0, 0, false, false);
				
			}
		});
		searchTcButton.setBounds(219, 285, 89, 23);
		listCustomerPanel.add(searchTcButton);
		
		JButton searchEmailButton = new JButton("Email Ara");
		searchEmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchTcTextField.setText("");
				searchNameTextField.setText("");
				
				FindCustomers findCustomerTc = new FindCustomers();
				List searchTcCustomer = findCustomerTc.searchEmailCustomerResults(searchEmailTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchTcCustomer.iterator(); iterator.hasNext();i++){
					
		            Customer newCustomer = (Customer) iterator.next(); 
		            
		            
					
					String[] kolon = { "Tc Kimlik Numarasý" , "Ad" , "Soyad" , "Email" , "Telefon Numarasý" , "Adres" , "Cinsiyet" , "Meslek" , "Doðum Tarihi" , "Ehliyet Türü" , 
							"Ehliyet Numarasý" , "Not"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() ,
		            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
		            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
					
					if( i == 0 ) {
			        	listCustomerTextFieldTc.setText(newCustomer.getcustomerTc());
			        	listCustomerTextFieldFirstName.setText(newCustomer.getcustomerFirstName());
			        	listCustomerTextFieldLastName.setText(newCustomer.getcustomerLastName());
			        	listCustomerTextFieldEmail.setText(newCustomer.getcustomerEmail());
			        	listCustomerTextFieldBirthDate.setText(newCustomer.getcustomerBirthdate().toGMTString());
			        	listCustomerTextFieldPhoneNumber.setText(newCustomer.getcustomerPhoneNumber());
			        	listCustomerTextFieldGender.setText(newCustomer.getcustomerGender());
			        	listCustomerTextFieldJob.setText(newCustomer.getcustomerJob());
			        	listCustomerTextFieldLicence.setText(newCustomer.getcustomerLicence());
			        	listCustomerTextFieldLicenceNo.setText(newCustomer.getcustomerLicenceNo());
			        	listCustomerTextAreaNotes.setText(newCustomer.getcustomerNotes());
			        	listCustomerTextAreaAddress.setText(newCustomer.getcustomerAddress());
		            }
				}
				
				
				listCustomerTable.setModel(tableModel);
				listCustomerScrollPane.setViewportView(listCustomerTable);
				
				listCustomerTable.changeSelection(0, 0, false, false);
				
			}
		});
		searchEmailButton.setBounds(480, 287, 89, 23);
		listCustomerPanel.add(searchEmailButton);
		
		JButton searchNameButton = new JButton("Ýsim Ara");
		searchNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchTcTextField.setText("");
				searchEmailTextField.setText("");
				
				FindCustomers findCustomerTc = new FindCustomers();
				List searchTcCustomer = findCustomerTc.searchNameCustomerResults(searchNameTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchTcCustomer.iterator(); iterator.hasNext();i++){
					
		            Customer newCustomer = (Customer) iterator.next(); 
		            
		            
					
					String[] kolon = { "Tc Kimlik Numarasý" , "Ad" , "Soyad" , "Email" , "Telefon Numarasý" , "Adres" , "Cinsiyet" , "Meslek" , "Doðum Tarihi" , "Ehliyet Türü" , 
							"Ehliyet Numarasý" , "Not"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() ,
		            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
		            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
					
					if( i == 0 ) {
			        	listCustomerTextFieldTc.setText(newCustomer.getcustomerTc());
			        	listCustomerTextFieldFirstName.setText(newCustomer.getcustomerFirstName());
			        	listCustomerTextFieldLastName.setText(newCustomer.getcustomerLastName());
			        	listCustomerTextFieldEmail.setText(newCustomer.getcustomerEmail());
			        	listCustomerTextFieldBirthDate.setText(newCustomer.getcustomerBirthdate().toGMTString());
			        	listCustomerTextFieldPhoneNumber.setText(newCustomer.getcustomerPhoneNumber());
			        	listCustomerTextFieldGender.setText(newCustomer.getcustomerGender());
			        	listCustomerTextFieldJob.setText(newCustomer.getcustomerJob());
			        	listCustomerTextFieldLicence.setText(newCustomer.getcustomerLicence());
			        	listCustomerTextFieldLicenceNo.setText(newCustomer.getcustomerLicenceNo());
			        	listCustomerTextAreaNotes.setText(newCustomer.getcustomerNotes());
			        	listCustomerTextAreaAddress.setText(newCustomer.getcustomerAddress());
		            }
				}
				
				
				listCustomerTable.setModel(tableModel);
				listCustomerScrollPane.setViewportView(listCustomerTable);
				
				listCustomerTable.changeSelection(0, 0, false, false);
				
			}
		});
		searchNameButton.setBounds(743, 285, 89, 23);
		listCustomerPanel.add(searchNameButton);
		
		//List Customers
		JMenuItem CustomerMenuItemList = new JMenuItem("Müþteri Listele");
		CustomerMenuItemList.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			
			listCarPanel.setVisible(false);
			addCustomerPanel.setVisible(false);
			listCustomerPanel.setVisible(true);
			addCarPanel.setVisible(false);
			rentCarPanel.setVisible(false);
			
			FindCustomers findCustomers = new FindCustomers();
			List customer = findCustomers.getCustomers();
			
			DefaultTableModel tableModel = new DefaultTableModel() {
				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			
			String[] kolon = { "Tc Kimlik Numarasý" , "Ad" , "Soyad" , "Email" , "Telefon Numarasý" , "Adres" , "Cinsiyet" , "Meslek" , "Doðum Tarihi" , "Ehliyet Türü" , "Ehliyet Numarasý" , "Not"};
			tableModel.setColumnIdentifiers(kolon);
			
			int i = 0;
			
			for (Iterator iterator = customer.iterator(); iterator.hasNext();i++){
	            Customer newCustomer = (Customer) iterator.next(); 
	            tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() , 
	            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
	            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
	            
	            if( i == 0 ) {
		        	listCustomerTextFieldTc.setText(newCustomer.getcustomerTc());
		        	listCustomerTextFieldFirstName.setText(newCustomer.getcustomerFirstName());
		        	listCustomerTextFieldLastName.setText(newCustomer.getcustomerLastName());
		        	listCustomerTextFieldEmail.setText(newCustomer.getcustomerEmail());
		        	listCustomerTextFieldBirthDate.setText(newCustomer.getcustomerBirthdate().toString());
		        	listCustomerTextFieldPhoneNumber.setText(newCustomer.getcustomerPhoneNumber());
		        	listCustomerTextFieldGender.setText(newCustomer.getcustomerGender());
		        	listCustomerTextFieldJob.setText(newCustomer.getcustomerJob());
		        	listCustomerTextFieldLicence.setText(newCustomer.getcustomerLicence());
		        	listCustomerTextFieldLicenceNo.setText(newCustomer.getcustomerLicenceNo());
		        	listCustomerTextAreaNotes.setText(newCustomer.getcustomerNotes());
		        	listCustomerTextAreaAddress.setText(newCustomer.getcustomerAddress());
	            }
			}
			
			
			listCustomerTable.setModel(tableModel);
			listCustomerScrollPane.setViewportView(listCustomerTable);
			
			listCustomerTable.changeSelection(0, 0, false, false);
			
		}
		});
		CustomerMenu.add(CustomerMenuItemList);		
		
		listCustomerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
					
					

					FindCustomers findCustomers = new FindCustomers();
					
					List customer ;
					
					if(searchTcTextField.getText().length() > 0) {
						customer = findCustomers.searchTcCustomerResults(searchTcTextField.getText());
						
					}
					else if(searchEmailTextField.getText().length() > 0)
						customer = findCustomers.searchEmailCustomerResults(searchEmailTextField.getText());
					
					else
						customer = findCustomers.searchNameCustomerResults(searchNameTextField.getText());
					
					int i = 0;
					
					int selectedTableItem = listCustomerTable.getSelectedRow();
					
					for (Iterator iterator = customer.iterator(); iterator.hasNext();i++){
						
			            Customer newCustomer = (Customer) iterator.next();
			            
			            if( i == selectedTableItem) {
			            	String listCustomerTc = newCustomer.getcustomerTc();
			            	String listCustomerFirstName = newCustomer.getcustomerFirstName();
			            	String listCustomerLastName = newCustomer.getcustomerLastName();
			            	String listCustomerEmail = newCustomer.getcustomerEmail();
			            	String listCustomerPhoneNumber = newCustomer.getcustomerPhoneNumber();
			            	String listCustomerAddress = newCustomer.getcustomerAddress();
			            	String listCustomerGender = newCustomer.getcustomerGender() ;
			            	String listCustomerJob = newCustomer.getcustomerJob() ;
			            	Date listCustomerBirthdate = newCustomer.getcustomerBirthdate();
			            	String listCustomerLicence = newCustomer.getcustomerLicence() ;
			            	String listCustomerLicenceNo = newCustomer.getcustomerLicenceNo();
			            	String listCustomerNotes = newCustomer.getcustomerNotes();
			            	
			            	listCustomerTextFieldTc.setText(listCustomerTc);
			            	listCustomerTextFieldFirstName.setText(listCustomerFirstName);
			            	listCustomerTextFieldLastName.setText(listCustomerLastName);
			            	listCustomerTextFieldEmail.setText(listCustomerEmail);
			            	listCustomerTextFieldBirthDate.setText(listCustomerBirthdate.toGMTString());
			            	listCustomerTextFieldPhoneNumber.setText(listCustomerPhoneNumber);
			            	listCustomerTextFieldGender.setText(listCustomerGender);
			            	listCustomerTextFieldJob.setText(listCustomerJob);
			            	listCustomerTextFieldLicence.setText(listCustomerLicence);
			            	listCustomerTextFieldLicenceNo.setText(listCustomerLicenceNo);
			            	listCustomerTextAreaNotes.setText(listCustomerNotes);
			            	listCustomerTextAreaAddress.setText(listCustomerAddress);
			            	
			            }
			            
					}
				
			}
		});
		
		
		JButton listCustomerSaveButton = new JButton("Kaydet");
		listCustomerSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String genderText = listCustomerTextFieldGender.getText();
				
				String tcText = listCustomerTextFieldTc.getText();
				String firstNameText = listCustomerTextFieldFirstName.getText();
				String lastNameText = listCustomerTextFieldLastName.getText();
				String jobText = listCustomerTextFieldJob.getText();
				
				String phoneNumberText = listCustomerTextFieldPhoneNumber.getText();
				String emailText = listCustomerTextFieldEmail.getText();
				String addressTextArea = listCustomerTextAreaAddress.getText();
				
				String lincenceText = listCustomerTextFieldLicence.getText();
				String lincenceNoText = listCustomerTextFieldLicenceNo.getText();
				String notesText = listCustomerTextAreaNotes.getText();
				
				
				if(tcText.length() != 11) {
					JOptionPane.showMessageDialog(MainPage.this, "T.C. kimlik numarasý 11 haneli olmalý.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidEmailAddress(emailText)) {
					JOptionPane.showMessageDialog(MainPage.this, "Email adresinizi kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidPhoneNumber(phoneNumberText)) {
					JOptionPane.showMessageDialog(MainPage.this, "Telefon Numaranýzý kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (genderText == "") {
						JOptionPane.showMessageDialog(MainPage.this, "Cinsiyetinizi Seçiniz","Hata", JOptionPane.INFORMATION_MESSAGE);
					}else {
						
						Customer customer = new Customer(tcText, firstNameText, lastNameText, emailText, phoneNumberText,
								addressTextArea, genderText, jobText, lincenceText, lincenceNoText, notesText);
						
						Session session = HibernateUtilCustomer.getSessionFactory().openSession();
						
						Transaction tx = session.beginTransaction();
						
						CustomerAuth customerAuth = new CustomerAuth();
						
						boolean isAlreadyTc = customerAuth.findCustomerTc(tcText);
						
						boolean isAlreadyEmail = customerAuth.findCustomerEmail(emailText);
						
						boolean isAlreadyPhoneNumber = customerAuth.findCustomerPhoneNumber(phoneNumberText);
						
						session.saveOrUpdate(customer);
						
						session.getTransaction().commit();
						
						session.close();
						
						JOptionPane.showMessageDialog(MainPage.this, "Düzenleme ve kayýt baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
						
					}
			}
		});
		listCustomerSaveButton.setBounds(221, 229, 89, 23);
		listCustomerShowTextPanel.add(listCustomerSaveButton);
		
		JButton listCustomerDeleteButton = new JButton("Sil");
		listCustomerDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Session session = HibernateUtilCustomer.getSessionFactory().openSession();
				
				Transaction tx = session.beginTransaction();
				
				FindCustomers findCustomers = new FindCustomers();
				
				List deleteCustomer = findCustomers.searchTcCustomerResults(listCustomerTextFieldTc.getText());
				
				for (Iterator iterator = deleteCustomer.iterator(); iterator.hasNext();){
					
		            Customer newCustomer = (Customer) iterator.next();
		            
		            session.delete(newCustomer);
					
					session.getTransaction().commit();
					
					session.close();
				}
				
				JOptionPane.showMessageDialog(MainPage.this, "Silme iþlemi baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
				
				CustomerMenuItemList.getAction();
			}
		});
		listCustomerDeleteButton.setBounds(360, 229, 89, 23);
		listCustomerShowTextPanel.add(listCustomerDeleteButton);
		
		JButton listCustomerRefreshButton = new JButton("Yenile");
		listCustomerRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchTcTextField.setText("");
				searchEmailTextField.setText("");
				searchNameTextField.setText("");
				
				FindCustomers findCustomers = new FindCustomers();
				List customer = findCustomers.getCustomers();
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				String[] kolon = { "Tc Kimlik Numarasý" , "Ad" , "Soyad" , "Email" , "Telefon Numarasý" , 
						"Adres" , "Cinsiyet" , "Meslek" , "Doðum Tarihi" , "Ehliyet Türü" , "Ehliyet Numarasý" , "Not"};
				tableModel.setColumnIdentifiers(kolon);
				
				int i = 0;
				
				for (Iterator iterator = customer.iterator(); iterator.hasNext();i++){
		            Customer newCustomer = (Customer) iterator.next(); 
		            tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() , 
		            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
		            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
		            
		            if( i == 0 ) {
			        	listCustomerTextFieldTc.setText(newCustomer.getcustomerTc());
			        	listCustomerTextFieldFirstName.setText(newCustomer.getcustomerFirstName());
			        	listCustomerTextFieldLastName.setText(newCustomer.getcustomerLastName());
			        	listCustomerTextFieldEmail.setText(newCustomer.getcustomerEmail());
			        	listCustomerTextFieldBirthDate.setText(newCustomer.getcustomerBirthdate().toGMTString());
			        	listCustomerTextFieldPhoneNumber.setText(newCustomer.getcustomerPhoneNumber());
			        	listCustomerTextFieldGender.setText(newCustomer.getcustomerGender());
			        	listCustomerTextFieldJob.setText(newCustomer.getcustomerJob());
			        	listCustomerTextFieldLicence.setText(newCustomer.getcustomerLicence());
			        	listCustomerTextFieldLicenceNo.setText(newCustomer.getcustomerLicenceNo());
			        	listCustomerTextAreaNotes.setText(newCustomer.getcustomerNotes());
			        	listCustomerTextAreaAddress.setText(newCustomer.getcustomerAddress());
		            }
				}
				
				
				listCustomerTable.setModel(tableModel);
				listCustomerScrollPane.setViewportView(listCustomerTable);
				
				listCustomerTable.changeSelection(0, 0, false, false);
				
			}
		});
		listCustomerRefreshButton.setBounds(501, 229, 89, 23);
		listCustomerShowTextPanel.add(listCustomerRefreshButton);
		
		
		
		
		
		//Add Customers
		JMenuItem CustomerMenuItemAdd = new JMenuItem("Müþteri Ekle");
		CustomerMenuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addCustomerPanel.setVisible(true);
				listCustomerPanel.setVisible(false);
				listCarPanel.setVisible(false);
				addCarPanel.setVisible(false);
				rentCarPanel.setVisible(false);
				
			}
		});
		CustomerMenu.add(CustomerMenuItemAdd);
		
		
		JPanel personalDetailsPanel = new JPanel();
		personalDetailsPanel.setBounds(0, 0, 357, 518);
		addCustomerPanel.add(personalDetailsPanel);
		personalDetailsPanel.setBorder(new TitledBorder(null, "Kiþisel Bilgiler", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		personalDetailsPanel.setName("");
		personalDetailsPanel.setToolTipText("");
		personalDetailsPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T.C. Kimlik Numarasý :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 64, 129, 14);
		personalDetailsPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ýsim :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(116, 104, 33, 14);
		personalDetailsPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soyisim :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(95, 154, 54, 14);
		personalDetailsPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Cinsiyet :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(91, 204, 58, 14);
		personalDetailsPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Meslek :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(99, 254, 50, 14);
		personalDetailsPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Doðum Tarihi :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(60, 304, 89, 14);
		personalDetailsPanel.add(lblNewLabel_7);
		
		addCustomerTcText = new JTextField();
		addCustomerTcText.setBounds(159, 62, 188, 20);
		personalDetailsPanel.add(addCustomerTcText);
		addCustomerTcText.setColumns(10);
		
		addCustomerLastNameText = new JTextField();
		addCustomerLastNameText.setBounds(159, 152, 188, 20);
		personalDetailsPanel.add(addCustomerLastNameText);
		addCustomerLastNameText.setColumns(10);
		
		addCustomerJobText = new JTextField();
		addCustomerJobText.setColumns(10);
		addCustomerJobText.setBounds(159, 252, 188, 20);
		personalDetailsPanel.add(addCustomerJobText);
		
		addCustomerFirstNameText = new JTextField();
		addCustomerFirstNameText.setColumns(10);
		addCustomerFirstNameText.setBounds(159, 102, 188, 20);
		personalDetailsPanel.add(addCustomerFirstNameText);
		
		JRadioButton addCustomerMaleRadio = new JRadioButton("Erkek");
		addCustomerMaleRadio.setBounds(159, 201, 65, 23);
		personalDetailsPanel.add(addCustomerMaleRadio);
		
		JRadioButton addCustomerFemaleRadio = new JRadioButton("Kadýn");
		addCustomerFemaleRadio.setBounds(241, 201, 65, 23);
		personalDetailsPanel.add(addCustomerFemaleRadio);
		
		ButtonGroup radioGenderGroup = new ButtonGroup();
		radioGenderGroup.add(addCustomerMaleRadio);
		radioGenderGroup.add(addCustomerFemaleRadio);
		
		JCalendar addCustomerBirthdateCalendar = new JCalendar();
		addCustomerBirthdateCalendar.setBounds(159, 304, 191, 153);
		personalDetailsPanel.add(addCustomerBirthdateCalendar);
		
		JPanel contactInformationPanel = new JPanel();
		contactInformationPanel.setBounds(367, 0, 292, 309);
		addCustomerPanel.add(contactInformationPanel);
		contactInformationPanel.setBorder(new TitledBorder(null, "Ýletiþim Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contactInformationPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setBounds(93, 140, 39, 14);
		contactInformationPanel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_4 = new JLabel("Telefon Numarasý :");
		lblNewLabel_4.setBounds(20, 69, 112, 14);
		contactInformationPanel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_10 = new JLabel("Adres :");
		lblNewLabel_10.setBounds(89, 220, 43, 14);
		contactInformationPanel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		addCustomerPhoneNumberText = new JTextField();
		addCustomerPhoneNumberText.setText("+90");
		addCustomerPhoneNumberText.setBounds(142, 67, 140, 20);
		contactInformationPanel.add(addCustomerPhoneNumberText);
		addCustomerPhoneNumberText.setColumns(10);
		
		addCustomerEmailText = new JTextField();
		addCustomerEmailText.setBounds(142, 138, 140, 20);
		contactInformationPanel.add(addCustomerEmailText);
		addCustomerEmailText.setColumns(10);
		
		TextArea addCustomerAddressTextArea = new TextArea();
		addCustomerAddressTextArea.setBounds(142, 190, 140, 72);
		contactInformationPanel.add(addCustomerAddressTextArea);
		
		JPanel lincenceDetailsPanel = new JPanel();
		lincenceDetailsPanel.setBounds(669, 0, 295, 309);
		addCustomerPanel.add(lincenceDetailsPanel);
		lincenceDetailsPanel.setBorder(new TitledBorder(null, "Ehliyet / DÝðer Bilgileri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lincenceDetailsPanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Ehliyet Türü :");
		lblNewLabel_8.setBounds(47, 66, 81, 14);
		lincenceDetailsPanel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_9 = new JLabel("Ehliyet Numarasý :");
		lblNewLabel_9.setBounds(20, 107, 108, 14);
		lincenceDetailsPanel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_11 = new JLabel("Notlar :");
		lblNewLabel_11.setBounds(82, 194, 46, 14);
		lincenceDetailsPanel.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		addCustomerLicenceText = new JTextField();
		addCustomerLicenceText.setBounds(138, 64, 147, 20);
		lincenceDetailsPanel.add(addCustomerLicenceText);
		addCustomerLicenceText.setColumns(10);
		
		addCustomerLicenceNoText = new JTextField();
		addCustomerLicenceNoText.setBounds(138, 105, 147, 20);
		lincenceDetailsPanel.add(addCustomerLicenceNoText);
		addCustomerLicenceNoText.setColumns(10);
		
		TextArea addCustomerNotesTextArea = new TextArea();
		addCustomerNotesTextArea.setBounds(138, 152, 147, 100);
		lincenceDetailsPanel.add(addCustomerNotesTextArea);
		
		JButton addCustomerAddButton = new JButton("Müþteri Ekle");
		addCustomerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String genderText = "";
				
				String tcText = addCustomerTcText.getText();
				String firstNameText = addCustomerFirstNameText.getText();
				String lastNameText = addCustomerLastNameText.getText();
				Date birthDate = addCustomerBirthdateCalendar.getDate();
				String jobText = addCustomerJobText.getText();
				
				String phoneNumberText = addCustomerPhoneNumberText.getText();
				String emailText = addCustomerEmailText.getText();
				String addressTextArea = addCustomerAddressTextArea.getText();
				
				String licenceText = addCustomerLicenceText.getText();
				String licenceNoText = addCustomerLicenceNoText.getText();
				String notesText = addCustomerNotesTextArea.getText();
				
				Calendar cal = addCustomerBirthdateCalendar.getCalendar();
				
				int currentYear = Year.now().getValue();
				int enteredYear = cal.get(Calendar.YEAR);
				
				if(addCustomerMaleRadio.isSelected()) {
					genderText = addCustomerMaleRadio.getText();
				}else if (addCustomerFemaleRadio.isSelected()) {
					genderText = addCustomerFemaleRadio.getText();
				}
				
				if(tcText.length() != 11) {
					JOptionPane.showMessageDialog(MainPage.this, "T.C. kimlik numarasý 11 haneli olmalý.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidEmailAddress(emailText)) {
					JOptionPane.showMessageDialog(MainPage.this, "Email adresinizi kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (!isValidPhoneNumber(phoneNumberText)) {
					JOptionPane.showMessageDialog(MainPage.this, "Telefon Numaranýzý kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (genderText == "") {
						JOptionPane.showMessageDialog(MainPage.this, "Cinsiyetinizi Seçiniz","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if (licenceText.length()<1 || licenceNoText.length()<1 || jobText.length()<1 || firstNameText.length()<1 || lastNameText.length()<1 || addressTextArea.length()<1){
						JOptionPane.showMessageDialog(MainPage.this, "Boþ kýsýmlarý doldurunuz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else if ((currentYear - enteredYear)<18) {
						JOptionPane.showMessageDialog(MainPage.this, "18 yaþýndan büyük olmalýsýnýz.","Hata", JOptionPane.INFORMATION_MESSAGE);
				}else {
						
						Customer customer = new Customer(tcText, firstNameText, lastNameText, emailText, phoneNumberText, addressTextArea, genderText, jobText, birthDate, licenceText, licenceNoText, notesText);
						
						Session session = HibernateUtilCustomer.getSessionFactory().openSession();
						
						Transaction tx = session.beginTransaction();
						
						CustomerAuth customerAuth = new CustomerAuth();
						
						boolean isAlreadyTc = customerAuth.findCustomerTc(tcText);
						
						boolean isAlreadyEmail = customerAuth.findCustomerEmail(emailText);
						
						boolean isAlreadyPhoneNumber = customerAuth.findCustomerPhoneNumber(phoneNumberText);
						
						if ( isAlreadyTc ) {
							JOptionPane.showMessageDialog(MainPage.this, "T.C. kimlik numarasý sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						} else if ( isAlreadyEmail ) {
							JOptionPane.showMessageDialog(MainPage.this, "Email sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						} else if ( isAlreadyPhoneNumber ) {
							JOptionPane.showMessageDialog(MainPage.this, "Telefon numarasý sistemde kayýtlý.","Hata", JOptionPane.INFORMATION_MESSAGE);
						}else {
							session.save(customer);
							tx.commit();
							JOptionPane.showMessageDialog(MainPage.this, "Kayýt baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
			}
		});
		addCustomerAddButton.setBounds(611, 485, 130, 23);
		addCustomerPanel.add(addCustomerAddButton);
		
		JButton addCustomerClearButon = new JButton("Temizle");
		addCustomerClearButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addCustomerTcText.setText("");
				addCustomerFirstNameText.setText("");
				addCustomerLastNameText.setText("");
				
				addCustomerJobText.setText("");
				addCustomerPhoneNumberText.setText("");
				addCustomerEmailText.setText("");
				addCustomerAddressTextArea.setText(" ");
				
				addCustomerLicenceText.setText("");
				addCustomerLicenceNoText.setText("");
				addCustomerNotesTextArea.setText(" ");
		
			}
		});
		addCustomerClearButon.setBounds(782, 485, 89, 23);
		addCustomerPanel.add(addCustomerClearButon);
		
		
		
		Panel listCarsTablePanel = new Panel();
		listCarsTablePanel.setLayout(null);
		listCarsTablePanel.setBounds(10, 347, 944, 161);
		listCarPanel.add(listCarsTablePanel);
		
		
		
		JScrollPane listCarsTableScrollPane = new JScrollPane();
		listCarsTableScrollPane.setBounds(10, 10, 924, 140);
		listCarsTablePanel.add(listCarsTableScrollPane);
		
		JPanel listCarsTextFieldsPanel = new JPanel();
		listCarsTextFieldsPanel.setLayout(null);
		listCarsTextFieldsPanel.setBounds(10, 11, 944, 296);
		listCarPanel.add(listCarsTextFieldsPanel);
		
		JLabel lblPlate = new JLabel("Plaka :");
		lblPlate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPlate.setBounds(14, 10, 40, 14);
		listCarsTextFieldsPanel.add(lblPlate);
		
		JLabel lblBrand = new JLabel("Marka :");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBrand.setBounds(10, 45, 44, 14);
		listCarsTextFieldsPanel.add(lblBrand);
		
		JLabel lblYear = new JLabel("Yýl :");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(32, 115, 22, 14);
		listCarsTextFieldsPanel.add(lblYear);
		
		JLabel lblFuel = new JLabel("Yakýt :");
		lblFuel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFuel.setBounds(18, 185, 36, 14);
		listCarsTextFieldsPanel.add(lblFuel);
		
		carPlateTextField = new JTextField();
		carPlateTextField.setColumns(10);
		carPlateTextField.setBounds(64, 9, 217, 18);
		listCarsTextFieldsPanel.add(carPlateTextField);
		
		carBrandTextField = new JTextField();
		carBrandTextField.setColumns(10);
		carBrandTextField.setBounds(64, 44, 217, 18);
		listCarsTextFieldsPanel.add(carBrandTextField);
		
		carModelTextField = new JTextField();
		carModelTextField.setColumns(10);
		carModelTextField.setBounds(64, 79, 217, 20);
		listCarsTextFieldsPanel.add(carModelTextField);
		
		carYearTextField = new JTextField();
		carYearTextField.setColumns(10);
		carYearTextField.setBounds(64, 113, 217, 20);
		listCarsTextFieldsPanel.add(carYearTextField);
		
		carFuelTextField = new JTextField();
		carFuelTextField.setColumns(10);
		carFuelTextField.setBounds(64, 184, 217, 18);
		listCarsTextFieldsPanel.add(carFuelTextField);
		
		carEngineTextField = new JTextField();
		carEngineTextField.setColumns(10);
		carEngineTextField.setBounds(421, 184, 217, 18);
		listCarsTextFieldsPanel.add(carEngineTextField);
		
		carTractionTextField = new JTextField();
		carTractionTextField.setColumns(10);
		carTractionTextField.setBounds(64, 218, 217, 20);
		listCarsTextFieldsPanel.add(carTractionTextField);
		
		carDoorTextField = new JTextField();
		carDoorTextField.setColumns(10);
		carDoorTextField.setBounds(421, 8, 217, 20);
		listCarsTextFieldsPanel.add(carDoorTextField);
		
		carColorTextField = new JTextField();
		carColorTextField.setColumns(10);
		carColorTextField.setBounds(421, 43, 217, 20);
		listCarsTextFieldsPanel.add(carColorTextField);
		
		carKmTextField = new JTextField();
		carKmTextField.setColumns(10);
		carKmTextField.setBounds(421, 79, 217, 20);
		listCarsTextFieldsPanel.add(carKmTextField);
		
		JLabel lblBody = new JLabel("Kasa :");
		lblBody.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBody.setBounds(375, 150, 36, 14);
		listCarsTextFieldsPanel.add(lblBody);
		
		carGearTextField = new JTextField();
		carGearTextField.setColumns(10);
		carGearTextField.setBounds(64, 149, 217, 18);
		listCarsTextFieldsPanel.add(carGearTextField);
		
		JLabel lblGear = new JLabel("Vites :");
		lblGear.setBounds(17, 150, 37, 14);
		listCarsTextFieldsPanel.add(lblGear);
		lblGear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblModel = new JLabel("Model :");
		lblModel.setBounds(11, 80, 43, 14);
		listCarsTextFieldsPanel.add(lblModel);
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		carBodyTextField = new JTextField();
		carBodyTextField.setColumns(10);
		carBodyTextField.setBounds(421, 149, 217, 18);
		listCarsTextFieldsPanel.add(carBodyTextField);
		
		JLabel lblEngine = new JLabel("Motor :");
		lblEngine.setBounds(369, 185, 42, 14);
		listCarsTextFieldsPanel.add(lblEngine);
		lblEngine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTraction = new JLabel("\u00C7eki\u015F :");
		lblTraction.setBounds(15, 220, 39, 14);
		listCarsTextFieldsPanel.add(lblTraction);
		lblTraction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDoor = new JLabel("Kap\u0131 :");
		lblDoor.setBounds(378, 10, 33, 14);
		listCarsTextFieldsPanel.add(lblDoor);
		lblDoor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblColor = new JLabel("Renk :");
		lblColor.setBounds(374, 45, 37, 14);
		listCarsTextFieldsPanel.add(lblColor);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblKm = new JLabel("Kilometre :");
		lblKm.setBounds(348, 81, 63, 14);
		listCarsTextFieldsPanel.add(lblKm);
		lblKm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDamage = new JLabel("Hasar Durumu :");
		lblDamage.setBounds(320, 115, 91, 14);
		listCarsTextFieldsPanel.add(lblDamage);
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		carDamageStatusTextField = new JTextField();
		carDamageStatusTextField.setColumns(10);
		carDamageStatusTextField.setBounds(421, 114, 217, 18);
		listCarsTextFieldsPanel.add(carDamageStatusTextField);
		
		JPanel pictureBoxPanel = new JPanel();
		pictureBoxPanel.setBounds(675, 35, 250, 200);
		listCarsTextFieldsPanel.add(pictureBoxPanel);
		pictureBoxPanel.setLayout(new BorderLayout(0, 0));
		
		JButton listCarsChoosePictureButton = new JButton("Resim Seç");
		listCarsChoosePictureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser carPictureChooser = new JFileChooser();
				carPictureChooser.showOpenDialog(null);
				File file = carPictureChooser.getSelectedFile();
				
				try {
					Image carPicture = ImageIO.read(file);
					
					ImageIcon carPictureImageIcon = new ImageIcon(carPicture);
					
					carPictureImageIcon = resizePic(carPictureImageIcon);
					
					pictureBoxPanel.removeAll();
					pictureBoxPanel.revalidate();
					pictureBoxPanel.repaint();
					
					JLabel label = new JLabel(carPictureImageIcon);
		        	
		        	pictureBoxPanel.add(label);
							
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
				
			}
		});
		listCarsChoosePictureButton.setBounds(750, 262, 100, 23);
		listCarsTextFieldsPanel.add(listCarsChoosePictureButton);
		
		searchPlateTextField = new JTextField();
		searchPlateTextField.setColumns(10);
		searchPlateTextField.setBounds(20, 321, 154, 20);
		listCarPanel.add(searchPlateTextField);
		
		searchBrandTextField = new JTextField();
		searchBrandTextField.setColumns(10);
		searchBrandTextField.setBounds(349, 321, 154, 20);
		listCarPanel.add(searchBrandTextField);
		
		searchModelTextField = new JTextField();
		searchModelTextField.setColumns(10);
		searchModelTextField.setBounds(675, 321, 154, 20);
		listCarPanel.add(searchModelTextField);
		
		JButton searchPlate = new JButton("Plaka Bul");
		searchPlate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchBrandTextField.setText("");
				searchModelTextField.setText("");
				
				FindCars findCarsPlate = new FindCars();
				List searchPlate = findCarsPlate.getCarPlate(searchPlateTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchPlate.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
		            
					
		            String[] kolon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus() , newCar.getPicture(), newCar.getPricePerDay()});
					
					if( i == 0 ) {
						
						carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
			        	
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
			        	
		            }
				}
				
				
				listCarsTable.setModel(tableModel);
				listCarsTableScrollPane.setViewportView(listCarsTable);
				
				listCarsTable.changeSelection(0, 0, false, false);
			}
		});
		searchPlate.setBounds(184, 318, 96, 23);
		listCarPanel.add(searchPlate);
		
		JMenuItem listCarMenuItem = new JMenuItem("Araç Listele");
		listCarMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addCustomerPanel.setVisible(false);
				listCustomerPanel.setVisible(false);
				listCarPanel.setVisible(true);
				addCarPanel.setVisible(false);
				rentCarPanel.setVisible(false);
				
				
				FindCars findCars = new FindCars();
				
				List cars = findCars.getAllCars();
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				String[] kolon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
				tableModel.setColumnIdentifiers(kolon);
				
				int i = 0;
				
				for (Iterator iterator = cars.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next();
		            
		            tableModel.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus() , newCar.getPicture(), newCar.getPricePerDay()});

		            if( i == 0 ) {
		            	
			        	carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
						
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
		            }
				}
				
				
				listCarsTable.setModel(tableModel);
				
				listCarsTableScrollPane.setViewportView(listCarsTable);
				
				listCarsTable.changeSelection(0, 0, false, false);
			}
		});
		CarMenu.add(listCarMenuItem);
		
		
		JButton listCarsSaveButton = new JButton("Kaydet");
		listCarsSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				Blob blob = null;
				
				try {
					blob = imageIcon2Blob(pictureBoxPanel);
				} catch (SerialException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Car cars = new Car(carPlateTextField.getText(), carBrandTextField.getText(), carModelTextField.getText()
						,Integer.parseInt(carYearTextField.getText()), carFuelTextField.getText(), carGearTextField.getText(),carBodyTextField.getText()
						,carEngineTextField.getText(), carTractionTextField.getText(), carDoorTextField.getText()
						,carColorTextField.getText(), carKmTextField.getText(), carDamageStatusTextField.getText(), blob, Integer.parseInt(carPriceTextField.getText()));
						
	        	if(Integer.parseInt(carYearTextField.getText())<1111|| Integer.parseInt(carYearTextField.getText())>9999) {
	        		JOptionPane.showMessageDialog(MainPage.this, "Tarihi kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
	        	}else if (Integer.parseInt(carPriceTextField.getText()) < 1 || Integer.parseInt(carPriceTextField.getText()) > 999999) {
	        		JOptionPane.showMessageDialog(MainPage.this, "Fiyatý kontrol ediniz.","Hata", JOptionPane.INFORMATION_MESSAGE);
	        	}else {
		        	Session session = HibernateUtilCar.getSessionFactory().openSession();
					
					Transaction tx = session.beginTransaction();
					
					session.saveOrUpdate(cars);
					
					session.getTransaction().commit();
					
					session.close();
	        	}
				
			}
		});
		listCarsSaveButton.setBounds(148, 262, 89, 23);
		listCarsTextFieldsPanel.add(listCarsSaveButton);
		
		
		JButton listCarsDeleteButton = new JButton("Sil");
		listCarsDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
						Session session = HibernateUtilCar.getSessionFactory().openSession();
						
						Transaction tx = session.beginTransaction();
						
						FindCars findCarsFromPlate = new FindCars();
						
						List deleteCar = findCarsFromPlate.getCarPlate(carPlateTextField.getText());
						
						for (Iterator iterator = deleteCar.iterator(); iterator.hasNext();){
							
				            Car newDeleteCar = (Car) iterator.next();
				            
				            session.delete(newDeleteCar);
							
							session.getTransaction().commit();
							
							session.close();
						}
						
						JOptionPane.showMessageDialog(MainPage.this, "Silme iþlemi baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		listCarsDeleteButton.setBounds(300, 262, 89, 23);
		listCarsTextFieldsPanel.add(listCarsDeleteButton);
		
		JButton listCarsRefreshButton = new JButton("Yenile");
		listCarsRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchPlateTextField.setText("");
				searchBrandTextField.setText("");
				searchModelTextField.setText("");
				
				FindCars findCars = new FindCars();
				List car = findCars.getAllCars();
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				String[] kolon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
				tableModel.setColumnIdentifiers(kolon);
				
				int i = 0;
				
				for (Iterator iterator = car.iterator(); iterator.hasNext();i++){
		            Car newCar = (Car) iterator.next(); 
		            tableModel.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus() , newCar.getPicture(), newCar.getPricePerDay()});

		            if( i == 0 ) {
		            	
			        	carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
			        	
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
		            }
				}
				
				listCarsTable.setModel(tableModel);
				
				listCarsTableScrollPane.setViewportView(listCarsTable);
				
				listCarsTable.changeSelection(0, 0, false, false);
				
			}
		});
		listCarsRefreshButton.setBounds(450, 262, 89, 23);
		listCarsTextFieldsPanel.add(listCarsRefreshButton);
		
		JLabel lblPic = new JLabel("Resim");
		lblPic.setBounds(783, 10, 44, 14);
		listCarsTextFieldsPanel.add(lblPic);
		lblPic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		carPriceTextField = new JTextField();
		carPriceTextField.setBounds(421, 213, 217, 20);
		listCarsTextFieldsPanel.add(carPriceTextField);
		carPriceTextField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Günlük Fiyat :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(333, 215, 78, 14);
		listCarsTextFieldsPanel.add(lblPrice);
		
		
		
		listCarsTable = new JTable();
		listCarsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				FindCars findCars = new FindCars();
				
				List car ;
				
				if(searchPlateTextField.getText().length() > 0) {
					car = findCars.getCarPlate(searchPlateTextField.getText());
					
				}
				else if(searchBrandTextField.getText().length() > 0)
					car = findCars.getCarBrand(searchBrandTextField.getText());
				
				else
					car = findCars.getCarModel(searchModelTextField.getText());
				
				int i = 0;
				
				int selectedTableItem = listCarsTable.getSelectedRow();
				
				for (Iterator iterator = car.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next();
		            
		            if( i == selectedTableItem) {
		            	
		            	carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
			        	
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
			        	
		            	
		            }
		            
				}
				
			}
		});
		listCarsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCarsTable.setBounds(10, 11, 924, 139);
		listCarsTablePanel.add(listCarsTable);
		
		JButton searchBrandButton = new JButton("Marka Bul");
		searchBrandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchPlateTextField.setText("");
				searchModelTextField.setText("");
				
				FindCars findCarsBrand = new FindCars();
				List searchBrand = findCarsBrand.getCarBrand(searchBrandTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchBrand.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
		            
					
		            String[] kolon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük FÝyat"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus() , newCar.getPicture(), newCar.getPricePerDay()});
					
					if( i == 0 ) {
						
						carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
			        	
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
			        	
		            }
				}
				
				
				listCarsTable.setModel(tableModel);
				listCarsTableScrollPane.setViewportView(listCarsTable);
				
				listCarsTable.changeSelection(0, 0, false, false);
				
			}
		});
		searchBrandButton.setBounds(513, 318, 96, 23);
		listCarPanel.add(searchBrandButton);
		
		JButton searchModelButton = new JButton("Model Bul");
		searchModelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchBrandTextField.setText("");
				searchPlateTextField.setText("");
				
				FindCars findCarsModel = new FindCars();
				List searchModel = findCarsModel.getCarModel(searchModelTextField.getText());
				
				DefaultTableModel tableModel = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				int i = 0;
				
				for (Iterator iterator = searchModel.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
		            
					
		            String[] kolon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
					tableModel.setColumnIdentifiers(kolon);
					
					tableModel.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus() , newCar.getPicture(), newCar.getPricePerDay()});
					
					if( i == 0 ) {
						
						carPlateTextField.setText(newCar.getPlate());
			        	carBrandTextField.setText(newCar.getBrand());
			        	carModelTextField.setText(newCar.getModel());
			        	carYearTextField.setText(String.valueOf(newCar.getYear()));
			        	carFuelTextField.setText(newCar.getFuel());
			        	carGearTextField.setText(newCar.getGear());
			        	carBodyTextField.setText(newCar.getBody());
			        	carEngineTextField.setText(newCar.getEngine());
			        	carTractionTextField.setText(newCar.getTraction());
			        	carDoorTextField.setText(newCar.getDoor());
			        	carColorTextField.setText(newCar.getColor());
			        	carKmTextField.setText(newCar.getKm());
			        	carDamageStatusTextField.setText(newCar.getDamageStatus());
			        	carPriceTextField.setText(String.valueOf(newCar.getPricePerDay()));
			        	
			        	ImageIcon carPicture = blob2Image(newCar.getPicture());
			        	
			        	pictureBoxPanel.removeAll();
						pictureBoxPanel.revalidate();
						pictureBoxPanel.repaint();
			        	
			        	JLabel label = new JLabel(carPicture);
			        	
			        	pictureBoxPanel.add(label);
			        	
		            }
				}
				
				
				listCarsTable.setModel(tableModel);
				listCarsTableScrollPane.setViewportView(listCarsTable);
				
				listCarsTable.changeSelection(0, 0, false, false);
				
			}
		});
		searchModelButton.setBounds(839, 318, 96, 23);
		listCarPanel.add(searchModelButton);
		
		
		
		
		
		
		
		JMenuItem addCarMenuItem = new JMenuItem("Araç Ekle");
		addCarMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addCustomerPanel.setVisible(false);
				listCustomerPanel.setVisible(false);
				listCarPanel.setVisible(false);
				addCarPanel.setVisible(true);
				rentCarPanel.setVisible(false);
				
			}
		});
		CarMenu.add(addCarMenuItem);
		
		JLabel addCarLblPicture = new JLabel("Resim");
		addCarLblPicture.setBounds(784, 37, 35, 16);
		addCarPanel.add(addCarLblPicture);
		addCarLblPicture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		JPanel avaibleCarListPanel = new JPanel();
		avaibleCarListPanel.setBorder(new TitledBorder(null, "Hazýr Araçlar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		avaibleCarListPanel.setBounds(10, 52, 944, 200);
		rentCarPanel.add(avaibleCarListPanel);
		avaibleCarListPanel.setLayout(null);
		
		JScrollPane rentCarsScrollPane = new JScrollPane();
		rentCarsScrollPane.setBounds(10, 22, 924, 167);
		avaibleCarListPanel.add(rentCarsScrollPane);
		
		rentCarsTable = new JTable();
		rentCarsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rentCarsTable.setBounds(10, 22, 924, 139);
		avaibleCarListPanel.add(rentCarsTable);
		
		JPanel rentedCarListPanel = new JPanel();
		rentedCarListPanel.setBorder(new TitledBorder(null, "Kiradaki Araçlar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rentedCarListPanel.setBounds(10, 297, 944, 176);
		rentCarPanel.add(rentedCarListPanel);
		rentedCarListPanel.setLayout(null);
		
		JScrollPane retrieveCarsScrollPane = new JScrollPane();
		retrieveCarsScrollPane.setBounds(10, 22, 924, 139);
		rentedCarListPanel.add(retrieveCarsScrollPane);
		
		retrieveCarsTable = new JTable();
		retrieveCarsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		retrieveCarsTable.setBounds(10, 22, 924, 139);
		rentedCarListPanel.add(retrieveCarsTable);
		
		
		
		
		
		
		JMenu rentTransactionsMenuItem = new JMenu("Kira Ýþlemleri");
		rentTransactionsMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				addCustomerPanel.setVisible(false);
				listCustomerPanel.setVisible(false);
				listCarPanel.setVisible(false);
				addCarPanel.setVisible(false);
				rentCarPanel.setVisible(true);
				
				
				
				FindCars findCars = new FindCars();
				List carsAvaible = findCars.getCarAvailable();
				List carsRented = findCars.getRentedRentCars();
				
				DefaultTableModel tableModelRentCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				DefaultTableModel tableModelRetrieveCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				
				String[] colon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
				
				String[] rentedColon = { "T.C. Kimlik Numarasý" , "Email" , "Telefon Numarasý" , "Plaka" , "Bedel" , "Kiralanma tarihi" , "Geri Alýnma Tarihi"};
				
				int i = 0;
				
				for (Iterator iterator = carsAvaible.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
					tableModelRentCar.setColumnIdentifiers(colon);
					
					tableModelRentCar.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus(), newCar.getPricePerDay()});
				}
				
				
				rentCarsTable.setModel(tableModelRentCar);
				rentCarsScrollPane.setViewportView(rentCarsTable);
				rentCarsTable.changeSelection(0, 0, false, false);
				
				
				for (Iterator iterator = carsRented.iterator(); iterator.hasNext();i++){
					
		            Rent rent = (Rent) iterator.next(); 
		            
		            tableModelRetrieveCar.setColumnIdentifiers(rentedColon);
					
		            tableModelRetrieveCar.addRow(new Object[]{rent.getCustomerTc(), rent.getCustomerEmail(), rent.getCustomerPhoneNumber(), rent.getCarPlate(),
		            		rent.getCarPrice(), rent.getRentDate(), rent.getRetrieveDate()});
				}
				
				retrieveCarsTable.setModel(tableModelRetrieveCar);
				retrieveCarsScrollPane.setViewportView(retrieveCarsTable);
				retrieveCarsTable.changeSelection(0, 0, false, false);
			}
		});
		menuBar.add(rentTransactionsMenuItem);
		
		
		JButton rentCarButton = new JButton("Kirala");
		rentCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int selectedIndex = rentCarsTable.getSelectedRow();
				
				int i = 0;
				
				Blob blob = null;
				
				FindCars findCars = new FindCars();
				
				List carsAvailable = findCars.getCarAvailable();
				
				for (Iterator iterator = carsAvailable.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
					if(i == selectedIndex) {
						
			            Car cars = new Car(newCar.getPlate(), newCar.getBrand(), newCar.getModel(), newCar.getYear(), newCar.getFuel(), 
			            		newCar.getGear(), newCar.getEngine(), newCar.getTraction(), newCar.getDoor(), newCar.getColor(),
			            		newCar.getKm(), newCar.getBody(), newCar.getDamageStatus(), newCar.getPicture(), true, newCar.getPricePerDay());
			            

			            RentCar newFrame = new RentCar(newCar.getPricePerDay(), newCar.getPlate());
						
					}
				}
			}
		});
		rentCarButton.setBounds(443, 263, 89, 23);
		rentCarPanel.add(rentCarButton);
		
		JButton btnNewButton = new JButton("Geri Al");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogOption = JOptionPane.YES_NO_OPTION;
				
				dialogOption = JOptionPane.showConfirmDialog(null, "Emin misiniz?", "Uyarý", dialogOption);
				
				if(dialogOption == JOptionPane.YES_OPTION) {
					
					int selectedTableItem = retrieveCarsTable.getSelectedRow();
					
					FindCars findCars = new FindCars();
					List rentedCars = findCars.getRented();
					List getRentedRentCars = findCars.getRentedRentCars();
					
					Session sessionRent = HibernateUtilRent.getSessionFactory().openSession();
					
					Session session = HibernateUtilCar.getSessionFactory().openSession();
					
					int i = 0;
					for(Iterator iterator = getRentedRentCars.iterator(); iterator.hasNext() ; i++) {
						
						Rent rent = (Rent) iterator.next();
						
						if(i == selectedTableItem) {
							
				            Rent rentCar = new Rent(rent.getCustomerTc(), rent.getCustomerEmail(), rent.getCustomerPhoneNumber(), 
				            		rent.getCarPlate(), rent.getCarPrice(), rent.getRentDate(), rent.getRetrieveDate());
				            
							Transaction tx = sessionRent.beginTransaction();
							
							sessionRent.delete(rentCar);
							
							sessionRent.getTransaction().commit();
						}
					}
					sessionRent.close();
					
					
					i = 0;
					for(Iterator iterator = rentedCars.iterator(); iterator.hasNext() ; i++) {
						
						Car newCar = (Car) iterator.next();
						
						if(i == selectedTableItem) {
							
							Car cars = new Car(newCar.getPlate(), newCar.getBrand(), newCar.getModel(), newCar.getYear(), newCar.getFuel(), 
				            		newCar.getGear(), newCar.getEngine(), newCar.getTraction(), newCar.getDoor(), newCar.getColor(),
				            		newCar.getKm(), newCar.getBody(), newCar.getDamageStatus(), newCar.getPicture(), false, newCar.getPricePerDay());
				            
							Transaction tx = session.beginTransaction();
							
							session.saveOrUpdate(cars);
							
							session.getTransaction().commit();
						}
					}
					session.close();
				}
				
				
				FindCars findCars = new FindCars();
				List carsAvaible = findCars.getCarAvailable();
				List carsRented = findCars.getRentedRentCars();
				
				DefaultTableModel tableModelRentCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				DefaultTableModel tableModelRetrieveCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				
				String[] colon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
				
				String[] rentedColon = { "T.C. Kimlik Numarasý" , "Email" , "Telefon Numarasý" , "Plaka" , "Bedel" , "Kiralanma tarihi" , "Geri Alýnma Tarihi"};
				
				int i = 0;
				
				for (Iterator iterator = carsAvaible.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
					tableModelRentCar.setColumnIdentifiers(colon);
					
					tableModelRentCar.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus(), newCar.getPricePerDay()});
				}
				
				
				rentCarsTable.setModel(tableModelRentCar);
				rentCarsScrollPane.setViewportView(rentCarsTable);
				rentCarsTable.changeSelection(0, 0, false, false);
				
				
				for (Iterator iterator = carsRented.iterator(); iterator.hasNext();i++){
					
		            Rent rent = (Rent) iterator.next(); 
		            
		            tableModelRetrieveCar.setColumnIdentifiers(rentedColon);
					
		            tableModelRetrieveCar.addRow(new Object[]{rent.getCustomerTc(), rent.getCustomerEmail(), rent.getCustomerPhoneNumber(), rent.getCarPlate(),
		            		rent.getCarPrice(), rent.getRentDate(), rent.getRetrieveDate()});
				}
				
				retrieveCarsTable.setModel(tableModelRetrieveCar);
				retrieveCarsScrollPane.setViewportView(retrieveCarsTable);
				retrieveCarsTable.changeSelection(0, 0, false, false);
				
			}
		});
		btnNewButton.setBounds(443, 484, 89, 23);
		rentCarPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sayfayý Yenile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FindCars findCars = new FindCars();
				List carsAvaible = findCars.getCarAvailable();
				List carsRented = findCars.getRentedRentCars();
				
				DefaultTableModel tableModelRentCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				DefaultTableModel tableModelRetrieveCar = new DefaultTableModel() {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				
				
				String[] colon = { "Plaka" , "Marka" , "Model" , "Yýl" , "Yakýt" , "Vites" , "Kasa" , "Motor" , "Çekiþ" , "Kapý" , "Renk" , "Kilometre", "Hasar Durumu", "Günlük Fiyat"};
				
				String[] rentedColon = { "T.C. Kimlik Numarasý" , "Email" , "Telefon Numarasý" , "Plaka" , "Bedel" , "Kiralanma tarihi" , "Geri Alýnma Tarihi"};
				
				int i = 0;
				
				for (Iterator iterator = carsAvaible.iterator(); iterator.hasNext();i++){
					
		            Car newCar = (Car) iterator.next(); 
		            
					tableModelRentCar.setColumnIdentifiers(colon);
					
					tableModelRentCar.addRow(new Object[]{newCar.getPlate() , newCar.getBrand() , newCar.getModel() , 
		            		newCar.getYear() , newCar.getFuel() , newCar.getGear() , newCar.getBody() , 
		            		newCar.getEngine() , newCar.getTraction(), newCar.getDoor() , newCar.getColor(),
		            		newCar.getKm() , newCar.getDamageStatus(), newCar.getPricePerDay()});
				}
				
				
				rentCarsTable.setModel(tableModelRentCar);
				rentCarsScrollPane.setViewportView(rentCarsTable);
				rentCarsTable.changeSelection(0, 0, false, false);
				
				
				for (Iterator iterator = carsRented.iterator(); iterator.hasNext();i++){
					
		            Rent rent = (Rent) iterator.next(); 
		            
		            tableModelRetrieveCar.setColumnIdentifiers(rentedColon);
					
		            tableModelRetrieveCar.addRow(new Object[]{rent.getCustomerTc(), rent.getCustomerEmail(), rent.getCustomerPhoneNumber(), rent.getCarPlate(),
		            		rent.getCarPrice(), rent.getRentDate(), rent.getRetrieveDate()});
				}
				
				retrieveCarsTable.setModel(tableModelRetrieveCar);
				retrieveCarsScrollPane.setViewportView(retrieveCarsTable);
				retrieveCarsTable.changeSelection(0, 0, false, false);
				
			}
		});
		btnNewButton_1.setBounds(422, 11, 126, 23);
		rentCarPanel.add(btnNewButton_1);
		
		JLabel lblBackground = new JLabel(backgroundPicture);
		lblBackground.setBounds(10, 11, 964, 518);
		rootPane.add(lblBackground);
		
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
	
	public ImageIcon resizePic(ImageIcon img) {
		
		Image image = img.getImage();
    	
    	Image reSizedImage = image.getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
    	
    	ImageIcon newCarPic = new ImageIcon(reSizedImage);
    	
    	return newCarPic;
	}
	
	public ImageIcon blob2Image(Blob blob) {
		
		int blobLength;
		
		byte[] bytes = null;
		
		try {
			
			blobLength = (int) blob.length();
			
			bytes = blob.getBytes(1, blobLength);
			
			blob.free();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon carPicture = new ImageIcon(bytes);
    	
    	ImageIcon newCarPic = resizePic(carPicture);
		
		return newCarPic;
	}

	public Blob imageIcon2Blob(JPanel pictureBoxPanel) throws InterruptedException, SerialException, SQLException, IOException{
		
		Component[] comp = pictureBoxPanel.getComponents();
		
		Blob blob = null;
		
		if(pictureBoxPanel.getComponentCount()<=0)
			return null;
		
		JLabel newGridLabel = (JLabel) comp[0];
			
		ImageIcon placeImage = (ImageIcon) newGridLabel.getIcon();
			
		Image image = placeImage.getImage();
			
		Icon icons = newGridLabel.getIcon();
		BufferedImage bi = new BufferedImage(icons.getIconWidth(), icons.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		icons.paintIcon(null, g, 0, 0);
		g.dispose();
	
		ByteArrayOutputStream os = new ByteArrayOutputStream();
			        
		ImageIO.write(bi, "png", os);

		InputStream fis = new ByteArrayInputStream(os.toByteArray());
			        
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
			        
		byte[] buf = new byte[1024];
			        
		for (int readNum; (readNum = fis.read(buf)) != -1;) {
			bos.write(buf, 0, readNum);
			System.out.println("read " + readNum + " bytes,");
		}
			        
		byte[] photo = bos.toByteArray();
		
		blob = new SerialBlob(photo);
			        
		return blob;
	}
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	private JTextField carPriceTextField;
	private JTextField addCarPricePerDayTextField;
	private JTable rentCarsTable;
	private JTable retrieveCarsTable;
	
	public static boolean isNumeric(String yearStr) {
		
		if (yearStr == null) {
	        return false; 
	    }
	    return pattern.matcher(yearStr).matches();
		
	}
}