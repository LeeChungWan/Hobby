package No2577;

import java.util.Scanner;
/*
 * ���� 2577�� ������ ����
 * �� ���� �ڿ��� A, B, C�� �־��� �� A��B��C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ���� ��� A = 150, B = 266, C = 427 �̶�� 
 * A �� B �� C = 150 �� 266 �� 427 = 17037300 �� �ǰ�, 
 * ����� ��� 17037300 ���� 0�� 3��, 1�� 1��, 3�� 2��, 7�� 2�� ������.
 * 
 * �Է� : ù° �ٿ� A, ��° �ٿ� B, ��° �ٿ� C�� �־�����. A, B, C�� ��� 100���� ���ų� ũ��, 1,000���� ���� �ڿ����̴�.
 * ��� : ù° �ٿ��� A��B��C�� ����� 0 �� �� �� �������� ����Ѵ�. ���������� ��° �ٺ��� �� ��° �ٱ��� A��B��C�� 
 *      ����� 1���� 9������ ���ڰ� ���� �� �� �������� ���ʷ� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * @author �����
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int mul = A*B*C;
		String str = String.valueOf(mul);
		char[] arr = str.toCharArray();
		int[] num = new int[10];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0')
				num[0]++;
			else if (arr[i] == '1')
				num[1]++;
			else if (arr[i] == '2')
				num[2]++;
			else if (arr[i] == '3')
				num[3]++;
			else if (arr[i] == '4')
				num[4]++;
			else if (arr[i] == '5')
				num[5]++;
			else if (arr[i] == '6')
				num[6]++;
			else if (arr[i] == '7')
				num[7]++;
			else if (arr[i] == '8')
				num[8]++;
			else
				num[9]++;
		}
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);
		sc.close();
	}

}
