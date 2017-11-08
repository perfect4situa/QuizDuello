package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

import model.Server;
import view.FinestraServer;

public class ControllerServer implements ActionListener {
	
	private FinestraServer view;
	private Server server;
	private int nGiocatori;
	private int nQuiz;
	
	public ControllerServer(FinestraServer view) throws IOException {
		view.getBtnSalva().addActionListener(this);
		view.getBtnOn().addActionListener(this);
		view.getBtnOff().addActionListener(this);
		view.setVisible(true);
		this.view = view;
		
		server = new Server();
		
		for(int i = 0; i < server.getListaQuiz().getList().size(); i++) {
			System.out.println(server.getListaQuiz().getList().get(i).getQuestion() + "/"
								+ server.getListaQuiz().getList().get(i).getTrue1() + "/"
								+ server.getListaQuiz().getList().get(i).getFalse1() + "/"
								+ server.getListaQuiz().getList().get(i).getFalse2() + "/"
								+ server.getListaQuiz().getList().get(i).getFalse3() + "/");
		}
		
	}

	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() == view.getBtnSalva()) {
			nGiocatori = Integer.parseInt((String)view.getnGiocatori().getSelectedItem());
			nQuiz = Integer.parseInt((String)view.getnQuiz().getSelectedItem());
			JOptionPane.showMessageDialog(null, "Le impostazioni sono state salvate correttamente", "Impostazioni", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(evt.getSource() == view.getBtnOn()) {
			server.start(9999, nGiocatori, nQuiz);
			
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
