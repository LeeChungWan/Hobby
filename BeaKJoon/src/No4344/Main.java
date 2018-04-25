package No4344;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 4344번 : 평균은 넘겠지
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * 
 * 입력 : 첫째 줄에는 테스트케이스 C가 주어진다.둘째 줄부터 각 테스트케이스 마다 첫 수로 정수 N(1 <= N <= 1000)명의 학생이 주어지고 그 다음으로 N명의 0부터 100 사이의 점수가 이어서 주어진다.
 * 출력 : 각 케이스마다 한줄씩 평균을 넘는 학생들의 비율을 소수점 넷째자리에서 반올림하여 출력한다.
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double count = 0;
		int numOfCase = sc.nextInt();
		int numOfStudent;
		double sum = 0;
		double average;
		double[][] arr = new double[numOfCase][];

		String str = "";

		// 입력값을 배열에 넣어주는 과정.
		for (int i = 0; i < numOfCase; i++) {
			numOfStudent = sc.nextInt();
			arr[i] = new double[numOfStudent];
			for (int j = 0; j < numOfStudent; j++)
				arr[i][j] = sc.nextDouble();
		}
		// 해당 케이스의 합계를 구하고 평균을 구함.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			average = sum / arr[i].length;
			Arrays.sort(arr[i]);
			// 평균보다 높은 케이스 수를 구하낟.
			for (int j = arr[i].length - 1; j >= 0; j--) {
				if (arr[i][j] > average)
					count++;
				else
					break;
			}
			System.out.println(String.format("%.3f", count / arr[i].length * 100.0) + "%");
			count = 0;
			sum = 0;
		}
		System.out.println(str);
		sc.close();
	}

}
