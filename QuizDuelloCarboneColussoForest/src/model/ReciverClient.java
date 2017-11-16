package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;

public class ReciverClient implements Runnable {

	private String message;
	private BufferedReader in;
	private Client client;
	private Thread t;
	
	public ReciverClient(BufferedReader in, Client client) {
		message = null;
		this.in = in;
		this.client = client;
		t = new Thread(this);
		t.start();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void run() {
		String[] vet;
		while(true)	{
			try {
				message = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			
			vet=message.split(";");
			
			switch(vet[0]) {
				case "startGame":
					client.getViewConnect().setVisible(false);
					client.getViewGame().setVisible(true);
					client.getViewGame().getModello().clear();
					for(String temp : vet) {
						if(!temp.equals(client.getNickname()) && !temp.equals("startGame"))	{
							client.getViewGame().getModello().addElement(temp);
						}
					}
				break;
				
				case "question":
					client.getViewGame().clearColors();
					client.getViewGame().getLblDomanda().setText(vet[1]);
					client.getViewGame().getBtnRisposta().setText(vet[2]);
					client.getViewGame().getBtnRisposta_1().setText(vet[3]);
					client.getViewGame().getBtnRisposta_2().setText(vet[4]);
					client.getViewGame().getBtnRisposta_3().setText(vet[5]);
					client.setSemaforo(true);
				break;
				
				case "result":
					if(vet[2].equals(client.getViewGame().getLblDomanda().getText())) {
						if(vet[1].equals("true")) {
							client.getViewGame().getLblInfo().setText("RISPOSTA ESATTA!!");
							client.getViewGame().getLblInfo().setBackground(Color.green);
						}
						else {
							client.getViewGame().getLblInfo().setText("RISPOSTA Errata!!");
							client.getViewGame().getLblInfo().setBackground(Color.red);
						}
						
						if(client.getViewGame().getBtnRisposta().getText().equals(vet[3])) {
							client.getViewGame().getBtnRisposta().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_1().getText().equals(vet[3]))
						{
							client.getViewGame().getBtnRisposta_1().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_2().getText().equals(vet[3]))
						{
							client.getViewGame().getBtnRisposta_2().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_3().getText().equals(vet[3]))
						{
							client.getViewGame().getBtnRisposta_3().setBackground(Color.green);
						}
					}
					client.setSemaforo(false);
				break;
				
				case "endGame":
					if(vet[1].equals(client.getNickname())) {
						client.getViewGame().getLblInfo().setText("!!!!Hai vinto!!!!!");
						client.getViewGame().getLblInfo().setBackground(Color.green);
					}
					else {
						client.getViewGame().getLblInfo().setText("Hai perso, ha vinto " + vet[1]);
						client.getViewGame().getLblInfo().setBackground(Color.red);
					}
					client.getViewGame().setVisible(false);
					client.getViewEnd().setVisible(true);
				break;
			}
		}
	}
	
}
