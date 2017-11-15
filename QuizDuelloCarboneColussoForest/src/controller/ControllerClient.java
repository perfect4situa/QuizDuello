package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import model.Client;
import model.Quiz;
import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultatiClient;

public class ControllerClient implements ActionListener {
	
	private Client client;
	private FinestraConnessioneClient viewConnect;
	private FinestraGiocoClient viewGame;
	private FinestraRisultatiClient viewEnd;

	public ControllerClient(FinestraConnessioneClient viewConnect, FinestraGiocoClient viewGame, FinestraRisultatiClient viewEnd) {
		viewConnect.getBtnConnetti().addActionListener(this);
		viewConnect.setVisible(true);
		this.viewConnect = viewConnect;
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
		this.client=new Client(viewConnect, viewGame, viewEnd);
	}

	public void actionPerformed(ActionEvent evt) {
		
		if(client.isSemaforo())
		{
			if(evt.getSource() == viewConnect.getBtnConnetti()) {
				try {
					client.connect(InetAddress.getByName(viewConnect.getIp().getText()), Integer.parseInt(viewConnect.getPorta().getText()));
					if(viewConnect.getNickname().getText().equals("")) {
						JOptionPane.showMessageDialog(viewConnect, "Inserisci un nickname", "Errore", JOptionPane.ERROR_MESSAGE);
					} else {
						client.openChannels();
						client.setNickname(viewConnect.getNickname().getText());
						client.send("newGame;"+client.getNickname());
						client.setSemaforo(false);
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
				Quiz risp = new Quiz(viewGame.getLblDomanda().getText(), viewGame.getBtnRisposta().getText(), viewGame.getBtnRisposta_1().getText(), viewGame.getBtnRisposta_2().getText(), viewGame.getBtnRisposta_3().getText());
				client.send("answer;"+risp.toString());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_1()) {
				Quiz risp = new Quiz(viewGame.getLblDomanda().getText(), viewGame.getBtnRisposta_1().getText(), viewGame.getBtnRisposta().getText(), viewGame.getBtnRisposta_2().getText(), viewGame.getBtnRisposta_3().getText());
				client.send("answer;"+risp.toString());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_2()) {
				Quiz risp = new Quiz(viewGame.getLblDomanda().getText(), viewGame.getBtnRisposta_2().getText(), viewGame.getBtnRisposta().getText(), viewGame.getBtnRisposta_1().getText(), viewGame.getBtnRisposta_3().getText());
				client.send("answer;"+risp.toString());
			}
			
			if(evt.getSource() == viewGame.getBtnRisposta_3()) {
				Quiz risp = new Quiz(viewGame.getLblDomanda().getText(), viewGame.getBtnRisposta_3().getText(), viewGame.getBtnRisposta().getText(), viewGame.getBtnRisposta_1().getText(), viewGame.getBtnRisposta_2().getText());
				client.send("answer;"+risp.toString());
			}
		}
		
		if(evt.getSource() == viewEnd.getBtnRigioca()) {
			//coming soon
		}
		
		if(evt.getSource() == viewEnd.getBtnEsci()) {
			client.disconnect();
			System.exit(0);
		}
		
	}

}
