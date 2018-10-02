package No14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int zero_cnt = 0;
	static int result = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] temp_map;
	static boolean[][] visited;
	static Queue<Integer> virus_x = new LinkedList<>();
	static Queue<Integer> virus_y = new LinkedList<>();
	static List<int[]> zero = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();

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
				if (map[i][j] == 2) {
					virus_x.add(i);
					virus_y.add(j);
				} else if (map[i][j] == 0) {
					int[] sub = { i, j };
					zero.add(sub);
				}
			}
		}

		int n = zero.size();
		combination(n, 3, 0);
		System.out.println(result);
	}

	public static void combination(int n, int r, int index) {
		if (r == 0) {
			showStack();
			return;
		} else if (n == r) {
			for (int i = 0; i < n; i++)
				stack.add(index + i);
			showStack();
			for (int i = 0; i < n; i++)
				stack.pop();
		} else {
			// index를 포함하는 경우
			stack.add(index);
			combination(n - 1, r - 1, index + 1);

			// index를 포함하지 않는 경우
			stack.pop();
			combination(n - 1, r, index + 1);
		}
	}

	public static void showStack() {
		copy_map();
		for (int i = 0; i < stack.size(); i++) {
			temp_map[zero.get(stack.get(i))[0]][zero.get(stack.get(i))[1]] = 1;
		}

		int size = virus_x.size();
		zero_cnt = zero.size() - 3;
		visited = new boolean[map.length][map[0].length];
		for (int i = 0; i < size; i++) {
			int row = virus_x.poll();
			int col = virus_y.poll();
			spead(row, col);
			virus_x.add(row);
			virus_y.add(col);

		}

		if (zero_cnt > result)
			result = zero_cnt;
	}

	public static void spead(int row, int col) {
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			if (row + x[i] >= 0 && row + x[i] < map.length && col + y[i] >= 0 && col + y[i] < map[row].length
					&& !visited[row + x[i]][col + y[i]]) {
				if (temp_map[row + x[i]][col + y[i]] == 0) {
					temp_map[row + x[i]][col + y[i]] = 2;
					zero_cnt--;
					spead(row + x[i], col + y[i]);
				}
			}
		}
	}

	public static void copy_map() {
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp_map[i], 0, map[i].length);
		}
	}
}
