package No1158;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i < N; i++)
			queue.add(i + 1);
		int count = 0;
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			for (int j = 0; j < queue.size(); j++) {
				count++;
				if (count % M == 0) {
					result.add(queue.get(0));
					queue.remove(0);
				} else {
					queue.add(queue.size(), queue.get(0));
					queue.remove(0);
				}
			}
		}
		String str = "<" + result.get(0);
		for (int k = 1; k < result.size(); k++) {
			str += ", " + result.get(k);
		}
		str += ">";
		System.out.println(str);
		sc.close();
	}
}
