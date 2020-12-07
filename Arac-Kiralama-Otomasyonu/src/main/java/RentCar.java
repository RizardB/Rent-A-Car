import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class RentCar extends JFrame {
	private JTable chooseCustomerRentCarTable;
	private JTextField rentCarCustomerTcTextField;
	private JTextField rentCarCustomerLastNameTextField;
	private JTextField rentCarCustomerFirstNameTextField;
	private JTextField rentCarCustomerPhoneTextField;
	private JTextField rentCarCustomerEmailTextField;
	private JTextField rentCarCustomerPriceTextField;
	private JTextField showPriceTextField;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentCar frame = new RentCar(0,"");
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 * @param j 
	 * @param price 
	 * @param j 
	 */
	public RentCar(int pricePerDay, String carPlate) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		JPanel rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		
		setLocationRelativeTo(null);
		setVisible(true);
		rootPane.setLayout(null);
		Date nowDateRentCar = new Date();
		Date nowDateRetrieveCar = new Date();
		
		JPanel rentCarChoseCustomerPanel = new JPanel();
		rentCarChoseCustomerPanel.setBounds(10, 11, 869, 489);
		rootPane.add(rentCarChoseCustomerPanel);
		rentCarChoseCustomerPanel.setLayout(null);
		rentCarChoseCustomerPanel.setVisible(false);
		
		
		JScrollPane chooseCustomerRentCarScrollPane = new JScrollPane();
		chooseCustomerRentCarScrollPane.setBounds(10, 44, 849, 169);
		rentCarChoseCustomerPanel.add(chooseCustomerRentCarScrollPane);
		
		chooseCustomerRentCarTable = new JTable();
		chooseCustomerRentCarTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				FindCustomers findCustomers = new FindCustomers();
				List customers = findCustomers.getCustomers();
				
				int i = 0;
				
				int selectedTableItem = chooseCustomerRentCarTable.getSelectedRow();
				
				for (Iterator iterator = customers.iterator(); iterator.hasNext();i++){
					
		            Customer newCustomer = (Customer) iterator.next(); 
		            
		            if( i == selectedTableItem ) {
		            	
			        	rentCarCustomerTcTextField.setText(newCustomer.getcustomerTc());
			        	rentCarCustomerEmailTextField.setText(newCustomer.getcustomerEmail());
			        	rentCarCustomerFirstNameTextField.setText(newCustomer.getcustomerFirstName());
			        	rentCarCustomerLastNameTextField.setText(newCustomer.getcustomerLastName());
			        	rentCarCustomerPhoneTextField.setText(newCustomer.getcustomerPhoneNumber());
			        	
		            }
		            
				}
				
			}
		});
		chooseCustomerRentCarScrollPane.setViewportView(chooseCustomerRentCarTable);
		
		
		
		rentCarCustomerTcTextField = new JTextField();
		rentCarCustomerTcTextField.setEditable(false);
		rentCarCustomerTcTextField.setBounds(167, 254, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerTcTextField);
		rentCarCustomerTcTextField.setColumns(10);
		
		rentCarCustomerLastNameTextField = new JTextField();
		rentCarCustomerLastNameTextField.setEditable(false);
		rentCarCustomerLastNameTextField.setBounds(580, 317, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerLastNameTextField);
		rentCarCustomerLastNameTextField.setColumns(10);
		
		rentCarCustomerFirstNameTextField = new JTextField();
		rentCarCustomerFirstNameTextField.setEditable(false);
		rentCarCustomerFirstNameTextField.setBounds(580, 254, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerFirstNameTextField);
		rentCarCustomerFirstNameTextField.setColumns(10);
		
		rentCarCustomerPhoneTextField = new JTextField();
		rentCarCustomerPhoneTextField.setEditable(false);
		rentCarCustomerPhoneTextField.setBounds(167, 317, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerPhoneTextField);
		rentCarCustomerPhoneTextField.setColumns(10);
		
		rentCarCustomerEmailTextField = new JTextField();
		rentCarCustomerEmailTextField.setEditable(false);
		rentCarCustomerEmailTextField.setBounds(167, 379, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerEmailTextField);
		rentCarCustomerEmailTextField.setColumns(10);
		
		rentCarCustomerPriceTextField = new JTextField();
		rentCarCustomerPriceTextField.setEditable(false);
		rentCarCustomerPriceTextField.setBounds(580, 379, 192, 20);
		rentCarChoseCustomerPanel.add(rentCarCustomerPriceTextField);
		rentCarCustomerPriceTextField.setColumns(10);
		
		JLabel lblTc = new JLabel("T.C. Kimlik Numarasý :");
		lblTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTc.setBounds(29, 256, 128, 14);
		rentCarChoseCustomerPanel.add(lblTc);
		
		JLabel lblNewLabel = new JLabel("Ýsim :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(537, 256, 33, 14);
		rentCarChoseCustomerPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Soyisim :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(517, 319, 53, 14);
		rentCarChoseCustomerPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon Numarasý :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(47, 319, 110, 14);
		rentCarChoseCustomerPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(117, 381, 40, 14);
		rentCarChoseCustomerPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ödenecek Tutar :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(470, 381, 100, 14);
		rentCarChoseCustomerPanel.add(lblNewLabel_5);
		

		
		JPanel rentCarCalculatePanel = new JPanel();
		rentCarCalculatePanel.setLayout(null);
		rentCarCalculatePanel.setBorder(new TitledBorder(null, "Fiyat Hesapla", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rentCarCalculatePanel.setBounds(10, 11, 869, 489);
		rootPane.add(rentCarCalculatePanel);
		
		showPriceTextField = new JTextField();
		showPriceTextField.setEnabled(false);
		showPriceTextField.setDisabledTextColor(Color.BLACK);
		showPriceTextField.setColumns(10);
		showPriceTextField.setBounds(380, 306, 104, 20);
		rentCarCalculatePanel.add(showPriceTextField);
		
		JCalendar calendarRentCar = new JCalendar();
		calendarRentCar.setBounds(159, 110, 191, 153);
		rentCarCalculatePanel.add(calendarRentCar);
		calendarRentCar.setMinSelectableDate(new Date());
		
		JCalendar calendarRetrieveCar = new JCalendar();
		calendarRetrieveCar.setBounds(525, 110, 191, 153);
		rentCarCalculatePanel.add(calendarRetrieveCar);
		calendarRetrieveCar.setMinSelectableDate(new Date());
		
		
		JButton priceCalculateButton = new JButton("Hesapla");
		priceCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result;
				int day = calendarRetrieveCar.getDayChooser().getDay() - calendarRentCar.getDayChooser().getDay();
				
				if(day <= 3) {
					result = pricePerDay * day;
				}else if (day > 3 && day <= 7) {
					result = pricePerDay * day * 9/10;
				}else {
					result = pricePerDay * day * 8/10;
				}
				showPriceTextField.setText("" + result);
			}
		});
		priceCalculateButton.setBounds(380, 337, 104, 23);
		rentCarCalculatePanel.add(priceCalculateButton);
		
		JLabel lblNewLabel_1 = new JLabel("Veriþ Tarihi");
		lblNewLabel_1.setBounds(222, 85, 76, 14);
		rentCarCalculatePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alýþ Tarihi");
		lblNewLabel_1_1.setBounds(588, 85, 76, 14);
		rentCarCalculatePanel.add(lblNewLabel_1_1);
		
		JButton rentCarNextButton = new JButton("Devam Et");
		rentCarNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rentCarCalculatePanel.setVisible(false);
				rentCarChoseCustomerPanel.setVisible(true);
				
				FindCustomers findCustomers = new FindCustomers();
				List customers = findCustomers.getCustomers();
				
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

				for (Iterator iterator = customers.iterator(); iterator.hasNext();i++){
					
		            Customer newCustomer = (Customer) iterator.next(); 
		            tableModel.addRow(new Object[]{newCustomer.getcustomerTc() , newCustomer.getcustomerFirstName() , newCustomer.getcustomerLastName() , newCustomer.getcustomerEmail() , 
		            		newCustomer.getcustomerPhoneNumber() , newCustomer.getcustomerAddress() , newCustomer.getcustomerGender() , newCustomer.getcustomerJob() , 
		            		newCustomer.getcustomerBirthdate() , newCustomer.getcustomerLicence() , newCustomer.getcustomerLicenceNo() , newCustomer.getcustomerNotes()});
		            
		            if( i == 0 ) {
		            	
			        	rentCarCustomerTcTextField.setText(newCustomer.getcustomerTc());
			        	rentCarCustomerEmailTextField.setText(newCustomer.getcustomerEmail());
			        	rentCarCustomerFirstNameTextField.setText(newCustomer.getcustomerFirstName());
			        	rentCarCustomerLastNameTextField.setText(newCustomer.getcustomerLastName());
			        	rentCarCustomerPhoneTextField.setText(newCustomer.getcustomerPhoneNumber());
			        	
			        	double result;
						int day = calendarRetrieveCar.getDayChooser().getDay() - calendarRentCar.getDayChooser().getDay();
						
						if(day <= 3) {
							result = pricePerDay * day;
						}else if (day > 3 && day <= 7) {
							result = pricePerDay * day * 9/10;
						}else {
							result = pricePerDay * day * 8/10;
						}
						rentCarCustomerPriceTextField.setText("" + result);
			        	
		            }
		            
				}
				
				
				chooseCustomerRentCarTable.setModel(tableModel);
				chooseCustomerRentCarScrollPane.setViewportView(chooseCustomerRentCarTable);
				chooseCustomerRentCarTable.changeSelection(0, 0, false, false);
				
			}
		});
		rentCarNextButton.setBounds(380, 455, 104, 23);
		rentCarCalculatePanel.add(rentCarNextButton);
		chooseCustomerRentCarTable.changeSelection(0, 0, false, false);
		
		
		JButton rentCarFinishButton = new JButton("Bitir");
		rentCarFinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tcText = rentCarCustomerTcTextField.getText();
				
				String phoneNumberText = rentCarCustomerPhoneTextField.getText();
				
				String emailText = rentCarCustomerEmailTextField.getText();
				
				FindCars findCars = new FindCars();
				
				List setCarRent = findCars.getCarSetRent(carPlate);
				
				Session sessionRent = HibernateUtilCar.getSessionFactory().openSession();
				
				Transaction trast =sessionRent.beginTransaction();
				
				
				for (Iterator iterator = setCarRent.iterator(); iterator.hasNext();){
					
		            Car newCar = (Car) iterator.next(); 
		            
		            Car car = new Car(newCar.getPlate(), newCar.getBrand(), newCar.getModel(), newCar.getYear(), newCar.getFuel(), 
		            		newCar.getGear(), newCar.getEngine(), newCar.getTraction(), newCar.getDoor(), newCar.getColor(),
		            		newCar.getKm(), newCar.getBody(), newCar.getDamageStatus(), newCar.getPicture(), true, newCar.getPricePerDay());
		            
		            sessionRent.update(car);
		            
				}
				
	            sessionRent.getTransaction().commit();
				
				sessionRent.close();

				Rent rent = new Rent(tcText, emailText, phoneNumberText, carPlate, rentCarCustomerPriceTextField.getText(), calendarRentCar.getDate(), calendarRetrieveCar.getDate());
						
				Session session = HibernateUtilRent.getSessionFactory().openSession();
						
				Transaction tx = session.beginTransaction();
						
				session.saveOrUpdate(rent);
						
				session.getTransaction().commit();
						
				session.close();
						
				JOptionPane.showMessageDialog(RentCar.this, "Kayýt baþarýlý.","Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		rentCarFinishButton.setBounds(414, 455, 89, 23);
		rentCarChoseCustomerPanel.add(rentCarFinishButton);
	}
}
