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
		int mean = 0; // 산술평균 : N개의 수들의 합을 N으로 나눈 값
		int mid; // 중앙값 : 중앙값
		int mod = 0; // 최빈값 : 빈도수 가장 많은 값 , 여러개 있을 경우 최빈 값중 두번째로 작은값 출력
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
		// 오름차순 정렬.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		// 최빈값 구하기.
		int maxMod = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// map에 없는 경우.
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
