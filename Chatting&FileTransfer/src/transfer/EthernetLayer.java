package transfer;

import java.util.Arrays;

public class EthernetLayer extends BaseLayer {
	final static int ETHERNET_HEADER_SIZE = 14; // Ethernet header size.
	final static int ETHERNET_MAX_DATA_SIZE = 1500; // Ethernet �ִ� ������ ũ��
	final static int ETHERNET_PACKET_SIZE = 1514; // Ethernet packet �ִ� ������

	byte[] Ethernet_type; // Ÿ��
	byte[] Ethernet_src; // �ڱ� MAC�ּ�
	byte[] Ethernet_dst; // ������ MAC�ּ�
	byte[] Ethernet_data; // Ethernet packet���� header�� �� ������.
	byte[] Ethernet_packet; // Ethernet Packet ���� (header + data)

	public EthernetLayer(String pName) {
		super(pName);
		resetHeader();
	}

	void resetHeader() {
		Ethernet_type = new byte[2]; // 0x0000�� ������� ����. IPv4�� Ÿ���� 0x0800
		Ethernet_type[0] = 8; // 0x08 ���� (�պκ�)
		Ethernet_type[1] = 0; // 0x00 ���� (�޺κ�)
		Ethernet_src = new byte[6];
		Ethernet_dst = new byte[6];
		Ethernet_data = new byte[ETHERNET_MAX_DATA_SIZE];
		Ethernet_packet = new byte[ETHERNET_PACKET_SIZE];
	}

	public byte[] getEthernet_src() {
		return Ethernet_src;
	}

	/*
	 * �Ķ���ͷ� ���� src �ּҸ� ����. Ethernet_packet�� src addr ����
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
	 * �Ķ���ͷ� ���� dst �ּҸ� ����. Ethernet_packet�� dst addr ����
	 * 
	 * @param ethernet_dst
	 */
	public void setEthernet_dst(byte[] ethernet_dst) {
		Ethernet_dst = Arrays.copyOf(ethernet_dst, ethernet_dst.length);
		for (int i = 0; i < 6; i++)
			Ethernet_packet[i] = Ethernet_dst[i];
	}

	/*
	 * ���� ���̾�� ���� data�� Ethernet Header�� �ٿ� ���� ���̾�� �����ش�.
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
		// �޾ƿ� ��Ŷ�� ������ �ּҿ� �ڽ��� src �ּҰ� ��ġ�ϴ��� Ȯ��.
		for (int i = 0; i < 6; i++) {
			if (Ethernet_src[i] != data[i])
				return false;
		}

		// ���� ���̾�� ���� ��Ŷ�� �����ش�.
		Ethernet_data = new byte[data.length - ETHERNET_HEADER_SIZE];
		System.arraycopy(data, 14, Ethernet_data, 0, Ethernet_data.length);
		if (this.mp_UpperLayer.Receive(Ethernet_data)) {
			return true;
		}
		System.out.println("[EhternetLayer] to [IPLayer] sending fail.");
		return false;
	}

}
