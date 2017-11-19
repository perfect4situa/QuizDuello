package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReciverClient implements Runnable {

	private String message;
	private BufferedReader in;
	private Client client;
	private Thread t;
	private int count;
	private boolean timer;
	
	public ReciverClient(BufferedReader in, Client client) {
		message = null;
		this.in = in;
		this.client = client;
		t = new Thread(this);
		t.start();
	}
	
	public String getMessage() {
		return message;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setTimer(boolean timer) {
		this.timer = timer;
	}

	public void run() {
		
		String[] vet;
		
		while(true)	{
			try {
				message = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			vet=message.split(";");
			
			switch(vet[0]) {
				case "startGame":
					client.getViewConnect().setVisible(false);
					client.getViewGame().setVisible(true);
					client.getViewGame().getModello().clear();
					for(String temp : vet) {
						if(!temp.equals(client.getNickname()) && !temp.equals("startGame"))	{
							client.getViewGame().getModello().addElement(temp);
						}
					}
				break;
				
				case "question":
					client.getViewGame().clearColors();
					client.getViewGame().getLblDomanda().setText("<html>" + vet[1] + "</html>");
					client.getViewGame().getBtnRisposta().setText(vet[2]);
					client.getViewGame().getBtnRisposta_1().setText(vet[3]);
					client.getViewGame().getBtnRisposta_2().setText(vet[4]);
					client.getViewGame().getBtnRisposta_3().setText(vet[5]);
					client.setSemaforo(true);
					
					count = 100;
					timer=true;
					client.getViewGame().getProgressBar().setValue(100);
					while(count > 0 && timer) {
						try {
							TimeUnit.MILLISECONDS.sleep(100);
							client.getViewGame().getProgressBar().setValue(client.getViewGame().getProgressBar().getValue() - 1);
							count--;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(timer)
					{
						client.send("answer;*null*");
					}
					else
					{
						client.getViewGame().getProgressBar().setValue(0);
					}
					
				break;
				
				case "result":
					
					if(!vet[1].equals("slow"))
					{
						if(client.getViewGame().getBtnRisposta().getText().equals(vet[2])) {
							client.getViewGame().getBtnRisposta().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_1().getText().equals(vet[2])) {
							client.getViewGame().getBtnRisposta_1().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_2().getText().equals(vet[2])) {
							client.getViewGame().getBtnRisposta_2().setBackground(Color.green);
						}
						else if(client.getViewGame().getBtnRisposta_3().getText().equals(vet[2])) {
							client.getViewGame().getBtnRisposta_3().setBackground(Color.green);
						}
						
						if(vet[1].equals("false"))
						{
							if(client.getViewGame().getBtnRisposta().getText().equals(vet[3])) {
								client.getViewGame().getBtnRisposta().setBackground(Color.red);
							}
							else if(client.getViewGame().getBtnRisposta_1().getText().equals(vet[3])) {
								client.getViewGame().getBtnRisposta_1().setBackground(Color.red);
							}
							else if(client.getViewGame().getBtnRisposta_2().getText().equals(vet[3])) {
								client.getViewGame().getBtnRisposta_2().setBackground(Color.red);
							}
							else if(client.getViewGame().getBtnRisposta_3().getText().equals(vet[3])) {
								client.getViewGame().getBtnRisposta_3().setBackground(Color.red);
							}
						}
					}
					
					client.setSemaforo(false);
				break;
				
				case "endGame":
					
					String[] temp;
					
					for(String x : vet) {
						
						if(!x.equals("endGame"))
						{
							temp=x.split(",");
							
							if(temp[0].equals(client.getNickname()))
							{
								temp[0]="<html><font color=red>"+temp[0]+"</font></html>";
								temp[1]="<html><font color=red>"+temp[1]+"</font></html>";
							}
							
							client.getViewEnd().getTableModel().addRow(temp);
						}
						
					}
					
					client.getViewGame().setVisible(false);
					client.getViewEnd().setVisible(true);
					
				break;
			}
		}
	}
	
}
