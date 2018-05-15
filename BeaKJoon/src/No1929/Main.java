package No1929;

import java.util.Scanner;
/*
 * 문제 1929번  소수 구하기
 * 입력 :	첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)
 * 출력 :	한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] arr = new boolean[N + 1];
		for (int i = 2; i < arr.length; i++)
			arr[i] = true;
		for (int i = 2; i <= Math.sqrt(N); ++i) {
			if (arr[i]) {
				for (int j = i+i; j <= N; j += i)
					arr[j] = false;
			}

		}
		for (int i = M; i <= N; i++) {
			if (arr[i])
				System.out.println(i);
		}
		sc.close();
	}

}
