package transfer;

import java.util.Arrays;

public class EthernetLayer extends BaseLayer {
	final static int ETHERNET_HEADER_SIZE = 14; // Ethernet header size.
	final static int ETHERNET_MAX_DATA_SIZE = 1500; // Ethernet 최대 데이터 크기
	final static int ETHERNET_PACKET_SIZE = 1514; // Ethernet packet 최대 사이즈

	byte[] Ethernet_type; // 타입
	byte[] Ethernet_src; // 자기 MAC주소
	byte[] Ethernet_dst; // 목적지 MAC주소
	byte[] Ethernet_data; // Ethernet packet에서 header를 뺀 데이터.
	byte[] Ethernet_packet; // Ethernet Packet 공간 (header + data)

	public EthernetLayer(String pName) {
		super(pName);
		resetHeader();
	}

	void resetHeader() {
		Ethernet_type = new byte[2]; // 0x0000의 사이즈로 생성. IPv4의 타입은 0x0800
		Ethernet_type[0] = 8; // 0x08 설정 (앞부분)
		Ethernet_type[1] = 0; // 0x00 설정 (뒷부분)
		Ethernet_src = new byte[6];
		Ethernet_dst = new byte[6];
		Ethernet_data = new byte[ETHERNET_MAX_DATA_SIZE];
		Ethernet_packet = new byte[ETHERNET_PACKET_SIZE];
	}

	public byte[] getEthernet_src() {
		return Ethernet_src;
	}

	/*
	 * 파라매터로 들어온 src 주소를 저장. Ethernet_packet에 src addr 저장
	 * 
	 * @param ethernet_src
	 */
	public void setEthernet_src(byte[] ethernet_src) {
		Ethernet_src = Arrays.copyOf(ethernet_src, ethernet_src.length);
		for (int i = 0; i < 6; i++)
			Ethernet_packet[i + 6] = Ethernet_src[i];
	}

	public byte[] getEthernet_dst() {
		return Ethernet_dst;
	}

	/*
	 * 파라매터로 들어온 dst 주소를 저장. Ethernet_packet에 dst addr 저장
	 * 
	 * @param ethernet_dst
	 */
	public void setEthernet_dst(byte[] ethernet_dst) {
		Ethernet_dst = Arrays.copyOf(ethernet_dst, ethernet_dst.length);
		for (int i = 0; i < 6; i++)
			Ethernet_packet[i] = Ethernet_dst[i];
	}

	/*
	 * 상위 레이어에서 받은 data에 Ethernet Header를 붙여 하위 레이어로 보내준다.
	 * 
	 * @param data, nlength
	 */
	@Override
	boolean Send(byte[] data, int nlength) {
		Ethernet_packet = new byte[ETHERNET_HEADER_SIZE + nlength];
		setEthernet_src(Ethernet_src);
		setEthernet_dst(Ethernet_dst);
		System.arraycopy(Ethernet_type, 0, Ethernet_packet, 12, Ethernet_type.length);
		System.arraycopy(data, 0, Ethernet_packet, 14, nlength);
		if (this.getUnderLayer().Send(Ethernet_packet, ETHERNET_HEADER_SIZE + nlength)) {
			return true;
		}
		System.out.println("[EthernetLayer] to [NILayer] sending fail.");
		return false;
	}

	@Override
	boolean Receive(byte[] data) {
		// 받아온 패킷의 목적지 주소와 자신의 src 주소가 일치하는지 확인.
		for (int i = 0; i < 6; i++) {
			if (Ethernet_src[i] != data[i])
				return false;
		}

		// 상위 레이어로 받은 패킷을 보내준다.
		Ethernet_data = new byte[data.length - ETHERNET_HEADER_SIZE];
		System.arraycopy(data, 14, Ethernet_data, 0, Ethernet_data.length);
		if (this.mp_UpperLayer.Receive(Ethernet_data)) {
			return true;
		}
		System.out.println("[EhternetLayer] to [IPLayer] sending fail.");
		return false;
	}

}
