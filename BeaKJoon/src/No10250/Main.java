package No10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� 10250�� ACM ȣ��
 * 
 * �Է� :	���α׷��� ǥ�� �Է¿��� �Է� �����͸� �޴´�. ���α׷��� �Է��� T ���� �׽�Ʈ �����ͷ� �̷���� �ִµ� T �� �Է��� �� ù �ٿ� �־�����. 
 * 		�� �׽�Ʈ �����ʹ� �� �����μ� H, W, N, �� ������ �����ϰ� ������ ���� ȣ���� �� ��, �� ���� �� ��, �� ��° �մ������� ��Ÿ����(1 �� H, W �� 99, 1 �� N �� H �� W).
 * 
 * ��� :	���α׷��� ǥ�� ��¿� ����Ѵ�. �� �׽�Ʈ �����͸��� ��Ȯ�� �� ���� ����ϴµ�, ������ N ��° �մԿ��� �����Ǿ�� �ϴ� �� ��ȣ�� ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String result = "";
		for (int i = 0; i < T; i++) {
			// ��, ������ �̿��ؼ� Ǯ��
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(tokens.nextToken());
			int W = Integer.parseInt(tokens.nextToken());
			int N = Integer.parseInt(tokens.nextToken());
			int X, Y;
			String str = "";

			if (N % H != 0) {
				Y = N % H;
				X = (N / H) + 1;
			} else {
				Y = H;
				X = N / H;
			}
			str += Y;
			if (X < 10)
				str += "0" + X;
			else
				str += X;
			result += str + "\n";
		}
		System.out.println(result);
	}

}
