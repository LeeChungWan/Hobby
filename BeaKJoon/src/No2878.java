import java.util.Arrays;
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
		int minimum = friend[0] * friend.length;
		int share = overCandy / friend.length;
		int rest = overCandy % friend.length;
		int result = 0;
		int index = 0;
		int midOverCandy = 0;
		int midResult = 0;
		int[] moreFriend;

		if (overCandy <= minimum) { // ������ ������ ���ѵ�...
			if (rest != 0) {
				result = (share + 1) * (share + 1) * rest + share * share * (friend.length - rest);
				return result;
			} else {
				result = share * share * friend.length;
				return result;
			}
		} else {
			for (int i = 0; i < friend.length; i++) {
				if (friend[i] <= share) {
					index++;
					midOverCandy += friend[i];
				} else
					break;
			}
			for (int i = 0; i < index; i++) {
				midResult += friend[i] * friend[i];
			}
			moreFriend = new int[friend.length - index];
			System.arraycopy(friend, index, moreFriend, 0, moreFriend.length);
			overCandy -= midOverCandy;
			return midResult + countBadMood(overCandy, moreFriend);
		}
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

		int wishCandy = sum(friend);
		int overCandy = wishCandy - totalCandy;
		Arrays.sort(friend);
		System.out.println(countBadMood(overCandy, friend));

		sc.close();

	}

}
