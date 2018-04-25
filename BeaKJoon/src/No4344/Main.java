package No4344;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ���� 4344�� : ����� �Ѱ���
 * ���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.
 * 
 * �Է� : ù° �ٿ��� �׽�Ʈ���̽� C�� �־�����.��° �ٺ��� �� �׽�Ʈ���̽� ���� ù ���� ���� N(1 <= N <= 1000)���� �л��� �־����� �� �������� N���� 0���� 100 ������ ������ �̾ �־�����.
 * ��� : �� ���̽����� ���پ� ����� �Ѵ� �л����� ������ �Ҽ��� ��°�ڸ����� �ݿø��Ͽ� ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double count = 0;
		int numOfCase = sc.nextInt();
		int numOfStudent;
		double sum = 0;
		double average;
		double[][] arr = new double[numOfCase][];

		String str = "";

		// �Է°��� �迭�� �־��ִ� ����.
		for (int i = 0; i < numOfCase; i++) {
			numOfStudent = sc.nextInt();
			arr[i] = new double[numOfStudent];
			for (int j = 0; j < numOfStudent; j++)
				arr[i][j] = sc.nextDouble();
		}
		// �ش� ���̽��� �հ踦 ���ϰ� ����� ����.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			average = sum / arr[i].length;
			Arrays.sort(arr[i]);
			// ��պ��� ���� ���̽� ���� ���ϳ�.
			for (int j = arr[i].length - 1; j >= 0; j--) {
				if (arr[i][j] > average)
					count++;
				else
					break;
			}
			System.out.println(String.format("%.3f", count / arr[i].length * 100.0) + "%");
			count = 0;
			sum = 0;
		}
		System.out.println(str);
		sc.close();
	}

}
