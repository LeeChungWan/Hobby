import java.util.Scanner;

public class No1003 {
	static int zero = 0;
	static int one = 0;

	public static int fibonacci(int n) {
		if (n == 0) {
			zero++;
			return 0;
		} else if (n == 1) {
			one++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		int index = 0;
		int[] result = new int[loop * 2];
		while (loop != 0) {
			fibonacci(sc.nextInt());
			result[index++] = zero;
			result[index++] = one;
			zero = 0;
			one = 0;
			loop--;

		}
		for (int i = 0; i < result.length; i += 2) {
			System.out.println(result[i] + " " + result[i + 1]);
		}
		sc.close();
	}

}
