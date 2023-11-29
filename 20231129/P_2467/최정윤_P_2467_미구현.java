package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro_2467_용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ph = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ph[i] = Integer.parseInt(st.nextToken());
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=N-1;j>=0;j--) {
				if(Math.abs(ph[i]+ph[j])<min) {
					min=Math.abs(ph[i]+ph[j]);
				}
				else {
					//ㅠㅠ 
				}
			}
		}
	}
}
