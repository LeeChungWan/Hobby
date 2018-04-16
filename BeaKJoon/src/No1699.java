import java.util.Scanner;

/*
 * ������ Ǯ ��� 
 * 2x2�迭�� ���� Min(opt(i-1,j), opt(i, j-1)) ������ �ذ��غ���.
 */
public class No1699 {
	public static int pow_2(int num) {
		return num * num;
	}

	public static int minimum(int num, int[] arr) {
		int j = 0;
		int value = num;
		int count = 0;
		int[] changedArr = null;
		while (value != 0) {
			// �̰����� i�� ���� ���������� �ٲپ��־� ���� ��� ��ų�� ������.
			for (int i = j; i < arr.length; i++) {
				if (value - arr[i] >= 0) {
					value -= arr[i];
					count++;
					if (i != 0)
						j = i;
					break;
				}
			}
		}

		if (arr.length > 1) {
			changedArr = new int[arr.length - 1];
			for (int i = 0; i < changedArr.length; i++)
				changedArr[i] = arr[i + 1];
			return Math.min(count, minimum(num, changedArr));
		} else
			return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sqrt = (int) Math.sqrt(num);
		int[] arr = new int[sqrt];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = pow_2(sqrt);
			sqrt--;
		}
		System.out.println(minimum(num, arr));
		sc.close();
	}

}
