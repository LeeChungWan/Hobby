package No13241;

import java.util.Scanner;

public class Main {
	public static long gcd(long m, long n) {
		long r;
		while (true) {
			r = m % n;
			if (r == 0)
				return n;
			else {
				m = n;
				n = r;
			}
		}
	}

	public static long lcm(long m, long n) {
		return m * n / gcd(m, n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(lcm(a,b));
		sc.close();
	}
}
