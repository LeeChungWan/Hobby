import java.util.Scanner;
/*
 * ���� 1094�� �����
 * 
 * �Է�:ù° �ٿ� X�� �־�����. X�� 64���� �۰ų� ���� �ڿ����̴�.
 * ���:������ ������ ��ģ�ٸ�, �� ���� ���븦 Ǯ�� �ٿ��� Xcm�� ���� �� �ִ��� ����Ѵ�.
 */
public class No1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sticksTotalLength = 64;
		int minStick = 64;
		int X = sc.nextInt();
		int count = 1;

		while (X != sticksTotalLength) {
			if (sticksTotalLength > X) {
				minStick /= 2;
				if (sticksTotalLength - minStick >= X) {
					sticksTotalLength -= minStick;
				} else {
					count++;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
