package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SceltaGioco {

	private JFrame frame;
	private String ut;
	private Integer crt;
	private Boolean statustombola=false, statusrubamazzo=false;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaGioco window = new SceltaGioco();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public SceltaGioco(String nome, int crediti) {
		ut=nome;
		crt = crediti;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScegliIlGioco = new JLabel("SCEGLI IL GIOCO CHE VUOI GIOCARE");
		lblScegliIlGioco.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblScegliIlGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliIlGioco.setBounds(95, 10, 393, 50);
		frame.getContentPane().add(lblScegliIlGioco);
		
		/*if (crt>100) {
		 * statustombola = true;
		 * }*/
		JButton tombola = new JButton("New button");
		tombola.setEnabled(statustombola);
		tombola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IntroTombola(ut,crt);
			}
		});
		tombola.setIcon(new ImageIcon(SceltaGioco.class.getResource("/imageGUI/tombola.jpg")));
		tombola.setBounds(48, 108, 122, 160);
		frame.getContentPane().add(tombola);
		JLabel lblTombola = new JLabel("Tombola");
		lblTombola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTombola.setHorizontalAlignment(SwingConstants.CENTER);
		lblTombola.setBounds(48, 71, 122, 41);
		frame.getContentPane().add(lblTombola);
		/*if (crt>200){		 
		 * statusrubamazzo = true;
		 * }*/
		JButton rubamazzo = new JButton("New button");
		rubamazzo.setEnabled(statusrubamazzo);
		rubamazzo.setIcon(new ImageIcon(SceltaGioco.class.getResource("/imageGUI/rubamazzo.jpg")));
		rubamazzo.setBounds(238, 108, 122, 160);
		frame.getContentPane().add(rubamazzo);
		
		JLabel lblRubamazzo = new JLabel("Rubamazzo");
		lblRubamazzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRubamazzo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRubamazzo.setBounds(238, 71, 122, 41);
		frame.getContentPane().add(lblRubamazzo);
		// }
		JButton Slot_machine = new JButton("slot");
		Slot_machine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Slot(crt);
				frame.setVisible(false);
			}
		});
		Slot_machine.setIcon(new ImageIcon(SceltaGioco.class.getResource("/imageGUI/slot_machine.jpeg")));
		Slot_machine.setBounds(426, 108, 122, 160);
		frame.getContentPane().add(Slot_machine);
		
		JLabel lblSlotMachine = new JLabel("Slot Machine");
		lblSlotMachine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlotMachine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSlotMachine.setBounds(426, 71, 122, 41);
		frame.getContentPane().add(lblSlotMachine);
		
		JButton class_tot = new JButton("Classifica Totale");
		class_tot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Classifica(1,ut,crt);
				frame.setVisible(false);
			}
			
		});
		class_tot.setBounds(95, 310, 168, 52);
		frame.getContentPane().add(class_tot);
		
		JButton class_giorno = new JButton("classifica Giornaliera");
		class_giorno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Classifica(2,ut, crt);
				frame.setVisible(false);
			}
		});
		class_giorno.setBounds(320, 310, 168, 52);
		frame.getContentPane().add(class_giorno);
		frame.setVisible(true);
	}
}
