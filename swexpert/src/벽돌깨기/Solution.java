package 벽돌깨기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int W;
	static int H;
	static int cnt_block;
	static int compare_block;
	static int result;
	static int[] list;
	static int[][] global_map;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			cnt_block = 0;
			compare_block = 0;
			result = Integer.MAX_VALUE;
			
			String[] info = br.readLine().split(" ");
			N = Integer.parseInt(info[0]);
			W = Integer.parseInt(info[1]);
			H = Integer.parseInt(info[2]);

			list = new int[N];

			global_map = new int[H][W];
			map = new int[H][W];

			for (int j = 0; j < H; j++) {
				String[] line = br.readLine().split(" ");
				for (int k = 0; k < W; k++) {
					global_map[j][k] = Integer.parseInt(line[k]);
					if (global_map[j][k] != 0)
						cnt_block++;
				}
			}

			permutation(0);
			System.out.println("#" + (i+1) + " " + result);
		}
	}

	public static void permutation(int depth) {
		if (depth == N) {
			copy_map();
			compare_block = cnt_block;
			for (int i = 0; i < list.length; i++) {
				boom(list[i]);
			}
			if (compare_block < result)
				result = compare_block;
			return;
		}
		for (int i = 0; i < W; i++) {
			list[depth] = i;
			permutation(depth + 1);
		}
	}

	public static void boom(int col) {
		int row = searchTopRow(col);
		// -1인 경우 해당 열의 블록이 없는경우.
		if (row != -1) {
			int type = map[row][col];
			map[row][col] = 0; // 해당 위치 터짐.
			compare_block--;
			nextBoom(row, col, type);
			sliding();
		}
	}

	public static void sliding() {
		for (int i = 0; i < map[0].length; i++) {
			int idx = map.length - 1;
			int[] save = new int[map.length];
			for (int j = map.length - 1; j >= 0; j--) {
				if (map[j][i] != 0)
					save[idx--] = map[j][i];
			}
			for (int j = map.length - 1; j >= 0; j--) {
				if (save[j] != 0)
					map[j][i] = save[j];
				else
					map[j][i] = 0;
			}
		}
	}

	public static void nextBoom(int row, int col, int type) {
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int j = 0; j < 4; j++) {
			int next_row = row + dx[j];
			int next_col = col + dy[j];
			// 숫자 써있는거 -1 만큼 터치기
			for (int i = 0; i < type - 1; i++) {
				if (next_row >= 0 && next_row < map.length && next_col >= 0 && next_col < map[row].length
						&& map[next_row][next_col] != 0) {
					compare_block--;
					if (map[next_row][next_col] == 1)
						map[next_row][next_col] = 0;
					else {
						int next_type = map[next_row][next_col];
						map[next_row][next_col] = 0;
						nextBoom(next_row, next_col, next_type);
					}
				}

				next_row += dx[j];
				next_col += dy[j];
			}
		}
	}

	public static int searchTopRow(int index) {
		for (int i = 0; i < H; i++) {
			if (map[i][index] != 0)
				return i;
		}
		return -1;
	}

	public static void copy_map() {
		for (int i = 0; i < global_map.length; i++)
			System.arraycopy(global_map[i], 0, map[i], 0, global_map[i].length);
	}

}