package No2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ���� 2751�� �� �����ϱ� 2
 * Merge Sort ����.
 */
public class Main {
	public static void mergeSort(int[] arr, int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int i = left; // ���� �迭 ù��° �ε���
		int j = mid + 1; // ������ �迭 ���� �ε���
		int index = 0;
		int[] tempArr = new int[right - left + 1];

		while (i <= mid && j <= right) {
			if (arr[i] < arr[j])
				tempArr[index++] = arr[i++];
			else
				tempArr[index++] = arr[j++];
		}
		// ���� �迭�� ���� ���� ���.
		if (i <= mid) {
			for (int m = i; m <= mid; m++)
				tempArr[index++] = arr[m];
		} else {// ������ �迭�� ���� ���� ���.
			for (int m = j; m <= right; m++)
				tempArr[index++] = arr[m];
		}
		System.arraycopy(tempArr, 0, arr, left, tempArr.length);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, arr.length - 1);
		for (int j = 0; j < N; j++) {
			System.out.println(arr[j]);
		}
	}

}
