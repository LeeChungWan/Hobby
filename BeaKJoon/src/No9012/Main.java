package No9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String line = sc.next();
			char[] arr = line.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(')
					stack.push(arr[i]);
				else {
					if (stack.isEmpty()) {
						stack.push(arr[j]);
						break;
					} else
						stack.pop();
				}
			}
			if (!stack.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
			stack.removeAllElements();
		}
		sc.close();
	}
}
