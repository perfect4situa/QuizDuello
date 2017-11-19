package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Utente implements Comparable<Utente>{

	private String nickname;
	private int punteggio;
	private Quiz quiz;
	private boolean semaforo;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ReciverServer recive;
	private boolean alive;
	
	public Utente(Socket socket) {
		alive=true;
		this.socket = socket;
		this.openChannels();
		quiz = null;
		semaforo = false;
		punteggio = 0;
	}
	
	private void openChannels() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			recive = new ReciverServer(in, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void endConnection() {
	
		recive.setOn(false);
		
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		in=null;
		out=null;
		socket=null;
		alive=false;
		semaforo=true;
	}
	
	public void sendMsg(String msg)	{
		new Sender(msg, out);
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

	public BufferedReader getIn() {
		return in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public boolean isSemaforo() {
		return semaforo;
	}

	public void setSemaforo(boolean semaforo) {
		this.semaforo = semaforo;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public int compareTo(Utente o) {
		
		if(this.getPunteggio()>o.getPunteggio())
		{
			return -1;
		}
		else
		{
			return 1;
		}
		
	}

	
}
