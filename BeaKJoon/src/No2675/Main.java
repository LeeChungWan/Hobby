package No2675;

import java.util.Scanner;

/*
 * ���� 2675�� ���ڿ� �ݺ�
 * ���ڿ� S�� �Է¹��� �Ŀ�, �� ���ڸ� R�� �ݺ��� �� ���ڿ� T�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �ٽ� �������ڸ�, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ T�� ����� �ȴ�. S���� QR Code "alphanumeric" ���ڸ� ����ִ�.
 * QR Code "alphanumeric" ���ڴ� 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ$%*+-./: �̴�.
 * 
 * �Է� : ù° �ٿ� �׽�Ʈ ���̽��� ���� T(1 <= T <= 1,000)�� �־�����. �� �׽�Ʈ ���̽���  �ݺ� Ƚ�� R(1 <= R <= 8), 
 *      ���ڿ� S�� �������� ���еǾ� �־�����. S�� ���̴� ��� 1�̸�, 20���ڸ� ���� �ʴ´�. 
 * ��� : �� �׽�Ʈ ���̽��� ���� T�� ����Ѵ�.
 * @author �����
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		int T = sc.nextInt();
		String[] result = new String[T];
		while (T > 0) {
			int R = sc.nextInt();
			String S = sc.next();
			char[] arr = S.toCharArray();
			String temp = "";
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < R; j++) {
					temp += arr[i];
				}
			}
			result[index++] = temp;
			T--;
		}

		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
		sc.close();
	}

}
