package No1769;
import java.util.Scanner;

/*
 * ���� 1769�� 3�ǹ��
 * 
 * �Է� : ù° �ٿ� ū �ڿ��� X�� �־�����. X�� 1,000,000�ڸ� ������ ���̴�.
 * ��� : ù° �ٿ� ���� ��ȯ�� ������ �� �� ���ƴ����� ����Ѵ�. �� ���� ���� �ƴ� ������ �Ǿ�� �Ѵ�. 
 *      ��° �ٿ��� �־��� ���� 3�� ����̸� YES, �ƴϸ� NO�� ����Ѵ�.
 */
public class Main {

	public static void count(String num, int countY) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - 48;
		}
		if (num.length() >= 2)
			countY++;
		if (sum / 10 != 0) {
			num = Integer.toString(sum);
			count(num, countY);
		} else {
			System.out.println(countY);
			if (sum % 3 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num;

		num = sc.next();
		count(num, 0);

		sc.close();
	}
}
