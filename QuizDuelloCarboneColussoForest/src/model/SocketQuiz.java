package model;

import java.net.Socket;

public class SocketQuiz {
	
	private String nickname;
	private Socket socket;
	
	public SocketQuiz(String nickname, Socket socket) {
		this.nickname = nickname;
		this.socket = socket;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
