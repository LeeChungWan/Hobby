package No1427;

import java.util.Scanner;
/*
 * 문제 1427번 소트인사이드
 * 입력 :	첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 * 출력 :	첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		char[] arr = N.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String result = "";
		for (int i = 0; i < arr.length; i++)
			result += arr[i];
		System.out.println(result);
		sc.close();
	}

}
