package No1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Integer> dx = new LinkedList<>();
	static Queue<Integer> dy = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] info = br.readLine().split(" ");
			M = Integer.parseInt(info[0]);
			N = Integer.parseInt(info[1]);

			map = new int[M][N];
			visited = new boolean[M][N];
			int K = Integer.parseInt(info[2]);
			for (int j = 0; j < K; j++) {
				String[] dot_info = br.readLine().split(" ");
				int x = Integer.parseInt(dot_info[0]);
				int y = Integer.parseInt(dot_info[1]);
				map[x][y] = 1;
				dx.add(x);
				dy.add(y);
			}
			int result = 0;
			while (!dx.isEmpty()) {
				int next_x = dx.poll();
				int next_y = dy.poll();
				if (!visited[next_x][next_y]) {
					result++;
					search(next_x, next_y);
				}

			}
			System.out.println(result);
		}

	}

	public static void search(int x, int y) {
		int[] xx = { 0, 0, 1, -1 };
		int[] yy = { 1, -1, 0, 0 };
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int next_x = x + xx[i];
			int next_y = y + yy[i];

			if (next_x >= 0 && next_x < M && next_y >= 0 && next_y < N && map[next_x][next_y] == 1
					&& !visited[next_x][next_y]) {
				search(next_x, next_y);
			}
		}
	}

}
