package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReciverServer implements Runnable {

	private String message;
	private BufferedReader in;
	private Utente utente;
	private Thread t;
	
	public ReciverServer(BufferedReader in, Utente utente) {
		message = null;
		this.in = in;
		this.utente = utente;
		t = new Thread(this);
		t.start();
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
				case "newGame":
					utente.setNickname(vet[1]);
					utente.setSemaforo(true);
				break;
				
				case "answer":
					
					if(vet[1].equals(utente.getQuiz().getTrue1()))	{
						utente.sendMsg("result;true;" + utente.getQuiz().getTrue1()+";"+vet[1]);
						utente.setPunteggio(utente.getPunteggio() + 100 + Integer.parseInt(vet[2]));
					}
					else if(vet[1].equals("*null*"))
					{
						utente.sendMsg("result;slow");
					}
					else {
						utente.sendMsg("result;false;" + utente.getQuiz().getTrue1()+";"+vet[1]);
					}
					
					if(!vet[1].equals("*null*"))
					{
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
						
					utente.setSemaforo(true);
				break;
			}
		}
	}

	public String getMessage() {
		return message;
	}

}
