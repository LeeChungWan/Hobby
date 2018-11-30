package TemplateMethodLib;

public abstract class AbsGameConnectHelper {

	// 외부에서는 호출하면 안되는데 내부에서 정의해야된다. ==> protected

	// 보안 과정
	protected abstract String doSecurity(String string);

	// 인증 과정
	protected abstract boolean authentication(String id, String password);

	// 권한 과정
	protected abstract int authorization(String userName);

	// 접속 과정
	protected abstract String connection(String info);

	// 템플릿 메소드
	public String requestConnection(String encodedInfo) {
		// 보안 작업 -> 암호화 된 문자열을 복호화
		String decodedInfo = doSecurity(encodedInfo);
		// 복호화된 값으로 아이디, 비밀번호를 할당한다.
		String id = "123";
		String password = "456";

		if (!authentication(id, password)) {
			throw new Error("아이디, 비밀번호가 틀렸습니다.");
		}

		String userName = "userName";
		int i = authorization(userName);
		switch (i) {
		case -1:
			throw new Error("Shut Down!");
		case 0: // 게임 매니저
			System.out.println("게임 매니저");
			break;
		case 1: // 유료 회원
			System.out.println("게임 매니저");
			break;
		case 2: // 무료 회원

			break;
		case 3:// 권한 없음

			break;

		default: // 기타 상황
			break;
		}
		return connection(decodedInfo);
	}
}
