package No15552;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� 15552�� : ���� A + B
 * �Է� : ù �ٿ� �׽�Ʈ���̽��� ���� T�� �־�����. T�� �ִ� 1,000,000�̴�. ���� T�ٿ��� ���� �� ���� A�� B�� �־�����. A�� B�� 1 �̻�, 1,000 �����̴�.
 * ��� : �� �׽�Ʈ���̽����� A+B�� �� �ٿ� �ϳ��� ������� ����Ѵ�.
 * @author : ����� 
 * @2018.04.25.
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine(); // ���� �Ÿ���.
		String line = br.readLine();
		while (line != null) {
			StringTokenizer parser = new StringTokenizer(line, " ");
			System.out.println(Integer.parseInt(parser.nextToken()) + Integer.parseInt(parser.nextToken()));
			line = br.readLine();
		}

	}

}
