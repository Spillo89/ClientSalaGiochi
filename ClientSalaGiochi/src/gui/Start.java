package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
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
		
		JLabel lblPoligames = new JLabel("POLIGAMES");
		lblPoligames.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblPoligames.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoligames.setBounds(116, 10, 200, 50);
		frame.getContentPane().add(lblPoligames);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setActionCommand("Login");
		btnNewButton.addActionListener(listener);
		btnNewButton.setBounds(64, 113, 121, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegistrati = new JButton("REGISTRATI");
		btnRegistrati.setActionCommand("Registrati");
		btnRegistrati.addActionListener(listener);
		btnRegistrati.setBounds(226, 113, 121, 42);
		frame.getContentPane().add(btnRegistrati);
		frame.setVisible(true);
	}
	
	ActionListener listener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getActionCommand().equals("Login")){
				new Login();
				frame.setVisible(false);
			}
			else{
				new Registrazione();
				frame.setVisible(false);
			}
			
		}
		
	};
	
}
