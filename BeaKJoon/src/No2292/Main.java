package No2292;

import java.util.Scanner;
/*
 * ����2292�� ����
 * ���������� �̷���� ������ �ִ�. �׸����� ���� �ٿ� ���� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��鼭 1�� �����ϴ� ��ȣ�� �ּҷ� �ű� �� �ִ�. ���� N�� �־����� ��, 
 * ������ �߾� 1���� N�� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� ����������(���۰� ���� �����Ͽ�)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ���, 13������ 3��, 58������ 5���� ������.
 * 
 * ���� :	ù° �ٿ� N(1 �� N �� 1,000,000,000)�� �־�����.
 * ��� :	�Է����� �־��� ����� �ּ� ������ ���� ������ �� �� �� ���� ���� �������� ����Ѵ�.
 * @author �����
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long num = 1;
		int count = 1;
		if (N == 1)
			System.out.println(1);
		else {
			while (num < N) {
				num += 6 * count;
				count++;
			}
			System.out.println(count);
		}
		sc.close();
	}

}
