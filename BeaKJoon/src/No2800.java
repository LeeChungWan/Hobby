import java.util.Scanner;

/*
 * ���� 2800�� ��ȣ����
 * 
 * �Է� : ù° �ٿ� ���� �ƴ� ������ �̷���� ������ �־�����. �� ������ ��ȣ�� �ùٸ��� �����ִ�. 
 *      ����, '+', '*', '-', '/', '(', ')'�θ� �̷���� �ִ�. 
 *      ������ ���̴� �ִ� 200�̰�, ��ȣ ���� ��� 1��, ���ƾ� 10���̴�. 
 * ��� : �ùٸ� ��ȣ ���� �����ؼ� ���� �� �ִ� ���� �ٸ� ���� ���� ������ ����Ѵ�.
 */
public class No2800 {

	public static void removeBracket(String problem, int numOfBracket) {
		char[][] stack = add(problem, numOfBracket);
	}

	public static char[][] add(String problem, int numOfBracket) {

		int indexOfX = 0;
		int indexOfY = 0;
		char[][] stack = initStack(problem, numOfBracket);

		for (int i = 0; i < problem.length(); i++) {
			if (problem.charAt(i) == '(') {
				stack[indexOfX][indexOfY++] = problem.charAt(i);
				// indexOfY++;
			} else if (problem.charAt(i) == ')') {
				stack[indexOfX++][indexOfY] = problem.charAt(i);
				// indexOfX++;
				indexOfY = 0;
			} else {
				stack[indexOfX++][indexOfY++] = problem.charAt(i);
				// indexOfX++;
				// indexOfY++;
			}
		}
		return stack;
	}

	public static int countBracket(String problem) {
		int num = 0;
		for (int i = 0; i < problem.length(); i++) {
			if (problem.charAt(i) == '(')
				num++;
		}
		return num;
	}

	public static char[][] initStack(String problem, int numOfBracket) {
		char[][] stack = new char[numOfBracket + 1][];
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

		int numOfBracket = countBracket(problem);
		System.out.println(numOfBracket);
		removeBracket(problem, numOfBracket);
		sc.close();
	}

}
