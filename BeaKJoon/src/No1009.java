import java.util.Scanner;

public class No1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		int a, b;
		int[] result = new int[numOfCase];
		int[][] repeat = { { 1 }, { 2, 4, 8, 6 }, { 3, 9, 7, 1 }, { 4, 6 }, { 5 }, { 6 }, { 7, 9, 3, 1 },
				{ 8, 4, 2, 6 }, { 9, 1 } };

		for (int j = 0; j < numOfCase; j++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if (a % 10 == 0)
				result[j] = 10;
			else {
				int temp = a % 10;
				int length = repeat[temp - 1].length;
				int index = b % length;
				if (index == 0) {
					result[j] = repeat[temp-1][length-1];
				} else {
					result[j] = repeat[temp - 1][index - 1];
				}
			}
		}
		for (int k = 0; k < numOfCase; k++)
			System.out.println(result[k]);
		sc.close();
	}

}
