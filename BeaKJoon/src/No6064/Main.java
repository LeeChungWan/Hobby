package No6064;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String str = "";
		for (int i = 0; i < T; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			boolean isFind = false;
			if (M < x || N < y) {
				str += "-1\n";
			} else {
				if (M > N) {
					int temp = M;
					M = N;
					N = temp;
					temp = x;
					x = y;
					y = temp;
				}
				int gap = N - M;
				if (gap == 0) {
					if (x != y) {
						str += "-1\n";
					} else {
						str += x + "\n";
					}
				} else {
					if (x == y) {
						str += x + "\n";
					} else {
						int result = x + M;
						int x_y;
						if (x + M > N) {
							x_y = x + M - N;
						} else {
							x_y = x + M;
						}
						while (!(x_y == x)) {
							if (x_y == y) {
								isFind = true;
								str += result + "\n";
								break;
							} else {
								x_y -= gap;
								if (!(x_y > 0)) {
									x_y += N;
								}
								result += M;
							}
						}
						if (!isFind) {
							str += "-1\n";
						}
					}
				}
			}
		}
		System.out.print(str);
		sc.close();

	}

}
