package No4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * ���� 4948�� ����Ʈ�� ����
 * �Ϸ� :	�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� ���̽��� n�� �����ϸ�, �� �ٷ� �̷���� �ִ�. (n �� 123456)
 * 		�Է��� ���������� 0�� �־�����.
 * ��� :	�� �׽�Ʈ ���̽��� ���ؼ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ����Ѵ�.
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
