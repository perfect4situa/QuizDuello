package main;

import java.io.IOException;

import controller.ControllerServer;
import view.FinestraServer;

public class MainServer {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			ControllerServer ctrl = new ControllerServer(new FinestraServer());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
