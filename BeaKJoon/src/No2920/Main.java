package No2920;

import java.util.Scanner;
/*
 * ���� 2920�� ����
 * �������� c d e f g a b C, �� 8�� ������ �̷�����ִ�. �� �������� 8�� ���� ������ ���� ���ڷ� �ٲپ� ǥ���Ѵ�. c�� 1��, d�� 2��, ..., C�� 8�� �ٲ۴�.
 * 1���� 8���� ���ʴ�� �����Ѵٸ� ascending, 8���� 1���� ���ʴ�� �����Ѵٸ� descending, �� �� �ƴ϶�� mixed �̴�.
 * ������ ������ �־����� ��, �̰��� ascending����, descending����, �ƴϸ� mixed���� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� 8�� ���ڰ� �־�����. �� ���ڴ� ���� ������ ������ ���̸�, 1���� 8���� ���ڰ� �� ���� �����Ѵ�.
 * ��� : ù° �ٿ� ascending, descending, mixed �� �ϳ��� ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		boolean asc = false;
		boolean des = false;
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		// check ascending.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != (i + 1))
				break;
			if (i + 1 == arr.length)
				asc = true;
		}
		// check descending.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr.length - i)
				break;
			if (i + 1 == arr.length)
				des = true;
		}
		if (asc)
			System.out.println("ascending");
		else if (des)
			System.out.println("descending");
		else
			System.out.println("mixed");
		sc.close();

	}

}
