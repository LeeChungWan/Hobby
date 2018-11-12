package No2309;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[] arr = new int[9];
	static Stack<Integer> stack = new Stack<>();
	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(9, 7, 0);
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
			stack.add(index);
			combination(n - 1, r - 1, index + 1);

			stack.pop();
			combination(n - 1, r, index + 1);
		}
	}

	public static void showStack() {
		int size = stack.size();
		int temp = 0;
		list.clear();

		for (int i = 0; i < size; i++) {
			temp += arr[stack.get(i)];
			list.add(arr[stack.get(i)]);
		}
		if (temp == 100) {
			Collections.sort(list);
			for (int i = 0; i < 7; i++)
				System.out.println(list.get(i));
			return;
		}
	}
}
