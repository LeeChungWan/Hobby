package No1065;

import java.util.Scanner;
/*
 * 문제 1065번 한수
 * 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 * 
 * 입력 : 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 * 출력 : 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 * @author 이충완
 */
public class Main {

	public static void hanSu(int n, boolean[] arr) {
		int num = n;
		int x = num % 10;
		num /= 10;
		int y = num % 10;
		int sub = x - y; // 등차값을 저장.
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
		// 1, 2의 자리수는 모두 한수이다.
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
