package controller;

import static java.lang.System.exit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import model.Client;
import model.Quiz;
import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultatiClient;

public class ControllerClient implements ActionListener, WindowListener {
	
	private Client client;
	private FinestraConnessioneClient viewConnect;
	private FinestraGiocoClient viewGame;
	private FinestraRisultatiClient viewEnd;

	public ControllerClient(FinestraConnessioneClient viewConnect, FinestraGiocoClient viewGame, FinestraRisultatiClient viewEnd) {
		viewConnect.getBtnConnetti().addActionListener(this);
		viewConnect.setVisible(true);
		this.viewConnect = viewConnect;
		viewGame.getProgressBar().setMinimum(0);
		viewGame.getProgressBar().setMaximum(100);
		viewGame.getBtnRisposta().addActionListener(this);
		viewGame.getBtnRisposta_1().addActionListener(this);
		viewGame.getBtnRisposta_2().addActionListener(this);
		viewGame.getBtnRisposta_3().addActionListener(this);
		viewGame.setVisible(false);
		this.viewGame = viewGame;
		viewEnd.getBtnRigioca().addActionListener(this);
		viewEnd.getBtnEsci().addActionListener(this);
		viewEnd.setVisible(false);
		this.viewEnd = viewEnd;
		viewGame.addWindowListener(this);
		viewEnd.addWindowListener(this);
		this.client = new Client(viewConnect, viewGame, viewEnd);
	}

	public void actionPerformed(ActionEvent evt) {
		
		if(client.isSemaforo())	{
			if(evt.getSource() == viewConnect.getBtnConnetti()) {
				try {
					InetAddress ip = InetAddress.getByName(viewConnect.getIp().getText());
					int port = Integer.parseInt(viewConnect.getPorta().getText());
					if(viewConnect.getNickname().getText().equals("")) {
						JOptionPane.showMessageDialog(viewConnect, "Inserisci un nickname", "Errore", JOptionPane.ERROR_MESSAGE);
					} else {
						client.connect(ip, port);
						client.setNickname(viewConnect.getNickname().getText());
						client.send("newGame;" + client.getNickname());
					}
				} catch (UnknownHostException e) {
					JOptionPane.showMessageDialog(viewConnect, "L'indirizzo ip o la porta a cui ci si sta tentando di connettere non risponde", "Errore di connessione", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					viewConnect.getBtnConnetti().setBackground(Color.red);
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(viewConnect, "Inserire un numero di porta valido", "Errore di connessione", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					viewConnect.getBtnConnetti().setBackground(Color.red);
				}
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta()) {
				client.getListener().setTimer(false);
				client.send("answer;" + viewGame.getBtnRisposta().getText() + ";" + client.getListener().getCount());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_1()) {
				client.getListener().setTimer(false);
				client.send("answer;" + viewGame.getBtnRisposta_1().getText() + ";" + client.getListener().getCount());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_2()) {
				client.getListener().setTimer(false);
				client.send("answer;" + viewGame.getBtnRisposta_2().getText() + ";" + client.getListener().getCount());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_3()) {
				client.getListener().setTimer(false);
				client.send("answer;" + viewGame.getBtnRisposta_3().getText() + ";" + client.getListener().getCount());
			}
		}
		
		if(evt.getSource() == viewEnd.getBtnRigioca()) {
			//coming soon
		}
		
		if(evt.getSource() == viewEnd.getBtnEsci()) {
			client.send("Terminate"); 
			client.disconnect();
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
		
		if(this.viewGame.isVisible())
		{
			if(JOptionPane.showConfirmDialog(this.viewGame, "Sicuro di voler Uscire?", "Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
				client.send("Terminate"); 
				client.disconnect();
		        exit(0);
		    }
		}
		else if(this.viewEnd.isVisible())
		{
			if(JOptionPane.showConfirmDialog(this.viewEnd, "Sicuro di voler Uscire?", "Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
				client.send("Terminate");
				client.disconnect();
		        exit(0);
		    }
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
