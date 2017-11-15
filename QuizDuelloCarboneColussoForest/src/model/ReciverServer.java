package model;

import java.io.BufferedReader;
import java.io.IOException;

public class ReciverServer implements Runnable {

	private String message;
	private BufferedReader in;
	private Utente utente;
	private Thread t;
	
	public ReciverServer(BufferedReader in, Utente utente) {
		message = null;
		this.in = in;
		this.utente=utente;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		String[] vet;
		
		while(true)
		{
			try {
				message = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			
			vet=message.split(";");
			
			switch(vet[0])
			{
				case "newGame":
					
					utente.setNickname(vet[1]);
				
					utente.setSemaforo(true);
				break;
				
				case "answer":
					
					if(vet[1].equals(utente.getQuiz().getQuestion()) && vet[2].equals(utente.getQuiz().getTrue1()))
					{
						utente.sendMsg("result;true;"+utente.getQuiz().toString());
						utente.setPunteggio(utente.getPunteggio()+1);
					}
					else
					{
						utente.sendMsg("result;false;"+utente.getQuiz().toString());
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
