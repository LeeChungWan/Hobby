package No3052;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		boolean[] already = new boolean[42];
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			n %= 42;
			if (!already[n]) {
				already[n] = true;
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}

}
