package No2747;
import java.util.Scanner;
/*
 * ���� 2747�� �Ǻ���ġ
 * �Է� : ù° �ٿ� n�� �־�����. n�� 45���� �۰ų� ���� �ڿ����̴�.
 * ��� : ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.
 */
public class Main {
	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n < 3)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
		sc.close();
	}

}
