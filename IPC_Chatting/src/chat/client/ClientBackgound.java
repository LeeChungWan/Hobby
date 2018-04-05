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
	private String nickName;

	public ClientGui getGui() {
		return gui;
	}

	public void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public void connet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			gui.appendMsg("��ü ä�ù濡 �����Ͽ����ϴ�. \n");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName);
			System.out.println("Ŭ���̾�Ʈ : �޽��� ���ۿϷ�");
			// ������ msg�� �о� ȭ�鿡 ���
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);
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

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
