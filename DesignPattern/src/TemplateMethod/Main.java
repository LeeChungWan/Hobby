package TemplateMethod;

import TemplateMethodLib.AbsGameConnectHelper;
import TemplateMethodLib.DefaultGameConnectHelper;

public class Main {
	public static void main(String[] args) {
		AbsGameConnectHelper helper = new DefaultGameConnectHelper();

		helper.requestConnection("아이디/암호 접속정보");

	}
}
