package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackgound {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;

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
