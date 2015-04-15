import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;


public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnFinished;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setTitle("Petcel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIfNotFilled = new JLabel("");
		lblIfNotFilled.setBackground(Color.RED);
		lblIfNotFilled.setBounds(400, 59, 327, 40);
		contentPane.add(lblIfNotFilled);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("Please enter your first name");
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setText("First Name");
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtFirstName.setBounds(400, 120, 327, 40);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Please enter your last name");
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtLastName.setText("Last Name");
		txtLastName.setBounds(400, 181, 327, 40);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Please enter your prefered email address");
		txtEmail.setText("Email");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtEmail.setColumns(10);
		txtEmail.setBounds(400, 242, 327, 40);
		contentPane.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("Please enter the password you would like to use");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setBounds(400, 303, 327, 40);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnFinished = new JButton("Finished");
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPassword.equals("") || txtEmail.equals("") || txtLastName.equals("") || txtFirstName.equals("")){
					lblIfNotFilled.setText("Please fill all text fields.");
				}
			}
		});
		btnFinished.setToolTipText("Press when finished filling out all text fields");
		btnFinished.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnFinished.setBounds(470, 364, 194, 55);
		contentPane.add(btnFinished);
		
		
	}
}
