import java.util.Scanner;

/*
 * 문제 2800번 괄호제거
 * 
 * 입력 : 첫째 줄에 음이 아닌 정수로 이루어진 수식이 주어진다. 이 수식은 괄호가 올바르게 쳐져있다. 
 *      숫자, '+', '*', '-', '/', '(', ')'로만 이루어져 있다. 
 *      수식의 길이는 최대 200이고, 괄호 쌍은 적어도 1개, 많아야 10개이다. 
 * 출력 : 올바른 괄호 쌍을 제거해서 나올 수 있는 서로 다른 식을 사전 순으로 출력한다.
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
