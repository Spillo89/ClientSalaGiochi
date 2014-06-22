package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchedaTombola {

	private JFrame frame;
	private JTable table;
	private Integer id;
	private JComboBox numeroRiga;
	private String nRiga, tipoVincita;
	private JRadioButton rdbtnAmbo;
	private JRadioButton rdbtnTerno;
	private JRadioButton rdbtnQuaterna;
	private JRadioButton rdbtnCinquina;
	private JRadioButton rdbtnTombola;
	private ButtonGroup vincita;


	/**
	 * Create the application.
	 */
	public SchedaTombola(int id_scheda) {
		id=id_scheda;
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				// qui verrà chiamato il comando per riempire la scheda e tramite for si riempiranno i valori
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 63, 422, 41);
		frame.getContentPane().add(table);
		
		JLabel lblValoreParametro = new JLabel("Scheda numero "+id);
		lblValoreParametro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblValoreParametro.setHorizontalAlignment(SwingConstants.CENTER);
		lblValoreParametro.setBounds(146, 11, 135, 41);
		frame.getContentPane().add(lblValoreParametro);
		
		rdbtnAmbo = new JRadioButton("Ambo\r\n");
		rdbtnAmbo.setSelected(true);
		rdbtnAmbo.setBounds(10, 152, 83, 23);
		frame.getContentPane().add(rdbtnAmbo);
		
		rdbtnTerno = new JRadioButton("Terno");
		rdbtnTerno.setBounds(115, 152, 83, 23);
		frame.getContentPane().add(rdbtnTerno);
		
		rdbtnQuaterna = new JRadioButton("Quaterna");
		rdbtnQuaterna.setBounds(10, 178, 83, 23);
		frame.getContentPane().add(rdbtnQuaterna);
		
		rdbtnCinquina = new JRadioButton("Cinquina");
		rdbtnCinquina.setBounds(115, 178, 83, 23);
		frame.getContentPane().add(rdbtnCinquina);
		
		rdbtnTombola = new JRadioButton("Tombola");
		rdbtnTombola.setBounds(51, 204, 83, 23);
		frame.getContentPane().add(rdbtnTombola);
		
		vincita = new ButtonGroup();
		vincita.add(rdbtnAmbo);
		vincita.add(rdbtnTerno);
		vincita.add(rdbtnQuaterna);
		vincita.add(rdbtnCinquina);
		vincita.add(rdbtnTombola);
		
		
		JLabel lblSullaRigaNumero = new JLabel("Sulla riga numero: ");
		lblSullaRigaNumero.setBounds(252, 156, 99, 14);
		frame.getContentPane().add(lblSullaRigaNumero);
		
		numeroRiga = new JComboBox();
		numeroRiga.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		numeroRiga.setBounds(361, 152, 43, 22);
		frame.getContentPane().add(numeroRiga);
		
		JButton btnReclamaVincita = new JButton("Reclama Vincita");
		btnReclamaVincita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nRiga=numeroRiga.getSelectedItem().toString();
				if(rdbtnAmbo.isSelected()){
					tipoVincita = rdbtnAmbo.getText();
				}else if(rdbtnTerno.isSelected()){
					tipoVincita = rdbtnTerno.getText();
				}else if(rdbtnQuaterna.isSelected()){
					tipoVincita = rdbtnQuaterna.getText();
				}else if(rdbtnCinquina.isSelected()){
					tipoVincita = rdbtnCinquina.getText();
				}else {
					tipoVincita = rdbtnTombola.getText();
				}
				
			}
		});
		btnReclamaVincita.setBounds(297, 204, 135, 41);
		frame.getContentPane().add(btnReclamaVincita);
		frame.setVisible(true);
	}
}
