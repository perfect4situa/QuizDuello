package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
