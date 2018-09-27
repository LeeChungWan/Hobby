package No2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] miro;
	static boolean[][] visited;
	static Queue<Integer> dx = new LinkedList<>();
	static Queue<Integer> dy = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		makeMiro();
		System.out.println(searchMiro());
	}

	public static void makeMiro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(tokens.nextToken());
		int col = Integer.parseInt(tokens.nextToken());
		miro = new int[row][col];
		visited = new boolean[row][col];
		visited[0][0] = true;

		for (int i = 0; i < row; i++) {
			int[] sub_miro = new int[col];
			String[] line = br.readLine().split("");

			for (int j = 0; j < line.length; j++) {
				sub_miro[j] = Integer.parseInt(line[j]);
			}

			miro[i] = sub_miro;
		}
		dx.add(0);
		dy.add(0);
	}

	public static int searchMiro() {
		int cnt = 2;
		breakOut: while (!dx.isEmpty()) {
			int size = dx.size();
			for (int i = 0; i < size; i++) {
				boolean result = search(dx.poll(), dy.poll());
				if (result)
					break breakOut;
			}
			cnt++;
		}
		return cnt;
	}

	public static boolean search(int row, int col) {
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };

		for (int i = 0; i < x.length; i++) {
			if (row + x[i] >= 0 && row + x[i] < miro.length && col + y[i] >= 0 && col + y[i] < miro[row].length) {
				if (row + x[i] == miro.length - 1 && col + y[i] == miro[row].length - 1) {
					return true;
				}
				if (miro[row + x[i]][col + y[i]] == 1 && !visited[row + x[i]][col + y[i]]) {
					dx.add(row + x[i]);
					dy.add(col + y[i]);
					visited[row + x[i]][col + y[i]] = true;
				}
			}
		}
		return false;
	}
}
