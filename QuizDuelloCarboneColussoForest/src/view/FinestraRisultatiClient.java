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

public class FinestraRisultatiClient extends JFrame {

	private static final long serialVersionUID = 7025038189949051806L;
	private JPanel contentPane;
	private JLabel lblVincente;
	private JLabel lblPlayer;
	private JLabel lblRisultati;
	private JLabel lblPerdente;
	private JButton btnRigioca;
	private JButton btnEsci;

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
		
		lblVincente = new JLabel("Vincente");
		lblVincente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVincente.setHorizontalAlignment(SwingConstants.CENTER);
		lblVincente.setBounds(167, 37, 102, 33);
		contentPane.add(lblVincente);
		
		lblPlayer = new JLabel("Player1");
		lblPlayer.setBounds(145, 89, 74, 14);
		contentPane.add(lblPlayer);
		
		lblRisultati = new JLabel("risultati");
		lblRisultati.setBounds(266, 89, 46, 14);
		contentPane.add(lblRisultati);
		
		lblPerdente = new JLabel("Perdente");
		lblPerdente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPerdente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdente.setBounds(115, 114, 215, 48);
		contentPane.add(lblPerdente);
		
		btnRigioca = new JButton("Rigioca");
		btnRigioca.setEnabled(false);
		btnRigioca.setBounds(241, 204, 89, 23);
		contentPane.add(btnRigioca);
		
		btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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

	public JLabel getLblRisultati() {
		return lblRisultati;
	}

	public void setLblRisultati(JLabel lblRisultati) {
		this.lblRisultati = lblRisultati;
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
