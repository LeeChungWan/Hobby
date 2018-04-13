package transfer;

import java.util.Arrays;

public class TCPLayer extends BaseLayer {
	final static int TCP_HEADER_SIZE = 20;
	final static int CHAT_PORT_NUMBER = 2080;
	final static int FILE_PORT_NUMBER = 2090;
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
	void resetHeader(){
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
	}

	public byte[] getTcp_dport() {
		return tcp_dport;
	}

	public void setTcp_dport(byte[] tcp_dport) {
		this.tcp_dport = Arrays.copyOf(tcp_dport, tcp_dport.length);
	}
	
	@Override
	boolean Send(byte[] data, int nlength){
		return false;
	}
	
	@Override
	boolean Receive(byte[] data){
		return false;
	}
}
