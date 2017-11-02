package model;

import java.io.IOException;
import java.util.ArrayList;

public class ListaSocket {
	
	private ArrayList<SocketQuiz> list;
	
	public ListaSocket() {
		list = new ArrayList<SocketQuiz>();
	}

	public ArrayList<SocketQuiz> getList() {
		return list;
	}

	public void setList(ArrayList<SocketQuiz> list) {
		this.list = list;
	}
	
	public void closeAll() throws IOException {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).getSocket().close();
		}
	}

}
