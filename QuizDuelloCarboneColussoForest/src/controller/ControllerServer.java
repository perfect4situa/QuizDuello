package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import model.Player;
import model.Quiz;
import model.ListaPlayer;
import model.ListaQuiz;
import view.FinestraServer;

public class ControllerServer implements ActionListener {
	
	private ListaQuiz quizModel;
	private ListaPlayer playerModel;
	private FinestraServer view;
	private ServerSocket server;
	private Socket sktIO;

	public ControllerServer(FinestraServer view) throws IOException {
		//inizializzazione finestra
		
		//inizializzazione server
		server = new ServerSocket(12345);
		sktIO = server.accept();
		BufferedReader input = new BufferedReader(new InputStreamReader(sktIO.getInputStream()));
		PrintWriter output = new PrintWriter(sktIO.getOutputStream(), true);		
		
		//caricamento quiz
		quizModel = new ListaQuiz();
		caricaQuiz(quizModel);
		/*for(int i = 0; i < quizModel.getList().size(); i++) {
			System.out.println(quizModel.getList().get(i).getQuestion() + "/"
								+ quizModel.getList().get(i).getTrue1() + "/"
								+ quizModel.getList().get(i).getFalse1() + "/"
								+ quizModel.getList().get(i).getFalse2() + "/"
								+ quizModel.getList().get(i).getFalse3() + "/");
		}*/
		
		//inizializzazione listasocket e attesa giocatori
		playerModel = new ListaPlayer();
		while(playerModel.getList().size() < Integer.parseInt(view.getComboBox().getSelectedItem())) {
			String received = input.readLine();
			if(received.contains("newPlayer")) {
				String[] vet = received.split(";");
				playerModel.getList().add(new Player(vet[1]));
			}
		}
		
		view.setVisible(true);
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		//da aggiungere gestione eventi
		if(e.getSource() == view) {
			
		}
	}
	
	public static void caricaQuiz(ListaQuiz quizModel) throws IOException {
		FileReader fRead = new FileReader("..\\QuizDuelloCarboneColussoForest\\resources\\quizData");
		BufferedReader fBuf = new BufferedReader(fRead);
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
