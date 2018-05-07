package No9012;

import java.util.Scanner;
import java.util.Stack;

/*
 * ���� 9012�� ��ȣ
 * ��ȣ ���ڿ�(Parenthesis String, PS)�� �� ���� ��ȣ ��ȣ�� ��(�� �� ��)�� ������ �����Ǿ� �ִ� ���ڿ��̴�. �� �߿��� ��ȣ�� ����� �ٸ��� ������ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(Valid PS, VPS)�̶�� �θ���. �� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���. 
 * ���� x �� VPS ��� �̰��� �ϳ��� ��ȣ�� ���� ���ο� ���ڿ� ��(x)���� VPS �� �ȴ�. �׸��� �� VPS x �� y�� ����(concatenation)��Ų ���ο� ���ڿ� xy�� VPS �� �ȴ�. ���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(())()))�� , �׸��� ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�.
 * �������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�. 
 * 
 * �Է� :	�Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �־�����. 
 * 		�Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. 
 * 		�� �׽�Ʈ �������� ù° �ٿ��� ��ȣ ���ڿ��� �� �ٿ� �־�����. 
 * 		�ϳ��� ��ȣ ���ڿ��� ���̴� 2 �̻� 50 �����̴�.
 * 
 * ��� :	����� ǥ�� ����� ����Ѵ�. ���� �Է� ��ȣ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(VPS)�̸� ��YES��, 
 * 		�ƴϸ� ��NO���� �� �ٿ� �ϳ��� ���ʴ�� ����ؾ� �Ѵ�
 */
public class Main {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String line = sc.next();
			char[] arr = line.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(')
					stack.push(arr[j]);
				else {
					if (stack.isEmpty()) {
						stack.push(arr[j]);
						break;
					} else
						stack.pop();
				}
			}
			if (!stack.isEmpty())
				System.out.println("NO");
			else
				System.out.println("YES");
			stack.removeAllElements();
		}
		sc.close();
	}
}
