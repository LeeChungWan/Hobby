package No8595;
import java.util.Scanner;

public class Main {
	/*
	 * ���� 8595�� ���� �ѹ�
	 * 
	 * �ܾ ���ڰ� �����ִ�. �� ���ڸ� ���� �ѹ���� �Ѵ�. ���ĺ� ��/�ҹ��ڿ� ���ڷ� �̷���� �ܾ �־����� ��, ��� ���� �ѹ���
	 * ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �ܾ�� ���� �ѹ��� �Ʒ��� ���� ������ ���´�. ���ӵ� ���ڴ� �� ���� �ѹ��̴�. �� ���� �ѹ�
	 * ���̿��� ���ڰ� ��� �� �� �ִ�. ���� �ѹ��� 6�ڸ��� ���� �ʴ´�.
	 * 
	 * �Է� : ù° �ٿ� �ܾ��� ���� n (1 �� n �� 5,000,000)�� �־�����. ��° �ٿ��� �ܾ �־�����. �ܾ�� ���ĺ�
	 * ��/�ҹ��ڿ� ����(0-9)�� �̷���� �ִ�. ��� : �Է����� �־��� �ܾ �����ִ� ��� ���� �ѹ��� ���� ����Ѵ�. ����, ����
	 * �ѹ��� ���� ��쿡�� 0�� ����Ѵ�.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = 0;
		long sum = 0;
		int length = sc.nextInt();
		String str = sc.next();
		String temp = "";
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (temp.length() > 6) {
				temp = "";
			} else if (arr[i] >= 48 && arr[i] <= 57) {
				temp += arr[i];
				if (i == arr.length - 1) {
					num = Integer.parseInt(temp);
					sum += num;
				}
			} else {
				if (temp.length() != 0) {
					num = Integer.parseInt(temp);
					sum += num;
					temp = "";
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
