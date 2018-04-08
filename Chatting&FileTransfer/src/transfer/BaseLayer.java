package transfer;

public abstract class BaseLayer {
	String m_pLayerName;		// ���̾� �̸�
	BaseLayer mp_UnderLayer;	// ���� ���̾�
	BaseLayer mp_UpperLayer;	// ���� ���̾�
	int m_nUpperLayerCount;		// ���� ���̾� ��
	
	/*
	 * BaseLayer�� �����ڷ� ���̾��� �̸��� ����
	 * @param pName
	 */
	public BaseLayer(String pName){
		this.m_nUpperLayerCount = 0;
		this.mp_UnderLayer = null;
		m_pLayerName = pName;
	}
	
	/*
	 * ���� ���̾ �������ش�.
	 * @param upperLayer
	 */
	void setUpperLayer(BaseLayer upperLayer){
		this.mp_UpperLayer = upperLayer;
	}
	
	/*
	 * ���� ���̾ �������ش�.
	 * @param underLayer
	 */
	void setUnderLayer(BaseLayer underLayer){
		this.mp_UnderLayer = underLayer;
	}
	
	/*
	 * ���� ���̾��� ���� ���̾ ��ȯ
	 * @return this.mp_UpperLayer;
	 */
	BaseLayer getUpperLayer(){
		return this.mp_UpperLayer;
	}
	
	/*
	 * ���� ���̾��� ���� ���̾ ��ȯ
	 * @return this.mp_UnderLayer;
	 */
	BaseLayer getUnderLayer(){
		return this.mp_UnderLayer;
	}
	
	/*
	 * �ش� ���̾��� �̸��� ��ȯ
	 * @return this.m_pLayerName;
	 */
	String getLayerName(){
		return this.m_pLayerName;
	}
}
