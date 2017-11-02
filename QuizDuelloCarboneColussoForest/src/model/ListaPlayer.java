package model;

import java.util.ArrayList;

public class ListaPlayer {
	
	private ArrayList<Player> list;
	
	public ListaPlayer() {
		list = new ArrayList<Player>();
	}

	public ArrayList<Player> getList() {
		return list;
	}

	public void setList(ArrayList<Player> list) {
		this.list = list;
	}

}
