package No1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� 1152�� �ܾ��� ����
 * ���� ��ҹ��ڿ� ���⸸���� �̷���� ������ �־�����. �� ���忡�� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է� : ù �ٿ� ���� ��ҹ��ڿ� ����� �̷���� ������ �־�����. �� ������ ���̴� 1,000,000�� ���� �ʴ´�. �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����.
 * ��� : ù° �ٿ� �ܾ��� ������ ����Ѵ�.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(br.readLine(), " ");
		System.out.println(parser.countTokens());
	}

}
