import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 2878번 캔디캔디
 * 오늘 사탕 M개를 가득 담은 박스가 택배로 택희네 집에 도착했다. 
 * 택희는 이 사탕을 N명의 친구들에게 나누어 주려고 한다.
 * 택희의 친구들은 문자로 사탕을 몇 개 받고 싶은지 보냈다. 
 * 만약 받고 싶은 개수만큼 사탕을 받지 못한다면, 그 친구는 분노하게 되고, 못 받는 개수가 많아질 수록 더욱 분노하게 된다.
 * 놀랍게도 택희는 친구들의 분노를 수치화 할 수 있는데, 이것은 못 받는 사탕 개수의 제곱이다.
 * 예를 들어, 택희의 친구 백준이가 받고 싶은 사탕의 개수가 32개였을 때, 사탕을 29개 받아 3개를 받지 못한다면, 그의 분노는 3의 제곱 9가 된다.
 * 택희가 받은 사탕의 개수와 친구의 수, 그리고 그 친구들이 받고 싶어하는 사탕의 개수가 주어졌을 때, 사탕을 적절히 나누어 주어 친구들의 분노의 합을 최소화해 
 * 그 값을 출력하는 프로그램을 작성하시오.
 * 
 * 입력 : 첫째 줄에 M(1 ≤ M ≤ 2×109)와 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 각 친구들이 받고 싶어하는 사탕의 개수가 주어진다. 이 개수는 2×109보다 작으며, 
 * 친구들이 받고 싶어하는 사탕의 개수의 합은 항상 M을 넘는다.
 * 
 * 출력 : 첫째 줄에 택희 친구들의 분노의 합의 최소값을 264로 나눈 나머지를 출력한다.
 */
public class No2878 {

	public static int countBadMood(int overCandy, int[] friend) {

		int index = 0;

		Arrays.sort(friend); // 오름차순

		int temp = overCandy / friend.length;
		int temp2 = overCandy % friend.length;

		if (temp != 0) { // 모든 친구들에게 적어도 temp개의 캔디를 수거해야하는 경우
			if (friend[0] >= temp) {
				if (temp2 == 0) { // 똑같이 temp개 수거하면 되는경우
					int sum = friend.length * temp * temp;
					return sum;
				} else { // 누구는 하나를 더 받는 경우
					int sum = temp + 1;
					int sum1 = temp2 * sum * sum + (friend.length - temp2) * temp * temp;
					return sum1;
				}
			} else {
				int temp3 = 0; // 다른애들한테 더 줘야되는 캔디의 수
				for (int i = 0; i < friend.length; i++) {
					if (friend[i] < temp) {
						index++;
						temp3 += temp - friend[i];
					} else
						break;
				}

				int sum3 = 0;
				for (int i = 0; i < index; i++) {
					sum3 += friend[i] * friend[i];
				}

				int[] newarr = new int[friend.length - index];
				System.arraycopy(friend, index, newarr, 0, newarr.length);
				temp3 += temp2; // 더 수거해야 하는 캔디의 수
				temp3 += temp2*(friend.length-index);
				return sum3 + countBadMood(temp3, newarr);

			}
		} else { // 몇명의 친구들만 캔디를 하나씩 수거해야 하는 경우
			return temp2;
		}

		// int sum = 0;
		// while (totalCandy != 0) {
		// Arrays.sort(friend); // 오름차순 정렬
		// friend[friend.length - 1]--;
		// totalCandy--;
		// }
		//
		// Arrays.sort(friend);
		//
		// for (int i = friend.length - 1; i >= 0; i--) {
		// if (friend[i] == 0)
		// break;
		// else {
		// sum += Math.pow(friend[i], 2);
		// }
		// }
		// System.out.println((int)(sum % (Math.pow(2, 64))));
	}

	private static int sum(int[] friend) {
		int sum = 0;
		for (int i = 0; i < friend.length; i++) {
			sum += friend[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int totalCandy = 0;
		int numOfFriend = 0;

		Scanner sc = new Scanner(System.in);

		totalCandy = sc.nextInt();
		numOfFriend = sc.nextInt();

		int[] friend = new int[numOfFriend];
		for (int i = 0; i < numOfFriend; i++) {
			friend[i] = sc.nextInt();
		}

		int sum = sum(friend);
		int overCandy = sum - totalCandy;
		System.out.println(countBadMood(overCandy, friend));

		sc.close();

	}

}
