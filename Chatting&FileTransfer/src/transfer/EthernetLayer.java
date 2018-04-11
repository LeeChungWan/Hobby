package transfer;

public class EthernetLayer extends BaseLayer{
	final static int ETHERNET_HEADER_SIZE = 14;			// Ethernet header size.
	final static int ETHERNET_MAX_DATA_SIZE = 1500;		// Ethernet 최대 데이터 크기
	final static int ETHERNET_TOTAL_MAX_SIZE = 1514;	// Ethernet packet 최대 사이즈
	
	byte[] Ethernet_type;	// 타입
	byte[] Ethernet_src;	// 자기 MAC주소
	byte[] Ethernet_dst;	// 목적지 MAC주소
	byte[] Ethernet_data;	// 데이터 공간
	
	public EthernetLayer(String pName) {
		super(pName);
		resetHeader();
	}
	
	void resetHeader(){
		Ethernet_type = new byte[2];	// 0x0000의 사이즈로 생성. IPv4의 타입은 0x0800
		Ethernet_type[0] = 8; 			// 0x08 설정 (앞부분)
		Ethernet_type[1] = 0;			// 0x00 설정  (뒷부분)
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
