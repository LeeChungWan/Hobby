package No10872;

import java.util.Scanner;
/*
 * ���� 10872�� ���丮��
 * �Է� :	ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.
 * ��� :	ù° �ٿ� N!�� ����Ѵ�.
 */
public class Main {
	public static int factorial(int n) {
		if (n < 2)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));
		sc.close();
	}

}
