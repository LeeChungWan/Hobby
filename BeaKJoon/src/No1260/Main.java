package No1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();

		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int edge1 = sc.nextInt();
			int edge2 = sc.nextInt();
			map[edge1][edge2] = 1;
			map[edge2][edge1] = 1;
		}

		visited = new boolean[N + 1];
		System.out.println(dfs(V, ""));

		visited = new boolean[N + 1];
		String bfs = "";
		queue.add(V);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			bfs += v + " ";
			bfs(v);
		}
		System.out.println(bfs);
		sc.close();
	}

	public static String dfs(int v, String s) {
		visited[v] = true;
		s += v + " ";
		String temp = "";
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && map[v][i] == 1)
				temp = dfs(i, s);
			if (temp.length() > s.length())
				s = temp;
		}
		return s;
	}

	public static void bfs(int v) {
		visited[v] = true;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && map[v][i] == 1) {
				visited[i] = true;
				queue.add(i);
			}
		}
	}
}
