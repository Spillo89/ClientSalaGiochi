package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Registrazione {

	private JFrame frame;
	private JTextField nome;
	private JTextField cognome;
	private JTextField utente;
	private JTextField psw;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Modulo di registrazione");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label.setBounds(162, 11, 210, 32);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 104, 74, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(10, 164, 66, 25);
		frame.getContentPane().add(lblCognome);
		
		JLabel lblNomeUtente = new JLabel("Nome Utente");
		lblNomeUtente.setBounds(10, 220, 84, 25);
		frame.getContentPane().add(lblNomeUtente);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 272, 66, 32);
		frame.getContentPane().add(lblPassword);
		
		nome = new JTextField();
		nome.setBounds(172, 104, 200, 32);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(172, 160, 200, 32);
		frame.getContentPane().add(cognome);
		
		utente = new JTextField();
		utente.setColumns(10);
		utente.setBounds(172, 216, 200, 32);
		frame.getContentPane().add(utente);
		
		psw = new JTextField();
		psw.setColumns(10);
		psw.setBounds(172, 272, 200, 32);
		frame.getContentPane().add(psw);
		
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRegistrati.setBounds(162, 356, 91, 23);
		frame.getContentPane().add(btnRegistrati);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome.setText("");
				cognome.setText("");
				utente.setText("");
				psw.setText("");
			}
		});
		btnCancella.setBounds(281, 356, 91, 23);
		frame.getContentPane().add(btnCancella);
		
		JButton btnNewButton = new JButton("Torna Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Start();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(202, 390, 129, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);

	}
}
