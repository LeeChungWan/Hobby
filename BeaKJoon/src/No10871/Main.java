package No10871;
import java.util.Scanner;
/*
 * 문제 10871번 : X보다 작은 수
 * 입력 : 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
 * 출럭 : X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 * @author : 이충완 
 * @2018.04.25.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int num = sc.nextInt();
		int input;
		String str = "";
		for (int i = 0; i < size; i++) {
			input = sc.nextInt();
			if (input < num)
				str += input + " ";
		}
		System.out.println(str);
		sc.close();
	}

}
