package transfer;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class NILayer extends BaseLayer {
	// 정적으로 jnetpcap.dll 파일 로드
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

	int m_iNumAdapter; // 네트워크 어뎁터 인덱스
	String pLayerName; // 레이어의 이름
	public Pcap m_AdapterObject; // 네트워크 어뎁터 객체
	public PcapIf device; // 네트워크 인터페이스 객체
	public java.util.List<PcapIf> m_pAdapterList; // 네트워크 인터페이스 목록
	StringBuilder errbuf = new StringBuilder(); // 에러버퍼

	/*
	 * NILayer의 생성자 필드 변수들을 초기화 네트워크 어렙터 목록 가져오기 함수 호출
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
	 * 선택된 네트워크 어뎁터 인덱스로 변수 초기화.
	 * 패킷 드라이버 시작 함수 실행.
	 * 패킷 수신함수 실행.
	 * @param iNum
	 */
	public void setAdapterNumber(int iNum) {
		m_iNumAdapter = iNum;
		packetStartDriver();
		Receive();
	}
	
	/*
	 * 현재 컴퓨터에 존재하는 모든 네트워크 어뎁터 목록 가져오기.
	 * 테트워크 어뎁터가 하나도 존재하지 않을 경우 에러 처리
	 */
	private void setAdapterList() {
		int r = Pcap.findAllDevs(m_pAdapterList, errbuf);
		if (r == Pcap.NOT_OK || m_pAdapterList.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s", errbuf);
			return;
		}
	}

	/*
	 * Pcap 동작에 필요한 기본 설정을 위한 변수 설정.
	 * 선택된 네트워크 어뎁터 및 설정된 옵션에 맟줘진 Pcap 작동 시작
	 */
	private void packetStartDriver() {
		int snaplen = 64 * 1024;
		int flags = Pcap.MODE_PROMISCUOUS;
		int timeout = 10 * 1000;
		m_AdapterObject = Pcap.openLive(m_pAdapterList.get(m_iNumAdapter).getName(), snaplen, flags, timeout, errbuf);
	}
	
	/*
	 * 패킷 전송 함수.
	 * 상위 레이어로부터 전달 받은 데이터를 바이트 버퍼에 닫음.
	 * 네트워크 어뎁터의 sendPacket() 함수를 통해 데이터 전송
	 * 패킷 전송이 실패한 경우 에러 메시지 출력 및 false 반환
	 * 패킷 전송이 성공한 경우 true 반환
	 * @param input, length
	 */
	public boolean Send(byte[] input, int length) {
		ByteBuffer buf = ByteBuffer.wrap(input);
		if (m_AdapterObject.sendPacket(buf) != Pcap.OK) {
			System.err.println(m_AdapterObject.getErr());
			return false;
		}
		return true;
	}

	/*
	 * 패킷 수신 시 패킷 처리를 위한 runnable 클래스 생성.
	 * Thread 생성 및 시작.
	 */
	private boolean Receive() {
		Receive_Thread thread = new Receive_Thread(m_AdapterObject, this.getUpperLayer());
		Thread obj = new Thread(thread);
		obj.start();

		return false;
	}
}

/*
 * 패킷 수신을 위한 Runnable class
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
	 * 수신된 데이터를 상위 레이어로 전달.
	 * 네트쿼크 어엡터에서 PcapPacketHandler를 무한 반복
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
