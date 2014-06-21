package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slot {

	private JFrame frame;
	private JTextField textField;

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slot window = new Slot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	/**
	 * Create the application.
	 */
	public Slot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPoliSlot = new JLabel("POLI SLOT");
		lblPoliSlot.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblPoliSlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliSlot.setBounds(163, 23, 261, 36);
		frame.getContentPane().add(lblPoliSlot);
		
		JButton gioca = new JButton("New button");
		gioca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// qui verra chiamato il server per prendere i numeri, verranno inseriti in 3 variabili e sostituiti
				// alle immagini dei numeri
				// poi verrà calcolata la vincita e aggiornati i crediti
			}
		});
		gioca.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/manovella.png")));
		gioca.setBounds(502, 155, 80, 158);
		frame.getContentPane().add(gioca);
		
		JLabel lblCrediti = new JLabel("Crediti");
		lblCrediti.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCrediti.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrediti.setBounds(381, 360, 110, 29);
		frame.getContentPane().add(lblCrediti);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(491, 362, 47, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("titolo");
		lblNewLabel.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/Jackpot.gif")));
		lblNewLabel.setBounds(109, 70, 378, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel num1 = new JLabel("New label");
		num1.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		num1.setBounds(103, 155, 110, 157);
		frame.getContentPane().add(num1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		label.setBounds(238, 155, 116, 157);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		label_1.setBounds(381, 155, 110, 157);
		frame.getContentPane().add(label_1);
	}
}
