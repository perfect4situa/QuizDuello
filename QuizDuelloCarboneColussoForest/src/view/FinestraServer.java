package view;

import java.awt.Color;
import java.awt.EventQueue;
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
	private JLabel lblGiocatoriPerPartita;
	private JComboBox<String> nGiocatori;
	private JLabel lblQuizPerPartita;
	private JComboBox<String> nQuiz;
	private JButton btnSalva;
	private JButton btnOn;
	private JButton btnOff;
	private JLabel lblOnOff;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraServer frame = new FinestraServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FinestraServer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizDuelloCarboneColussoForest\\resources\\icon.png"));
		setTitle("QuizDuello (Server)");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data e ora", "IP", "Porta"
			}
		));
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox<String> getnGiocatori() {
		return nGiocatori;
	}

	public void setnGiocatori(JComboBox<String> nGiocatori) {
		this.nGiocatori = nGiocatori;
	}

	public JComboBox<String> getnQuiz() {
		return nQuiz;
	}

	public void setnQuiz(JComboBox<String> nQuiz) {
		this.nQuiz = nQuiz;
	}

	public JButton getBtnSalva() {
		return btnSalva;
	}

	public void setBtnSalva(JButton btnSalva) {
		this.btnSalva = btnSalva;
	}

	public JButton getBtnOn() {
		return btnOn;
	}

	public void setBtnOn(JButton btnOn) {
		this.btnOn = btnOn;
	}

	public JButton getBtnOff() {
		return btnOff;
	}

	public void setBtnOff(JButton btnOff) {
		this.btnOff = btnOff;
	}

	public JLabel getLblOnOff() {
		return lblOnOff;
	}

	public void setLblOnOff(JLabel lblOnOff) {
		this.lblOnOff = lblOnOff;
	}
	
}
