package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	// 이슈1. 메시지 주고 받기.
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ServerGui gui;

	public ServerGui getGui() {
		return gui;
	}

	public void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "에서 접속했습니다.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			String msg = in.readUTF();
			System.out.println("client에서 받은 메세지 : " + msg);
			 gui.appendMsg(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}
}
