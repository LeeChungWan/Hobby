package No11720;

import java.util.Scanner;
/*
 * 문제11720번 : 숫자의 합
 * 입력 : 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * 출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String value = sc.next();
		int sum = 0;
		char[] arr = value.toCharArray();
		for (int i = 0; i < num; i++) {
			sum += arr[i] - 48;
		}
		System.out.println(sum);
		sc.close();
	}
}
