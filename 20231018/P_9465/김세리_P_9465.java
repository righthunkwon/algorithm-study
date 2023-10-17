package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9465_스티커 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int [2][n+1];
			int[] dp0 = new int[n+1]; // 0행 dp배열
			int[] dp1 = new int[n+1]; // 1행 dp배열
			int[] dpt = new int[n+1]; // 총 dp배열
			int max=0;

			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<n+1;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력완료	

			if(n==1) max = Math.max(arr[0][1],arr[1][1]);
			if(n==2) max = Math.max(arr[1][1]+arr[0][2],arr[0][1]+arr[1][2]);

			if(n>=3) {

				dp0[1]=arr[0][1];
				dp1[1]=arr[1][1];
				dpt[1]=Math.max(dp0[1],dp1[1]);
				max = dpt[1];

				dp0[2]=arr[1][1]+arr[0][2];
				dp1[2]=arr[0][1]+arr[1][2];
				dpt[2] = Math.max(dp0[2], dp1[2]);
				max = Math.max(max, dpt[2]);

				for(int i=3;i<n+1;i++) {
					dp0[i]=Math.max(dp1[i-2],dp1[i-1])+arr[0][i];
					dp1[i]=Math.max(dp0[i-1],dp0[i-2])+arr[1][i];
					dpt[i] = Math.max(dp0[i], dp1[i]);
					max = Math.max(max, dpt[i]);
				}
			}		

			System.out.println(max);

		}//T
	}//main

}
