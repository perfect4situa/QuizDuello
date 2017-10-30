package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FinestraClient;

public class ControllerClient implements ActionListener {
	
	private FinestraClient view;

	public ControllerClient(FinestraClient view) {
		//inizializzazione finestra
		
		view.setVisible(true);
		
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
