package chat.client;

import java.io.IOException;
import java.net.Socket;

public class ClientBackgound {
	Socket socket;

	public void connet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClientBackgound clientBackgound = new ClientBackgound();
		clientBackgound.connet();
	}
}
