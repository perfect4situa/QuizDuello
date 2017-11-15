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
	
	public boolean allReady()
	{
		boolean temp=true;
		
		for(int i=0;i<list.size();i++)
		{
			temp=temp && list.get(i).isSemaforo();
		}
		
		return temp;
	}

	public void setList(ArrayList<Utente> list) {
		this.list = list;
	}
	
	public void sendAll(String msg) {
		for(Utente temp : list) {
			temp.sendMsg(msg);
		}
	}
	
	public void winner()
	{
		Utente x=null;
		
		for(int i=0;i<list.size();i++)
		{
			if(i==0)
			{
				x=list.get(0);
			}
			else
			{
				if(x.getPunteggio()<list.get(i).getPunteggio())
				{
					x=list.get(i);
				}
			}
		}
		
		this.sendAll("endGame;"+x.getNickname());
	}
	
	public void sendQuiz(Quiz x) {
		for(Utente temp : list) {
			temp.setQuiz(x);
			
			temp.setSemaforo(false);
			
			temp.sendMsg("question;"+x.toString());
		}
	}
	
	
	public void closeConnections() {
		for(Utente temp : list) {
			temp.endConnection();
		}
	}

}
