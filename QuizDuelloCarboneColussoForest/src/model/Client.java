package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Reciver listener;
	private String nickname;
	
	public Client() {
		socket = null;
		in = null;
		out = null;
		listener = null;
		nickname = null;
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

	public Reciver getListener() {
		return listener;
	}

	public void setListener(Reciver listener) {
		this.listener = listener;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
			listener = new Reciver(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		new Sender(msg, out);
		//out.println(msg);
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
