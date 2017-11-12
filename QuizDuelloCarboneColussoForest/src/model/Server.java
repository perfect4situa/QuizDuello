package model;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

	private ServerSocket server;
	private QuizList quizList;
	private ClientList clientList;
	private int nQuiz;
	private int nClient;
	Thread t;
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		quizList = new QuizList();
		try {
			quizList.caricaQuiz();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientList = new ClientList();
		nQuiz = 1;
		nClient = 1;
		t = new Thread(this);
	}
	
	public int getnQuiz() {
		return nQuiz;
	}

	public void setnQuiz(int nQuiz) {
		this.nQuiz = nQuiz;
	}

	public int getnClient() {
		return nClient;
	}

	public void setnClient(int nClient) {
		this.nClient = nClient;
	}

	public void run() {
		while(true) {
			while(clientList.getList().size() < nClient) {
				Client now = new Client();
				try {
					now.setSocket(server.accept());
					clientList.getList().add(now);
					now.openChannels();
					Reciver rec = new Reciver(now.getIn());
					while(!rec.isArrived());
					now.setNickname(rec.getMessage());
					System.out.println("new user:" + now.getNickname());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void start() {
		t.start();
	}
	
	public void close()	{
		clientList.closeConnections();		
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		server = null;
	}
	
}
