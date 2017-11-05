package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultati;

public class ControllerClient implements ActionListener {
	
	private FinestraConnessioneClient viewConnect;
	private FinestraGiocoClient viewGame;
	private FinestraRisultati viewEnd;

	public ControllerClient(FinestraConnessioneClient viewConnect, FinestraGiocoClient viewGame, FinestraRisultati viewEnd) {
		//inizializzazione finestra
		viewConnect.setVisible(true);
		viewGame.setVisible(false);
		viewEnd.setVisible(false);
		this.viewConnect = viewConnect;
		this.viewGame = viewGame;
		this.viewEnd = viewEnd;
	}

	public void actionPerformed(ActionEvent evt) {
		
	}

}
