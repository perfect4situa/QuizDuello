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
	
	public void add(Utente x)
	{
		list.add(x);
	}
	
	public boolean allReady() {
		boolean flag = true;
		
		for(Utente temp : list) {
			flag = flag && temp.isSemaforo();
		}
		
		int i=0;
		
		do
		{
			if(!list.get(i).isAlive())
			{
				list.remove(i);
				i--;
			}
			i++;
		}
		while(i<list.size());
		
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
			temp.sendMsg(mixer(x));
		}
	}
	
	private String mixer(Quiz x)
	{
		String msg="question;"+x.getQuestion();
		
		String[] mixerIn={x.getTrue1(), x.getFalse1(), x.getFalse2(), x.getFalse3()};
		int random;
		int[] array=new int[4];
		int dim=0;
		boolean go;
		
		for(int j=0;j<4;j++)
		{
		
			do
			{
				go=true;
				
				random=(int)(Math.random()*4);
				
				for(int i=0;i<dim;i++)
				{
					if(random==array[i])
					{
						go=false;
					}
				}
				
			}
			while(!go);
			
			array[dim]=random;
			dim++;
			
			msg+=";"+mixerIn[random];
			
		}
		
		return msg;
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
		
		while(!allReady());
		
		for(Utente temp : list) {
			temp.sendMsg("Terminate");
			temp.endConnection();
			
		}
	}

}
