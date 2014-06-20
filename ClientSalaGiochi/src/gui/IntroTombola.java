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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroTombola window = new IntroTombola();
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
	public IntroTombola() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(257, 52, 50, 24);
		frame.getContentPane().add(comboBox);
		
		JButton Gioca = new JButton("Gioca");
		Gioca.setBounds(10, 112, 127, 30);
		frame.getContentPane().add(Gioca);
		
		JButton back = new JButton("Torna Indietro");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SceltaGioco();
				frame.setVisible(false);
			}
		});
		back.setBounds(180, 112, 127, 30);
		frame.getContentPane().add(back);
		frame.setVisible(true);
	}
}
