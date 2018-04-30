package No2941;

import java.util.Scanner;
/*
 * 문제 2941번 크로아티아 알파벳
 * 입력 :	첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 		문제 설명에 나와있는 크로아티아 알파벳만 주어진다.
 * 출력 :	입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * @author 이충완
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		int num = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'c') {
				if (i + 1 < arr.length && arr[i + 1] == '=' || arr[i + 1] == '-')
					num--;
			} else if (arr[i] == 'd') {
				if (i + 1 < arr.length && arr[i + 1] == '-')
					num--;
				else if (i + 2 < arr.length && arr[i + 1] == 'z' && arr[i + 2] == '=')
					num--;
			} else if (i + 1 < arr.length && arr[i] == 'l' && arr[i + 1] == 'j')
				num--;
			else if (i + 1 < arr.length && arr[i] == 'n' && arr[i + 1] == 'j')
				num--;
			else if (i + 1 < arr.length && arr[i] == 's' && arr[i + 1] == '=')
				num--;
			else if (i + 1 < arr.length && arr[i] == 'z' && arr[i + 1] == '=')
				num--;
		}
		System.out.println(num);
		sc.close();
	}

}
