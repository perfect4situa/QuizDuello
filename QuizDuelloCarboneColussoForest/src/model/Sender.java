package model;

import java.io.PrintStream;

public class Sender implements Runnable{

	private String message;
	private PrintStream out;
	private Thread t;
	
	public Sender(String message, PrintStream out)
	{
		this.message=message;
		this.out=out;
		
		this.start();
	}
	
	
	@Override
	public void run() {
		
		out.println(message);
		
	}

	private void start()
	{
		t=new Thread(this);
		t.start();
	}
}
