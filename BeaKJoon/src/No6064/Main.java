package No6064;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result = "";
		for (int i = 0; i < T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int sub = M - N;
			int count = 0;
			int compareValue = x;
			boolean check = false;
			// M > N 일 경우는 1:1 이라면 y의 값이 M-N만큼 증가.
			if (x == y) {
				result += x + "\n";
				check = true;
			} 
			else if (M == 1 || N == 1) {
				if (x == 1)
					result += y + "\n";
				else
					result += x + "\n";
				check = true;
			}
			else if (M == x && N == y) {
				// M과 N의 최소 공배수가 result이다.
				int temp1 = x, temp2=y;
				if(x<y){
					x = temp2;
					y = temp1;
				}
				int r = 1;
				// 유클리드 호제법을 이용한 최소공배수 구하기.
				while(r>0){
					r = x % y;
					x = y;
					y = r;
				}
				result += ((temp1*temp2)/x) + "\n";
				check = true;
			} 
			else if (sub > 0) {
				// M > N 일 경우는 1:1 이라면 y의 값이 M-N만큼 증가.
				for (int j = 0; j < ((N / sub) + 1); j++) {
					compareValue += sub;
					count++;
					if (compareValue > N) {
						compareValue -= N;
					}
					if (compareValue == y) {
						result += ((M * count) + x) + "\n";
						check = true;
						break;
					}

				}
			} else if (sub < 0) {
				// N < M 일 경우는 1:1 이라면 y의 값이 N-M만큼 감소.
				for (int j = 0; j < (N / Math.abs(sub) + 1); j++) {
					compareValue += sub;
					count++;
					if (compareValue < 0)
						compareValue += N;

					if (compareValue == y) {
						result += ((M * count) + x) + "\n";
						check = true;
						break;
					}
				}
			}
			if (!check)
				result += "-1\n";

		}
		System.out.println(result);
		sc.close();

	}

}
