import java.util.Scanner;

/*
 * ���� 2394�� ����̺� ����
 * 
 * �Է� : ù° �ٿ� N�� �־�����. ���� �ٺ��ʹ� ���ο� ���� ������ ��Ÿ���� �� �ڿ��� P, Q�� �־�����. 
 *      �̴� P�� ���ÿ� Q�� ���� ���̿� ���ΰ� ������ �ǹ��Ѵ�. 
 *      P=Q=0�� �Է����� �־����� �Է��� ���� ��Ÿ����.
 * 
 * ��� : ù° �ٿ� �湮�� ������ ������ ����Ѵ�. 
 *      ���� �ٿ��� ����̺� ��θ� ����Ѵ�. 
 *      1�� ���ÿ��� N���� ���ٰ� �ٽ� ���ƿ� �� ���� ��쿡�� 0�� ����Ѵ�.
 */
public class No2394 {

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
