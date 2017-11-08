package main;

import controller.ControllerClient;
import view.FinestraConnessioneClient;

public class MainClient {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ControllerClient ctrl = new ControllerClient(new FinestraConnessioneClient());
	}

}
