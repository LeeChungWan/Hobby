package No11720;

import java.util.Scanner;
/*
 * ����11720�� : ������ ��
 * �Է� : ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٿ� ���� N���� ������� �־�����.
 * ��� : �Է����� �־��� ���� N���� ���� ����Ѵ�.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String value = sc.next();
		int sum = 0;
		char[] arr = value.toCharArray();
		for (int i = 0; i < num; i++) {
			sum += arr[i] - 48;
		}
		System.out.println(sum);
		sc.close();
	}
}
