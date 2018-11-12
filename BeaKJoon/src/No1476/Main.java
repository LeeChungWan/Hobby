package No1476;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		int temp_e = 1;
		int temp_s = 1;
		int temp_m = 1;

		int years = 1;
		while (true) {
			if (temp_e == E && temp_s == S && temp_m == M)
				break;
			temp_e = (temp_e + 1) % 16;
			if (temp_e == 0)
				temp_e++;
			temp_s = (temp_s + 1) % 29;
			if (temp_s == 0)
				temp_s++;
			temp_m = (temp_m + 1) % 20;
			if (temp_m == 0)
				temp_m++;
			years++;
		}
		System.out.println(years);
		sc.close();
	}

}
