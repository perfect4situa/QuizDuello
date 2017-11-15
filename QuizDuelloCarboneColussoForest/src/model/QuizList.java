package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuizList {
	
	private ArrayList<Quiz> list;
	private int[] used;
	private int index;
	
	public QuizList(int n) {
		list = new ArrayList<Quiz>();
		used=new int[n];
		index=0;
	}
	
	public ArrayList<Quiz> getList() {
		return list;
	}
	
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Quiz take()
	{
		int x=-1;
		boolean flag;
		
		
		do
		{
			flag=true;
			
			x=(int)(Math.random()*list.size())-1;
			
			
			for(int i=0;i<index;i++)
			{
				if(used[i]==x)
				{
					flag=false;
				}
			}
		}
		while(!flag);
			
			
		used[index]=x;
		
		index++;
		
		return list.get(x);
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
