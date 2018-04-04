package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackgound {
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;

	public ClientGui getGui() {
		return gui;
	}

	public void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public void connet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("������ ����Ǿ����ϴ�.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF("�ȳ��ϼ���. ���� Ŭ���̾�Ʈ�Դϴ�.");
			System.out.println("�޽��� ���� �Ϸ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientBackgound clientBackgound = new ClientBackgound();
		clientBackgound.connet();
	}
}
