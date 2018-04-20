import java.util.Scanner;

public class No1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		int a, b;
		int[] result = new int[numOfCase];

		for (int j = 0; j < numOfCase; j++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if (a == 10)
				result[j] = 10;
			else {
				int temp = a % 10;
				for (int i = 1; i < b; i++) {
					temp = (temp * a) % 10; // °ö¼ÀÀÇ 1ÀÇ ÀÚ¸®ÀÇ °ª.
				}
				result[j] = temp;
			}
		}
		for (int k = 0; k < numOfCase; k++)
			System.out.println(result[k]);
		sc.close();
	}

}
