package No1934;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int gcd(int m, int n) {
		int r;
		while (true) {
			r = m % n;
			if (r == 0)
				return n;
			else {
				m = n;
				n = r;
			}
		}
	}

	public static int lcm(int m, int n) {
		return m * n / gcd(m, n);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++){
			String line = br.readLine();
			StringTokenizer tokens = new StringTokenizer(line, " ");
			int m = Integer.parseInt(tokens.nextToken());
			int n = Integer.parseInt(tokens.nextToken());
			bw.write(lcm(m,n)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
