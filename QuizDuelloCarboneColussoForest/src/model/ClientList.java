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
	
	public void sendAll(String msg) {
		for(Utente temp : list) {
			temp.sendMsg(msg);
		}
	}
	
	public void closeConnections() {
		for(Utente temp : list) {
			temp.endConnection();
		}
	}

}
