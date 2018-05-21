package No10872;

import java.util.Scanner;
/*
 * 문제 10872번 팩토리얼
 * 입력 :	첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
 * 출력 :	첫째 줄에 N!을 출력한다.
 */
public class Main {
	public static int factorial(int n) {
		if (n < 2)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));
		sc.close();
	}

}
