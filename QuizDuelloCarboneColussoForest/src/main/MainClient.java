package main;

import controller.ControllerClient;
import view.FinestraConnessioneClient;
import view.FinestraGiocoClient;
import view.FinestraRisultatiClient;

public class MainClient {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ControllerClient ctrl = new ControllerClient(new FinestraConnessioneClient(), new FinestraGiocoClient(), new FinestraRisultatiClient());
	}

}
