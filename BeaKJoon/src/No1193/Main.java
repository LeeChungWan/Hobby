package No1193;

import java.util.Scanner;
/*
 * 문제 1193번 분수찾기
 * 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * 
 * 입력 :	첫째 줄에 X(1≤X≤10,000,000)가 주어진다.
 * 출력 :	첫째 줄에 분수를 출력한다.
 * @author 이충완
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int count = 0;
		int num = 0;
		while (num < X) {
			count++;
			num += count;
		}
		// 짝수 일떄
		if (count % 2 == 0) {
			System.out.println((1 + (X - (num - count) - 1)) + "/" + (count - (X - (num - count) - 1)));
		} else {// 홀수 일때
			System.out.println((1 + (num - X)) + "/" + (count - (num - X)));
		}
		sc.close();
	}

}