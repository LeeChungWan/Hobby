import java.util.Scanner;
/*
 * 문제 1094번 막대기
 * 
 * 입력:첫째 줄에 X가 주어진다. X는 64보다 작거나 같은 자연수이다.
 * 출력:문제의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력한다.
 */
public class No1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sticksTotalLength = 64;
		int minStick = 64;
		int X = sc.nextInt();
		int count = 1;

		while (X != sticksTotalLength) {
			if (sticksTotalLength > X) {
				minStick /= 2;
				if (sticksTotalLength - minStick >= X) {
					sticksTotalLength -= minStick;
				} else {
					count++;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
