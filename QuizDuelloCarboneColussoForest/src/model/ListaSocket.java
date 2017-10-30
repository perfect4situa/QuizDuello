package model;

import java.net.Socket;
import java.util.ArrayList;

public class ListaSocket {
	
	private ArrayList<Socket> list;
	
	public ListaSocket() {
		list = new ArrayList<Socket>();
	}

	public ArrayList<Socket> getList() {
		return list;
	}

	public void setList(ArrayList<Socket> list) {
		this.list = list;
	}

}
