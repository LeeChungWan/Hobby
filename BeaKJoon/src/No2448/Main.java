package No2448;

import java.util.Scanner;

public class Main {
	static String[][] arr = new String[3072][3072];

	public static void makeStars(int N, int x, int y) {
		if (N == 3) {
			arr[x][y] = "*";
			arr[x + 1][y - 1] = "*";
			arr[x + 1][y + 1] = "*";
			arr[x + 2][y - 2] = "*";
			arr[x + 2][y - 1] = "*";
			arr[x + 2][y] = "*";
			arr[x + 2][y + 1] = "*";
			arr[x + 2][y + 2] = "*";
			return;
		}
		makeStars(N / 2, x, y);
		makeStars(N / 2, x + N / 2, y - N / 2);
		makeStars(N / 2, x + N / 2, y + N / 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j] = " ";
		}

		makeStars(N, 0, N - 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		sc.close();

	}

}
