package No9020;

import java.util.Scanner;

public class Main {
	static final int MAX = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] isPrime = new boolean[MAX + 1];
		for (int i = 2; i <= MAX; i++)
			isPrime[i] = true;
		for (int i = 2; i <= MAX; i++) {
			for (int j = i + i; j <= MAX; j += i) {
				if (!isPrime[j])
					continue;
				isPrime[j] = false;
			}
		}

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			int p = 0;
			int q = 0;
			for (int j = 2; j <= k / 2; j++) {
				if (isPrime[j] && isPrime[k - j]) {
					p = j;
					q = k - j;
				}
			}
			System.out.println(p + " " + q);
		}
		sc.close();

	}

}
