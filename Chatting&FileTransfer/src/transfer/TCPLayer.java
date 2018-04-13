package transfer;

import java.util.Arrays;

public class TCPLayer extends BaseLayer {
	final static int TCP_DST_INDEX = 2;
	final static int TCP_HEADER_SIZE = 20;
	final static byte[] CHAT_PORT_NUMBER = { 20, 80 };
	final static byte[] FILE_PORT_NUMBER = { 20, 90 };
	byte[] tcp_sport; // source port
	byte[] tcp_dport; // destination port
	byte[] tcp_seq; // sequence number
	byte[] tcp_ack; // acknowledged number
	byte[] tcp_offset; // no use
	byte[] tcp_flag; // control flag
	byte[] tcp_window; // no use
	byte[] tcp_cksum; // check sum
	byte[] tcp_urgptr; // no use
	byte[] padding;
	byte[] tcp_data; // 상위 레이어의 패킷
	byte[] tcp_packet; // tcp packet = tcp_header + tcp_data

	public TCPLayer(String pName) {
		super(pName);
		resetHeader();
	}

	/*
	 * tcp header의 값들을 초기화.
	 */
	void resetHeader() {
		tcp_sport = new byte[2];
		tcp_dport = new byte[2];
		tcp_seq = new byte[4];
		tcp_ack = new byte[4];
		tcp_offset = new byte[1];
		tcp_flag = new byte[1];
		tcp_window = new byte[2];
		tcp_cksum = new byte[2];
		tcp_urgptr = new byte[2];
	}

	public byte[] getTcp_sport() {
		return tcp_sport;
	}

	public void setTcp_sport(byte[] tcp_sport) {
		this.tcp_sport = Arrays.copyOf(tcp_sport, tcp_sport.length);
		// 상위 레이어로 보내기 위해 packet에 sport값 저장.
		tcp_packet[0] = tcp_sport[0];
		tcp_packet[1] = tcp_sport[1];
	}

	public byte[] getTcp_dport() {
		return tcp_dport;
	}

	public void setTcp_dport(byte[] tcp_dport) {
		this.tcp_dport = Arrays.copyOf(tcp_dport, tcp_dport.length);
		// 상위 레이어로 보내기 위해 packet에 dport값 저장.
		tcp_packet[2] = tcp_dport[0];
		tcp_packet[3] = tcp_dport[1];
	}

	@Override
	boolean Send(byte[] data, int nlength) {
		tcp_packet = new byte[TCP_HEADER_SIZE + nlength];
		// ChatAppLayer에서 패킷이 온경우.
		if (this.getUpperLayer().m_pLayerName.equals("ChatAppLayer")) {
			byte[] chat_port = { 20, 80 };
			setTcp_sport(chat_port);
		} else {
			// FileAppLayer에서 파일이 온경우.
			byte[] file_port = { 20, 90 };
			setTcp_sport(file_port);
		}
		return false;
	}

	/*
	 * 목적지 포트주소를 확인하는 상위레이어로 보냄.
	 */
	@Override
	boolean Receive(byte[] data) {
		// ChatAppLayer로 가는 경우.
		if (data[3] == 80) {

		} else {
			// FileAppLayer로 가는 경우.

		}
		return false;
	}
}
