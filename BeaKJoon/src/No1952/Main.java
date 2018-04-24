package No1952;

/*
 * 1952번 문제 : 달팽이 2
 * 
 * 입력 : 첫째 줄에 M과 N이 빈 칸을 사이에 두고 주어진다. (2≤M, N≤100)
 * 출력 : 첫째 줄에 표의 모든 칸이 채워질 때까지 선이 꺾어지는 횟수를 출력한다.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m, n;
		int p = 0, q = 0;
		int x, y;
		int count = 0;
		int numOfBrokenLine = 0;
		String direction = "우";

		m = sc.nextInt();
		n = sc.nextInt();

		x = m;
		y = n;
		int[][] visit = new int[m][n];

		while (count != m * n) {
			if (direction.equals("상")) {
				for (int i = x - 1; i >= p; i--) {
					if (visit[i][q] == 0) {
						visit[i][q] = 1;
						count++;
					}
				}
				q++;
				numOfBrokenLine++;
				direction = "우";

			} else if (direction.equals("하")) {
				for (int i = p; i < x; i++) {
					if (visit[i][y - 1] == 0) {
						visit[i][y - 1] = 1;
						count++;
					}
				}
				y--;
				numOfBrokenLine++;
				direction = "좌";

			} else if (direction.equals("좌")) {
				for (int i = y - 1; i >= q; i--) {
					if (visit[x - 1][i] == 0) {
						visit[x - 1][i] = 1;
						count++;
					}
				}
				x--;
				numOfBrokenLine++;
				direction = "상";
			} else { // 오른쪽
				for (int i = q; i < y; i++) {
					if (visit[p][i] == 0) {
						visit[p][i] = 1;
						count++;
					}
				}
				p++;
				numOfBrokenLine++;
				direction = "하";
			}
		}

		System.out.println(numOfBrokenLine - 1);

		sc.close();

	}

}
