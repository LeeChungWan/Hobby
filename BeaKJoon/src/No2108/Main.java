package No2108;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int mean = 0; // ������ : N���� ������ ���� N���� ���� ��
		int mid; // �߾Ӱ� : �߾Ӱ�
		int mod = 0; // �ֺ� : �󵵼� ���� ���� �� , ������ ���� ��� �ֺ� ���� �ι�°�� ������ ���
		int range;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			mean += arr[i];
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		// �������� ����.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		// �ֺ� ���ϱ�.
		int maxMod = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// map�� ���� ���.
			if (!map.containsValue(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		
		
		 
		mean = Math.round(mean / N);
		if (N == 1)
			mid = arr[0];
		else
			mid = Math.round(N / 2);
		range = Math.abs(max - min);

		System.out.println(mean + "\n" + mid + "\n" + mod + "\n" + range);
		sc.close();
	}
}
