package model;

import java.util.ArrayList;

public class ClientList {
	
	private ArrayList<Utente> list;
	
	public ClientList() {
		list = new ArrayList<Utente>();
	}

	public ArrayList<Utente> getList() {
		return list;
	}
	
	public void setList(ArrayList<Utente> list) {
		this.list = list;
	}
	
	public boolean allReady() {
		boolean flag = true;
		for(Utente temp : list) {
			flag = flag && temp.isSemaforo();
		}
		return flag;
	}
	
	public void sendAll(String msg) {
		for(Utente temp : list) {
			temp.sendMsg(msg);
		}
	}
	
	public void sendQuiz(Quiz x) {
		for(Utente temp : list) {
			temp.setQuiz(x);
			temp.setSemaforo(false);
			temp.sendMsg("question;" + x.toString());
		}
	}
	
	public void winner() {
		Utente x = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(x.getPunteggio() < list.get(i).getPunteggio())	{
				x = list.get(i);
			}
		}
		this.sendAll("endGame;" + x.getNickname());
	}
	
	public void closeConnections() {
		for(Utente temp : list) {
			temp.endConnection();
		}
	}

}
