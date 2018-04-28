package No2577;

import java.util.Scanner;
/*
 * 문제 2577번 숫자의 개수
 * 세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 
 * A × B × C = 150 × 266 × 427 = 17037300 이 되고, 
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 * 
 * 입력 : 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.
 * 출력 : 첫째 줄에는 A×B×C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A×B×C의 
 *      결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 * 
 * @author 이충완
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int mul = A*B*C;
		String str = String.valueOf(mul);
		char[] arr = str.toCharArray();
		int[] num = new int[10];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0')
				num[0]++;
			else if (arr[i] == '1')
				num[1]++;
			else if (arr[i] == '2')
				num[2]++;
			else if (arr[i] == '3')
				num[3]++;
			else if (arr[i] == '4')
				num[4]++;
			else if (arr[i] == '5')
				num[5]++;
			else if (arr[i] == '6')
				num[6]++;
			else if (arr[i] == '7')
				num[7]++;
			else if (arr[i] == '8')
				num[8]++;
			else
				num[9]++;
		}
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);
		sc.close();
	}

}
