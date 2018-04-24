package No1002;
import java.util.Scanner;

/*
 * 문제 1002 터렛 
 * 입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
 *      한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. 
 *      x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, 
 *      r1, r2는 10,000보다 작거나 같은 자연수이다.
 * 
 * 출력 : 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 
 *      만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
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
