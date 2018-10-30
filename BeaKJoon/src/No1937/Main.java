package No1937;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int[][] dp;
	static int result = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				move(i, j);
			}

		}
		System.out.println(result);
	}

	public static int move(int x, int y) {
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		if (dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];

			// 범위 조건
			if (next_x >= 0 && next_x < map.length && next_y >= 0 && next_y < map.length
					&& map[x][y] < map[next_x][next_y]) {
				int temp = 1;
				temp += move(next_x, next_y);
				dp[x][y] = Math.max(temp, dp[x][y]);
				if (dp[x][y] > result)
					result = dp[x][y];

			}
		}
		return dp[x][y];
	}
}
