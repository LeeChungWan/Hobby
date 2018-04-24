package No1699;
import java.util.Scanner;

/*
 * ������ Ǯ ��� 
 * ��ü �迭�� ���� ���� �ְ� ����.
 */
public class Main {
	public static int pow_2(int num) {
		return num * num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 0;
		int sqrt = 0;
		int[] dp = new int[100001];
		
		for(int i=1; i<317; i++)
			dp[i*i] = 1;
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<100001; i++){
			sqrt = (int)Math.sqrt(i);
			min = 10000;
			for(int j=sqrt; j>=1;j--){
				int temp = 1 + dp[i-(j*j)];
				if(min > temp){
					min = temp;
					dp[i] = min;
				}
			}
		}
		System.out.println(dp[n]);
		sc.close();
	}

}
