package No2609;

import java.util.Scanner;

public class Main {
	public static int gcd(int m, int n) {
		int r;
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

	public static int lcm(int m, int n) {
		return m * n / gcd(m, n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(gcd(m,n));
		System.out.println(lcm(m,n));
		sc.close();
	}
}
