package No10871;
import java.util.Scanner;
/*
 * ���� 10871�� : X���� ���� ��
 * �Է� : ù° �ٿ� N�� X�� �־�����. (1 �� N, X �� 10,000)��° �ٿ� ���� A�� �̷�� ���� N���� �־�����. �־����� ������ ��� 1���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̴�.
 * �ⷰ : X���� ���� ���� �Է¹��� ������� �������� ������ ����Ѵ�. X���� ���� ���� ��� �ϳ� �����Ѵ�.
 * @author : ����� 
 * @2018.04.25.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int num = sc.nextInt();
		int input;
		String str = "";
		for (int i = 0; i < size; i++) {
			input = sc.nextInt();
			if (input < num)
				str += input + " ";
		}
		System.out.println(str);
		sc.close();
	}

}
