package No11050;

import java.util.Scanner;
/*
 * ���� 11050�� ���װ��1
 * �Է� :	ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 0 �� K �� N)
 * ��� :	���װ���� ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int numberator=1; // ����
		int denominator=1 ;// �и�
		while(K>0){
			numberator *=N--;
			denominator *= K--;
		}
		System.out.println((int)numberator/denominator);
		sc.close();
	}

}
