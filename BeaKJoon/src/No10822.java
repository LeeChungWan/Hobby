import java.util.Scanner;

/*
 * ���� 10822�� ���ϱ�
 * ���ڿ� �޸��θ� �̷���� ���ڿ� S�� �־�����. �� ��, S�� ���ԵǾ��ִ� �ڿ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * S�� ù ���ڿ� ������ ���ڴ� �׻� �����̰�, �޸��� �����ؼ� �־����� �ʴ´�. �־����� ���� �׻� �ڿ����̴�.
 * 
 * �Է� : ù° �ٿ� ���ڿ� S�� �־�����. S�� ���̴� �ִ� 100�̴�. ���ԵǾ��ִ� ������ 1,000,000���� �۰ų� ���� �ڿ����̴�.
 * ��� : ���ڿ� S�� ���ԵǾ� �ִ� �ڿ����� ���� ����Ѵ�.
 * Ǯ�� : ���ڿ��� char �迭�� �ٲپ� ,�� ������ ������ ���ڿ��� ��ġ�� ,�� ������ ���� ���ڿ��� ������ �ٲپ� ���ϱ�.
 */
public class No10822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String num = "";
		int sum = 0;
		int temp = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ',') {
				num += arr[i];

			} else {
				temp = Integer.parseInt(num);
				sum += temp;
				num = "";
			}
		}
		temp = Integer.parseInt(num);
		sum += temp;
		System.out.println(sum);
		sc.close();

	}
}
