package No1316;

import java.util.Scanner;
/*
 * ���� 1316�� �׷� �ܾ� üĿ
 * �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�. ���� ���, ccazzzzbb�� c, a, z, b�� ��� �����ؼ� ��Ÿ����, 
 * kin�� k, i, n�� �����ؼ� ��Ÿ���� ������ �׷� �ܾ�������, aabbbccb�� b�� �������� ��Ÿ���� ������ �׷� �ܾ �ƴϴ�.
 * �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� �ܾ��� ���� N�� ���´�. N�� 100���� �۰ų� ���� �ڿ����̴�. ��°�ٺ��� N���� �ٿ� �ܾ ���´�. 
 * 		�ܾ�� ���ĺ� �ҹ��ڷθ� �Ǿ��ְ� �ߺ����� ������, ���̴� �ִ� 100�̴�.
 * ��� : ù° �ٿ� �׷� �ܾ��� ������ ����Ѵ�.
 * @author �����
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �ܾ��� ����.
		int countOfGroupNum = N;
		while (N > 0) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			
			// ���� �ݺ��� Ż���� ���� breakOut
			breakOut: for (int i = 0; i < arr.length; i++) {
				int index = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[index] == arr[j]) {
						if (j - index > 1) {
							countOfGroupNum--;
							break breakOut;
						}else{
							index = j;
						}
					}
				}
			}
			N--;
		}

		System.out.println(countOfGroupNum);
		sc.close();
	}
}
