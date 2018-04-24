package No1952;

/*
 * 1952�� ���� : ������ 2
 * 
 * �Է� : ù° �ٿ� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (2��M, N��100)
 * ��� : ù° �ٿ� ǥ�� ��� ĭ�� ä���� ������ ���� �������� Ƚ���� ����Ѵ�.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m, n;
		int p = 0, q = 0;
		int x, y;
		int count = 0;
		int numOfBrokenLine = 0;
		String direction = "��";

		m = sc.nextInt();
		n = sc.nextInt();

		x = m;
		y = n;
		int[][] visit = new int[m][n];

		while (count != m * n) {
			if (direction.equals("��")) {
				for (int i = x - 1; i >= p; i--) {
					if (visit[i][q] == 0) {
						visit[i][q] = 1;
						count++;
					}
				}
				q++;
				numOfBrokenLine++;
				direction = "��";

			} else if (direction.equals("��")) {
				for (int i = p; i < x; i++) {
					if (visit[i][y - 1] == 0) {
						visit[i][y - 1] = 1;
						count++;
					}
				}
				y--;
				numOfBrokenLine++;
				direction = "��";

			} else if (direction.equals("��")) {
				for (int i = y - 1; i >= q; i--) {
					if (visit[x - 1][i] == 0) {
						visit[x - 1][i] = 1;
						count++;
					}
				}
				x--;
				numOfBrokenLine++;
				direction = "��";
			} else { // ������
				for (int i = q; i < y; i++) {
					if (visit[p][i] == 0) {
						visit[p][i] = 1;
						count++;
					}
				}
				p++;
				numOfBrokenLine++;
				direction = "��";
			}
		}

		System.out.println(numOfBrokenLine - 1);

		sc.close();

	}

}
