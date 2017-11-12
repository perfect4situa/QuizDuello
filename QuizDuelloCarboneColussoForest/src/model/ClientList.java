package model;

import java.util.ArrayList;

public class ClientList {
	
	private ArrayList<Client> list;
	
	public ClientList() {
		list = new ArrayList<Client>();
	}

	public ArrayList<Client> getList() {
		return list;
	}

	public void setList(ArrayList<Client> list) {
		this.list = list;
	}
	
	public void sendAll(String msg) {
		for(Client temp : list) {
			temp.send(msg);
		}
	}
	
	public void closeConnections() {
		for(Client temp : list) {
			temp.disconnect();
		}
	}

}
