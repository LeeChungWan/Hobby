package No1193;

import java.util.Scanner;
/*
 * ���� 1193�� �м�ã��
 * ������ �м����� 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> �� �� ���� ������ ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.
 * X�� �־����� ��, X��° �м��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� :	ù° �ٿ� X(1��X��10,000,000)�� �־�����.
 * ��� :	ù° �ٿ� �м��� ����Ѵ�.
 * @author �����
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int count = 0;
		int num = 0;
		while (num < X) {
			count++;
			num += count;
		}
		// ¦�� �ϋ�
		if (count % 2 == 0) {
			System.out.println((1 + (X - (num - count) - 1)) + "/" + (count - (X - (num - count) - 1)));
		} else {// Ȧ�� �϶�
			System.out.println((1 + (num - X)) + "/" + (count - (num - X)));
		}
		sc.close();
	}

}