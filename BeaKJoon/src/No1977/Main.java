package No1977;

import java.util.Scanner;
/*
 * 문제 1977번 완전제곱수
 * 입럭 :	첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10000이하의 자연수이며 M은 N보다 같거나 작다.
 * 출력 :	M이상 N이하의 자연수 중 완전제곱수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최소값을 출력한다. 
 * 		단, M이상 N이하의 자연수 중 완전제곱수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		double num = 0;
		int min = 0;
		int sum = 0;
		boolean checkMin = false;
		for (int i = M; i <= N; i++) {
			num = Math.sqrt(i);
			if (num - (int) num == 0) {
				sum += i;
				if (!checkMin) {
					min = i;
					checkMin = true;
				}
			}
		}
		if (sum != 0)
			System.out.println(sum + "\n" + min);
		else
			System.out.println(-1);
		sc.close();
	}
}
