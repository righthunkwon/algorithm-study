package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_Q14426_접두사_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0; //정답 초기화
		HashSet<String>[]hs = new HashSet[501]; 
		for(int i=1;i<=500;i++) {
			hs[i]=new HashSet<String>();
		}
		
		while(N-->0) {
			String str = br.readLine(); //문자열 입력 받기
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<str.length();i++) {
				sb.append(str.charAt(i));
				hs[sb.length()].add(sb.toString()); //한 문자열에 대한 모든 가능한 접두사 HashSet에 넣기
			}  //길이에 따라 hashset 저장
		}
		
		while(M-->0) {
			String prefix = br.readLine(); //접두사 입력 받기
			if(hs[prefix.length()].contains(prefix))cnt++; 
			//해당 문자열길이의 hashset에 prefix가 있으면 답 +1
		}
		
		System.out.println(cnt);
	
	}//main
}//class
