package TemplateMethodLib;

public abstract class AbsGameConnectHelper {

	// �ܺο����� ȣ���ϸ� �ȵǴµ� ���ο��� �����ؾߵȴ�. ==> protected

	// ���� ����
	protected abstract String doSecurity(String string);

	// ���� ����
	protected abstract boolean authentication(String id, String password);

	// ���� ����
	protected abstract int authorization(String userName);

	// ���� ����
	protected abstract String connection(String info);

	// ���ø� �޼ҵ�
	public String requestConnection(String encodedInfo) {
		// ���� �۾� -> ��ȣȭ �� ���ڿ��� ��ȣȭ
		String decodedInfo = doSecurity(encodedInfo);
		// ��ȣȭ�� ������ ���̵�, ��й�ȣ�� �Ҵ��Ѵ�.
		String id = "123";
		String password = "456";

		if (!authentication(id, password)) {
			throw new Error("���̵�, ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}

		String userName = "userName";
		int i = authorization(userName);
		switch (i) {
		case -1:
			throw new Error("Shut Down!");
		case 0: // ���� �Ŵ���
			System.out.println("���� �Ŵ���");
			break;
		case 1: // ���� ȸ��
			System.out.println("���� �Ŵ���");
			break;
		case 2: // ���� ȸ��

			break;
		case 3:// ���� ����

			break;

		default: // ��Ÿ ��Ȳ
			break;
		}
		return connection(decodedInfo);
	}
}
