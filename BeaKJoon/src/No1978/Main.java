package No1978;

import java.io.IOException;
import java.util.Scanner;
/*
 * ���� 1978�� �Ҽ� ã��
 * 
 * �Է� :	ù �ٿ� ���� ���� N�� �־�����. N�� 100�����̴�. �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.
 * ��� :	�־��� ���� �� �Ҽ��� ������ ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int j = 0; j < N; j++) {
			if (num[j] != 1) {
				for (int k = 2; k <= num[j]; k++) {
					if(num[j]%k==0){
						if(k == num[j])
							count++;
						else
							break;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
