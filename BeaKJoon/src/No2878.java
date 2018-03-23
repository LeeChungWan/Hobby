import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ���� 2878�� ĵ��ĵ��
 * ���� ���� M���� ���� ���� �ڽ��� �ù�� ����� ���� �����ߴ�. 
 * ����� �� ������ N���� ģ���鿡�� ������ �ַ��� �Ѵ�.
 * ������ ģ������ ���ڷ� ������ �� �� �ް� ������ ���´�. 
 * ���� �ް� ���� ������ŭ ������ ���� ���Ѵٸ�, �� ģ���� �г��ϰ� �ǰ�, �� �޴� ������ ������ ���� ���� �г��ϰ� �ȴ�.
 * ����Ե� ����� ģ������ �г븦 ��ġȭ �� �� �ִµ�, �̰��� �� �޴� ���� ������ �����̴�.
 * ���� ���, ������ ģ�� �����̰� �ް� ���� ������ ������ 32������ ��, ������ 29�� �޾� 3���� ���� ���Ѵٸ�, ���� �г�� 3�� ���� 9�� �ȴ�.
 * ���� ���� ������ ������ ģ���� ��, �׸��� �� ģ������ �ް� �;��ϴ� ������ ������ �־����� ��, ������ ������ ������ �־� ģ������ �г��� ���� �ּ�ȭ�� 
 * �� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� M(1 �� M �� 2��109)�� N(1 �� N �� 100,000)�� �־�����. 
 * ��° �ٺ��� N���� �ٿ��� �� ģ������ �ް� �;��ϴ� ������ ������ �־�����. �� ������ 2��109���� ������, 
 * ģ������ �ް� �;��ϴ� ������ ������ ���� �׻� M�� �Ѵ´�.
 * 
 * ��� : ù° �ٿ� ���� ģ������ �г��� ���� �ּҰ��� 264�� ���� �������� ����Ѵ�.
 */
public class No2878 {

	public static int countBadMood(int overCandy, int[] friend) {

		int index = 0;

		Arrays.sort(friend); // ��������

		int temp = overCandy / friend.length;
		int temp2 = overCandy % friend.length;

		if (temp != 0) { // ��� ģ���鿡�� ��� temp���� ĵ�� �����ؾ��ϴ� ���
			if (friend[0] >= temp) {
				if (temp2 == 0) { // �Ȱ��� temp�� �����ϸ� �Ǵ°��
					int sum = friend.length * temp * temp;
					return sum;
				} else { // ������ �ϳ��� �� �޴� ���
					int sum = temp + 1;
					int sum1 = temp2 * sum * sum + (friend.length - temp2) * temp * temp;
					return sum1;
				}
			} else {
				int temp3 = 0; // �ٸ��ֵ����� �� ��ߵǴ� ĵ���� ��
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
				temp3 += temp2; // �� �����ؾ� �ϴ� ĵ���� ��
				temp3 += temp2*(friend.length-index);
				return sum3 + countBadMood(temp3, newarr);

			}
		} else { // ����� ģ���鸸 ĵ�� �ϳ��� �����ؾ� �ϴ� ���
			return temp2;
		}

		// int sum = 0;
		// while (totalCandy != 0) {
		// Arrays.sort(friend); // �������� ����
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
