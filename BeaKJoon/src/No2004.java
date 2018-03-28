import java.math.BigInteger;
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
		BigInteger multiOfN = new BigInteger(Integer.toString(n));
		BigInteger multiOfM = new BigInteger(Integer.toString(m));
		for (int i = n - 1; i > n - m; i--)
			multiOfN = multiOfN.multiply(new BigInteger(Integer.toString(i)));

		for (int i = m - 1; i > 0; i--)
			multiOfM = multiOfM.multiply(new BigInteger(Integer.toString(i)));

		BigInteger result = multiOfN.divide(multiOfM);
		int count = 0;
		BigInteger checkZero = result.mod(new BigInteger(Integer.toString(10)));
		while (checkZero.equals(BigInteger.ZERO)) {
			count++;
			result = result.divide(new BigInteger(Integer.toString(10)));
			checkZero = result.mod(new BigInteger(Integer.toString(10)));
		}
		System.out.println(count);
		sc.close();
	}

}
