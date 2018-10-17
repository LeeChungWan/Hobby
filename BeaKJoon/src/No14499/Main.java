package No14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int global_x;
	static int global_y;
	static int[][] map;
	static int[] dice = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		global_x = Integer.parseInt(info[2]);
		global_y = Integer.parseInt(info[3]);
		int K = Integer.parseInt(info[4]);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		String[] orders = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			roll(global_x, global_y, Integer.parseInt(orders[i]) - 1);
		}

	}

	public static void roll(int x, int y, int order) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		int temp_west = 0;
		int temp_east = 0;
		if (x + dx[order] >= 0 && x + dx[order] < map.length && y + dy[order] >= 0 && y + dy[order] < map[x].length) {
			switch (order) {
			case 0:
				if (map[x + dx[order]][y + dy[order]] == 0) {
					map[x + dx[order]][y + dy[order]] = dice[1];
				} else {
					dice[1] = map[x + dx[order]][y + dy[order]];
					map[x + dx[order]][y + dy[order]] = 0;
				}
				temp_west = dice[0];
				temp_east = dice[1];
				dice[0] = dice[5];
				dice[1] = dice[3];
				dice[3] = temp_west;
				dice[5] = temp_east;
				break;
			case 1:
				if (map[x + dx[order]][y + dy[order]] == 0) {
					map[x + dx[order]][y + dy[order]] = dice[0];
				} else {
					dice[0] = map[x + dx[order]][y + dy[order]];
					map[x + dx[order]][y + dy[order]] = 0;
				}
				temp_west = dice[0];
				temp_east = dice[1];
				dice[0] = dice[3];
				dice[1] = dice[5];
				dice[3] = temp_east;
				dice[5] = temp_west;
				break;
			case 2:
				if (map[x + dx[order]][y + dy[order]] == 0) {
					map[x + dx[order]][y + dy[order]] = dice[2];
				} else {
					dice[2] = map[x + dx[order]][y + dy[order]];
					map[x + dx[order]][y + dy[order]] = 0;
				}
				int temp_first = dice[2];
				System.arraycopy(dice, 3, dice, 2, 3);
				dice[5] = temp_first;
				break;
			case 3:
				if (map[x + dx[order]][y + dy[order]] == 0) {
					map[x + dx[order]][y + dy[order]] = dice[4];
				} else {
					dice[4] = map[x + dx[order]][y + dy[order]];
					map[x + dx[order]][y + dy[order]] = 0;
				}
				int temp_last = dice[5];
				System.arraycopy(dice, 2, dice, 3, 3);
				dice[2] = temp_last;
				break;
			default:
				break;
			}
			global_x = x + dx[order];
			global_y = y + dy[order];
			System.out.println(dice[3]);
		}
	}

}
