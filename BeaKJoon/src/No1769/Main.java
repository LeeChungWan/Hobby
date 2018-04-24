package No1769;
import java.util.Scanner;

/*
 * 문제 1769번 3의배수
 * 
 * 입력 : 첫째 줄에 큰 자연수 X가 주어진다. X는 1,000,000자리 이하의 수이다.
 * 출력 : 첫째 줄에 문제 변환의 과정을 몇 번 거쳤는지를 출력한다. 이 수는 음이 아닌 정수가 되어야 한다. 
 *      둘째 줄에는 주어진 수가 3의 배수이면 YES, 아니면 NO를 출력한다.
 */
public class Main {

	public static void count(String num, int countY) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - 48;
		}
		if (num.length() >= 2)
			countY++;
		if (sum / 10 != 0) {
			num = Integer.toString(sum);
			count(num, countY);
		} else {
			System.out.println(countY);
			if (sum % 3 == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num;

		num = sc.next();
		count(num, 0);

		sc.close();
	}
}
