package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FinestraConnessioneClient;

public class ControllerClient implements ActionListener {
	
	private FinestraConnessioneClient view;

	public ControllerClient(FinestraConnessioneClient view) {
		//inizializzazione finestra
		
		view.setVisible(true);
		
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
