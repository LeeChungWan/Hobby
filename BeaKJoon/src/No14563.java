import java.util.Scanner;

public class No14563 {

	public static int calculate(int value) {
		int compareSum = 1;
		int endNum = value;
		int numOfLoop = value / 2;

		for (int i = 2; i < numOfLoop; i++) {
			if (!(i < endNum))
				break;
			if ((value % i) == 0) {
				compareSum += i;
				compareSum += value / i;
				endNum = value / i;
			}
		}
		return compareSum;
	}

	public static void printResult(int compareSum, int value) {
		if (value == 1)
			System.out.println("Deficient");
		else if (compareSum == value)
			System.out.println("Perfect");
		else if (compareSum < value)
			System.out.println("Deficient");
		else
			System.out.println("Abundant");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfvalue = 0;
		int[] arrOfvalue;

		numOfvalue = sc.nextInt();
		arrOfvalue = new int[numOfvalue];

		for (int i = 0; i < numOfvalue; i++) {
			arrOfvalue[i] = sc.nextInt();
		}

		for (int i = 0; i < numOfvalue; i++) {
			printResult(calculate(arrOfvalue[i]), arrOfvalue[i]);

		}
		sc.close();
	}
}
