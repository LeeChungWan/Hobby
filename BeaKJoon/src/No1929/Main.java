package No1929;

import java.util.Scanner;
/*
 * ���� 1929��  �Ҽ� ���ϱ�
 * �Է� :	ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1��M��N��1,000,000)
 * ��� :	�� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] arr = new boolean[N + 1];
		for (int i = 2; i < arr.length; i++)
			arr[i] = true;
		for (int i = 2; i <= Math.sqrt(N); ++i) {
			if (arr[i]) {
				for (int j = i+i; j <= N; j += i)
					arr[j] = false;
			}

		}
		for (int i = M; i <= N; i++) {
			if (arr[i])
				System.out.println(i);
		}
		sc.close();
	}

}
