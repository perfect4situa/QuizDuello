package model;

import java.util.ArrayList;

public class ListaQuiz {
	
	private ArrayList<Quiz> list;

	public ListaQuiz() {
		this.list = new ArrayList<Quiz>();
	}

	public ArrayList<Quiz> getList() {
		return list;
	}

	public void setList(ArrayList<Quiz> list) {
		this.list = list;
	}
	
}
