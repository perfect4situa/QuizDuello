package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class FinestraConnessioneClient extends JFrame {

	private static final long serialVersionUID = -839161723918206407L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblIp;
	private JTextField ip;
	private JLabel lblPorta;
	private JTextField porta;
	private JLabel lblNickname;
	private JTextField nickname;
	private JButton btnConnetti;

	public FinestraConnessioneClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizZello\\resources\\icon.png"));
		setTitle("QuizZello (Connessione)");
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
		
		lblIp = new JLabel("IP:");
		lblIp.setToolTipText("IP del server");
		lblIp.setBounds(44, 35, 26, 14);
		panel.add(lblIp);
		
		ip = new JTextField();
		ip.setToolTipText("Inserisci l'IP del server");
		ip.setBounds(80, 32, 86, 20);
		panel.add(ip);
		ip.setColumns(10);
		
		lblPorta = new JLabel("PORTA:");
		lblPorta.setToolTipText("Porta del server");
		lblPorta.setBounds(226, 35, 46, 14);
		panel.add(lblPorta);
		
		porta = new JTextField();
		porta.setToolTipText("Inserisci la porta del server");
		porta.setBounds(284, 32, 86, 20);
		panel.add(porta);
		porta.setColumns(10);
		
		lblNickname = new JLabel("NICKNAME:");
		lblNickname.setToolTipText("Nickname di gioco");
		lblNickname.setBounds(133, 99, 63, 14);
		panel.add(lblNickname);
		
		nickname = new JTextField();
		nickname.setToolTipText("Inserisci il tuo nickname");
		nickname.setBounds(207, 96, 86, 20);
		panel.add(nickname);
		nickname.setColumns(10);
		
		btnConnetti = new JButton("CONNETTI");
		btnConnetti.setToolTipText("Richiesta connessione al server");
		btnConnetti.setBounds(166, 175, 115, 23);
		panel.add(btnConnetti);
	}

	public JTextField getIp() {
		return ip;
	}

	public JTextField getPorta() {
		return porta;
	}

	public JTextField getNickname() {
		return nickname;
	}

	public JButton getBtnConnetti() {
		return btnConnetti;
	}
	
}
