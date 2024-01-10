import java.io.*;

public class Prp_5582_공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		int[][] dp = new int[a.length][b.length];
		//a의 [i] 글자와 b의 [j] 글자
		if (a[0] == b[0])
			dp[0][0] = 1;
		for(int i=1;i<a.length;i++) { 
			if(a[i]==b[0])dp[i][0]=1;
		}
		for(int i=1;i<b.length;i++) {
			if(a[0]==b[i])dp[0][i]=1;
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < b.length; j++) {
				if (a[i] == b[j]) //연속되게 값이 있다면 +1이 될 것 ..
					dp[i][j] = dp[i - 1][j - 1] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
