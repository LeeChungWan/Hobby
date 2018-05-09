package No6064;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result = "";
		for (int i = 0; i < T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int indexM = 0;
			int indexN = 0;
			int[][] arr = new int[M][N];
			for (int j = 0; j < M * N; j++) {
				if (indexM < M) {
					if (indexN >= N)
						indexN = 0;
					arr[indexM++][indexN++] = j + 1;

				} else {
					indexM = 0;
					if (indexN == N)
						break;
					arr[indexM++][indexN++] = j + 1;
				}
			}
			if (arr[x - 1][y - 1] != 0)
				result += arr[x - 1][y - 1] + "\n";
			else
				result += "-1\n";
		}
		System.out.println(result);
		sc.close();

	}

}
