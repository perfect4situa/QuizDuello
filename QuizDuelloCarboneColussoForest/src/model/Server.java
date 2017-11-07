package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements Runnable{

	private ArrayList<Utente> lista;
	private ServerSocket server;
	private ListaQuiz listaQuiz;
	private Thread t;
	
	public Server(int port)
	{
		lista=new ArrayList<Utente>();
		try {
			server=new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaQuiz=new ListaQuiz();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start()
	{
		t=new Thread(this);
		t.start();
	}
	
}
