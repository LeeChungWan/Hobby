package No1427;

import java.util.Scanner;
/*
 * ���� 1427�� ��Ʈ�λ��̵�
 * �Է� :	ù° �ٿ� �����ϰ����ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.
 * ��� :	ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		char[] arr = N.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String result = "";
		for (int i = 0; i < arr.length; i++)
			result += arr[i];
		System.out.println(result);
		sc.close();
	}

}
