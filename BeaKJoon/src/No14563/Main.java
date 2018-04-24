package No14563;
import java.util.Scanner;

public class Main {

	public static int calculate(int value) {
		int compareSum = 0;
		int endNum = value;

		for (int i = 1; i < value; i++) {
			if (!(i < endNum))
				break;
			if ((value % i) == 0) {
				compareSum += i;
				if (i != 1 && i != (value / i))
					compareSum += value / i;
				endNum = value / i;
			}
		}
		return compareSum;
	}

	public static void printResult(int compareSum, int value) {
		if (compareSum == value)
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
