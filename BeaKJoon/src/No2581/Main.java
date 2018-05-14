package No2581;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 문제  2581번 소수
 * 입력 :	입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 * 출력 :	M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최소값을 출력한다.
 * 		단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */
public class Main {
	public static boolean isPrime(int n) {
		if (n != 1) {
			for (int k = 2; k <= n; k++) {
				if (n % k == 0) {
					if (k == n)
						return true;
					else
						break;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				arr.add(i);
			}
		}
		int sum = 0;
		for (int j = 0; j < arr.size(); j++) {
			sum += arr.get(j);
		}
		if(arr.isEmpty())
			System.out.println("-1");
		else
			System.out.println(sum+"\n"+arr.get(0));
		sc.close();
	}

}
