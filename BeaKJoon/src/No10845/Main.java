package No10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 문제 10845번 큐
 */

public class Main {
	static List<Integer> queue = new ArrayList<>();
	public static void push(int num){
		queue.add(num);
	}
	public static int pop(){
		if(queue.size() != 0){
			int pop = queue.get(0);
			queue.remove(0);
			return pop;
		}
		return -1;
	}
	public static int empty(){
		if(queue.size() != 0)
			return 0;
		return 1;
	}
	public static int front(){
		if(queue.size() !=0)
			return queue.get(0);
		return -1;
	}
	public static int back(){
		if(queue.size() != 0)
			return queue.get(size()-1);
		return -1;
	}
	public static int size(){
		return queue.size();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++){
			StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
			String cmd = tokens.nextToken();
			switch (cmd) {
			case "push":
				push(Integer.parseInt(tokens.nextToken()));
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "front":
				System.out.println(front());
				break;
			case "back":
				System.out.println(back());
				break;
			default:
				break;
			}
		}
	}

}
