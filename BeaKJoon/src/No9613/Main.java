package No9613;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			long result = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if(j != k && k>j)
						result += gcd(Integer.parseInt(info[j + 1]), Integer.parseInt(info[k + 1]));
				}
			}
			System.out.println(result);
		}
	}

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
}
