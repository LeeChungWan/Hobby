package Stretegy;

public class AObj {

	Ainterface ainterface;

	public AObj() {
		ainterface = new AinterfaceImplement();
	}

	// ����� �����Ҷ� �ٸ� ��ü ����� ������ ����ϴ� ��.
	public void funcAA() {

		// �����ϴ� (��������Ʈ)
		ainterface.funcA();
		ainterface.funcA();

		// System.out.println("AAA");
		// System.out.println("AAA");

		// ~ ����� �ʿ��մϴ�. �������ּ���.
	}
}
