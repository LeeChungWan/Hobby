package No2750;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ���� 2750�� �� �����ϱ�
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� :	ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ���� ���밪�� 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ��� :	ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		sc.close();
	}

}
