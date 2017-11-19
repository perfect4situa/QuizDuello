package model;

import java.util.ArrayList;
import java.util.Collections;

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
	
	private void ordina()
	{
		Collections.sort(this.list);
	}
	
	public void winner() {
		
		this.ordina();
		
		String msg="endGame";
		
		for(int i = 0; i < list.size(); i++) {
			
			msg+=";"+list.get(i).getNickname()+","+list.get(i).getPunteggio();
		}
		this.sendAll(msg);
	}
	
	public void closeConnections() {
		for(Utente temp : list) {
			temp.endConnection();
		}
	}

}
