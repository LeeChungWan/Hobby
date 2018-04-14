package transfer;

public abstract class BaseLayer {
	String m_pLayerName; // 레이어 이름
	Object mp_UnderLayer; // 하위 레이어
	Object mp_UpperLayer; // 상위 레이어
	int m_nUpperLayerCount; // 상위 레이어 수
	boolean bSuccess;

	/*
	 * BaseLayer의 생성자로 레이어의 이름을 설정
	 * 
	 * @param pName
	 */
	public BaseLayer(String pName) {
		this.m_nUpperLayerCount = 0;
		this.mp_UnderLayer = null;
		m_pLayerName = pName;
	}

	/*
	 * 상위 레이어를 설정해준다.
	 * 
	 * @param upperLayer
	 */
	void setUpperLayer(Object upperLayer) {
		this.mp_UpperLayer = upperLayer;
	}

	/*
	 * 하위 레이어를 설정해준다.
	 * 
	 * @param underLayer
	 */
	void setUnderLayer(Object underLayer) {
		this.mp_UnderLayer = underLayer;
	}

	/*
	 * 현재 레이어의 상위 레이어를 반환
	 * 
	 * @return this.mp_UpperLayer;
	 */
	Object getUpperLayer() {
		return this.mp_UpperLayer;
	}

	/*
	 * 현재 레이어의 하위 레이어를 반환
	 * 
	 * @return this.mp_UnderLayer;
	 */
	Object getUnderLayer() {
		return this.mp_UnderLayer;
	}

	/*
	 * 해당 레이어의 이름을 반환
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
