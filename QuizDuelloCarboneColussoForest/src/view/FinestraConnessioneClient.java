package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FinestraConnessioneClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -839161723918206407L;
	private JPanel contentPane;
	private JPanel login;
	private JLabel lblIp;
	private JTextField ip;
	private JLabel lblPorta;
	private JTextField porta;
	private JLabel lblNickname;
	private JTextField nickname;
	private JButton btnConnetti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraConnessioneClient frame = new FinestraConnessioneClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinestraConnessioneClient() {
		setTitle("QuizDuello");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JPanel();
		login.setBounds(0, 0, 444, 271);
		contentPane.add(login);
		login.setLayout(null);
		
		lblIp = new JLabel("IP");
		lblIp.setBounds(28, 35, 26, 14);
		login.add(lblIp);
		
		ip = new JTextField();
		ip.setBounds(71, 32, 86, 20);
		login.add(ip);
		ip.setColumns(10);
		
		lblPorta = new JLabel("PORTA");
		lblPorta.setBounds(220, 35, 46, 14);
		login.add(lblPorta);
		
		porta = new JTextField();
		porta.setBounds(292, 32, 86, 20);
		login.add(porta);
		porta.setColumns(10);
		
		lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(43, 99, 73, 14);
		login.add(lblNickname);
		
		nickname = new JTextField();
		nickname.setBounds(130, 96, 86, 20);
		login.add(nickname);
		nickname.setColumns(10);
		
		btnConnetti = new JButton("CONNETTI");
		btnConnetti.setBounds(263, 192, 115, 23);
		login.add(btnConnetti);
	}

	public JPanel getLogin() {
		return login;
	}

	public void setLogin(JPanel login) {
		this.login = login;
	}

	public JTextField getIp() {
		return ip;
	}

	public void setIp(JTextField ip) {
		this.ip = ip;
	}

	public JTextField getPorta() {
		return porta;
	}

	public void setPorta(JTextField porta) {
		this.porta = porta;
	}

	public JTextField getNickname() {
		return nickname;
	}

	public void setNickname(JTextField nickname) {
		this.nickname = nickname;
	}

	public JButton getBtnConnetti() {
		return btnConnetti;
	}

	public void setBtnConnetti(JButton btnConnetti) {
		this.btnConnetti = btnConnetti;
	}

}
