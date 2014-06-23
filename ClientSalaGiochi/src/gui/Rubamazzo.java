package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Rubamazzo {

	private JFrame frame;
	private String ut;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rubamazzo window = new Rubamazzo();
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
	public Rubamazzo(String utente) {
		ut=utente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel g2mazzo = new JLabel("mazzo");
		g2mazzo.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/retro.jpg")));
		g2mazzo.setBounds(147, 11, 68, 103);
		frame.getContentPane().add(g2mazzo);
		
		JLabel g1mazzo = new JLabel("mazzo");
		g1mazzo.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/retro.jpg")));
		g1mazzo.setBounds(481, 459, 68, 103);
		frame.getContentPane().add(g1mazzo);
		
		JLabel lblMazzetto = new JLabel("Mazzetto");
		lblMazzetto.setBounds(481, 434, 46, 14);
		frame.getContentPane().add(lblMazzetto);
		
		JLabel label_1 = new JLabel("Mazzetto");
		label_1.setBounds(147, 141, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel ct7 = new JLabel("");
		ct7.setBounds(225, 166, 68, 103);
		frame.getContentPane().add(ct7);
		
		JLabel ct8 = new JLabel("");
		ct8.setBounds(303, 166, 68, 103);
		frame.getContentPane().add(ct8);
		
		JLabel ct9 = new JLabel("");
		ct9.setBounds(381, 166, 68, 103);
		frame.getContentPane().add(ct9);
		
		JLabel ct10 = new JLabel("");
		ct10.setBounds(459, 166, 68, 103);
		frame.getContentPane().add(ct10);
		
		JLabel ct3 = new JLabel("");
		ct3.setBounds(303, 280, 68, 103);
		frame.getContentPane().add(ct3);
		
		JLabel ct6 = new JLabel("");
		ct6.setBounds(147, 166, 68, 103);
		frame.getContentPane().add(ct6);
		
		JLabel ct4 = new JLabel("");
		ct4.setBounds(381, 280, 68, 103);
		frame.getContentPane().add(ct4);
		
		JLabel ct5 = new JLabel("");
		ct5.setBounds(459, 280, 68, 103);
		frame.getContentPane().add(ct5);
		
		JLabel ct2 = new JLabel("");
		ct2.setBounds(225, 280, 68, 103);
		frame.getContentPane().add(ct2);
		
		JLabel ct1 = new JLabel("");
		ct1.setBounds(147, 280, 68, 103);
		frame.getContentPane().add(ct1);
		
		JLabel g3mazzo = new JLabel("carta1");
		g3mazzo.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/retro2.jpg")));
		g3mazzo.setBounds(10, 364, 103, 68);
		frame.getContentPane().add(g3mazzo);
		
		JLabel g4mazzo = new JLabel("carta1");
		g4mazzo.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/retro2.jpg")));
		g4mazzo.setBounds(579, 166, 103, 68);
		frame.getContentPane().add(g4mazzo);
		
		JButton g1c1 = new JButton("");
		g1c1.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/vuoto.png")));
		g1c1.setBounds(191, 459, 68, 103);
		frame.getContentPane().add(g1c1);
		
		JButton g1c2 = new JButton("");
		g1c2.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/vuoto.png")));
		g1c2.setBounds(287, 459, 68, 103);
		frame.getContentPane().add(g1c2);
		
		JButton g1c3 = new JButton("");
		g1c3.setIcon(new ImageIcon(Rubamazzo.class.getResource("/imageGUIRubaMazzo/vuoto.png")));
		g1c3.setBounds(381, 459, 68, 103);
		frame.getContentPane().add(g1c3);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
