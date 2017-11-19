package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class FinestraServer extends JFrame {

	private static final long serialVersionUID = -5769128379290199250L;
	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modello;
	private JLabel lblGiocatoriPerPartita;
	private JComboBox<String> nGiocatori;
	private JLabel lblQuizPerPartita;
	private JComboBox<String> nQuiz;
	private JLabel lblOnOff;
	private JButton btnOn;
	private JButton btnOff;
	private JButton btnSalva;

	public FinestraServer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizZello\\resources\\icon.png"));
		setTitle("QuizZello (Server)");
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 444, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Log di connessione");
		scrollPane.setBounds(10, 95, 424, 165);
		panel.add(scrollPane);
		
		table = new JTable();
		modello = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"IP", "Porta"
				}
		);
		table.setModel(modello);
		table.setToolTipText("Log di connessione");
		scrollPane.setViewportView(table);
		
		lblGiocatoriPerPartita = new JLabel("Giocatori per partita:");
		lblGiocatoriPerPartita.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiocatoriPerPartita.setToolTipText("Numero di giocatori per partita");
		lblGiocatoriPerPartita.setBounds(10, 11, 117, 14);
		panel.add(lblGiocatoriPerPartita);
		
		nGiocatori = new JComboBox<String>();
		nGiocatori.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4", "5", "6"}));
		nGiocatori.setToolTipText("Seleziona un numero");
		nGiocatori.setBounds(137, 8, 49, 20);
		panel.add(nGiocatori);
		
		lblQuizPerPartita = new JLabel("Quiz per partita:");
		lblQuizPerPartita.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuizPerPartita.setToolTipText("Numero di quiz per partita");
		lblQuizPerPartita.setBounds(10, 36, 117, 14);
		panel.add(lblQuizPerPartita);
		
		nQuiz = new JComboBox<String>();
		nQuiz.setToolTipText("Seleziona un numero");
		nQuiz.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		nQuiz.setBounds(137, 33, 49, 20);
		panel.add(nQuiz);
		
		btnSalva = new JButton("Salva");
		btnSalva.setToolTipText("Salva modifiche");
		btnSalva.setBounds(54, 61, 89, 23);
		panel.add(btnSalva);
		
		btnOn = new JButton("ON");
		btnOn.setEnabled(true);
		btnOn.setToolTipText("Accendi server");
		btnOn.setBounds(345, 32, 89, 23);
		panel.add(btnOn);
		
		btnOff = new JButton("OFF");
		btnOff.setEnabled(false);
		btnOff.setToolTipText("Spegni server");
		btnOff.setBounds(345, 61, 89, 23);
		panel.add(btnOff);
		
		lblOnOff = new JLabel("I/O");
		lblOnOff.setOpaque(true);
		lblOnOff.setBackground(Color.RED);
		lblOnOff.setToolTipText("Stato server");
		lblOnOff.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnOff.setBounds(379, 8, 20, 20);
		panel.add(lblOnOff);
	}

	public JComboBox<String> getnGiocatori() {
		return nGiocatori;
	}

	public JComboBox<String> getnQuiz() {
		return nQuiz;
	}
	
	public JLabel getLblOnOff() {
		return lblOnOff;
	}

	public JButton getBtnOn() {
		return btnOn;
	}

	public JButton getBtnOff() {
		return btnOff;
	}
	
	public JButton getBtnSalva() {
		return btnSalva;
	}

	public DefaultTableModel getModello() {
		return modello;
	}
	
}
