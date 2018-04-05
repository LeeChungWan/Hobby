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
	private String msg;

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
			gui.appendMsg("클라이언트와 연결되었습니다.\n");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// client의 메시지를 읽어 화면에 출력.
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg("client(상대) : " + msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
