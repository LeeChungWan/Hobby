package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	ServerSocket serverSocket;
	Socket socket;

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("�����...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.��");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}
}
