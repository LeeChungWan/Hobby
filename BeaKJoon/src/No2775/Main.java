package No2775;

import java.util.Scanner;
/*
 * ���� 2775�� �γ�ȸ���� ���׾�
 * ��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.
 * �� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a ���� b ȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� b ȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ��Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.
 * ����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� ���� ���� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ֳ��� ����϶�. ��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.
 * 
 * �Է� :	ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����. (1 <= k <= 14, 1 <= n <= 14)
 * ��� :	������ Test case�� ���ؼ� �ش� ���� ���ֹ� ���� ����϶�.
 * @author �����
 */

public class Main {

	public static void main(String[] args) {
		int[][] arr = new int[15][15];
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = i + 1;
			arr[i][0] = 1;
		}
		for (int i = 1; i < arr.length; i++)
			for (int j = 1; j < arr[i].length; j++)
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String str = "";
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			str += arr[k][n-1] + "\n";
		}
		System.out.println(str);
		sc.close();
	}

}
