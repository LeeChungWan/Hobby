package Stretegy;

public class Main {

	public static void main(String[] args) {
		Ainterface ainterface = new AinterfaceImplement();

		// ��� ��� ���
		ainterface.funcA();

		AObj aObj = new AObj();
		aObj.funcAA();
		
		GameChracter chracter = new GameChracter();
		
		chracter.attack();
		
		chracter.setWeapon(new Knife());
		chracter.attack();
		
		chracter.setWeapon(new Sword());
		chracter.attack();
		
		chracter.setWeapon(new Ax());
		chracter.attack();
	}

}
