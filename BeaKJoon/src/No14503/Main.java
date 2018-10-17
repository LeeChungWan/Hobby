package No14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int area = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] map_info = br.readLine().split(" ");
		int row = Integer.parseInt(map_info[0]);
		int col = Integer.parseInt(map_info[1]);

		map = new int[row][col];

		String[] robot_info = br.readLine().split(" ");
		int dx = Integer.parseInt(robot_info[0]);
		int dy = Integer.parseInt(robot_info[1]);
		int direction = Integer.parseInt(robot_info[2]);

		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		clean(dx, dy, direction);
		System.out.println(area);
	}

	public static void clean(int x, int y, int direction) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int cnt = 0;
		int row = 0;
		int col = 0;
		boolean isBreak = false;

		if (map[x][y] == 0) {
			// 1
			map[x][y] = -1;
			area++;
		}
		while (cnt++ < 4) {
			if (--direction < 0)
				direction = 3;
			// 2-1
			row = x + dx[direction];
			col = y + dy[direction];
			if (map[row][col] == 0) {
				isBreak = true;
				break;
			}
		}

		if (isBreak)
			clean(row, col, direction);
		if (cnt > 4) {
			int next_x = x + dx[direction] * -1;
			int next_y = y + dy[direction] * -1;
			if (map[x + dx[direction] * -1][y + dy[direction] * -1] != 1)
				clean(next_x, next_y, direction);

		}

	}

}
