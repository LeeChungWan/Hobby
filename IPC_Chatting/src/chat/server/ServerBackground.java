package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {
	// �̽�1. �޽��� �ְ� �ޱ�.
	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;

	// ����� ������ �����ϴ� ��
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	public ServerGui getGui() {
		return gui;
	}

	public void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // ��������.
			serverSocket = new ServerSocket(7777);
			while (true) {
				// ������ ���� : �湮�ڸ� ��� �޾Ƽ� ������ ���ù��� ��ӻ���
				System.out.println("�����...");
				socket = serverSocket.accept(); // �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
				// �̰��� ���ο� ����� ������ Ŭ������ �����ؼ� ���������� �־��ش�.
				Receiver receiver = new Receiver(socket);
				receiver.start();

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
		Iterator<String> it = clientMap.keySet().iterator();

		String key;
		while (it.hasNext()) {
			key = it.next();
			try {
				clientMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ���� ����(Ŭ���̾�Ʈ) ����� ����
	public void addClient(String nickName, DataOutputStream out) throws IOException {
		gui.appendMsg(nickName + "���� �����Ͽ����ϴ�.\n");
		sendMessage(nickName + "���� �����Ͽ����ϴ�.\n");
		clientMap.put(nickName, out);
	}

	public void removeClient(String nickName) {
		gui.appendMsg(nickName + "���� �α׾ƿ��߽��ϴ�.\n");
		sendMessage(nickName + "���� �α׾ƿ��߽��ϴ�.\n");
		clientMap.remove(nickName);
	}

	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String nickName;

		public Receiver(Socket socket) throws IOException {

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			// Ŭ���̾�Ʈ ���̵� �޾ƿ��� �ʹ�.
			nickName = in.readUTF();
			addClient(nickName, out);

		}

		public void run() {
			try {
				while (in != null) {
					// client�� �޽����� �о� ȭ�鿡 ���.
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				// ��� ���� ����� �����߻�. �������
				removeClient(nickName);
			}
		}
	}
}
