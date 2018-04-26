package No2448;

import java.util.Scanner;
/*
 * 문제 2448번 별찍기-11
 * 
 * 입력 : 첫째 줄에 N이 주어진다. N은 항상 3*2^k 수이다. (3, 6, 12, 24, 48, ...) (k<=10)
 * 출력 : 첫째 줄부터 N번째 줄까지 별을 출력한다.
 * @author 이충완
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
