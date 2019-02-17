package 줄기세포배양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws IOException {
		String result = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int count = 0;
			String[] info = br.readLine().split(" ");
			Cell[][] map = new Cell[450][450];
			boolean[][] contains = new boolean[450][450];
			Integer[] coordinate;
			Queue<Integer[]> coordinates = new LinkedList<>();
			List<Integer[]> flags = new LinkedList<>();
			int N = Integer.parseInt(info[0]);
			int M = Integer.parseInt(info[1]);
			int K = Integer.parseInt(info[2]);
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					if (!line[j].equals("0")) {
						count++;
						map[i + 200][j + 200] = new Cell(Integer.parseInt(line[j]), Integer.parseInt(line[j]),
								"inactive");
						Integer[] flag = { i + 200, j + 200 };
						flags.add(flag);
						coordinates.add(flag);
						contains[i + 200][j + 200] = true;
					}
				}
			}

			for (int k = 1; k <= K; k++) {
				int size = coordinates.size();
				for (int i = 0; i < size; i++) {
					coordinate = coordinates.poll();
					Cell cell = map[coordinate[0]][coordinate[1]];
					int energy = cell.laterEnergy;
					switch (cell.state) {
					case "inactive":
						energy--;
						if (energy == 0) {
							cell.state = "active";
							cell.laterEnergy = cell.initEnergy;
						} else {
							cell.laterEnergy--;
						}
						coordinates.add(coordinate);
						break;
					case "active":
						energy--;
						if (cell.initEnergy - energy == 1) {
							int[] dx = { 0, 0, 1, -1 };
							int[] dy = { 1, -1, 0, 0 };
							for (int d = 0; d < 4; d++) {
								if (contains[coordinate[0] + dx[d]][coordinate[1] + dy[d]]) {
									if (map[coordinate[0] + dx[d]][coordinate[1] + dy[d]].flag) {
										if (cell.initEnergy > map[coordinate[0] + dx[d]][coordinate[1]
												+ dy[d]].initEnergy) {
											map[coordinate[0] + dx[d]][coordinate[1]
													+ dy[d]].initEnergy = cell.initEnergy;
											map[coordinate[0] + dx[d]][coordinate[1]
													+ dy[d]].laterEnergy = cell.initEnergy;
										}
									}
								} else {
									map[coordinate[0] + dx[d]][coordinate[1] + dy[d]] = new Cell(cell.initEnergy,
											cell.initEnergy, "inactive");
									count++;
									Integer[] flag = { coordinate[0] + dx[d], coordinate[1] + dy[d] };
									flags.add(flag);
									contains[coordinate[0] + dx[d]][coordinate[1] + dy[d]] = true;
									coordinates.add(flag);
								}
							}
						}

						if (energy == 0) {
							map[coordinate[0]][coordinate[1]].state = "dead";
							count--;
						} else {
							map[coordinate[0]][coordinate[1]].laterEnergy--;
							coordinates.add(coordinate);
						}
						break;
					default:
						break;
					}
				}
				for (Integer[] key : flags) {
					map[key[0]][key[1]].flag = false;
				}
				flags.clear();
			}
			result += "#" + tc + " " + count + "\n";
		}
		System.out.println(result);
	}
}

class Cell {
	int initEnergy;
	int laterEnergy;
	String state;
	boolean flag;

	public Cell(int initEnergy, int laterEnergy, String state) {
		this.initEnergy = initEnergy;
		this.laterEnergy = laterEnergy;
		this.state = state;
		this.flag = true;
	}

}
