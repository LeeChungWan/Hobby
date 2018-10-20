package 조합;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		combination(n, r, 0);
		sc.close();
	}

	public static void combination(int n, int r, int index) {
		if (r == 0) {
			showStack();
			return;
		} else if (n == r) {
			for (int i = 0; i < n; i++)
				stack.add(index + i);
			showStack();
			for (int i = 0; i < n; i++)
				stack.pop();
		} else {
			// index를 포함하는 경우
			stack.add(index);
			combination(n - 1, r - 1, index + 1);
			// index를 포함하지 않는 경우
			stack.pop();
			combination(n - 1, r, index + 1);
		}
	}

	public static void showStack() {
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println("");
	}
}
