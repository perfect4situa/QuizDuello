package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Utente {

	private String nickname;
	private Socket socket;
	private int punteggio;
	private BufferedReader in;
	private PrintWriter out;
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
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			recive=new Reciver(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void endConnection()
	{
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		in=null;
		out=null;
		socket=null;
	}
	
	private void reciveNickname()
	{	
		while(!recive.isArrived());
		
		if(recive.getMessage().startsWith("newgame;"));
		{
			nickname=recive.getMessage().substring(8);
		}
	}
	
	public void sendMsg(String msg)
	{
		send=new Sender(msg, this.out);
		
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public Sender getSend() {
		return send;
	}

	public void setSend(Sender send) {
		this.send = send;
	}

	public Reciver getRecive() {
		return recive;
	}

	public void setRecive(Reciver recive) {
		this.recive = recive;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	
}


