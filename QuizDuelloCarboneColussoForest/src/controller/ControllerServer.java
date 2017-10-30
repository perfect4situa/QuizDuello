package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListaQuiz;
import model.ListaSocket;
import view.FinestraServer;

public class ControllerServer implements ActionListener {
	
	private ListaQuiz quizModel;
	private ListaSocket socketModel;
	private FinestraServer view;

	public ControllerServer(ListaQuiz quizModel, ListaSocket socketModel, FinestraServer view) {
		//inizializzazione finestra
		//caricamento quiz
		//inizializzazione listasocket
		
		view.setVisible(true);
		
		this.quizModel = quizModel;
		this.socketModel = socketModel;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
