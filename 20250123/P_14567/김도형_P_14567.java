import java.io.*;
import java.util.*;

public class BOJ_G5_14567_선수과목 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[]list = new ArrayList[n+1]; 
		int [] dp = new int[n+1]; //해당 과목 이수할때 필요한 최소 학기 수
		Arrays.fill(dp, 1); //일단 전부 1로 초기화
		for(int i=0;i<=n;i++)list[i]=new ArrayList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		for(int i=1;i<=n;i++) {
			
			for(int el : list[i]) {
				dp[el]=Math.max(dp[el], dp[i]+1);
			}
		}
		
		for(int i=1;i<=n;i++)System.out.print(dp[i]+" ");
		
		
	}

}
