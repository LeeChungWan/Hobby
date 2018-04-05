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
	private String msg;

	public ClientGui getGui() {
		return gui;
	}

	public void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public void connet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			gui.appendMsg("������ ����Ǿ����ϴ�. \n");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			//������ msg�� �о� ȭ�鿡 ���
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg("server(���) : " + msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientBackgound clientBackgound = new ClientBackgound();
		clientBackgound.connet();
	}

	// ������ �޽��� ����
	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
