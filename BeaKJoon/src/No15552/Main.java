package No15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // ���� �Ÿ���.
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer parser = new StringTokenizer(line, " ");
			bw.write(Integer.parseInt(parser.nextToken()) + Integer.parseInt(parser.nextToken()) + "\n");
		}
		bw.flush();
		bw.close();

	}

}
