package No1475;

import java.util.Scanner;
/*
 * ���� 1475�� �� ��ȣ
 * �ټ��̴� �������� ������ ���� �̻�Դ�. �ټ��̴� �ڱ� �� ��ȣ�� ���� �ö�ƽ ���ڷ� ���� ���̷��� �Ѵ�.
 * �ټ����� ���������� �ö�ƽ ���ڸ� �� ��Ʈ�� �Ǵ�. �� ��Ʈ���� 0������ 9������ ���ڰ� �ϳ��� ����ִ�. 
 * �ټ����� �� ��ȣ�� �־����� ��, �ʿ��� ��Ʈ�� ������ �ּҰ��� ����Ͻÿ�. 
 * (6�� 9�� ����� �̿��� �� �ְ�, 9�� 6�� ����� �̿��� �� �ִ�.)
 * 
 * �Է� :	ù° �ٿ� �ټ����� �� ��ȣ N�� �־�����. N�� 1,000,000���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
 * ��� :	ù° �ٿ� �ʿ��� ��Ʈ�� ������ ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int[] numOfNumber = new int[10];
		char[] arr = N.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] - 48;
			numOfNumber[index]++;
		}
		int maxOfNumber = 0;
		for (int i = 0; i < numOfNumber.length; i++) {
			if (i != 6 && i != 9 && numOfNumber[i] > maxOfNumber)
				maxOfNumber = numOfNumber[i];
		}
		int numOfSixAndNine = (numOfNumber[6] + numOfNumber[9]) / 2 + (numOfNumber[6] + numOfNumber[9]) % 2;
		if (maxOfNumber < numOfSixAndNine)
			maxOfNumber = numOfSixAndNine;
		System.out.println(maxOfNumber);
		sc.close();
	}

}
