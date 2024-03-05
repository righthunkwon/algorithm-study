import java.util.Scanner;

public class Main {
	
	static long []dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long a = sc.nextLong();
		Long b = sc.nextLong();

		//long tmp = 10000000000000000L;
		//String bin = Long.toBinaryString(tmp);
		//System.out.println(bin);
		//1000,1110000110,1111001001,1011111100,0001000000,0000000000 -> 2^54 보다 작음
		
		//dp[i] = 0~ 2^i 까지의 1의 개수 합
		dp = new long [55];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<55;i++) {
			dp[i]=dp[i-1]*2 + jegob(i-1);
		}
		// 누적합 구해서 1~b 까지의 1 누적합에서 1~a-1까지의 누적합 빼준다
		long ans = cal(b)-cal(a-1);
		
		System.out.println(ans);
		
	}//main
	
	
	//0~x 까지 1의 개수 누적합
	public static long cal(long x) {
		long res = 0;
		while(x>0) {
			int L = Long.toBinaryString(x).length(); //2진수르 바꿨을 때의 길이 => 2^L-1 하면 맨 앞 1의 값이 됨
			res+=dp[L-1]+ (x-jegob(L-1)+1); 
			
			// dp[L-1]은 현재 x의 2진수 길이보다 1 짧은 부분까지의 누적합
			// x-jegob(L-1)+1 은  L자리수인 x보다 작거나 같은 2진수 값들의 갯수 => 맨앞 1만 카운트해주는 것!
			
			x-=jegob(L-1); //2진수 맨앞 1 제거한 다음 다시 반복
		}
		return res;
	}
	
	//2의 x제곱 반환하는 메서드  => math.pow 를 쓰면 double을 반환하는데 long으로 변환하는 과정에서 오차가 생길 수 있다고 함..ㅠ
	public static long jegob(int x) {
		long res = 1;
		for(int i=0;i<x;i++) {
			res *=2;
		}
		return res;
	}
}


/*
0         dp[0] = 0
1         dp[1] = 1 + 0

10
11        dp[2] = 2 + dp[1]*2  = 4

			*dp[1]*2하는 이유 ??? => 앞에 1을 빼면 dp[1]을 두번 반복해 더하는 것과 동일
			
100
101
110
111      dp[3] = 4 + dp[2]*2 = 12

1000
1001
1010 
1011
1100
1101
1110
1111     dp[4] = 8 + dp[3]*2 = 32


10000        
10001      
10010
10011        
10100
10101
10110
10111     
11000
11001
11010 
11011
11100
11101
11110
11111

 * 
 * */
