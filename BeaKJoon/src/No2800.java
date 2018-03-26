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

	public static void removeBracket(String problem, int numOfIndexX) {
		char[][] stack = add(problem, numOfIndexX);
		
		//경우의 수에 따라 괄호를 제거하기 위한 변수 선언.
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

	// 울퉁불퉁한 모양의 스택을 생성하여 반환.
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
