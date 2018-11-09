package No12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int M = 0;
	static int cnt_loop = -1;
	static int cnt_dupl = 0;
	static boolean[] visited = new boolean[100001];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if (N == M) {
			System.out.println(0);
			System.out.println(1);
		} else {
			queue.add(N);
			while (!queue.isEmpty()) {
				int size = queue.size();
				cnt_loop++;
				for (int i = 0; i < size; i++) {
					int dot = queue.poll();
					search(dot);
				}
				if (cnt_dupl != 0)
					break;
			}

			System.out.println(cnt_loop);
			System.out.println(cnt_dupl);
		}
		sc.close();
	}

	public static void search(int dot) {
		int[] next_dot = { dot - 1, dot + 1, 2 * dot };

		visited[dot] = true;
		if (dot == M) {
			cnt_dupl++;
		} else {
			for (int i = 0; i < 3; i++) {
				if (next_dot[i] >= 0 && next_dot[i] < 100001 && !visited[next_dot[i]]) {
					queue.add(next_dot[i]);
				}
			}
		}
	}

}
