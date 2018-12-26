package No2665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int c;
	static int result;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int[][] c_map;
	static Queue<Integer> q_x = new LinkedList<>();
	static Queue<Integer> q_y = new LinkedList<>();
	static Queue<Integer> q_c = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		c_map = new int[N][N];
		c = 0;
		result = N * N;

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				c_map[i][j] = N * N;
			}
		}

		q_x.add(0);
		q_y.add(0);
		q_c.add(0);
		while (!q_x.isEmpty()) {
			int size = q_x.size();
			int xx, yy, cc;
			for (int i = 0; i < size; i++) {
				xx = q_x.poll();
				yy = q_y.poll();
				cc = q_c.poll();
				bfs(xx, yy, cc);
			}

		}
		System.out.println(c_map[N - 1][N - 1]);

	}

	public static void bfs(int x, int y, int c) {
		if (map[x][y] == 0)
			c++;
		if (c < c_map[x][y]) {
			c_map[x][y] = c;

			for (int i = 0; i < dx.length; i++) {
				int next_x = x + dx[i];
				int next_y = y + dy[i];
				if (next_x >= 0 && next_y >= 0 && next_x < map.length && next_y < map.length) {
					q_x.add(next_x);
					q_y.add(next_y);
					q_c.add(c);
				}

			}
		}
	}

	public static void dfs(int x, int y) {
		if (x == map.length - 1 && y == map.length - 1) {
			if (c < result)
				result = c;
		} else {

			if (map[x][y] == 0) {
				c++;
			}

			if (c < result) {
				for (int i = 0; i < 2; i++) {
					int next_x = x + dx[i];
					int next_y = y + dy[i];
					if (next_x < map.length && next_y < map.length) {
						dfs(next_x, next_y);
					}
				}
			}

			if (map[x][y] == 0) {
				c--;
			}
		}
	}

}
