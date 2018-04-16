package transfer;

public class ChatAppLayer extends BaseLayer {

	final static int CHAT_HEADER_SIZE = 4;
	final static int CHAT_DATA_SIZE = 1456;
	final static int CHAT_TOTAL_SIZE = 1460;

	byte[] capp_totlen; // 사용자가 입력한 문자열의 길이를 저장.
	byte[] capp_type; // 단편화에 대한 정보 ex) 0x00:단편화 되지 않음, 0x01:단편화 첫부분, 0x단편화 중간
	byte[] capp_unused; //사용안함.
	byte[] capp_data;	// 사용자가 입력한 문자열을 저장.
	byte[] capp_packet;

	public ChatAppLayer(String pName) {
		super(pName);
	}

	void resetHeader() {
		capp_totlen = new byte[2];
		capp_type = new byte[1];
		capp_unused = new byte[1];
		capp_data = new byte[CHAT_DATA_SIZE];
	}
	
	@Override
	boolean Send(byte[] data, int nlength) {
		// TODO Auto-generated method stub
		return super.Send(data, nlength);
	}
	
	@Override
	boolean Receive(byte[] data) {
		// TODO Auto-generated method stub
		return super.Receive(data);
	}
}
