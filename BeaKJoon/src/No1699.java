import java.util.Scanner;

/*
 * 다음에 풀 방법 
 * 전체 배열을 만들어서 값을 넣고 시작.
 */
public class No1699 {
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
