package main;

import controller.ControllerServer;
import model.Server;
import view.FinestraServer;

public class MainServer {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ControllerServer ctrl = new ControllerServer(new Server(9999), new FinestraServer());
	}

}
