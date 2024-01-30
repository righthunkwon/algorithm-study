package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q10986_나머지_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  
		int M = Integer.parseInt(st.nextToken()); 
		int ans = 0;
		int [] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			//누적합 구하기
			arr[i]=arr[i-1]+num;
            //누적합의 나머지가 0이라면  정답 +1
			if(arr[i]%M==0) ans++;
		}
		
		System.out.println(ans);
	}//main
}//class
