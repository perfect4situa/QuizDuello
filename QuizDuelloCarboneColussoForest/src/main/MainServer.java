package main;

import controller.ControllerServer;
import model.ListaQuiz;
import model.ListaSocket;
import view.FinestraServer;

public class MainServer {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		ControllerServer ctrl = new ControllerServer(new ListaQuiz(), new ListaSocket(), new FinestraServer());
		
	}

}