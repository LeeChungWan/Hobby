import java.util.Scanner;

public class No1003 {
	public static long countZero(int n) {
		long[] arr = new long[n + 1];
		arr[0] = 1;
		if (n > 0) {
			arr[1] = 0;
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}

		}

		return arr[n];
	}

	public static long countOne(int n) {
		long[] arr = new long[n + 1];
		arr[0] = 0;
		if (n > 0) {
			arr[1] = 1;
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int index = 0;
		int loop = sc.nextInt();
		long[] result = new long[loop * 2];
		while (loop != 0) {
			n = sc.nextInt();
			result[index++] = countZero(n);
			result[index++] = countOne(n);
			loop--;
		}
		for (int i = 0; i < result.length; i += 2) {
			System.out.println(result[i] + " " + result[i + 1]);
		}
		sc.close();
	}

}
