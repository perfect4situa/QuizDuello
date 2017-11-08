package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements Runnable {

	private ArrayList<Utente> lista;
	private ServerSocket server;
	private ListaQuiz listaQuiz;
	private Thread t;
	private int port;
	private int nGiocatori;
	private int nQuiz;
	
	public Server() {
		lista = new ArrayList<Utente>();
	}
	
	public void run() {
		
	}
	
	public void start(int port, int nGiocatori, int nQuiz) {
		this.port = port;
		this.nGiocatori = nGiocatori;
		this.nQuiz = nQuiz;
		
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		listaQuiz=new ListaQuiz();
		try {
			caricaQuiz(listaQuiz);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		t = new Thread(this);
		t.start();
	}
	
	public void close()	{
		for(int i = lista.size(); i > 0; i++) {
			lista.get(i).endConnection();
			lista.remove(i);
		}
		
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		server=null;
	}
	
	
	public static void caricaQuiz(ListaQuiz quizModel) throws IOException {
		BufferedReader fBuf = new BufferedReader(new FileReader("..\\QuizDuelloCarboneColussoForest\\resources\\quizData.txt"));
		String[] vet;
		String nextStr = fBuf.readLine();
	    while(nextStr != null) {
	    	vet = nextStr.split(";");
	    	quizModel.getList().add(new Quiz(vet[0], vet[1], vet[2], vet[3], vet[4]));
	        nextStr = fBuf.readLine();
	    }
	    fBuf.close();
	}

	public ArrayList<Utente> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Utente> lista) {
		this.lista = lista;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public ListaQuiz getListaQuiz() {
		return listaQuiz;
	}

	public void setListaQuiz(ListaQuiz listaQuiz) {
		this.listaQuiz = listaQuiz;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public int getnGiocatori() {
		return nGiocatori;
	}

	public void setnGiocatori(int nGiocatori) {
		this.nGiocatori = nGiocatori;
	}

	public int getnQuiz() {
		return nQuiz;
	}

	public void setnQuiz(int nQuiz) {
		this.nQuiz = nQuiz;
	}
	
}
