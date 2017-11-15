package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultatiClient;

public class Client{

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ReciverClient listener;
	private String nickname;
	private boolean semaforo;
	private FinestraConnessioneClient viewConnect;
	private FinestraGiocoClient viewGame;
	private FinestraRisultatiClient viewEnd;
	
	public Client(FinestraConnessioneClient viewConnect, FinestraGiocoClient viewGame, FinestraRisultatiClient viewEnd) {
		//so già che non ti piacerà colusso ma a meno di non bloccare tutta la grafica il modo migliore è questo, comunque
		//rispetta l'MCXV dato che il model deve occuparsi solo degli input utente e non quelli che arrivano dall'esterno
		this.viewConnect=viewConnect;
		this.viewGame=viewGame;
		this.viewEnd=viewEnd;
		
		socket = null;
		in = null;
		out = null;
		listener = null;
		nickname = null;
		semaforo=true;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

	public boolean isSemaforo() {
		return semaforo;
	}



	public void setSemaforo(boolean semaforo) {
		this.semaforo = semaforo;
	}

	

	public FinestraConnessioneClient getViewConnect() {
		return viewConnect;
	}


	public FinestraGiocoClient getViewGame() {
		return viewGame;
	}


	public FinestraRisultatiClient getViewEnd() {
		return viewEnd;
	}


	public void connect(InetAddress ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openChannels() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			listener = new ReciverClient(in, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg)
	{
		new Sender(msg, out);
	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		listener = null;
		in = null;
		out = null;
		socket = null;
	}

	
}
