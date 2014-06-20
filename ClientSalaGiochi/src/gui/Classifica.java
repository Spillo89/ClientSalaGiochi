package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Classifica {

	private JFrame frame;
	private JTable table;
	private int cl;
	private String tipo = null;
	private JButton btnAggiorna;
	private JButton btnIndietro;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classifica window = new Classifica();
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
	public Classifica(int classtype) {
		cl=classtype;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(cl==1){
			tipo = "Generale";
			// query per i giocatori globali
		}else{
			tipo = "Giornaliera";
			// query per i giocatori odierni
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"User", "Punti", "altro"},
				{"gg", null, null},
			},
			new String[] {
				"User", "Punti", "boh"
			}
		));
		table.setBounds(10, 53, 422, 50);
		frame.getContentPane().add(table);

		
		JLabel lblClassificaGenerale = new JLabel("Classifica "+tipo+"");
		lblClassificaGenerale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClassificaGenerale.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassificaGenerale.setBounds(122, 11, 208, 31);
		frame.getContentPane().add(lblClassificaGenerale);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Classifica(cl);
				frame.setVisible(false);
			}
		});
		btnAggiorna.setBounds(31, 200, 126, 51);
		frame.getContentPane().add(btnAggiorna);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SceltaGioco();
				frame.setVisible(false);
			}
		});
		btnIndietro.setBounds(280, 200, 126, 51);
		frame.getContentPane().add(btnIndietro);
		frame.setVisible(true);
	}
}
