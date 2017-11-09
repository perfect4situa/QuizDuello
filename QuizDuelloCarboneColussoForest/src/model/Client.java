package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {
	
	private Socket socket;
	private Thread t;
	private BufferedReader in;
	private PrintStream out;
	
	
	public Client(int port,String ip)
	{
		try {
			socket = new Socket(InetAddress.getByName(ip), port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		t=new Thread(this);
		t.start();
	}
	
	private void openChannels() {
		try {
			out = new PrintStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
