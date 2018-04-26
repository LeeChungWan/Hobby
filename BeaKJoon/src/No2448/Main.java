package No2448;

import java.util.Scanner;
/*
 * ���� 2448�� �����-11
 * 
 * �Է� : ù° �ٿ� N�� �־�����. N�� �׻� 3*2^k ���̴�. (3, 6, 12, 24, 48, ...) (k<=10)
 * ��� : ù° �ٺ��� N��° �ٱ��� ���� ����Ѵ�.
 * @author �����
 */
public class Main {
	static char[][] arr = null;

	public static void makeStars(int N, int x, int y) {
		if (N == 3) {
			arr[x][y] = '*';
			arr[x + 1][y - 1] = arr[x + 1][y + 1] = arr[x + 2][y
					- 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = '*';
			return;
		}
		makeStars(N / 2, x, y);
		makeStars(N / 2, x + N / 2, y - N / 2);
		makeStars(N / 2, x + N / 2, y + N / 2);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new char[N][2 * N - 1];
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j] = ' ';
		makeStars(N, 0, N - 1);

		for (int i = 0; i < N; i++)
			System.out.println(arr[i]);
		sc.close();

	}

}
