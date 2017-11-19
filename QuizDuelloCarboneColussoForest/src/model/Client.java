package model;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultatiClient;

public class Client {

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
		this.viewConnect = viewConnect;
		this.viewGame = viewGame;
		this.viewEnd = viewEnd;
		
		socket = null;
		in = null;
		out = null;
		listener = null;
		nickname = null;
		semaforo = true;
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

	public ReciverClient getListener() {
		return listener;
	}

	public void setListener(ReciverClient listener) {
		this.listener = listener;
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
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			setListener(new ReciverClient(in, this));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		new Sender(msg, out);
		semaforo=false;
	}

	public void disconnect() {
		
		listener.setOn(false);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setListener(null);
		in = null;
		out = null;
		socket = null;
		exit(0);
	}
	
}
