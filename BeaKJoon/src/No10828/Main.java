package No10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 10828번 스택
 * 스택 구현.
 */
public class Main {
	static List<Integer> stack = new ArrayList<>();

	public static void push(int num) {
		stack.add(num);
	}

	public static int size() {
		return stack.size();
	}

	public static int empty() {
		if (stack.size() != 0)
			return 0;
		return 1;
	}

	public static int top() {
		if (size() != 0)
			return stack.get(size() - 1);
		return -1;
	}

	public static int pop() {
		if (size() != 0) {
			int top = stack.get(size() - 1);
			stack.remove(size() - 1);
			return top;
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			String cmd = tokens.nextToken();
			switch (cmd) {
			case "push":
				push(Integer.parseInt(tokens.nextToken()));
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			default:
				break;
			}
		}
	}

}
