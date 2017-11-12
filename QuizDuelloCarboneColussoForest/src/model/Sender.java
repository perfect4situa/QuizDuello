package model;

import java.io.PrintWriter;

public class Sender implements Runnable {

	private String message;
	private PrintWriter out;
	private Thread t;
	
	public Sender(String message, PrintWriter out) {
		this.message = message;
		this.out = out;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		out.println(message);
	}
	
}
