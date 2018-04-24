package No8595;
import java.util.Scanner;

public class Main {
	/*
	 * 문제 8595번 히든 넘버
	 * 
	 * 단어에 숫자가 숨어있다. 이 숫자를 히든 넘버라고 한다. 알파벳 대/소문자와 숫자로 이루어진 단어가 주어졌을 때, 모든 히든 넘버의
	 * 합을 구하는 프로그램을 작성하시오. 단어와 히든 넘버는 아래와 같은 성질을 갖는다. 연속된 숫자는 한 히든 넘버이다. 두 히든 넘버
	 * 사이에는 글자가 적어도 한 개 있다. 히든 넘버는 6자리를 넘지 않는다.
	 * 
	 * 입력 : 첫째 줄에 단어의 길이 n (1 ≤ n ≤ 5,000,000)이 주어진다. 둘째 줄에는 단어가 주어진다. 단어는 알파벳
	 * 대/소문자와 숫자(0-9)로 이루어져 있다. 출력 : 입력으로 주어진 단어에 숨어있는 모든 히든 넘버의 합을 출력한다. 만약, 히든
	 * 넘버가 없는 경우에는 0을 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = 0;
		long sum = 0;
		int length = sc.nextInt();
		String str = sc.next();
		String temp = "";
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (temp.length() > 6) {
				temp = "";
			} else if (arr[i] >= 48 && arr[i] <= 57) {
				temp += arr[i];
				if (i == arr.length - 1) {
					num = Integer.parseInt(temp);
					sum += num;
				}
			} else {
				if (temp.length() != 0) {
					num = Integer.parseInt(temp);
					sum += num;
					temp = "";
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
