package No7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] boxs;
	static int[][] box;
	static int cnt_ripen = 0;
	static int cnt_empty = 0;
	static Queue<Integer> dx = new LinkedList<>();
	static Queue<Integer> dy = new LinkedList<>();
	static Queue<Integer> dh = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(tokens.nextToken());
		int row = Integer.parseInt(tokens.nextToken());
		int height = Integer.parseInt(tokens.nextToken());

		boxs = new int[height][][];
		for (int j = 0; j < height; j++) {
			box = new int[row][col];
			int cnt_row = 0;
			for (int k = 0; k < row; k++) {
				tokens = new StringTokenizer(br.readLine(), " ");
				int[] sub_box = new int[col];
				while (tokens.hasMoreTokens()) {
					for (int i = 0; i < col; i++) {
						sub_box[i] = Integer.parseInt(tokens.nextToken());
						if (sub_box[i] == 1) {
							dx.add(cnt_row);
							dy.add(i);
							dh.add(j);
							cnt_ripen++;
						}
						if (sub_box[i] == -1)
							cnt_empty++;
					}
				}
				box[cnt_row] = sub_box;
				cnt_row++;
				boxs[j] = box;
			}
		}

		int temp_ripen = cnt_ripen;
		int cnt_day = 0;
		boolean case1 = false;
		boolean case2 = false;
		boolean case3 = false;
		while (!dx.isEmpty()) {

			int size = dx.size();
			for (int i = 0; i < size; i++) {
				ripen(dx.poll(), dy.poll(), dh.poll());
			}

			if (temp_ripen == cnt_ripen) {
				if (cnt_ripen + cnt_empty == row * col * height) {
					// case1 : 모두 익음
					case1 = true;
					break;
				} else if (cnt_day == 0 && cnt_ripen + cnt_empty == row * col * height) {
					// case3 : 처음부터 다익음
					case3 = true;
					break;
				} else {
					// case2 : 몇개 못익음
					case2 = true;
					break;
				}

			} else {
				cnt_day++;
				temp_ripen = cnt_ripen;
			}

		}

		if (case1) {
			System.out.println(cnt_day);
		} else if (case2) {
			System.out.println(-1);
		} else if (case3) {
			System.out.println(0);
		}

	}

	public static void ripen(int row, int col, int height) {
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		int[] h = { 1, -1 };
		// 같은 층의 박스 검사
		for (int i = 0; i < x.length; i++) {
			if (row + x[i] >= 0 && row + x[i] < box.length && col + y[i] >= 0 && col + y[i] < box[row].length) {
				if (boxs[height][row + x[i]][col + y[i]] == 0) {
					boxs[height][row + x[i]][col + y[i]] = 1;
					dx.add(row + x[i]);
					dy.add(col + y[i]);
					dh.add(height);
					cnt_ripen++;
				}
			}
		}
		// 다른 층의 박스 검사
		for (int i = 0; i < h.length; i++) {
			if (height + h[i] >= 0 && height + h[i] < boxs.length) {
				if (boxs[height + h[i]][row][col] == 0) {
					boxs[height + h[i]][row][col] = 1;
					dx.add(row);
					dy.add(col);
					dh.add(height + h[i]);
					cnt_ripen++;
				}
			}
		}
	}
}
