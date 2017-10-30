package main;

import controller.ControllerClient;
import view.FinestraClient;

public class MainClient {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		ControllerClient ctrl = new ControllerClient(new FinestraClient());
		
	}

}
