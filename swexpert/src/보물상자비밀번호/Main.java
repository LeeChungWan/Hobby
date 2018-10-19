package 보물상자비밀번호;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException {
		Deque<Integer> dequeue;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			dequeue = new LinkedList<>();
			int N = sc.nextInt();
			int K = sc.nextInt();
			String[] list = sc.next().split("");
			for (int j = 0; j < N; j++) {
				try {
					dequeue.add(Integer.parseInt(list[j]));
				} catch (Exception e) {
					if (list[j].equals("A")) {
						dequeue.add(10);
					} else if (list[j].equals("B")) {
						dequeue.add(11);
					} else if (list[j].equals("C")) {
						dequeue.add(12);
					} else if (list[j].equals("D")) {
						dequeue.add(13);
					} else if (list[j].equals("E")) {
						dequeue.add(14);
					} else {
						dequeue.add(15);
					}
				}
			}

			List<Integer> result = new LinkedList<>();
			Map<Integer, Integer> visited = new HashMap<>();
			for (int z = 0; z < N / 4; z++) {
				for (int p = 0; p < 4; p++) {
					int sub = 0;
					for (int q = (N / 4) - 1; q >= 0; q--) {
						int temp = dequeue.poll();
						dequeue.add(temp);
						sub += (int) Math.pow(16, q) * temp;
					}
					if (visited.get(sub) == null) {
						visited.put(sub, sub);
						result.add(sub);
					}
				}
				// 한칸씩 이동
				int last = dequeue.pollLast();
				dequeue.addFirst(last);
			}
			Desc desc = new Desc();
			Collections.sort(result, desc);
			System.out.println("#" + (i + 1) + " " + result.get(K - 1));

		}
		sc.close();
	}

}

class Desc implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
	
}