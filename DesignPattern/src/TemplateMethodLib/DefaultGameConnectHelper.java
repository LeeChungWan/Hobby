package TemplateMethodLib;

public class DefaultGameConnectHelper extends AbsGameConnectHelper {

	@Override
	protected String doSecurity(String string) {
		System.out.println("강화된 알고리즘을 이용한 디코드 과정");
		return string;
	}

	@Override
	protected boolean authentication(String id, String password) {
		System.out.println("아이디 암호 확인 과정");
		return true;
	}

	@Override
	protected int authorization(String userName) {
		System.out.println("권한 확인 과정");
		// 서버에서 유저의 나이를 확인하여 Shutdown제도 도입
		return 0;
	}

	@Override
	protected String connection(String info) {
		System.out.println("마지막 접속 단계!");
		return info;
	}

}
