package No1546;

import java.util.Scanner;
/*
 * ���� 1546�� : ���
 * �����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ밪�� �����. 
 * �� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.
 * ���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.
 * �������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� ���� �� ������ ���� N�� �־�����. �� ���� 1000���� �۰ų� ����. ��° �ٿ� �������� ���� ������ �־�����. �� ���� 100���� �۰ų� ���� ���� �ƴ� �����̰�, ��� �ϳ��� ���� 0���� ũ��.
 * ��� : ù° �ٿ� ���ο� ����� ����Ѵ�. ������� ����/��� ������ 10-2���� ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		double[] arr = new double[size];
		double max = 0;
		double sum = 0;
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextDouble();
			if (arr[i] > max)
				max = arr[i];
		}
		for (int i = 0; i < size; i++) {
			sum += (arr[i] / max) * 100.0;
		}
		System.out.println(String.format("%.2f", sum / (double) size));
		sc.close();
	}

}
