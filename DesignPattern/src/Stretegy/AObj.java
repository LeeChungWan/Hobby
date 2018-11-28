package Stretegy;

public class AObj {

	Ainterface ainterface;

	public AObj() {
		ainterface = new AinterfaceImplement();
	}

	// 기능을 구현할때 다른 객체 기능을 빌려서 사용하는 것.
	public void funcAA() {

		// 위임하다 (델리게이트)
		ainterface.funcA();
		ainterface.funcA();

		// System.out.println("AAA");
		// System.out.println("AAA");

		// ~ 기능이 필요합니다. 개발해주세요.
	}
}
