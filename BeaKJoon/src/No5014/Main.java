package No5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); // �ǹ����� ���� ���� ��
		S = sc.nextInt(); // ���� ����
		G = sc.nextInt(); // ������ ����
		U = sc.nextInt(); // �ö� �� �� �ִ� ���
		D = sc.nextInt(); // ���� �� �� �ִ� ���
		int count = 0;
		boolean isFind = false;
		boolean[] visited = new boolean[F + 1];
		visited[0] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		visited[S] = true;
		breakOut: while (!queue.isEmpty()) {
			int loop = queue.size();
			for (int i = 0; i < loop; i++) {
				int compare = queue.poll();
				if (compare == G) {
					isFind = true;
					break breakOut;
				} else {
					int up = compare + U;
					int down = compare - D;
					if (up <= F) {
						if (!visited[up]) {
							visited[up] = true;
							queue.add(up);
						}
					}
					if (down >= 1) {
						if (!visited[down]) {
							visited[down] = true;
							queue.add(down);
						}
					}
				}
			}
			count++;
		}
		if (isFind)
			System.out.println(count);
		else
			System.out.println("use the stairs");
		sc.close();
	}

}
