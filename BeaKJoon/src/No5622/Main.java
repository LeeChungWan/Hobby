package No5622;

import java.util.Scanner;
/*
 * 문제 5622번 다이얼
 * 
 * 입력 : 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
 * 출력 : 첫째 줄에 다이얼을 걸기 위해서 필요한 시간을 출력한다.
 * @author 이충완
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		int sum = 0;
		for(int i=0; i<arr.length;i++){
			if(arr[i] == 'A' ||arr[i]=='B'||arr[i]=='C')
				sum += 3;
			else if(arr[i] == 'D' ||arr[i]=='E'||arr[i]=='F')
				sum+=4;
			else if(arr[i] == 'G' ||arr[i]=='H'||arr[i]=='I')
				sum+=5;
			else if(arr[i] == 'J' ||arr[i]=='K'||arr[i]=='L')
				sum+=6;
			else if(arr[i] == 'M' ||arr[i]=='N'||arr[i]=='O')
				sum+=7;
			else if(arr[i] == 'P' ||arr[i]=='Q'||arr[i]=='R'||arr[i]=='S')
				sum+=8;
			else if(arr[i] == 'T' ||arr[i]=='U'||arr[i]=='V')
				sum+=9;
			else
				sum+=10;
		}
		System.out.println(sum);
		sc.close();
		
	}

}
