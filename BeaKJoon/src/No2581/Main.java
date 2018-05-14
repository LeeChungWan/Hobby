package No2581;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * ����  2581�� �Ҽ�
 * �Է� :	�Է��� ù° �ٿ� M��, ��° �ٿ� N�� �־�����. M�� N�� 10,000������ �ڿ����̸�, M�� N���� �۰ų� ����.
 * ��� :	M�̻� N������ �ڿ��� �� �Ҽ��� ���� ��� ã�� ù° �ٿ� �� ����, ��° �ٿ� �� �� �ּҰ��� ����Ѵ�.
 * 		��, M�̻� N������ �ڿ��� �� �Ҽ��� ���� ���� ù° �ٿ� -1�� ����Ѵ�.
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
