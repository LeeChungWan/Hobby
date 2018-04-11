package transfer;

public class EthernetLayer extends BaseLayer{
	final static int ETHERNET_HEADER_SIZE = 14;
	final static int ETHERNET_MAX_DATA_SIZE = 1500;
	final static int ETHERNET_TOTAL_MAX_SIZE = 1514;
	
	byte[] Ethernet_type;
	byte[] Ethernet_src;
	byte[] Ethernet_dst;
	byte[] Ethernet_data;
	
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

	public EthernetLayer(String pName) {
		super(pName);
		
	}
	
}
