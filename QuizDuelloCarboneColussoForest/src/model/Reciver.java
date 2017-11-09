package model;

import java.io.BufferedReader;
import java.io.IOException;

public class Reciver implements Runnable {

	private String message;
	private boolean arrived;
	private BufferedReader in;
	private Thread t;
	
	public Reciver(BufferedReader in) {
		message = "";
		arrived = false;
		this.in = in;
		this.start();
	}
	
	public void run() {	
		
		try {
			message = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		arrived = true;
	
	}
	
	public void start()	{
		t = new Thread(this);
		t.start();
	}

	public String getMessage() {
		return message;
	}

	public boolean isArrived() {
		return arrived;
	}
	
}
