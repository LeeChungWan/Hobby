package No1065;

import java.util.Scanner;
/*
 * ���� 1065�� �Ѽ�
 * � ���� ���� X�� �ڸ����� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�. ���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�. 
 * N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� 1,000���� �۰ų� ���� �ڿ��� N�� �־�����.
 * ��� : ù° �ٿ� 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����Ѵ�.
 * @author �����
 */
public class Main {

	public static void hanSu(int n, boolean[] arr) {
		int num = n;
		int x = num % 10;
		num /= 10;
		int y = num % 10;
		int sub = x - y; // �������� ����.
		while (num >= 10) {
			x = num % 10;
			num /= 10;
			y = num % 10;
			if (sub != (x - y)) {
				arr[n] = false;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] check= new boolean[1001];;
		int N = sc.nextInt();
		// 1, 2�� �ڸ����� ��� �Ѽ��̴�.
		if (N < 100)
			System.out.println(N);
		else {
			for (int i = 1; i < check.length; i++)
				check[i] = true;
			for (int i = 100; i < check.length; i++)
				hanSu(i, check);
			int count = 0;
			for(int i=1; i<=N;i++){
				if(check[i])
					count++;
			}
			System.out.println(count);
		}
		sc.close();
	}

}
