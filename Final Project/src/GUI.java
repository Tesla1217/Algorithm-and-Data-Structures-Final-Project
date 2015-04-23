import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame {

	private static ArrayList<Pet> pets = new ArrayList<Pet>();
	private static ArrayList<Pet> pending = new ArrayList<Pet>();
	private static ArrayList<Pet> search = new ArrayList<Pet>();
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static ArrayList<Buyer> buyers = new ArrayList<Buyer>();

	private static Buyer loggedIn;
	private static Pet selectedPet;
	private static Admin selectedAdmin;
	private static Buyer selectedBuyer;
	private static boolean isAdmin;

	private DefaultListModel<String> searchResult = new DefaultListModel<String>();
	private DefaultListModel<String> toBe = new DefaultListModel<String>();
	private DefaultListModel<String> pet = new DefaultListModel<String>();
	private DefaultListModel<String> user = new DefaultListModel<String>();

	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtUsername_1;
	private JTextField txtEmail;
	private JPasswordField pwdPassword_1;
	private JTextField txtspecies;
	private JTextField txtBreed;
	private JTextField txtColor;
	private JTextField txtAge;
	private JTextField txtSize;
	private JTextField txtUsername_2;
	private JTextField txtEmail_1;
	private JPasswordField pwdPassword_2;
	private final JPanel editUser = new JPanel();
	private JTextField txtName;
	private JTextField txtSpecies;
	private JTextField txtBreed_1;
	private JTextField txtColor_1;
	private JTextField txtAge_1;
	private JTextField txtSize_1;
	private JTextField txtUsername_3;
	private JTextField txtEmail_2;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Admin admin = new Admin("Admin", "password", "it@petcel.com");
		admins.add(admin);
		Buyer buyer = new Buyer("Tester", "testing", "test@test.test");
		buyers.add(buyer);
		
		randomGen();

		selectedPet = pets.get(0);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Petcel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel Startpage = new JPanel();
		getContentPane().add(Startpage, "name_63803443844434");
		Startpage.setLayout(null);

		JPanel Login = new JPanel();
		getContentPane().add(Login, "name_64026748277919");
		Login.setLayout(null);

		JPanel NewUser = new JPanel();
		getContentPane().add(NewUser, "name_64675839362850");
		NewUser.setLayout(null);

		JPanel AdminPanel = new JPanel();
		getContentPane().add(AdminPanel, "name_66000421503226");
		AdminPanel.setLayout(null);

		JPanel AdoptSearch = new JPanel();
		getContentPane().add(AdoptSearch, "name_69523913349441");
		AdoptSearch.setLayout(null);

		JPanel Adopt = new JPanel();
		getContentPane().add(Adopt, "name_83667589830663");
		Adopt.setLayout(null);

		JPanel NewAdoption = new JPanel();
		getContentPane().add(NewAdoption, "name_85847064623792");
		NewAdoption.setLayout(null);

		JPanel addPet = new JPanel();
		getContentPane().add(addPet, "name_88459203897581");
		addPet.setLayout(null);

		JPanel petSelector = new JPanel();
		getContentPane().add(petSelector, "name_89524709356220");
		petSelector.setLayout(null);

		JPanel addUser = new JPanel();
		getContentPane().add(addUser, "name_91006323948918");
		addUser.setLayout(null);

		JPanel userSelector = new JPanel();
		getContentPane().add(userSelector, "name_91713203735229");
		userSelector.setLayout(null);

		JPanel editPet = new JPanel();
		getContentPane().add(editPet, "name_94046765316076");
		editPet.setLayout(null);

		JButton button_3 = new JButton("Exit");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSelector.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button_3.setBounds(21, 358, 200, 150);
		userSelector.add(button_3);

		JLabel lblUserSelector = new JLabel("Users:");
		lblUserSelector.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserSelector.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblUserSelector.setBounds(270, 21, 619, 95);
		userSelector.add(lblUserSelector);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(270, 137, 619, 250);
		userSelector.add(scrollPane_3);

		JList<String> list = new JList<String>(user);
		list.setFont(new Font("Tahoma", Font.PLAIN, 35));
		scrollPane_3.setViewportView(list);

		txtUsername_3 = new JTextField();
		txtUsername_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtUsername_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername_3.setText("Username");
		txtUsername_3.setBounds(300, 172, 600, 60);
		editUser.add(txtUsername_3);
		txtUsername_3.setColumns(10);

		txtEmail_2 = new JTextField();
		txtEmail_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtEmail_2.setText("Email");
		txtEmail_2.setBounds(300, 253, 600, 60);
		editUser.add(txtEmail_2);
		txtEmail_2.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setBounds(300, 334, 600, 60);
		editUser.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isAdmin(list.getSelectedValue())) {
					selectedAdmin = getAdmin(list.getSelectedValue());
					txtUsername_3.setText(selectedAdmin.getUsername());
					txtEmail_2.setText(selectedAdmin.getEmail());
					txtPassword.setText(selectedAdmin.getPassword());
				} else {
					selectedBuyer = getBuyer(list.getSelectedValue());
					txtUsername_3.setText(selectedBuyer.getUsername());
					txtEmail_2.setText(selectedBuyer.getEmail());
					txtPassword.setText(selectedBuyer.getPassword());
				}
				userSelector.setVisible(false);
				editUser.setVisible(true);
			}
		});
		btnEdit_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnEdit_1.setBounds(270, 416, 287, 74);
		userSelector.add(btnEdit_1);

		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeUser(list.getSelectedValue());
				user.removeElement(list.getSelectedValue());

			}
		});
		btnRemove_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnRemove_1.setBounds(578, 416, 311, 74);
		userSelector.add(btnRemove_1);
		
		JButton button_6 = new JButton("Back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSelector.setVisible(false);
				AdminPanel.setVisible(true);
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_6.setBounds(21, 21, 200, 150);
		userSelector.add(button_6);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(267, 127, 594, 260);
		petSelector.add(scrollPane_2);

		JList<String> petList = new JList<String>(pet);
		petList.setFont(new Font("Tahoma", Font.PLAIN, 30));
		scrollPane_2.setViewportView(petList);

		JLabel lblPets = new JLabel("Pets:");
		lblPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblPets.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblPets.setBounds(267, 21, 594, 78);
		petSelector.add(lblPets);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPet = findPet(petList.getSelectedValue());
				txtName.setText(selectedPet.getName());
				txtSpecies.setText(selectedPet.getType());
				txtBreed_1.setText(selectedPet.getBreed());
				txtColor_1.setText(selectedPet.getColor());
				txtAge_1.setText(Integer.toString(selectedPet.getAge()));
				String length = "";
				switch (selectedPet.getSize()) {
				case 1:
					length = "Small";
					break;
				case 2:
					length = "Medium";
					break;
				case 3:
					length = "Large";
					break;
				case 4:
					length = "Extra Large";
					break;
				}
				txtSize_1.setText(length);
				petSelector.setVisible(false);
				editPet.setVisible(true);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnEdit.setBounds(267, 408, 276, 78);
		petSelector.add(btnEdit);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePet(petList.getSelectedValue());
				pet.removeElement(petList.getSelectedValue());
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnRemove.setBounds(564, 408, 297, 78);
		petSelector.add(btnRemove);

		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petSelector.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_1.setBounds(21, 358, 200, 150);
		petSelector.add(button_1);
		
		JButton button_8 = new JButton("Back");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petSelector.setVisible(false);
				AdminPanel.setVisible(true);
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_8.setBounds(21, 21, 200, 150);
		petSelector.add(button_8);

		txtUsername_1 = new JTextField();
		txtUsername_1.setToolTipText("Username");
		txtUsername_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtUsername_1.setText("Username");
		txtUsername_1.setBounds(288, 176, 530, 62);
		NewUser.add(txtUsername_1);
		txtUsername_1.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email, must contain the @ sign");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtEmail.setText("Email");
		txtEmail.setBounds(288, 259, 530, 62);
		NewUser.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblWelcome.setBounds(288, 21, 530, 105);
		NewUser.add(lblWelcome);

		JLabel lblPleaseEnterValid = new JLabel(
				"Please enter valid Email or Password");
		lblPleaseEnterValid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterValid.setBounds(288, 129, 530, 26);
		lblPleaseEnterValid.setForeground(Color.RED);
		lblPleaseEnterValid.setVisible(false);
		NewUser.add(lblPleaseEnterValid);

		JButton btnFinished = new JButton("Register");
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = "";
				for (char i : pwdPassword_1.getPassword()) {
					pass += i;
				}
				if (txtEmail.getText().contains("@") && pass.length() > 3) {
					Buyer temp = new Buyer(txtUsername_1.getText(), pass,
							txtEmail.getText());
					loggedIn = temp;
					buyers.add(temp);
					NewUser.setVisible(false);
					AdoptSearch.setVisible(true);
				} else {
					lblPleaseEnterValid.setVisible(true);
				}
			}
		});
		btnFinished.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnFinished.setBounds(446, 440, 205, 68);
		NewUser.add(btnFinished);

		pwdPassword_1 = new JPasswordField();
		pwdPassword_1.setToolTipText("Password");
		pwdPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		pwdPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword_1.setText("Password");
		pwdPassword_1.setBounds(288, 342, 530, 62);
		NewUser.add(pwdPassword_1);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUser.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		btnExit.setBounds(21, 358, 200, 150);
		NewUser.add(btnExit);

		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 36));
		txtUsername.setText("Username");
		txtUsername.setBounds(289, 224, 502, 64);
		Login.add(txtUsername);
		txtUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setToolTipText("Password");
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 36));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(289, 322, 502, 65);
		Login.add(pwdPassword);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblNewLabel.setBounds(278, 21, 513, 122);
		Login.add(lblNewLabel);

		JLabel lblPleaseEnterThe = new JLabel(
				"Please enter the correct Username and Password");
		lblPleaseEnterThe.setForeground(Color.RED);
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe.setBounds(288, 164, 503, 39);
		Login.add(lblPleaseEnterThe);
		lblPleaseEnterThe.setVisible(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int logins = login(txtUsername.getText(),
						pwdPassword.getPassword());
				switch (logins) {
				case 0:
					Login.setVisible(false);
					AdoptSearch.setVisible(true);
					txtUsername.setText("Username");
					pwdPassword.setText("Password");
					lblPleaseEnterThe.setVisible(false);
					break;
				case 1:
					for (int i = 0; i < pending.size(); i++) {
						toBe.addElement(pending.get(i).getName() + " "
								+ pending.get(i).getAdopter().getUsername());
					}
					Login.setVisible(false);
					AdminPanel.setVisible(true);
					txtUsername.setText("Username");
					pwdPassword.setText("Password");
					lblPleaseEnterThe.setVisible(false);
					break;
				default:
					lblPleaseEnterThe.setVisible(true);
					break;
				}

				// lblPleaseEnterThe.setVisible(true);
				// Login.setVisible(false);
				// AdminPanel.setVisible(true);
			}
		});
		btnLogin.setToolTipText("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(385, 423, 305, 65);
		Login.add(btnLogin);

		JButton button = new JButton("Exit");
		button.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button.setBounds(21, 358, 200, 150);
		Login.add(button);

		JButton btnNewUser = new JButton("New User");
		btnNewUser.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Startpage.setVisible(false);
				NewUser.setVisible(true);
			}
		});
		btnNewUser.setBounds(216, 219, 233, 151);
		Startpage.add(btnNewUser);

		JButton btnExistingUser = new JButton("Existing User");
		btnExistingUser.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnExistingUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Startpage.setVisible(false);
				Login.setVisible(true);
			}
		});
		btnExistingUser.setBounds(733, 219, 233, 151);
		Startpage.add(btnExistingUser);

		JLabel lblPetcel = new JLabel("Petcel");
		lblPetcel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetcel.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblPetcel.setBounds(447, 35, 289, 170);
		Startpage.add(lblPetcel);

		JLabel lblAdoptionApproval = new JLabel("Adoption approval:");
		lblAdoptionApproval.setBounds(31, 21, 298, 79);
		lblAdoptionApproval.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdoptionApproval.setFont(new Font("Tahoma", Font.PLAIN, 34));
		AdminPanel.add(lblAdoptionApproval);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 99, 298, 330);
		AdminPanel.add(scrollPane);

		JList<String> toBeAdopted = new JList<String>(toBe);
		toBeAdopted.setToolTipText("Adoption List");
		toBeAdopted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		scrollPane.setViewportView(toBeAdopted);

		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(toBeAdopted.getSelectedValue() != null){
					approveAdoptin(toBeAdopted.getSelectedValue());
					toBe.removeElement(toBeAdopted.getSelectedValue());
				}
			}
		});
		btnApprove.setToolTipText("Approve Adoption");
		btnApprove.setBounds(31, 439, 298, 51);
		btnApprove.setFont(new Font("Tahoma", Font.BOLD, 26));
		AdminPanel.add(btnApprove);

		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.setVisible(false);
				addPet.setVisible(true);
			}
		});
		btnAddPet.setBounds(387, 99, 200, 150);
		AdminPanel.add(btnAddPet);

		JButton btnRemovePet = new JButton("Pet Selector");
		btnRemovePet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnRemovePet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.setVisible(false);
				pet.removeAllElements();
				for (int i = 0; i < pets.size(); i++) {
					String length = "";
					switch (pets.get(i).getSize()) {
					case 1:
						length = "Small";
						break;
					case 2:
						length = "Medium";
						break;
					case 3:
						length = "Large";
						break;
					case 4:
						length = "Extra Large";
						break;
					}
					pet.addElement(pets.get(i).getName() + " | "
							+ pets.get(i).getType() + " | "
							+ pets.get(i).getBreed() + " | "
							+ pets.get(i).getColor() + " | "
							+ pets.get(i).getAge() + " | " + length);
				}
				petSelector.setVisible(true);
			}
		});
		btnRemovePet.setBounds(608, 99, 298, 150);
		AdminPanel.add(btnRemovePet);

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.setVisible(false);
				addUser.setVisible(true);
			}
		});
		btnAddUser.setBounds(387, 270, 200, 150);
		AdminPanel.add(btnAddUser);

		JButton btnRemoveUser = new JButton("User Selector");
		btnRemoveUser.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.removeAllElements();
				for (int i = 0; i < buyers.size(); i++) {
					user.addElement(buyers.get(i).getUsername() + " | "
							+ buyers.get(i).getEmail() + " | "
							+ buyers.get(i).getPassword());
				}
				for (int i = 0; i < admins.size(); i++) {
					user.addElement(admins.get(i).getUsername() + " | "
							+ admins.get(i).getEmail() + " | "
							+ admins.get(i).getPassword());
				}
				AdminPanel.setVisible(false);
				userSelector.setVisible(true);
			}
		});
		btnRemoveUser.setBounds(608, 270, 298, 150);
		AdminPanel.add(btnRemoveUser);

		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		btnExit_1.setBounds(953, 358, 200, 150);
		AdminPanel.add(btnExit_1);

		JComboBox species = new JComboBox();
		species.setFont(new Font("Tahoma", Font.PLAIN, 30));
		species.setModel(new DefaultComboBoxModel(new String[] {
				"Species (All)", "Dog", "Cat", "Fish", "Bird" }));
		species.setBounds(392, 159, 377, 39);
		AdoptSearch.add(species);

		JComboBox breed = new JComboBox();
		breed.setFont(new Font("Tahoma", Font.PLAIN, 30));
		breed.setModel(new DefaultComboBoxModel(new String[] {"Breed (All)", "Dogs:", "German Shepard", "Husky", "Lab", "Cats:", "Persian", "Siamese", "Main Coon", "Fish:", "Goldfish", "Betta", "Clownfish", "Birds:", "Bald Eagle", "Hawk", "Parrot"}));
		breed.setBounds(392, 219, 377, 39);
		AdoptSearch.add(breed);

		JComboBox color = new JComboBox();
		color.setFont(new Font("Tahoma", Font.PLAIN, 30));
		color.setModel(new DefaultComboBoxModel(new String[] {"Color (All)", "Black", "Brown", "White", "Yellow", "Golden"}));
		color.setBounds(392, 279, 377, 39);
		AdoptSearch.add(color);

		JComboBox age = new JComboBox();
		age.setFont(new Font("Tahoma", Font.PLAIN, 30));
		age.setModel(new DefaultComboBoxModel(new String[] { "Age (All)", "0",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15" }));
		age.setBounds(392, 339, 110, 32);
		AdoptSearch.add(age);

		JComboBox size = new JComboBox();
		size.setFont(new Font("Tahoma", Font.PLAIN, 30));
		size.setModel(new DefaultComboBoxModel(new String[] { "Size (All)",
				"Small", "Medium", "Large", "Extra Large" }));
		size.setBounds(523, 339, 246, 32);
		AdoptSearch.add(size);

		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String species1 = "";
				String breed1 = "";
				String color1 = "";
				int age1 = 0;
				int size1 = 0;
				if (species.getSelectedItem().toString().contains("All")){
					species1 = null;
				}
				else{
					species1 = species.getSelectedItem().toString();
				}
				if (breed.getSelectedItem().toString().contains("All")){
					breed1 = null;
				}
				else{
					breed1 = breed.getSelectedItem().toString();
				}
				if (color.getSelectedItem().toString().contains("All")){
					color1 = null;
				}
				else{
					color1 = color.getSelectedItem().toString();
				}
				if (age.getSelectedItem().toString().contains("All")){
					age1 = -1;
				}
				else{
					age1 = Integer.parseInt(age.getSelectedItem().toString());
				}
				if (size.getSelectedItem().toString().contains("All")){
					size1 = -1;
				}
				else {
					switch(size.getSelectedItem().toString()){
						case "Small":
							size1 = 1;
							break;
						case "Medium":
							size1 = 2;
							break;
						case "Large":
							size1 = 3;
							break;
						case "Extra Large":
							size1 = 4;
							break;
					}
				}
				search = Search.search(pets, species1, breed1, color1, age1,
						size1);
				for (int i = 0; i < search.size(); i++) {
					String length = "";
					switch (search.get(i).getSize()) {
					case 1:
						length = "Small";
						break;
					case 2:
						length = "Medium";
						break;
					case 3:
						length = "Large";
						break;
					case 4:
						length = "Extra Large";
						break;
					}
					searchResult.addElement(search.get(i).getName() + " | "
							+ search.get(i).getType() + " | "
							+ search.get(i).getBreed() + " | "
							+ search.get(i).getColor() + " | "
							+ search.get(i).getAge() + " | " + length);
				}
				AdoptSearch.setVisible(false);
				Adopt.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnSearch.setBounds(392, 392, 377, 94);
		AdoptSearch.add(btnSearch);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(392, 63, 377, 75);
		AdoptSearch.add(lblSearch);

		JButton btnExit_2 = new JButton("Exit");
		btnExit_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnExit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptSearch.setVisible(false);
				searchResult.removeAllElements();
				loggedIn = null;
				Startpage.setVisible(true);
			}
		});
		btnExit_2.setBounds(21, 358, 200, 150);
		AdoptSearch.add(btnExit_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 131, 600, 300);
		Adopt.add(scrollPane_1);

		JList<String> AdoptList = new JList<String>(searchResult);
		AdoptList.setFont(new Font("Tahoma", Font.PLAIN, 30));
		scrollPane_1.setViewportView(AdoptList);

		JLabel lblSearchResults = new JLabel("Search Results:");
		lblSearchResults.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setBounds(250, 39, 600, 71);
		Adopt.add(lblSearchResults);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult.removeAllElements();
				Adopt.setVisible(false);
				AdoptSearch.setVisible(true);
			}
		});
		btnBack.setBounds(21, 21, 141, 71);
		Adopt.add(btnBack);

		JButton btnAdopt = new JButton("Adopt");
		btnAdopt.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnAdopt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adoptPet(AdoptList.getSelectedValue());
				Adopt.setVisible(false);
				NewAdoption.setVisible(true);
			}
		});
		btnAdopt.setBounds(453, 452, 212, 58);
		Adopt.add(btnAdopt);

		JButton btnExit_3 = new JButton("Exit");
		btnExit_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnExit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adopt.setVisible(false);
				searchResult.removeAllElements();
				loggedIn = null;
				Startpage.setVisible(true);
			}
		});
		btnExit_3.setBounds(21, 360, 200, 150);
		Adopt.add(btnExit_3);

		JLabel lblCongragulationsYouHave = new JLabel(
				"You have just placed an adoption request!");
		lblCongragulationsYouHave.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCongragulationsYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongragulationsYouHave.setBounds(219, 257, 735, 64);
		NewAdoption.add(lblCongragulationsYouHave);

		JLabel lblCongragulations = new JLabel("Congragulations!");
		lblCongragulations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongragulations.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblCongragulations.setBounds(219, 91, 735, 215);
		NewAdoption.add(lblCongragulations);

		JLabel lblPleaseWaitFor = new JLabel(
				"Please wait for the request to be approved.");
		lblPleaseWaitFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWaitFor.setBounds(219, 470, 735, 38);
		NewAdoption.add(lblPleaseWaitFor);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewAdoption.setVisible(false);
				searchResult.removeAllElements();
				AdoptSearch.setVisible(true);
			}
		});
		btnSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSearch_1.setBounds(21, 21, 200, 150);
		NewAdoption.add(btnSearch_1);

		JButton btnExit_4 = new JButton("Exit");
		btnExit_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAdoption.setVisible(false);
				searchResult.removeAllElements();
				loggedIn = null;
				Startpage.setVisible(true);
			}
		});
		btnExit_4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnExit_4.setBounds(953, 21, 200, 150);
		NewAdoption.add(btnExit_4);

		JLabel lblAddAPet = new JLabel("Add a Pet:");
		lblAddAPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAPet.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblAddAPet.setBounds(250, 21, 630, 100);
		addPet.add(lblAddAPet);

		txtspecies = new JTextField();
		txtspecies.setHorizontalAlignment(SwingConstants.CENTER);
		txtspecies.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtspecies.setText("Species");
		txtspecies.setBounds(350, 170, 400, 40);
		addPet.add(txtspecies);
		txtspecies.setColumns(10);

		txtBreed = new JTextField();
		txtBreed.setHorizontalAlignment(SwingConstants.CENTER);
		txtBreed.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtBreed.setText("Breed");
		txtBreed.setBounds(350, 231, 400, 40);
		addPet.add(txtBreed);
		txtBreed.setColumns(10);

		txtColor = new JTextField();
		txtColor.setHorizontalAlignment(SwingConstants.CENTER);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtColor.setText("Color");
		txtColor.setBounds(350, 292, 400, 40);
		addPet.add(txtColor);
		txtColor.setColumns(10);

		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setText("Age");
		txtAge.setBounds(350, 353, 140, 40);
		addPet.add(txtAge);
		txtAge.setColumns(10);

		txtSize = new JTextField();
		txtSize.setHorizontalAlignment(SwingConstants.CENTER);
		txtSize.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtSize.setText("Size");
		txtSize.setBounds(511, 353, 239, 40);
		addPet.add(txtSize);
		txtSize.setColumns(10);

		JLabel lblPleaseEnterValid_1 = new JLabel(
				"Please enter valid Size or Age");
		lblPleaseEnterValid_1.setForeground(Color.RED);
		lblPleaseEnterValid_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterValid_1.setBounds(350, 121, 400, 40);
		lblPleaseEnterValid_1.setVisible(false);
		addPet.add(lblPleaseEnterValid_1);

		JButton btnAddPet_1 = new JButton("Add Pet");
		btnAddPet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String size = txtSize.getText().toLowerCase();

				if (isInteger(txtAge.getText())
						&& Integer.parseInt(txtAge.getText()) >= 0
						&& (size.equals("small") || size.equals("medium")
								|| size.equals("large") || size
									.equals("extra large"))) {
					addPet.setVisible(false);
					pet.removeAllElements();
					for (int i = 0; i < pets.size(); i++) {
						String length = "";
						switch (pets.get(i).getSize()) {
						case 1:
							length = "Small";
							break;
						case 2:
							length = "Medium";
							break;
						case 3:
							length = "Large";
							break;
						case 4:
							length = "Extra Large";
							break;
						}
						pet.addElement(pets.get(i).getName() + " | "
								+ pets.get(i).getType() + " | "
								+ pets.get(i).getBreed() + " | "
								+ pets.get(i).getColor() + " | "
								+ pets.get(i).getAge() + " | " + length);
					}
					petSelector.setVisible(true);
				} else {
					lblPleaseEnterValid_1.setVisible(true);
				}
			}
		});
		btnAddPet_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnAddPet_1.setBounds(350, 414, 400, 83);
		addPet.add(btnAddPet_1);

		JButton btnExit_5 = new JButton("Exit");
		btnExit_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnExit_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPet.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		btnExit_5.setBounds(21, 358, 200, 150);
		addPet.add(btnExit_5);
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPet.setVisible(false);
				AdminPanel.setVisible(true);
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_7.setBounds(21, 21, 200, 150);
		addPet.add(button_7);

		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_2.setBounds(21, 358, 200, 150);
		addUser.add(button_2);

		JLabel lblAddAUser = new JLabel("Add a User:");
		lblAddAUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAUser.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblAddAUser.setBounds(250, 21, 630, 100);
		addUser.add(lblAddAUser);

		txtUsername_2 = new JTextField();
		txtUsername_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtUsername_2.setText("Username");
		txtUsername_2.setBounds(250, 181, 630, 66);
		addUser.add(txtUsername_2);
		txtUsername_2.setColumns(10);

		txtEmail_1 = new JTextField();
		txtEmail_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtEmail_1.setText("Email");
		txtEmail_1.setBounds(250, 268, 630, 66);
		addUser.add(txtEmail_1);
		txtEmail_1.setColumns(10);

		pwdPassword_2 = new JPasswordField();
		pwdPassword_2.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pwdPassword_2.setText("Password");
		pwdPassword_2.setBounds(250, 355, 630, 66);
		addUser.add(pwdPassword_2);

		JLabel lblPleaseEnterValid_2 = new JLabel(
				"Please enter valid Email and Password");
		lblPleaseEnterValid_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPleaseEnterValid_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterValid_2.setForeground(Color.RED);
		lblPleaseEnterValid_2.setBounds(250, 117, 630, 43);
		lblPleaseEnterValid_2.setVisible(false);
		addUser.add(lblPleaseEnterValid_2);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = "";
				for (char i : pwdPassword_2.getPassword()) {
					pass += i;
				}
				if (txtEmail_1.getText().contains("@") && pass.length() > 3) {
					Buyer temp = new Buyer(txtUsername_2.getText(), pass,
							txtEmail_1.getText());
					buyers.add(temp);
				} else {
					lblPleaseEnterValid_2.setVisible(true);
				}

				user.removeAllElements();
				for (int i = 0; i < buyers.size(); i++) {
					user.addElement(buyers.get(i).getUsername() + " | "
							+ buyers.get(i).getEmail() + " | "
							+ buyers.get(i).getPassword());
				}
				for (int i = 0; i < admins.size(); i++) {
					user.addElement(admins.get(i).getUsername() + " | "
							+ admins.get(i).getEmail() + " | "
							+ admins.get(i).getPassword());
				}
				addUser.setVisible(false);
				userSelector.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAdd.setBounds(430, 442, 272, 66);
		addUser.add(btnAdd);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser.setVisible(false);
				AdminPanel.setVisible(true);
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnBack_1.setBounds(21, 21, 200, 150);
		addUser.add(btnBack_1);

		JButton button_4 = new JButton("Exit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPet.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_4.setBounds(21, 358, 200, 150);
		editPet.add(button_4);

		JLabel lblPetEditor = new JLabel("Pet Editor:");
		lblPetEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetEditor.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblPetEditor.setBounds(300, 21, 594, 114);
		editPet.add(lblPetEditor);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtName.setText("Name");
		txtName.setBounds(300, 127, 594, 53);
		editPet.add(txtName);
		txtName.setColumns(10);

		txtSpecies = new JTextField();
		txtSpecies.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpecies.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtSpecies.setText("Species");
		txtSpecies.setBounds(300, 201, 594, 53);
		editPet.add(txtSpecies);
		txtSpecies.setColumns(10);

		txtBreed_1 = new JTextField();
		txtBreed_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBreed_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtBreed_1.setText("Breed");
		txtBreed_1.setBounds(300, 275, 594, 53);
		editPet.add(txtBreed_1);
		txtBreed_1.setColumns(10);

		txtColor_1 = new JTextField();
		txtColor_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtColor_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtColor_1.setText("Color");
		txtColor_1.setBounds(300, 338, 594, 53);
		editPet.add(txtColor_1);
		txtColor_1.setColumns(10);

		txtAge_1 = new JTextField();
		txtAge_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtAge_1.setText("Age");
		txtAge_1.setBounds(300, 409, 275, 53);
		editPet.add(txtAge_1);
		txtAge_1.setColumns(10);

		txtSize_1 = new JTextField();
		txtSize_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSize_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtSize_1.setText("Size");
		txtSize_1.setBounds(596, 409, 298, 53);
		editPet.add(txtSize_1);
		txtSize_1.setColumns(10);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int petLoc = pets.indexOf(selectedPet);
				String size = txtSize_1.getText().toLowerCase();
				if (isInteger(txtAge_1.getText())
						&& Integer.parseInt(txtAge_1.getText()) >= 0
						&& (size.equals("small") || size.equals("medium")
								|| size.equals("large") || size
									.equals("extra large"))) {
					pets.get(petLoc).setName(txtName.getText());
					pets.get(petLoc).setType(txtSpecies.getText());
					pets.get(petLoc).setBreed(txtBreed_1.getText());
					pets.get(petLoc).setColor(txtColor_1.getText());
					pets.get(petLoc).setAge(
							Integer.parseInt((txtAge_1.getText())));
					int size5 = 0;
					switch (size) {
					case "small":
						size5 = 1;
						break;
					case "medium":
						size5 = 2;
						break;
					case "large":
						size5 = 3;
						break;
					case "extra large":
						size5 = 4;
						break;
					}
					pets.get(petLoc).setSize(size5);
					editPet.setVisible(false);

					petSelector.setVisible(true);
				}
				pet.removeAllElements();
				for (int i = 0; i < pets.size(); i++) {
					String length = "";
					switch (pets.get(i).getSize()) {
					case 1:
						length = "Small";
						break;
					case 2:
						length = "Medium";
						break;
					case 3:
						length = "Large";
						break;
					case 4:
						length = "Extra Large";
						break;
					}
					pet.addElement(pets.get(i).getName() + " | "
							+ pets.get(i).getType() + " | "
							+ pets.get(i).getBreed() + " | "
							+ pets.get(i).getColor() + " | "
							+ pets.get(i).getAge() + " | " + length);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnNewButton.setBounds(953, 358, 200, 150);
		editPet.add(btnNewButton);
		
		JButton button_9 = new JButton("Back");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPet.setVisible(false);
				petSelector.setVisible(true);
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_9.setBounds(21, 21, 200, 150);
		editPet.add(button_9);
		getContentPane().add(editUser, "name_94086793681125");
		editUser.setLayout(null);

		JButton button_5 = new JButton("Exit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editUser.setVisible(false);
				Startpage.setVisible(true);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_5.setBounds(21, 358, 200, 150);
		editUser.add(button_5);

		JLabel lblUserEditor = new JLabel("User Editor:");
		lblUserEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserEditor.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblUserEditor.setBounds(300, 21, 600, 110);
		editUser.add(lblUserEditor);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter a valid Email and Password");
		lblPleaseEnterA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterA.setForeground(Color.RED);
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPleaseEnterA.setBounds(300, 125, 600, 40);
		lblPleaseEnterA.setVisible(false);
		editUser.add(lblPleaseEnterA);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(txtEmail_2.getText() + " " + txtPassword.getText());
				if (txtEmail_2.getText().contains("@") && txtPassword.getText().length() > 3) {
					System.out.println("stuff");
					if (isAdmin) {
						int adminLoc = admins.indexOf(selectedAdmin);

						admins.get(adminLoc).setUsername(txtUsername_3.getText());
						admins.get(adminLoc).setEmail(txtEmail_2.getText());
						admins.get(adminLoc).setPassword(txtPassword.getText());

					} else {
						int buyerLoc = buyers.indexOf(selectedBuyer);

						buyers.get(buyerLoc).setUsername(txtUsername_3.getText());
						buyers.get(buyerLoc).setEmail(txtEmail_2.getText());
						buyers.get(buyerLoc).setPassword(txtPassword.getText());

					}
					System.out.println("stuff");
					user.removeAllElements();
					for (int i = 0; i < buyers.size(); i++) {
						user.addElement(buyers.get(i).getUsername() + " | "
								+ buyers.get(i).getEmail() + " | "
								+ buyers.get(i).getPassword());
					}
					for (int i = 0; i < admins.size(); i++) {
						user.addElement(admins.get(i).getUsername() + " | "
								+ admins.get(i).getEmail() + " | "
								+ admins.get(i).getPassword());
					}
					System.out.println("stuff");
					editUser.setVisible(false);
					userSelector.setVisible(true);
				}else{
					lblPleaseEnterA.setVisible(true);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSave.setBounds(450, 415, 300, 79);
		editUser.add(btnSave);
		
		JButton button_10 = new JButton("Back");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editUser.setVisible(false);
				userSelector.setVisible(true);
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_10.setBounds(21, 21, 200, 150);
		editUser.add(button_10);
		
		

	}

	private int login(String user, char[] pass) {

		String password = "";
		for (char i : pass)
			password += i;

		for (int i = 0; i < admins.size(); i++) {
			if (admins.get(i).getUsername().equals(user)
					&& admins.get(i).getPassword().equals(password)) {
				return 1;
			}
		}

		for (int i = 0; i < buyers.size(); i++) {

			if (buyers.get(i).getUsername().equals(user)
					&& buyers.get(i).getPassword().equals(password)) {
				loggedIn = buyers.get(i);
				return 0;
			}
		}
		return -1;
	}

	private void removePet(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < pets.size(); i++)
			if (pets.get(i).getName().equals(name))
				pets.remove(pets.get(i));
	}

	private void adoptPet(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < pets.size(); i++)
			if (pets.get(i).getName().equals(name)) {
				System.out.println(loggedIn.getUsername());
				pets.get(i).setAdopter(loggedIn);
				pending.add(pets.get(i));
				pets.remove(pets.get(i));
			}
	}

	private Pet findPet(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < pets.size(); i++)
			if (pets.get(i).getName().equals(name))
				return (pets.get(i));
		return null;
	}

	private Admin getAdmin(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < admins.size(); i++)
			if (admins.get(i).getUsername().equals(name))
				return (admins.get(i));
		return null;
	}

	private Buyer getBuyer(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < buyers.size(); i++)
			if (buyers.get(i).getUsername().equals(name))
				return (buyers.get(i));
		return null;
	}

	private void approveAdoptin(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < pending.size(); i++)
			if (pending.get(i).getName().equals(name))
				pending.remove(pending.get(i));
	}

	private void removeUser(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < admins.size(); i++){
			if (admins.get(i).getUsername().equals(name)){
				admins.remove(admins.get(i));
			}
		}
		for (int i = 0; i < buyers.size(); i++){
			if (buyers.get(i).getUsername().equals(name)){
				buyers.remove(buyers.get(i));
			}
		}
	}

	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public boolean isAdmin(String name) {
		name = name.substring(0, name.indexOf(" "));
		for (int i = 0; i < admins.size(); i++){
			if (admins.get(i).getUsername().equals(name)) {
				isAdmin = true;
				return true;
			}
		}
		for (int i = 0; i < buyers.size(); i++){
			if (buyers.get(i).getUsername().equals(name)) {
				isAdmin = false;
				return false;
			}
		}
		return false;
	}
	
	public static void randomGen(){
		//Pets
		Random r = new Random();
		for(int i = 0; i <= 100; i++){
			String name = Integer.toString(i);
			String species = "";
			String breed = "";
			String color = "";
			int age = r.nextInt(16);
			int size = r.nextInt(4) + 1;
			int ran = r.nextInt(4);
			int ranBreed = 0;
			switch(ran){
				case 0:
					species = "dog";
					ranBreed = r.nextInt(3);
					break;
				case 1:
					species = "cat";
					ranBreed = r.nextInt(3) + 3;
					break;
				case 2:
					species = "fish";
					ranBreed = r.nextInt(3) + 6;
					break;
				case 3:
					species = "bird";
					ranBreed = r.nextInt(3) + 9;
					break;
			}
			switch(ranBreed){
				case 0:
					breed = "German Shepard";
					break;
				case 1:
					breed = "Husky";
					break;
				case 2:
					breed = "Lab";
					break;
				case 3:
					breed = "Persian";
					break;
				case 4:
					breed = "Siamese";
					break;
				case 5:
					breed = "Maine Coon";
					break;
				case 6:
					breed = "Goldfish";
					break;
				case 7:
					breed = "Betta";
					break;
				case 8:
					breed = "Clownfish";
					break;
				case 9:
					breed = "Bald Eagle";
					break;
				case 10:
					breed = "Hawk";
					break;
				case 11:
					breed = "Parrot";
					break;
						
			}
			ran = r.nextInt(5);
			switch(ran){
				case 0:
					color = "black";
					break;
				case 1:
					color = "brown";
					break;
				case 2:
					color = "white";
					break;
				case 3:
					color = "yellow";
					break;
				case 4:
					color = "golden";
					break;
			}
			Pet temp = new Pet(name, species, breed, color, age, size);
			pets.add(temp);
		}
	}
}
