package No10434;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 10434번 행복한 소수
 * 
 * 입력 : 첫 줄에 테스트 케이스의 수 P가 주어진다. (1 ≤ P ≤ 1000)
 * 각 테스트 케이스는 테스트 케이스 번호와 행복한 소수인지 판정해야 할 정수인 M으로 이루어져 있다. (1 ≤ m ≤ 10000).
 * 출력 : 각 테스트 케이스마다, 테스트 케이스의 번호, 입력받은 수, 만일 M이 행복한 소수라면 YES 아니라면 NO를 공백으로 각각 구분하여 출력한다.
 */
public class Main {
	static List<Integer> checkValue = new ArrayList<>();

	public static void happyPrimeNumber(int[] arr) {
		int value = 0;
		int result = -1;
		int arrSize = arr.length;
		for (int i = 0; i < arrSize; i++) {
			value = arr[i];
			System.out.print((i + 1) + " " + value);
			if (isPrime(value)) {
				checkValue.clear();
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
			return false; // 1은 소수가 아니다.

		if ((n & 1) == 0) // 짝수는
			return (n == 2); // 2이면 true 아니면 소수아니다

		for (int i = 3; i * i <= n; i++) { // i = 3 ~ sqrt(n) 까지의 홀수
			if (n % i == 0) {// i가 n의 약수라면
				return false; // 약수존재. 소수아니다.
			}
		}
		return true; // 소수이다
	}

	public static int test(int num) {
		int sum = 0;
		int midSum = 0;
		int divider = 1;
		while (true) {
			if (num == 1)
				return 0;
			else if (num / divider == 0) {
				break;
			} else {
				if (num % (divider * 10) != 0) {
					midSum = num % (divider * 10) / divider;
					midSum *= midSum;
					sum += midSum;
					divider *= 10;
				} else {
					divider *= 10;
				}
			}
		}
		if (sum == 1)
			return sum;
		else if (check(sum))
			return test(sum);
		else
			return 0;
	}

	public static boolean check(int sum) {
		for (int i = 0; i < checkValue.size(); i++) {
			if (checkValue.get(i) == sum)
				return false;
		}
		checkValue.add(sum);
		return true;
	}

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
