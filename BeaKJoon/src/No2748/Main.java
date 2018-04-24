package No2748;
import java.util.Scanner;
/*
 * ���� 2748�� �Ǻ���ġ2
 * �Է� : ù° �ٿ� n�� �־�����. n�� 90���� �۰ų� ���� �ڿ����̴�.
 * ��� : ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.
 */
public class Main {
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
