package No1978;

import java.io.IOException;
import java.util.Scanner;
/*
 * 문제 1978번 소수 찾기
 * 
 * 입력 :	첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 출력 :	주어진 수들 중 소수의 개수를 출력한다.
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
