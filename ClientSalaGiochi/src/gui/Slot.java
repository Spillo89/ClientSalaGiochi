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

public class Slot {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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
	}

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
		
		JButton risultato = new JButton("New button");
		risultato.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/Jackpot.gif")));
		risultato.setSelectedIcon(null);
		risultato.setEnabled(false);
		risultato.setBounds(90, 70, 378, 51);
		frame.getContentPane().add(risultato);
		
		JButton num1 = new JButton("New button");
		num1.setBackground(Color.WHITE);
		num1.setForeground(Color.BLACK);
		num1.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		num1.setEnabled(false);
		num1.setBounds(90, 156, 110, 157);
		frame.getContentPane().add(num1);
		
		JButton num2 = new JButton("New button");
		num2.setBackground(Color.WHITE);
		num2.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		num2.setEnabled(false);
		num2.setBounds(222, 156, 110, 157);
		frame.getContentPane().add(num2);
		
		JButton num3 = new JButton("New button");
		num3.setBackground(Color.WHITE);
		num3.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/5.png")));
		num3.setEnabled(false);
		num3.setBounds(358, 156, 110, 157);
		frame.getContentPane().add(num3);
		
		JButton gioca = new JButton("New button");
		gioca.setIcon(new ImageIcon(Slot.class.getResource("/imageGUISlot/manovella.png")));
		gioca.setBounds(491, 155, 80, 158);
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
	}
}
