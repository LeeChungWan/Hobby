package No1157;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * ���� 1157�� �ܾ����
 * ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�. ��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
 * 
 * �Է� : ù° �ٿ� ���ĺ� ��ҹ��ڷ� �̷���� �ܾ �־�����. �־����� �ܾ��� ���̴� 1,000,000�� ���� �ʴ´�.
 * ��� : ù° �ٿ� �� �ܾ�� ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
 * @author �����
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
