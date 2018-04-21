import java.util.Scanner;

public class No1010 {
	public static long factorial(int num, int count) {
//		if (num == 1)
//			return 1;
//		else
//			return (num * factorial(num - 1));
		
		long[] arr = new long[count];
		arr[0] = num;
		for(int i=1; i<arr.length;i++){
			arr[i] = arr[i-1]*(num--);
		}
		return arr[arr.length-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		int n, m;
		long[] result = new long[numOfCase];

		for (int i = 0; i < numOfCase; i++) {
			n = sc.nextInt();
			m = sc.nextInt();

			if (n == m)
				result[i] = 1;
			else if (n == 1)
				result[i] = m;
			else {
				long numerator = factorial(m, m-n);
				long denominator = factorial(m-n,m-n);
				result[i] = numerator / denominator;
			}

		}
		for(int i=0; i<result.length;i++)
			System.out.println(result[i]);
		sc.close();

	}

}
