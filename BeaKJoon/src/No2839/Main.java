package No2839;

import java.util.Scanner;

/*
 * 문제 2839번: 설탕 배달
 * 입력 : 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
 * 출력 : 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = -1;
		int temp = 0;
		int count = 0;
		// 5의 배수인 경우
		if (N % 5 == 0)
			System.out.println(N / 5);
		else {
			// 3의 배수인 경우를 최소의 경우라 초기화.
			if (N % 3 == 0)
				min = N / 3;
			// 5가 x개 3이 y개로 최소의 갯수를 구할수 있는경우.
			count = N / 5;
			while (count != 0) {
				temp = N - 5 * (count);
				if (temp % 3 != 0) {
					count--;
				} else {
					min = count + temp / 3;
					break;
				}
			}
			System.out.println(min);
		}
		sc.close();
	}
}
