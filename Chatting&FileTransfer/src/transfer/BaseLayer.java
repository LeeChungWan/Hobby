package transfer;

public abstract class BaseLayer {
	String m_pLayerName;		// 레이어 이름
	BaseLayer mp_UnderLayer;	// 하위 레이어
	BaseLayer mp_UpperLayer;	// 상위 레이어
	int m_nUpperLayerCount;		// 상위 레이어 수
	
	/*
	 * BaseLayer의 생성자로 레이어의 이름을 설정
	 * @param pName
	 */
	public BaseLayer(String pName){
		this.m_nUpperLayerCount = 0;
		this.mp_UnderLayer = null;
		m_pLayerName = pName;
	}
	
	/*
	 * 상위 레이어를 설정해준다.
	 * @param upperLayer
	 */
	void setUpperLayer(BaseLayer upperLayer){
		this.mp_UpperLayer = upperLayer;
	}
	
	/*
	 * 하위 레이어를 설정해준다.
	 * @param underLayer
	 */
	void setUnderLayer(BaseLayer underLayer){
		this.mp_UnderLayer = underLayer;
	}
	
	/*
	 * 현재 레이어의 상위 레이어를 반환
	 * @return this.mp_UpperLayer;
	 */
	BaseLayer getUpperLayer(){
		return this.mp_UpperLayer;
	}
	
	/*
	 * 현재 레이어의 하위 레이어를 반환
	 * @return this.mp_UnderLayer;
	 */
	BaseLayer getUnderLayer(){
		return this.mp_UnderLayer;
	}
	
	/*
	 * 해당 레이어의 이름을 반환
	 * @return this.m_pLayerName;
	 */
	String getLayerName(){
		return this.m_pLayerName;
	}
}
