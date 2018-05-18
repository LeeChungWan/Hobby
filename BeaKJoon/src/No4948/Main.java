package No4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * 문제 4948번 베르트랑 공준
 * 일력 :	입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤ 123456)
 * 		입력의 마지막에는 0이 주어진다.
 * 출력 :	각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		List<Integer> arrN = new ArrayList<>();
		while (N != 0) {
			if (N > max)
				max = N;
			arrN.add(N);
			N = Integer.parseInt(br.readLine());
		}
		boolean[] arrResult = new boolean[2 * max + 1];
		for (int i = 2; i < arrResult.length; i++) {
			arrResult[i] = true;
		}
		for (int i = 2; i <= Math.sqrt(2 * max); ++i) {
			if (arrResult[i]) {
				for (int j = i + i; j <= 2 * max; j += i)
					arrResult[j] = false;
			}

		}
		for (int i = 0; i < arrN.size(); i++) {
			int count = 0;
			for (int j = arrN.get(i)+1; j <= arrN.get(i) * 2; j++) {
				if(arrResult[j]){
					count++;					
				}
			}
			System.out.println(count);
		}
	}

}
