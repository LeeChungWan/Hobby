package No2800;
import java.util.Scanner;

/*
 * ���� 2800�� ��ȣ����
 * 
 * �Է� : ù° �ٿ� ���� �ƴ� ������ �̷���� ������ �־�����. �� ������ ��ȣ�� �ùٸ��� �����ִ�. 
 *      ����, '+', '*', '-', '/', '(', ')'�θ� �̷���� �ִ�. 
 *      ������ ���̴� �ִ� 200�̰�, ��ȣ ���� ��� 1��, ���ƾ� 10���̴�. 
 * ��� : �ùٸ� ��ȣ ���� �����ؼ� ���� �� �ִ� ���� �ٸ� ���� ���� ������ ����Ѵ�.
 */
public class Main {

	public static void removeBracket(String problem, int numOfIndexX) {
		char[][] stack = add(problem, numOfIndexX);
		
		//����� ���� ���� ��ȣ�� �����ϱ� ���� ���� ����.
		int i = numOfIndexX - 1;
	}

	public static char[][] add(String problem, int numOfIndexX) {

		int indexOfX = 0;
		int indexOfY = 0;
		char[][] stack = initStack(problem, numOfIndexX);

		for (int i = 0; i < problem.length(); i++) {
			if (problem.charAt(i) == '(') {
				if (i == 0) {
					stack[indexOfX][indexOfY++] = problem.charAt(i);
				} else {
					indexOfY = 0;
					stack[++indexOfX][indexOfY++] = problem.charAt(i);
				}
			} else if (problem.charAt(i) == ')') {
				stack[indexOfX++][indexOfY] = problem.charAt(i);
				indexOfY = 0;
			} else {
				stack[indexOfX][indexOfY++] = problem.charAt(i);
			}
		}
		return stack;
	}

	public static int countIndexOfX(String problem) {
		int num = 0;
		for (int i = 0; i < problem.length(); i++) {
			if (problem.charAt(i) == '(')
				num++;
			else if (problem.charAt(i) == ')') {
				if ((i + 1) < problem.length())
					num++;
			}
		}
		return num;
	}

	// ���������� ����� ������ �����Ͽ� ��ȯ.
	public static char[][] initStack(String problem, int numOfIndexX) {
		char[][] stack = new char[numOfIndexX][];
		int indexOfX = 0;
		int indexOfY = 0;
		for (int i = 0; i < problem.length(); i++) {
			if (problem.charAt(i) == '(') {
				if (i == 0) {
					indexOfY++;
				} else {
					stack[indexOfX++] = new char[indexOfY];
					indexOfY = 1;
				}
			} else if (problem.charAt(i) == ')') {
				stack[indexOfX++] = new char[++indexOfY];
				indexOfY = 0;
			} else {
				indexOfY++;
			}
		}
		return stack;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String problem = null;

		problem = sc.nextLine();

		int numOfIndexX = countIndexOfX(problem);
		System.out.println(numOfIndexX);
		removeBracket(problem, numOfIndexX);
		sc.close();
	}

}