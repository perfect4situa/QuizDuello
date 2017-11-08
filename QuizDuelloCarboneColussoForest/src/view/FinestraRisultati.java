package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FinestraRisultati extends JFrame {

	private static final long serialVersionUID = 7025038189949051806L;
	private JPanel contentPane;
	private JLabel lblVincente;
	private JLabel lblPlayer;
	private JLabel lblPlayer_1;
	private JLabel lblRisultati;
	private JLabel lblRisultati_1;
	private JLabel lblPerdente;
	private JButton btnRigioca;
	private JButton btnEsci;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraRisultati frame = new FinestraRisultati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FinestraRisultati() {
		setTitle("QuizDuello (Risultati)");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizDuelloCarboneColussoForest\\resources\\icon.png"));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVincente = new JLabel("Vincente");
		lblVincente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVincente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVincente.setBounds(133, 11, 173, 54);
		contentPane.add(lblVincente);
		
		lblPlayer = new JLabel("Player1");
		lblPlayer.setBounds(115, 76, 46, 14);
		contentPane.add(lblPlayer);
		
		lblPlayer_1 = new JLabel("Player2");
		lblPlayer_1.setBounds(284, 76, 46, 14);
		contentPane.add(lblPlayer_1);
		
		lblRisultati = new JLabel("risultati");
		lblRisultati.setBounds(115, 101, 46, 14);
		contentPane.add(lblRisultati);
		
		lblRisultati_1 = new JLabel("risultati");
		lblRisultati_1.setBounds(284, 101, 46, 14);
		contentPane.add(lblRisultati_1);
		
		lblPerdente = new JLabel("Perdente");
		lblPerdente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPerdente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdente.setBounds(134, 139, 173, 54);
		contentPane.add(lblPerdente);
		
		btnRigioca = new JButton("Rigioca");
		btnRigioca.setBounds(241, 204, 89, 23);
		contentPane.add(btnRigioca);
		
		btnEsci = new JButton("Esci");
		btnEsci.setBounds(115, 204, 89, 23);
		contentPane.add(btnEsci);
	}

	public JLabel getLblVincente() {
		return lblVincente;
	}

	public void setLblVincente(JLabel lblVincente) {
		this.lblVincente = lblVincente;
	}

	public JLabel getLblPlayer() {
		return lblPlayer;
	}

	public void setLblPlayer(JLabel lblPlayer) {
		this.lblPlayer = lblPlayer;
	}

	public JLabel getLblPlayer_1() {
		return lblPlayer_1;
	}

	public void setLblPlayer_1(JLabel lblPlayer_1) {
		this.lblPlayer_1 = lblPlayer_1;
	}

	public JLabel getLblRisultati() {
		return lblRisultati;
	}

	public void setLblRisultati(JLabel lblRisultati) {
		this.lblRisultati = lblRisultati;
	}

	public JLabel getLblRisultati_1() {
		return lblRisultati_1;
	}

	public void setLblRisultati_1(JLabel lblRisultati_1) {
		this.lblRisultati_1 = lblRisultati_1;
	}

	public JLabel getLblPerdente() {
		return lblPerdente;
	}

	public void setLblPerdente(JLabel lblPerdente) {
		this.lblPerdente = lblPerdente;
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
