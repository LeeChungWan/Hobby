package No15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 문제 15552번 : 빠른 A + B
 * 입력 : 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
 * 출력 : 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
 * @author : 이충완 
 * @2018.04.25.
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 한줄 거르기.
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer parser = new StringTokenizer(line, " ");
			bw.write(Integer.parseInt(parser.nextToken()) + Integer.parseInt(parser.nextToken()) + "\n");
		}
		bw.flush();
		bw.close();

	}

}
