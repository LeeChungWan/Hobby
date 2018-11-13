package No1463;

import java.util.Scanner;

public class Main {
	static boolean[] visited = new boolean[1000001];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		function(sc.nextInt(), 0);
		System.out.println(result);
		sc.close();
	}

	public static void function(int value, int idx) {
		int temp1 = value % 3;
		int temp2 = value % 2;
		int temp3 = value - 1;
		
		if(idx > result)
			return;
		
		visited[value] = true;
		
		if (value == 1) {
			if (idx < result)
				result = idx;
		} else {

			if (temp1 == 0 && !visited[value / 3])
				function(value / 3, idx + 1);
			if (temp2 == 0 && !visited[value / 2])
				function(value / 2, idx + 1);
			if (!visited[temp3])
				function(temp3, idx + 1);
		}
		visited[value] = false;
	}
}
