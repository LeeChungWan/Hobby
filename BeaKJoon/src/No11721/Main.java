package No11721;

import java.util.Scanner;

/*
 * ���� 11721�� : �� ���� ���� ����ϱ�
 * �Է� : ù° �ٿ� �ܾ �־�����. �ܾ�� ���ĺ� �ҹ��ڿ� �빮�ڷθ� �̷���� ������, ���̴� 100�� ���� �ʴ´�. ���̰� 0�� �ܾ�� �־����� �ʴ´�.
 * ��� : �Է����� �־��� �ܾ �� ���� ��� �� �ٿ� �ϳ��� ����Ѵ�. �ܾ��� ���̰� 10�� ����� �ƴ� ��쿡�� ������ �ٿ��� 10�� �̸��� ���ڸ� ����� ���� �ִ�.
 * 
 * @author : ����� 
 * @2018.04.25.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String str = "";
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && i % 10 == 0)
				str += "\n";
			str += arr[i];
		}
		System.out.println(str);
		sc.close();
	}

}
