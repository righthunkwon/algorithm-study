package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q2437_저울 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int [N];
		for(int i = 0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); //오름차순 정렬

		int max = 0; //현재 인덱스까지의 숫자로 나타낼 수 있는 최대의 수
		for(int i=0;i<N;i++) {
			if(arr[i]>max+1)break; 
			else max+=arr[i]; 
		}
		System.out.println(max+1);
		
		/* 
		 * arr : 1 1 2 3  6  7  30
		 * max : 1 2 4 7 13 20  
		 * 
		 * */
		
	}//main
}//class
