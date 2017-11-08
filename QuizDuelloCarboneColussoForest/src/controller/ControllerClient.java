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

	public ControllerClient(FinestraConnessioneClient viewConnect) {
		viewConnect.getBtnConnetti().addActionListener(this);
		viewConnect.setVisible(true);
		this.viewConnect = viewConnect;
	}

	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource() == viewConnect.getBtnConnetti()) {
			
		}
		
		if(evt.getSource() == viewGame.getBtnRisposta()) {
			
		}
		
		if(evt.getSource() == viewGame.getBtnRisposta_1()) {
			
		}
		
		if(evt.getSource() == viewGame.getBtnRisposta_2()) {
	
		}
		
		if(evt.getSource() == viewGame.getBtnRisposta_3()) {
	
		}
		
		if(evt.getSource() == viewEnd.getBtnRigioca()) {
			
		}
		
		if(evt.getSource() == viewEnd.getBtnEsci()) {
			
		}
		
	}

}
