package No8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ���� 8958�� OX����
 * "OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. 
 * ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.
 * "OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.
 * OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, 
 *      ���̰� 0���� ũ�� 80���� ���� ���ڿ��� �־�����. ���ڿ��� O�� X������ �̷���� �ִ�.
 *      
 * ��� : �� �׽�Ʈ ���̽����� ������ ����Ѵ�.
 * @author �����
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		while (line > 0) {
			int sum = 0;
			int bonus = 0;
			String str = br.readLine();
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'O') {
					sum++;
					sum += bonus;
					bonus++;
				} else
					bonus = 0;
			}
			System.out.println(sum);
			line--;
		}
	}
}
