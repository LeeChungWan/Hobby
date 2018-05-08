package No10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 10250번 ACM 호텔
 * 
 * 입력 :	프로그램은 표준 입력에서 입력 데이터를 받는다. 프로그램의 입력은 T 개의 테스트 데이터로 이루어져 있는데 T 는 입력의 맨 첫 줄에 주어진다. 
 * 		각 테스트 데이터는 한 행으로서 H, W, N, 세 정수를 포함하고 있으며 각각 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지를 나타낸다(1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W).
 * 
 * 출력 :	프로그램은 표준 출력에 출력한다. 각 테스트 데이터마다 정확히 한 행을 출력하는데, 내용은 N 번째 손님에게 배정되어야 하는 방 번호를 출력한다.
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String result = "";
		for (int i = 0; i < T; i++) {
			// 몫, 나머지 이용해서 풀기
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
