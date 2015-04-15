import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class StartPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage frame = new StartPage();
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
	public StartPage() {
		setTitle("Petcel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.setToolTipText("Click if you are a new user.");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewUser.setBounds(250, 200, 191, 129);
		contentPane.add(btnNewUser);
		
		JButton btnExistingUser = new JButton("Existing User");
		btnExistingUser.setToolTipText("Click if you are an existing user.");
		btnExistingUser.setBounds(700, 200, 191, 129);
		contentPane.add(btnExistingUser);
		
		JLabel lblPetcel = new JLabel("Petcel");
		lblPetcel.setToolTipText("The best electronic adoption software");
		lblPetcel.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblPetcel.setBounds(410, 49, 314, 119);
		contentPane.add(lblPetcel);
	}
}
