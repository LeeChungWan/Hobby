package transfer;

public abstract class BaseLayer {
	String m_pLayerName; // ���̾� �̸�
	Object mp_UnderLayer; // ���� ���̾�
	Object mp_UpperLayer; // ���� ���̾�
	int m_nUpperLayerCount; // ���� ���̾� ��
	boolean bSuccess;

	/*
	 * BaseLayer�� �����ڷ� ���̾��� �̸��� ����
	 * 
	 * @param pName
	 */
	public BaseLayer(String pName) {
		this.m_nUpperLayerCount = 0;
		this.mp_UnderLayer = null;
		m_pLayerName = pName;
	}

	/*
	 * ���� ���̾ �������ش�.
	 * 
	 * @param upperLayer
	 */
	void setUpperLayer(Object upperLayer) {
		this.mp_UpperLayer = upperLayer;
	}

	/*
	 * ���� ���̾ �������ش�.
	 * 
	 * @param underLayer
	 */
	void setUnderLayer(Object underLayer) {
		this.mp_UnderLayer = underLayer;
	}

	/*
	 * ���� ���̾��� ���� ���̾ ��ȯ
	 * 
	 * @return this.mp_UpperLayer;
	 */
	Object getUpperLayer() {
		return this.mp_UpperLayer;
	}

	/*
	 * ���� ���̾��� ���� ���̾ ��ȯ
	 * 
	 * @return this.mp_UnderLayer;
	 */
	Object getUnderLayer() {
		return this.mp_UnderLayer;
	}

	/*
	 * �ش� ���̾��� �̸��� ��ȯ
	 * 
	 * @return this.m_pLayerName;
	 */
	String getLayerName() {
		return this.m_pLayerName;
	}

	boolean Send(byte[] data, int nlength) {
		return false;
	}

	boolean Receive() {
		return false;
	}

	boolean Receive(byte[] data) {
		return false;
	}
}
