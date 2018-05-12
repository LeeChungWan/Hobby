package No10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void radixSort(int[] arr, int maxD) {
		int index = 0;
		Queue<Integer>[] figures = new Queue[10];
		// �� �ڸ����� ���ڿ� ���� ť�� ���� 0-9����.
		for (int i = 0; i < 10; i++) {
			figures[i] = new LinkedList<>();
		}
		
		for (int j = 0; j < maxD; j++) {
			int mod = (int)Math.pow(10, j)*10;
			int arrIndex = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] / (mod/10) != 0) {
					index = arr[i] % mod;
					figures[index].add(arr[i]);
				}else{ // �ڸ����� mod���� ������� arr�� �տ��� ���� ä�� �ش�.
					arr[arrIndex++] = arr[i];
				}
			}
			int queueIndex = 0;
			for (int i = 0; i < 10; i++) {
				while (!figures[queueIndex].isEmpty()) {
					arr[arrIndex++] = figures[queueIndex].poll();
				}
				queueIndex++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxD = 0;
		String num = null;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			num = br.readLine();
			if (num.length() > maxD)
				maxD = num.length();
			arr[i] = Integer.parseInt(num);
		}
		radixSort(arr, maxD);
		for(int j=0; j<N;j++)
			System.out.println(arr[j]);
	}

}
