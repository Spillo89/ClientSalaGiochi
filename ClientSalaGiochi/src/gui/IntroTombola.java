package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroTombola {

	private JFrame frame;
	private String numeroschede="1",ut;
	private JComboBox numschede;
	private int crt;


	/**
	 * Create the application.
	 */
	public IntroTombola(String user, int crediti) {
		ut=user;
		crt=crediti;
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
		
		JLabel lblStaiPerCominciare = new JLabel("Stai per cominciare una partita a tombola!");
		lblStaiPerCominciare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStaiPerCominciare.setBounds(10, 11, 362, 30);
		frame.getContentPane().add(lblStaiPerCominciare);
		
		JLabel lblQuanteSchedeVuoi = new JLabel("Quante Schede vuoi comprare?");
		lblQuanteSchedeVuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuanteSchedeVuoi.setBounds(10, 52, 237, 31);
		frame.getContentPane().add(lblQuanteSchedeVuoi);
		
		numschede = new JComboBox();
		numschede.setModel(new DefaultComboBoxModel(new String[] {"4", "3", "2", "1"}));
		numschede.setBounds(257, 52, 50, 24);
		frame.getContentPane().add(numschede);
		
		
		
		
		JButton Gioca = new JButton("Gioca");
		Gioca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numeroschede = numschede.getSelectedItem().toString();
				for(int i=1; i<=Integer.parseInt(numeroschede);i++){
					new SchedaTombola(i,ut);
				} 
					new Tabellone();
				frame.setVisible(false);
			}
		});
		Gioca.setBounds(10, 112, 127, 30);
		frame.getContentPane().add(Gioca);
		
		JButton back = new JButton("Torna Indietro");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SceltaGioco(ut,crt);
				frame.setVisible(false);
			}
		});
		back.setBounds(180, 112, 127, 30);
		frame.getContentPane().add(back);
		frame.setVisible(true);
	}
}
