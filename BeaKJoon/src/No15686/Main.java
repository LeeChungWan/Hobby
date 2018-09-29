package No15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<int[]> home;
	static List<int[]> chicken;
	static int chicken_distance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);

		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				int[] coordinate = { i, j };
				if (line[j].equals("1")) {
					home.add(coordinate);
				} else if (line[j].equals("2")) {
					chicken.add(coordinate);
				}
			}
		}

		int[] arr = new int[chicken.size()];
		combination(arr, 0, chicken.size(), M, 0);
		System.out.println(chicken_distance);
	}

	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0)
			calculate(arr, index);
		else if (target == n)
			return;
		else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}

	public static void calculate(int[] arr, int length) {
		int temp_total = 0;
		for (int i = 0; i < home.size(); i++) {
			int distance = Integer.MAX_VALUE;
			for (int j = 0; j < length; j++) {
				int gap = Math.abs(chicken.get(arr[j])[0] - home.get(i)[0])
						+ Math.abs(chicken.get(arr[j])[1] - home.get(i)[1]);
				if (gap < distance) {
					distance = gap;
					if (distance == 1)
						break;
				}
			}
			temp_total += distance;
		}
		if (temp_total < chicken_distance)
			chicken_distance = temp_total;
	}

}
