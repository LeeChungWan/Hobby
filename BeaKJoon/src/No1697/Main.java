package No1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt = 0;
	static boolean isFind = false;
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		search(N, K);
		while (!isFind && !queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				if(!isFind)
					search(queue.poll(), K);
				else
					break;
			}
		}
		System.out.println(cnt);
	}

	public static void search(int n, int k) {
		int[] next = { n - 1, n + 1, 2 * n };

		if (!isFind) {
			if (n == k)
				isFind = true;
			else {
				for (int i = 0; i < next.length; i++) {
					if (next[i] == k) {
						isFind = true;
						cnt++;
						break;
					} else if (!visited[next[i]] && next[i] >= 0 && next[i] <= 100000) {
						visited[next[i]] = true;
						queue.add(next[i]);
					}
				}

			}

		}
	}

}
