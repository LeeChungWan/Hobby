package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	// �̽�1. �޽��� �ְ� �ޱ�.
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
			System.out.println("�����...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
			gui.appendMsg("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.\n");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// client�� �޽����� �о� ȭ�鿡 ���.
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg("client(���) : " + msg);
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
