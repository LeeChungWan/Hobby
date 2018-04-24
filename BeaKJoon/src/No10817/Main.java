package No10817;
import java.util.Scanner;

public class Main {

	public static void compareOfValue(Node[] node) {
		if (node[0].value < node[1].value)
			node[1].point++;
		else
			node[0].point++;

		if (node[1].value < node[2].value)
			node[2].point++;
		else
			node[1].point++;

		if (node[0].value < node[2].value)
			node[2].point++;
		else
			node[0].point++;
	}

	public static void printResult(Node[] node) {
		if (node[0].point == 1) {
			System.out.println(node[0].value);
		} else if (node[1].point == 1) {
			System.out.println(node[1].value);
		} else {
			System.out.println(node[2].value);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int value;
		Node[] arrOfNode = new Node[3];

		for (int i = 0; i < 3; i++) {
			value = sc.nextInt();
			arrOfNode[i] = new Node(value);
		}

		compareOfValue(arrOfNode);
		printResult(arrOfNode);

		sc.close();
	}

	static class Node {
		int value;
		int point;

		public Node(int value) {
			this.value = value;
			this.point = 0;
		}
	}

}
