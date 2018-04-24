package No2394;
import java.util.Scanner;

/*
 * 문제 2394번 드라이브 투어
 * 
 * 입력 : 첫째 줄에 N이 주어진다. 다음 줄부터는 도로에 대한 정보를 나타내는 두 자연수 P, Q가 주어진다. 
 *      이는 P번 도시와 Q번 도시 사이에 도로가 있음을 의미한다. 
 *      P=Q=0이 입력으로 주어지면 입력의 끝을 나타낸다.
 * 
 * 출력 : 첫째 줄에 방문한 도시의 개수를 출력한다. 
 *      다음 줄에는 드라이브 경로를 출력한다. 
 *      1번 도시에서 N번에 갔다가 다시 돌아올 수 없는 경우에는 0을 출력한다.
 */
public class Main {

	public static void searchPath(boolean[][] map, boolean[][] visit, int numOfWay) {

		for (int i = 1; i < numOfWay; i++) {
			for(int j=1; j<numOfWay; j++){
				if(map[i][j] != false){
					
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int numOfCity = 0;
		int numOfWay = 0;
		int src = 0;
		int dst = 0;

		numOfCity = sc.nextInt();

		boolean[][] map = new boolean[numOfCity + 1][numOfCity + 1];
		boolean[][] visit = new boolean[numOfCity + 1][numOfCity + 1];

		while (true) {
			src = sc.nextInt();
			dst = sc.nextInt();
			if (src == 0 && dst == 0)
				break;
			else {
				map[src][dst] = true;
				map[dst][src] = true;
				numOfWay++;
			}
		}

		searchPath(map, visit, numOfWay);

		sc.close();

	}

}
