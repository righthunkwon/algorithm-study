package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q7453_합이_0인_네_정수 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //배열의 크기
		int[] A = new int[N], B = new int[N], C = new int[N], D = new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
		}
		
		int[]AB = new int[N*N];
		int[]CD = new int[N*N];
		int idx =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				AB[idx]=A[i]+B[j];
				CD[idx]=C[i]+D[j];
				idx++;
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long ans = 0;
		
		//투포인터
		int left = 0;
		int right = N*N-1;
		while(left<N*N && right>=0) {
			if(AB[left]+CD[right]>0) {
				right--;
			}else if(AB[left]+CD[right]<0) {
				left++;
			}else {
				int leftCnt =0;
				int rightCnt =0;
				
			}
			
			
		}
		
		
		
		
		
	}//main
}//class
