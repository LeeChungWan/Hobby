import java.util.Scanner;

/*
 * ���� 10434�� �ູ�� �Ҽ�
 * 
 * �Է� : ù �ٿ� �׽�Ʈ ���̽��� �� P�� �־�����. (1 �� P �� 1000)
 * �� �׽�Ʈ ���̽��� �׽�Ʈ ���̽� ��ȣ�� �ູ�� �Ҽ����� �����ؾ� �� ������ M���� �̷���� �ִ�. (1 �� m �� 10000).
 * ��� : �� �׽�Ʈ ���̽�����, �׽�Ʈ ���̽��� ��ȣ, �Է¹��� ��, ���� M�� �ູ�� �Ҽ���� YES �ƴ϶�� NO�� �������� ���� �����Ͽ� ����Ѵ�.
 */
public class No10434 {

	public static void happyPrimeNumber(int[] arr) {
		int value = 0;
		int result = -1;
		int arrSize = arr.length;
		for (int i = 0; i < arrSize; i++) {
			value = arr[i];
			System.out.print((i+1) + " " + value);
			if (isPrime(value)) {
				result = test(value);
				if (result == 1) {
					System.out.println(" YES");
				} else {
					System.out.println(" NO");
				}

			} else {
				System.out.println(" NO");
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
						sum = num % (divider * 10) / divider;
						sum *= sum;
						// sum += Math.pow((num % (divider * 10)) / divider, 2);
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
			return 0;
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfCase = 0;
		int key = 0;
		int value = 0;
		numOfCase = sc.nextInt();
		int[] arr_value = new int[numOfCase];

		for (int i = 0; i < numOfCase; i++) {
			key = sc.nextInt();
			value = sc.nextInt();
			arr_value[i] = value;
		}

		happyPrimeNumber(arr_value);

		sc.close();
	}
}
