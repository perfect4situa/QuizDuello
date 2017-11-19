package view;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FinestraRisultatiClient extends JFrame {

	private static final long serialVersionUID = 7025038189949051806L;
	private JPanel contentPane;
	private JButton btnRigioca;
	private JButton btnEsci;
	private JScrollPane scrollPane;
	private JLabel lblClassifica;
	private JTable table;
	private DefaultTableModel tableModel;

	public FinestraRisultatiClient() {
		setTitle("QuizDuello (Risultati)");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizDuello\\resources\\icon.png"));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRigioca = new JButton("Rigioca");
		btnRigioca.setBounds(241, 204, 89, 23);
		contentPane.add(btnRigioca);
		
		btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEsci.setBounds(115, 204, 89, 23);
		contentPane.add(btnEsci);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 61, 249, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tableModel = new DefaultTableModel(
				new String[][] {
				},
				new String[] {
					"Nickname", "Punteggio"
				}
		);
		table.setModel(tableModel);
		table.setToolTipText("Classifica");
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		lblClassifica = new JLabel("Classifica");
		lblClassifica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClassifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassifica.setBounds(169, 25, 89, 25);
		contentPane.add(lblClassifica);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JButton getBtnRigioca() {
		return btnRigioca;
	}

	public void setBtnRigioca(JButton btnRigioca) {
		this.btnRigioca = btnRigioca;
	}

	public JButton getBtnEsci() {
		return btnEsci;
	}

	public void setBtnEsci(JButton btnEsci) {
		this.btnEsci = btnEsci;
	}
}
