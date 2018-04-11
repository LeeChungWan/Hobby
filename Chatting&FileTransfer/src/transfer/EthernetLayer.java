package transfer;

public class EthernetLayer extends BaseLayer{
	final static int ETHERNET_HEADER_SIZE = 14;			// Ethernet header size.
	final static int ETHERNET_MAX_DATA_SIZE = 1500;		// Ethernet �ִ� ������ ũ��
	final static int ETHERNET_TOTAL_MAX_SIZE = 1514;	// Ethernet packet �ִ� ������
	
	byte[] Ethernet_type;	// Ÿ��
	byte[] Ethernet_src;	// �ڱ� MAC�ּ�
	byte[] Ethernet_dst;	// ������ MAC�ּ�
	byte[] Ethernet_data;	// ������ ����
	
	public EthernetLayer(String pName) {
		super(pName);
		resetHeader();
	}
	
	void resetHeader(){
		Ethernet_type = new byte[2];	// 0x0000�� ������� ����. IPv4�� Ÿ���� 0x0800
		Ethernet_type[0] = 8; 			// 0x08 ���� (�պκ�)
		Ethernet_type[1] = 0;			// 0x00 ����  (�޺κ�)
		Ethernet_src = new byte[6];
		Ethernet_dst = new byte[6];
		Ethernet_data = new byte[ETHERNET_MAX_DATA_SIZE];
	}
	
	public byte[] getEthernet_src() {
		return Ethernet_src;
	}

	public void setEthernet_src(byte[] ethernet_src) {
		Ethernet_src = ethernet_src;
	}

	public byte[] getEthernet_dst() {
		return Ethernet_dst;
	}

	public void setEthernet_dst(byte[] ethernet_dst) {
		Ethernet_dst = ethernet_dst;
	}

}
