package 순열;

import java.util.Scanner;
// 중복 허용 순열

public class Main {
	static int[] list;
	static int n;
	static int r;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		list = new int[r];
		permutation(0);
		sc.close();
	}

	public static void permutation(int depth) {
		if (depth == r) {
			for (int i = 0; i < r; i++)
				System.out.print(list[i] + " ");
			System.out.println("");
			return;
		}
		for (int i = 0; i < n; i++) {
			list[depth] = i;
			permutation(depth + 1);
		}

	}
}
