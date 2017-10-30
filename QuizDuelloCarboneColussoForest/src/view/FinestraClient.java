package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinestraClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -839161723918206407L;
	private JPanel contentPane;
	private JPanel login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraClient frame = new FinestraClient();
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
	public FinestraClient() {
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
	}

}
