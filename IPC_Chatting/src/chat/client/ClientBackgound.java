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
			System.out.println("서버와 연결되었습니다.");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF("안녕하세요. 저는 클라이언트입니다.");
			System.out.println("메시지 전송 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClientBackgound clientBackgound = new ClientBackgound();
		clientBackgound.connet();
	}
}
