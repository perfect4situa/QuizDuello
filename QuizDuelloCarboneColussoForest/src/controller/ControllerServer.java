package controller;

import static java.lang.System.exit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import model.Server;
import view.FinestraServer;

public class ControllerServer implements ActionListener, WindowListener {
	
	private Server server;
	private FinestraServer view;
	
	public ControllerServer(FinestraServer view) {
		view.getBtnSalva().addActionListener(this);
		view.getBtnOn().addActionListener(this);
		view.getBtnOff().addActionListener(this);
		view.addWindowListener(this);
		view.setVisible(true);
		this.view = view;
		
		this.server = new Server(view);
	}

	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() == view.getBtnSalva()) {
			server.setnClient(Integer.parseInt((String)view.getnGiocatori().getSelectedItem()));
			server.setnQuiz(Integer.parseInt((String)view.getnQuiz().getSelectedItem()));
			JOptionPane.showMessageDialog(null, "Le impostazioni sono state salvate correttamente", "Impostazioni", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(evt.getSource() == view.getBtnOn()) {
			server.start(9999);
			server.setnClient(Integer.parseInt((String)view.getnGiocatori().getSelectedItem()));
			server.setnQuiz(Integer.parseInt((String)view.getnQuiz().getSelectedItem()));
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

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		 if(JOptionPane.showConfirmDialog(this.view, "Sicuro di voler Uscire?", "Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
			 	server.close();
	            exit(0);
	        }  
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
