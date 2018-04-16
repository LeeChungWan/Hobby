package transfer;

public class ChatAppLayer extends BaseLayer {

	final static int CHAT_HEADER_SIZE = 4;
	final static int CHAT_DATA_SIZE = 1456;
	final static int CHAT_TOTAL_SIZE = 1460;

	byte[] capp_totlen; // ����ڰ� �Է��� ���ڿ��� ���̸� ����.
	byte[] capp_type; // ����ȭ�� ���� ���� ex) 0x00:����ȭ ���� ����, 0x01:����ȭ ù�κ�, 0x����ȭ �߰�
	byte[] capp_unused; //������.
	byte[] capp_data;	// ����ڰ� �Է��� ���ڿ��� ����.
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
