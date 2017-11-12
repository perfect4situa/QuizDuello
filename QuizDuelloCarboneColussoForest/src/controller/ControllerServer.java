package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.Server;
import view.FinestraServer;

public class ControllerServer implements ActionListener {
	
	private Server server;
	private FinestraServer view;
	
	public ControllerServer(Server server, FinestraServer view) {
		view.getBtnSalva().addActionListener(this);
		view.getBtnOn().addActionListener(this);
		view.getBtnOff().addActionListener(this);
		view.setVisible(true);
		this.view = view;
		server.setnClient(Integer.parseInt((String)view.getnGiocatori().getSelectedItem()));
		server.setnQuiz(Integer.parseInt((String)view.getnQuiz().getSelectedItem()));
		this.server = server;
	}

	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() == view.getBtnSalva()) {
			server.setnClient(Integer.parseInt((String)view.getnGiocatori().getSelectedItem()));
			server.setnQuiz(Integer.parseInt((String)view.getnQuiz().getSelectedItem()));
			JOptionPane.showMessageDialog(null, "Le impostazioni sono state salvate correttamente", "Impostazioni", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(evt.getSource() == view.getBtnOn()) {
			server.start();
			view.getBtnOn().setEnabled(false);
			view.getBtnOff().setEnabled(true);
			view.getLblOnOff().setBackground(Color.GREEN);
		}

		if(evt.getSource() == view.getBtnOff()) {
			server.close();
			view.getBtnOn().setEnabled(true);
			view.getBtnOff().setEnabled(false);
			view.getLblOnOff().setBackground(Color.RED);
		}
		
	}
	
}
