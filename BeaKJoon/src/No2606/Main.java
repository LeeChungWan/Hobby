package No2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	static boolean[][] infection;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPC = Integer.parseInt(br.readLine());
		int numOfEdge = Integer.parseInt(br.readLine());
		infection = new boolean[numOfPC][numOfPC];
		visited = new boolean[numOfPC];
		
		for (int i = 0; i < numOfEdge; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			infection[x - 1][y - 1] = true;
			infection[y - 1][x - 1] = true;
		}
		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int now) {
		visited[now] = true;
		for (int i = 0; i < visited.length; i++) {
			if(infection[now][i] && !visited[i]){
				cnt++;
				dfs(i);
			}
		}
	}
	
}
