package Adapter;

// �α׸� ���� �� �ִ� ����� ����!
// �̹� �������ִ� ���̺귯���� Ʃ�� �� �� �ִ�!
public class AdapterImplement implements Adapter {

	@Override
	public Float twiceOf(Float f) {
		return Math.doubled(f.doubleValue()).floatValue();
		// return (float) Math.twoTime(f.doubleValue());
	}

	@Override
	public Float halfOf(Float f) {
		System.out.println("���� �Լ� ȣ��");
		return (float) Math.half(f.doubleValue());
	}

}
