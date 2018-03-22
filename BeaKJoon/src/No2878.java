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

	public static void countBadMood(int totalCandy, int[] friend) {
		int sum = 0;
		while (totalCandy != 0) {
			Arrays.sort(friend); // �������� ����
			friend[friend.length - 1]--;
			totalCandy--;
		}
		
		Arrays.sort(friend);
		
		for (int i = friend.length - 1; i >= 0; i--) {
			if (friend[i] == 0)
				break;
			else {
				sum += Math.pow(friend[i], 2);
			}
		}
		System.out.println((int)(sum % (Math.pow(2, 64))));
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

		countBadMood(totalCandy, friend);

		sc.close();

	}

}
