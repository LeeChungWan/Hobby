import java.util.Scanner;

/*
 * 문제 2004번 조합 0의 개수
 * 
 * 입력 : 첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.
 * 
 * 출력 : 첫째 줄에 0의 개수를 출력한다.
 */
public class No2004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int saveN = n;
		int saveM = m;
		int countZero = 0;
		int countTwoOfN = 0;
		int countFiveOfN = 0;
		int countTwoOfM = 0;
		int countFiveOfM = 0;
		int countTwo = 0;
		int countFive = 0;
		int loop = m;
		while (loop != 0) {
			while (saveN % 2 == 0) {
				countTwoOfN++;
				saveN /= 2;
			}
			while (saveN % 5 == 0) {
				countFiveOfN++;
				saveN /= 5;
			}
			while (saveM % 2 == 0) {
				countTwoOfM++;
				saveM /= 2;
			}
			while (saveM % 5 == 0) {
				countFiveOfM++;
				saveM /= 5;
			}
			saveN = --n;
			saveM = --m;
			loop--;
		}

		countTwo = countTwoOfN - countTwoOfM;
		countFive = countFiveOfN - countFiveOfM;

		while (countTwo > 0 && countFive > 0) {
			countZero++;
			countTwo--;
			countFive--;
		}
		System.out.println(countZero);
		sc.close();
	}
}