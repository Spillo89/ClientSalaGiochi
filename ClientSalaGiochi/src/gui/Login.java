package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField utente;
	private JTextField psw;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLogin.setBounds(120, 0, 200, 50);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNomeUtente = new JLabel("Nome Utente");
		lblNomeUtente.setBounds(10, 66, 136, 27);
		frame.getContentPane().add(lblNomeUtente);
		
		utente = new JTextField();
		utente.setBounds(156, 61, 200, 36);
		frame.getContentPane().add(utente);
		utente.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 127, 108, 50);
		frame.getContentPane().add(lblPassword);
		
		psw = new JTextField();
		psw.setBounds(156, 134, 200, 36);
		frame.getContentPane().add(psw);
		psw.setColumns(10);
		
		JButton btnLogga = new JButton("Logga");
		btnLogga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ut= utente.getText();
				String ps= psw.getText();
				new SceltaGioco();
				frame.setVisible(false);
			}
		});
		btnLogga.setBounds(156, 209, 91, 23);
		frame.getContentPane().add(btnLogga);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				utente.setText("");
				psw.setText("");
			}
		});
		btnCancella.setBounds(265, 209, 91, 23);
		frame.getContentPane().add(btnCancella);
		
		JButton btnTornaIndietro = new JButton("Torna Indietro");
		btnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Start();
				frame.setVisible(false);
			}
		});
		btnTornaIndietro.setBounds(194, 243, 126, 23);
		frame.getContentPane().add(btnTornaIndietro);
		frame.setVisible(true);
	}

}
