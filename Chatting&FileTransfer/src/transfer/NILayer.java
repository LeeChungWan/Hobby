package transfer;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class NILayer extends BaseLayer {
	// �������� jnetpcap.dll ���� �ε�
	static {
		try {
			// native Library Load
			System.load(new File("jnetpcap.dll").getAbsolutePath());
			System.out.println(new File("jnetpcap.dll").getAbsolutePath());
		} catch (UnsatisfiedLinkError e) {
			System.out.println("Native code library failed to load.\n " + e);
			System.exit(1);
		}
	}

	int m_iNumAdapter; // ��Ʈ��ũ ��� �ε���
	String pLayerName; // ���̾��� �̸�
	public Pcap m_AdapterObject; // ��Ʈ��ũ ��� ��ü
	public PcapIf device; // ��Ʈ��ũ �������̽� ��ü
	public java.util.List<PcapIf> m_pAdapterList; // ��Ʈ��ũ �������̽� ���
	StringBuilder errbuf = new StringBuilder(); // ��������

	/*
	 * NILayer�� ������ �ʵ� �������� �ʱ�ȭ ��Ʈ��ũ ��� ��� �������� �Լ� ȣ��
	 * 
	 * @param pName
	 */
	public NILayer(String pName) {
		super(pName);
		// pLayerName = pName;
		m_pAdapterList = new ArrayList<PcapIf>();
		m_iNumAdapter = 0;
		setAdapterList();
	}

	/*
	 * ���õ� ��Ʈ��ũ ��� �ε����� ���� �ʱ�ȭ. ��Ŷ ����̹� ���� �Լ� ����. ��Ŷ �����Լ� ����.
	 * 
	 * @param iNum
	 */
	public void setAdapterNumber(int iNum) {
		m_iNumAdapter = iNum;
		packetStartDriver();
		Receive();
	}

	/*
	 * ���� ��ǻ�Ϳ� �����ϴ� ��� ��Ʈ��ũ ��� ��� ��������. ��Ʈ��ũ ��Ͱ� �ϳ��� �������� ���� ��� ���� ó��
	 */
	private void setAdapterList() {
		int r = Pcap.findAllDevs(m_pAdapterList, errbuf);
		if (r == Pcap.NOT_OK || m_pAdapterList.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s", errbuf);
			return;
		}
	}

	/*
	 * Pcap ���ۿ� �ʿ��� �⺻ ������ ���� ���� ����. ���õ� ��Ʈ��ũ ��� �� ������ �ɼǿ� ������ Pcap �۵� ����
	 */
	private void packetStartDriver() {
		int snaplen = 64 * 1024;
		int flags = Pcap.MODE_PROMISCUOUS;
		int timeout = 10 * 1000;
		m_AdapterObject = Pcap.openLive(m_pAdapterList.get(m_iNumAdapter).getName(), snaplen, flags, timeout, errbuf);
	}

	/*
	 * ��Ŷ ���� �Լ�. ���� ���̾�κ��� ���� ���� �����͸� ����Ʈ ���ۿ� ����. ��Ʈ��ũ ����� sendPacket() �Լ��� ����
	 * ������ ���� ��Ŷ ������ ������ ��� ���� �޽��� ��� �� false ��ȯ ��Ŷ ������ ������ ��� true ��ȯ
	 * 
	 * @param input, length
	 */
	@Override
	public boolean Send(byte[] input, int length) {
		ByteBuffer buf = ByteBuffer.wrap(input);
		if (m_AdapterObject.sendPacket(buf) != Pcap.OK) {
			System.err.println(m_AdapterObject.getErr());
			return false;
		}
		return true;
	}

	/*
	 * ��Ŷ ���� �� ��Ŷ ó���� ���� runnable Ŭ���� ����. Thread ���� �� ����.
	 */
	@Override
	boolean Receive() {
		Receive_Thread thread = new Receive_Thread(m_AdapterObject, this.getUpperLayer());
		Thread obj = new Thread(thread);
		obj.start();

		return false;
	}
}

/*
 * ��Ŷ ������ ���� Runnable class
 */
class Receive_Thread implements Runnable {
	byte[] data;
	Pcap AdapterObject;
	BaseLayer UpperLayer;

	public Receive_Thread(Pcap m_AdapterObject, BaseLayer m_UpperLayer) {
		AdapterObject = m_AdapterObject;
		UpperLayer = m_UpperLayer;
	}

	/*
	 * ���ŵ� �����͸� ���� ���̾�� ����. ��Ʈ��ũ ��Ϳ��� PcapPacketHandler�� ���� �ݺ�
	 */
	public void run() {
		while (true) {
			PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {
				public void nextPacket(PcapPacket packet, String user) {
					data = packet.getByteArray(0, packet.size());
					UpperLayer.Receive(data);
				}
			};

			AdapterObject.loop(100000, jpacketHandler, "");
		}
	}
}
