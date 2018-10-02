package No2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int[][] temp_map;
	static int group = 0;
	static int years = 0;
	static boolean[][] visited;
	static Queue<Integer> dx = new LinkedList<>();
	static Queue<Integer> dy = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int row = Integer.parseInt(info[0]);
		int col = Integer.parseInt(info[1]);
		map = new int[row][col];
		temp_map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] != 0) {
					dx.add(i);
					dy.add(j);
				}
			}
		}

		boolean isBreak = false;
		while (!dx.isEmpty()) {
			// melt_ice에서 전것이 이후것에 영향을 주면 copy()가 필요함.
			copy();
			int size = dx.size();
			for (int i = 0; i < size; i++) {
				melt_ice(dx.poll(), dy.poll());
			}
			years++;

			group = 0;
			visited = new boolean[row][col];
			Queue<Integer> temp_x = new LinkedList<>();
			Queue<Integer> temp_y = new LinkedList<>();
			while (!dx.isEmpty()) {
				int x = dx.poll();
				int y = dy.poll();
				temp_x.add(x);
				temp_y.add(y);
				if (!visited[x][y]) {
					group++;
					search(x, y);
				}

			}
			if (group > 1) {
				System.out.println(years);
				isBreak = true;
				break;
			}
			dx = temp_x;
			dy = temp_y;
		}
		if (!isBreak)
			System.out.println(0);

	}

	public static void search(int row, int col) {
		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			if (row + x[i] >= 0 && row + x[i] < map.length && col + y[i] >= 0 && col + y[i] < map[row].length
					&& !visited[row + x[i]][col + y[i]]) {
				if (map[row + x[i]][col + y[i]] > 0)
					search(row + x[i], col + y[i]);
			}
		}
	}

	public static void melt_ice(int row, int col) {
		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (row + x[i] >= 0 && row + x[i] < map.length && col + y[i] >= 0 && col + y[i] < map[row].length) {
				if (temp_map[row + x[i]][col + y[i]] == 0)
					cnt++;
			}
		}
		int remain = map[row][col] - cnt;
		if (remain <= 0) {
			map[row][col] = 0;
		} else {
			dx.add(row);
			dy.add(col);
			map[row][col] = remain;
		}
	}

	public static void copy() {
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp_map[i], 0, map[i].length);
		}
	}
}
