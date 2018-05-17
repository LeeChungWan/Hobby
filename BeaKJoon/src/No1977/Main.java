package No1977;

import java.util.Scanner;
/*
 * ���� 1977�� ����������
 * �Է� :	ù° �ٿ� M��, ��° �ٿ� N�� �־�����. M�� N�� 10000������ �ڿ����̸� M�� N���� ���ų� �۴�.
 * ��� :	M�̻� N������ �ڿ��� �� ������������ ���� ��� ã�� ù° �ٿ� �� ����, ��° �ٿ� �� �� �ּҰ��� ����Ѵ�. 
 * 		��, M�̻� N������ �ڿ��� �� ������������ ���� ���� ù° �ٿ� -1�� ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		double num = 0;
		int min = 0;
		int sum = 0;
		boolean checkMin = false;
		for (int i = M; i <= N; i++) {
			num = Math.sqrt(i);
			if (num - (int) num == 0) {
				sum += i;
				if (!checkMin) {
					min = i;
					checkMin = true;
				}
			}
		}
		if (sum != 0)
			System.out.println(sum + "\n" + min);
		else
			System.out.println(-1);
		sc.close();
	}
}
