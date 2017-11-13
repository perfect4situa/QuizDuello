package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuizList {
	
	private ArrayList<Quiz> list;
	
	public QuizList() {
		list = new ArrayList<Quiz>();
	}
	
	public ArrayList<Quiz> getList() {
		return list;
	}
	
	public void caricaQuiz() throws IOException {
		BufferedReader fBuf = new BufferedReader(new FileReader("..\\QuizDuelloCarboneColussoForest\\resources\\quizData.txt"));
		String[] vet;
		String nextStr = fBuf.readLine();
	    while(nextStr != null) {
	    	vet = nextStr.split(";");
	    	list.add(new Quiz(vet[0], vet[1], vet[2], vet[3], vet[4]));
	        nextStr = fBuf.readLine();
	    }
	    fBuf.close();
	}
	
}
