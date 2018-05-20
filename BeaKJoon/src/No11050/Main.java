package No11050;

import java.util.Scanner;
/*
 * 문제 11050번 이항계수1
 * 입력 :	첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
 * 출력 :	이항계수를 출력한다.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int numberator=1; // 분자
		int denominator=1 ;// 분모
		while(K>0){
			numberator *=N--;
			denominator *= K--;
		}
		System.out.println((int)numberator/denominator);
		sc.close();
	}

}
