package AlgoStudy;
import java.util.Scanner;
public class BOJ_Q2133_타일_채우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] dp = new int[31];
		dp[0]=0;
		dp[2]=3;
		dp[4]=11;
		for(int i=6;i<=30;i+=2) {
			dp[i]=dp[i-2]*3; //dp[2]경우의 수가 이전 케이스의 앞에 붙는다고 생각..
			for(int j=i-4; j>=0; j-=2) {
				dp[i]+= dp[j]*2;  
				//각 짝수번째 타일마다 고유의 특이 케이스 2개씩 존재하는데, 
				//이전까지의 특이케이스들이 맨 앞에 오는 경우들 더해줌
			}
			dp[i]+=2; //현 타일의 특이 케이스 2개 더해줌
		}
		System.out.println(dp[N]);
	}
}
