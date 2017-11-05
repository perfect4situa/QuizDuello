package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import model.Quiz;
import model.ListaPlayer;
import model.ListaQuiz;
import view.FinestraServer;

public class ControllerServer implements ActionListener {
	
	private ServerSocket server;
	private Socket sktIO;
	private ListaQuiz quizModel;
	private ListaPlayer playerModel;
	private FinestraServer view;
	private int nGiocatori;
	private int nQuiz;

	public ControllerServer(FinestraServer view) throws IOException {
		//inizializzazione finestra
		view.getBtnSalva().addActionListener(this);
		view.getBtnOn().addActionListener(this);
		view.getBtnOff().addActionListener(this);
		view.setVisible(true);
		this.view = view;
		
		//inizializzazione server
		server = new ServerSocket(12345);
		sktIO = server.accept();
		BufferedReader input = new BufferedReader(new InputStreamReader(sktIO.getInputStream()));
		PrintWriter output = new PrintWriter(sktIO.getOutputStream(), true);
		
		//caricamento quiz
		quizModel = new ListaQuiz();
		caricaQuiz(quizModel);
		for(int i = 0; i < quizModel.getList().size(); i++) {
			System.out.println(quizModel.getList().get(i).getQuestion() + "/"
								+ quizModel.getList().get(i).getTrue1() + "/"
								+ quizModel.getList().get(i).getFalse1() + "/"
								+ quizModel.getList().get(i).getFalse2() + "/"
								+ quizModel.getList().get(i).getFalse3() + "/");
		}
		
		//inizializzazione listasocket e attesa giocatori
		/*playerModel = new ListaPlayer();
		while(playerModel.getList().size() < nGiocatori) {
			String received = input.readLine();
			if(received.contains("newPlayer")) {
				String[] vet = received.split(";");
				playerModel.getList().add(new Player(vet[1]));
			}
		}*/
	}

	public void actionPerformed(ActionEvent evt) {
		//da aggiungere gestione eventi
		if(evt.getSource() == view.getBtnSalva()) {
			nGiocatori = Integer.parseInt((String)view.getnGiocatori().getSelectedItem());
			nQuiz = Integer.parseInt((String)view.getnQuiz().getSelectedItem());
			JOptionPane.showMessageDialog(null, "Le impostazioni sono state salvate correttamente", "Impostazioni", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(evt.getSource() == view.getBtnOn()) {
			try {
				server = new ServerSocket(12345);
				sktIO = server.accept();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			view.getBtnOn().setEnabled(false);
			view.getBtnOff().setEnabled(true);
			view.getLblOnOff().setBackground(Color.GREEN);
		}

		if(evt.getSource() == view.getBtnOff()) {
			try {
				sktIO.close();
				server.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			view.getBtnOn().setEnabled(true);
			view.getBtnOff().setEnabled(false);
			view.getLblOnOff().setBackground(Color.RED);
		}
	}
	
	public static void caricaQuiz(ListaQuiz quizModel) throws IOException {
		BufferedReader fBuf = new BufferedReader(new FileReader("..\\QuizDuelloCarboneColussoForest\\resources\\quizData.txt"));
		String[] vet;
		String nextStr = fBuf.readLine();
	    while(nextStr != null) {
	    	vet = nextStr.split(";");
	    	quizModel.getList().add(new Quiz(vet[0], vet[1], vet[2], vet[3], vet[4]));
	        nextStr = fBuf.readLine();
	    }
	    fBuf.close();
	}

}
