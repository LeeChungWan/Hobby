package No1157;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 문제 1157번 단어공부
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 * 
 * 입력 : 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 * 출력 : 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * @author 이충완
 */

public class Main {

	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toUpperCase();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (list.isEmpty())
				list.add(new Node(arr[i]));
			else {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).value == arr[i]) {
						list.get(j).count++;
						break;
					} else if ((j + 1) == list.size()){
						list.add(new Node(arr[i]));
						break;
					}					
				}
			}
		}
		int index = 0;
		int max = list.get(0).count;
		boolean check = false;
		for(int i=1; i<list.size();i++){
			if(max < list.get(i).count){
				max = list.get(i).count;
				index = i;
				check = false;
			}else if(max == list.get(i).count){
				check = true;
			}
		}
		if(check)
			System.out.println("?");
		else
			System.out.println(list.get(index).value);
		sc.close();
	}

}

class Node {
	int count;
	char value;

	public Node(char value) {
		this.count = 1;
		this.value = value;
	}
}
