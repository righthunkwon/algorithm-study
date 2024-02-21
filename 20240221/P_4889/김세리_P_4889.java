package _20240221;

import java.util.*;
import java.io.*;

public class _4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int tc=1;
		ss: while(true) {
			s = br.readLine();
			// s가 null이거나 시작이 '-'로 시작하면 끝('---'아님 주의ㅜㅜ)
			if(s==null || s.charAt(0)=='-') break ss;
			
			int N = s.length();
			int[] arr = new int[N];
			// '}' 의 경우엔 -1로, '{' 의 경우엔 1로 입력을 받는다
			for(int i=0;i<N;i++) {
				int a =s.charAt(i);
				if(a=='}') arr[i]=-1;
				else if(a=='{') arr[i]=1;
			}
			
			// 더한 값: sum, 내가 바꾼 횟수: cnt
			int sum=0, cnt=0;
			
			for(int i=0;i<N;i++) {
				
				// arr에 입력된 값을 더해본다
				sum += arr[i];
				
				// 안정적인 문자열은 sum 이 무조건 0이상으로 이루어져야 한다.
				
				// 앞에서부터 더하는데 마이너스란 소리는
				// 앞부분에 닫힘('}')으로 시작한다는 소리니까
				
				if(sum<0) {
					// 닫힘('}')인 애를 열림('{')으로 바꿔준다
					// 바꾼거에 맞춰서 sum도 바꿔주고, cnt도 추가해준다
					arr[i] = 1;
					sum = sum +2;
					cnt++;
				}
			}
			
			// 한바퀴 다 돈 후에 sum이 양수란 소리는 열림('{')인 애들이 많다는 소리이므로
			// 뒤부터 하나씩 닫힘('}')으로 바꿔준다
			out: if(sum>0) {
				for(int i=N-1;i>=0;i--) {
					if(arr[i]==1) {
						// 열림('{')인 애를 닫힘('}')으로 바꿔준다
						// 바꾼거에 맞춰서 sum도 바꿔주고, cnt도 추가해준다
						arr[i]=-1;
						sum = sum-2;
						cnt++;
					}
					// sum이 0이 되는 순간 나간다
					if(sum==0) break out;
				}
			}
			
			System.out.println(tc+". "+cnt);
			tc++;
			
		}//while
		
	}//main

}
