package No1010;
import java.util.Scanner;

public class Main {
	static int[][] mem = new int[33][33];

	static int func(int n, int r) {
		if (n == r)
			return 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (i < j) {
					mem[i - 1][j] = 0;
				}
				if (i - 1 == j) {
					mem[i - 1][j] = 1;
				}
				if (i - 1 == j - 1) {
					mem[i - 1][j - 1] = 1;
				}
				if (j - 1 == 0) {
					mem[i - 1][j - 1] = 1;
				}
				if (j == 0) {
					mem[i - 1][j] = 1;
				}
				if (j == 1) {
					mem[i - 1][j] = i - 1;
				}
				if (j - 1 == 1) {
					mem[i - 1][j - 1] = i - 1;
				}

				mem[i][j] = mem[i - 1][j - 1] + mem[i - 1][j];
			}
		}
		return mem[n][r];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		int n, r;
		double[] result = new double[numOfCase];

		for (int i = 0; i < numOfCase; i++) {
			r = sc.nextInt();
			n = sc.nextInt();
			result[i] = func(n, r);
		}
		for (int i = 0; i < result.length; i++)
			System.out.println((long)result[i]);
		sc.close();

	}

}
