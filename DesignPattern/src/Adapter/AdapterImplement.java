package Adapter;

// 로그를 찍을 수 있는 기능을 제공!
// 이미 구현되있는 라이브러리를 튜닝 할 수 있다!
public class AdapterImplement implements Adapter {

	@Override
	public Float twiceOf(Float f) {
		return Math.doubled(f.doubleValue()).floatValue();
		// return (float) Math.twoTime(f.doubleValue());
	}

	@Override
	public Float halfOf(Float f) {
		System.out.println("절반 함수 호출");
		return (float) Math.half(f.doubleValue());
	}

}
