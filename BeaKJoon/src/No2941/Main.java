package No2941;

import java.util.Scanner;
/*
 * ���� 2941�� ũ�ξ�Ƽ�� ���ĺ�
 * �Է� :	ù° �ٿ� �ִ� 100������ �ܾ �־�����. ���ĺ� �ҹ��ڿ� '-', '='�θ� �̷���� �ִ�.
 * 		���� ���� �����ִ� ũ�ξ�Ƽ�� ���ĺ��� �־�����.
 * ��� :	�Է����� �־��� �ܾ �� ���� ũ�ξ�Ƽ�� ���ĺ����� �̷���� �ִ��� ����Ѵ�.
 * @author �����
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		int num = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'c') {
				if (i + 1 < arr.length && arr[i + 1] == '=' || arr[i + 1] == '-')
					num--;
			} else if (arr[i] == 'd') {
				if (i + 1 < arr.length && arr[i + 1] == '-')
					num--;
				else if (i + 2 < arr.length && arr[i + 1] == 'z' && arr[i + 2] == '=')
					num--;
			} else if (i + 1 < arr.length && arr[i] == 'l' && arr[i + 1] == 'j')
				num--;
			else if (i + 1 < arr.length && arr[i] == 'n' && arr[i + 1] == 'j')
				num--;
			else if (i + 1 < arr.length && arr[i] == 's' && arr[i + 1] == '=')
				num--;
			else if (i + 1 < arr.length && arr[i] == 'z' && arr[i + 1] == '=')
				num--;
		}
		System.out.println(num);
		sc.close();
	}

}
