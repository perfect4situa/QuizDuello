package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
					client.getViewGame().getLblDomanda().setText("<html>" + vet[1] + "</html>");
					client.getViewGame().getBtnRisposta().setText(vet[2]);
					client.getViewGame().getBtnRisposta_1().setText(vet[3]);
					client.getViewGame().getBtnRisposta_2().setText(vet[4]);
					client.getViewGame().getBtnRisposta_3().setText(vet[5]);
					client.setSemaforo(true);
					/*int count = 0;
					while(count < 5) {
						try {
							TimeUnit.SECONDS.sleep(1);
							client.getViewGame().getProgressBar().setValue(client.getViewGame().getProgressBar().getValue() + 20);
							count++;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					client.getViewGame().getProgressBar().setValue(0);*/
				break;
				
				case "result":
					if(client.getViewGame().getBtnRisposta().getText().equals(vet[3])) {
						client.getViewGame().getBtnRisposta().setBackground(Color.green);
					}
					if(client.getViewGame().getBtnRisposta_1().getText().equals(vet[3])) {
						client.getViewGame().getBtnRisposta_1().setBackground(Color.green);
					}
					if(client.getViewGame().getBtnRisposta_2().getText().equals(vet[3])) {
						client.getViewGame().getBtnRisposta_2().setBackground(Color.green);
					}
					if(client.getViewGame().getBtnRisposta_3().getText().equals(vet[3])) {
						client.getViewGame().getBtnRisposta_3().setBackground(Color.green);
					}
					client.setSemaforo(false);
				break;
				
				case "endGame":
					client.getViewEnd().getLblPlayer().setText(vet[1]);
					if(vet[1].equals(client.getNickname())) {
						client.getViewEnd().getLblPerdente().setText("!!Hai VINTO!!");
						client.getViewEnd().getLblPerdente().setBackground(Color.GREEN);
					}
					else {
						client.getViewEnd().getLblPerdente().setText("Hai perso :(");
						client.getViewEnd().getLblPerdente().setBackground(Color.RED);
					}
					client.getViewGame().setVisible(false);
					client.getViewEnd().setVisible(true);
				break;
			}
		}
	}
	
}
