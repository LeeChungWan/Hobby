package No2747;
import java.util.Scanner;
/*
 * 문제 2747번 피보나치
 * 입력 : 첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
 * 출력 : 첫째 줄에 n번째 피보나치 수를 출력한다.
 */
public class Main {
	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n < 3)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
		sc.close();
	}

}
