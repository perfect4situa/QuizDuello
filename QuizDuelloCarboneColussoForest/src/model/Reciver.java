package model;

import java.io.BufferedReader;
import java.io.IOException;

public class Reciver implements Runnable {

	private String message;
	private boolean arrived;
	private BufferedReader in;
	private Thread t;
	
	public Reciver(BufferedReader in) {
		message = null;
		arrived = false;
		this.in = in;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true)
		{
			try {
				message = in.readLine();
				arrived = true;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public String getMessage() {
		arrived=false;
		return message;
	}
	
	public boolean isArrived() {
		return arrived;
	}
	
	public void setArrived(boolean arrived) {
		this.arrived = arrived;
	}

}
