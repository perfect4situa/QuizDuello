package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Utente {

	private String Nickname;
	private Socket socket;
	private double punteggio;
	private BufferedReader in;
	private PrintStream out;
	private Sender send;
	private Reciver recive;
	
	public Utente(Socket socket)
	{
		this.socket=socket;
		this.openChannels();
		this.reciveNickname();
	}
	
	private void openChannels() {

		try {
			out = new PrintStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


