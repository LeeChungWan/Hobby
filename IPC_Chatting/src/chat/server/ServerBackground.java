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
	// 이슈1. 메시지 주고 받기.
	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;

	// 사용자 정보를 저장하는 맵
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	public ServerGui getGui() {
		return gui;
	}

	public void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // 교통정리.
			serverSocket = new ServerSocket(7777);
			while (true) {
				// 서버가 할일 : 방문자를 계속 받아서 쓰레드 리시버를 계속생성
				System.out.println("대기중...");
				socket = serverSocket.accept(); // 반복해서 사용자를 받는다.
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				// 이곳에 새로운 사용자 쓰레드 클래스를 생성해서 소켓정보를 넣어준다.
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
				clientMap.get(key).writeUTF(key + " : " + msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 맵의 내용(클아이언트) 저장과 삭제
	public void addClient(String nickName, DataOutputStream out) throws IOException {
		sendMessage(nickName + "님이 접속하였습니다.");
		clientMap.put(nickName, out);
	}

	public void removeClient(String nickName) {
		sendMessage(nickName + "님이 로그아웃했습니다.");
		clientMap.remove(nickName);
	}

	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String nickName;

		public Receiver(Socket socket) throws IOException {

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			// 클라이언트 아이디를 받아오고 싶다.
			nickName = in.readUTF();
			addClient(nickName, out);

		}

		public void run() {
			try {
				while (in != null) {
					// client의 메시지를 읽어 화면에 출력.
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				// 사용 접속 종료시 에러발생. 나갈경우
				removeClient(nickName);
			}
		}
	}
}
