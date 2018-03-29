import java.util.Scanner;
/*
 * 문제 2748번 피보나치2
 * 입력 : 첫째 줄에 n이 주어진다. n은 90보다 작거나 같은 자연수이다.
 * 출력 : 첫째 줄에 n번째 피보나치 수를 출력한다.
 */
public class No2748 {
	public static long fibonacci(int n) {
		long[] arr = new long[n+1];
		arr[0] = 0;

		if (n > 0) {
			arr[1] = 1;
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
		sc.close();
	}
}
