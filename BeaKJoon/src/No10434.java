import java.util.HashMap;
import java.util.Scanner;

/*
 * ���� 10434�� �ູ�� �Ҽ�
 * 
 * �Է� : ù �ٿ� �׽�Ʈ ���̽��� �� P�� �־�����. (1 �� P �� 1000)
 * �� �׽�Ʈ ���̽��� �׽�Ʈ ���̽� ��ȣ�� �ູ�� �Ҽ����� �����ؾ� �� ������ M���� �̷���� �ִ�. (1 �� m �� 10000).
 * ��� : �� �׽�Ʈ ���̽�����, �׽�Ʈ ���̽��� ��ȣ, �Է¹��� ��, ���� M�� �ູ�� �Ҽ���� YES �ƴ϶�� NO�� �������� ���� �����Ͽ� ����Ѵ�.
 */
public class No10434 {

	public static void happyPrimeNumber(HashMap<Integer, Integer> map) {
		int value = 0;
		int result = -1;
		int mapSize = map.size();
		for (int i = 1; i <= mapSize; i++) {
			value = map.get(i);
			System.out.print(i + " " + value);
			result = test(value);
			if (isPrime(value)) {
				if (result == 1) {
					System.out.println(" YES");
				} else {
					System.out.println(" No");
				}

			} else {
				System.out.println(" No");
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false; // 1�� �Ҽ��� �ƴϴ�.

		if ((n & 1) == 0) // ¦����
			return (n == 2); // 2�̸� true �ƴϸ� �Ҽ��ƴϴ�

		for (int i = 3; i * i <= n; i++) { // i = 3 ~ sqrt(n) ������ Ȧ��
			if (n % i == 0) {// i�� n�� ������
				return false; // �������. �Ҽ��ƴϴ�.
			}
		}
		return true; // �Ҽ��̴�
	}

	public static int test(int num) {
		try {
			int sum = 0;
			int divider = 1;
			while (true) {
				if (num == 1)
					return 0;
				else if (num / divider == 0) {
					break;
				} else {
					if (num % (divider * 10) != 0) {
						sum += Math.pow((num % (divider * 10)) / divider, 2);
						divider *= 10;
					} else {
						divider *= 10;
					}
				}
			}

			if (sum == 1)
				return sum;
			else
				return test(sum);

		} catch (StackOverflowError e) {
			// TODO: handle exception
			return -1;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfCase = 0;
		int key = 0;
		int value = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		numOfCase = sc.nextInt();

		for (int i = 0; i < numOfCase; i++) {
			key = sc.nextInt();
			value = sc.nextInt();
			map.put(key, value);
		}

		happyPrimeNumber(map);

		sc.close();
	}
}
