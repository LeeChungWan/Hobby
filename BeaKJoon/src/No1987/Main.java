package No1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] map;
	static boolean[] visited = new boolean[26];
	static int result = 0;
	static int temp = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int row = Integer.parseInt(info[0]);
		int col = Integer.parseInt(info[1]);

		map = new String[row][col];

		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				map[i][j] = line[j];
			}
		}
		search(0, 0);
		System.out.println(temp);
	}

	public static void search(int x, int y) {
		int idx = map[x][y].charAt(0) - 65;
		visited[idx] = true;
		result++;
		if(temp < result)
			temp = result;
		
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		
		for(int i=0; i<dx.length; i++){
			if(x+dx[i] >=0 && x+dx[i]<map.length && y+dy[i]>=0&&y+dy[i]<map[x].length){
				int next_idx = map[x+dx[i]][y+dy[i]].charAt(0) - 65;
				if(!visited[next_idx]){
					search(x+dx[i], y+dy[i]);
				}
			}
		}
		visited[idx] = false;
		result--;
	}

}
