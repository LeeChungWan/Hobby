package No1002;
import java.util.Scanner;

/*
 * ���� 1002 �ͷ� 
 * �Է� : ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ������ ���� �����Ǿ��ִ�.
 *      �� �ٿ� x1, y1, r1, x2, y2, r2�� �־�����. 
 *      x1, y1, x2, y2�� -10,000���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̰�, 
 *      r1, r2�� 10,000���� �۰ų� ���� �ڿ����̴�.
 * 
 * ��� : �� �׽�Ʈ ���̽����� ������� ���� �� �ִ� ��ġ�� ���� ����Ѵ�. 
 *      ���� ������� ���� �� �ִ� ��ġ�� ������ ���Ѵ��� ��쿡�� -1�� ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1, y1, r1;
		int x2, y2, r2;
		double distance;
		int testCase = 0;
		testCase = sc.nextInt();

		int[] result = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			int temp = 0;
			if (r1 > r2) {
				temp = r2;
				r2 = r1;
				r1 = temp;
			}
			if (x1 == x2 && y1 == y2 && r1 == r2)
				result[i] = -1;
			else if (distance + r1 < r2 || distance > r1 + r2)
				result[i] = 0;
			else if (distance + r1 == r2 || r1 + r2 == distance)
				result[i] = 1;
			else if (distance + r1 > r2)
				result[i] = 2;

		}

		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

		sc.close();
	}

}
