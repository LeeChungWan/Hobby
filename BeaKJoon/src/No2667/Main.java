package No2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static Queue<Integer> dx = new LinkedList<>();
	static Queue<Integer> dy = new LinkedList<>();
	static List<Integer> result = new LinkedList<>();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		int row_idx = 0;
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			int[] sub = new int[N];
			for (int j = 0; j < line.length; j++) {
				sub[j] = Integer.parseInt(line[j]);
				if (sub[j] == 1) {
					dx.add(row_idx);
					dy.add(j);
				}
			}
			map[row_idx++] = sub;
		}
		while (!dx.isEmpty()) {
			int x = dx.poll();
			int y = dy.poll();
			if(!visited[x][y]){
				cnt = 1;
				search(x, y);
				result.add(cnt);
			}
			
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
	}

	public static void search(int row, int col) {
		visited[row][col] = true;
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };

		for (int i = 0; i < x.length; i++) {
			if (row + x[i] >= 0 && row + x[i] < map.length && col + y[i] >= 0 && col + y[i] < map.length
					&& !visited[row + x[i]][col + y[i]]) {
				if (map[row + x[i]][col + y[i]] == 1) {
					cnt++;
					search(row + x[i], col + y[i]);
				}
			}
		}
	}

}
