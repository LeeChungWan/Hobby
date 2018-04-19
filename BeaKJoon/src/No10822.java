import java.util.Scanner;

/*
 * 문제 10822번 더하기
 * 숫자와 콤마로만 이루어진 문자열 S가 주어진다. 이 때, S에 포함되어있는 자연수의 합을 구하는 프로그램을 작성하시오.
 * S의 첫 문자와 마지막 문자는 항상 숫자이고, 콤마는 연속해서 주어지지 않는다. 주어지는 수는 항상 자연수이다.
 * 
 * 입력 : 첫째 줄에 문자열 S가 주어진다. S의 길이는 최대 100이다. 포함되어있는 정수는 1,000,000보다 작거나 같은 자연수이다.
 * 출력 : 문자열 S에 포함되어 있는 자연수의 합을 출력한다.
 * 풀이 : 문자열을 char 배열로 바꾸어 ,가 나오기 전값을 문자열로 합치고 ,이 나오면 만든 문자열을 정수로 바꾸어 더하기.
 */
public class No10822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String num = "";
		int sum = 0;
		int temp = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ',') {
				num += arr[i];

			} else {
				temp = Integer.parseInt(num);
				sum += temp;
				num = "";
			}
		}
		temp = Integer.parseInt(num);
		sum += temp;
		System.out.println(sum);
		sc.close();

	}
}
