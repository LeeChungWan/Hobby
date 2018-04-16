import java.util.Scanner;

/*
 * 다음에 풀 방법 
 * 2x2배열을 만들어서 Min(opt(i-1,j), opt(i, j-1)) 식으로 해결해보기.
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
			// 이곳에서 i에 값을 유동적으로 바꾸어주어 성능 향상 시킬수 있을듯.
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
