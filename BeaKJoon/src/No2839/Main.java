package No2839;

import java.util.Scanner;

/*
 * ���� 2839��: ���� ���
 * �Է� : ù° �ٿ� N�� �־�����. (3 �� N �� 5000)
 * ��� : ����̰� ����ϴ� ������ �ּ� ������ ����Ѵ�. ����, ��Ȯ�ϰ� Nų�α׷��� ���� �� ���ٸ� -1�� ����Ѵ�.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = -1;
		int temp = 0;
		int count = 0;
		// 5�� ����� ���
		if (N % 5 == 0)
			System.out.println(N / 5);
		else {
			// 3�� ����� ��츦 �ּ��� ���� �ʱ�ȭ.
			if (N % 3 == 0)
				min = N / 3;
			// 5�� x�� 3�� y���� �ּ��� ������ ���Ҽ� �ִ°��.
			count = N / 5;
			while (count != 0) {
				temp = N - 5 * (count);
				if (temp % 3 != 0) {
					count--;
				} else {
					min = count + temp / 3;
					break;
				}
			}
			System.out.println(min);
		}
		sc.close();
	}
}
