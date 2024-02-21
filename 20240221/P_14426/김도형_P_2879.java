package algo_study;

import java.io.*;
import java.util.*;

public class BOJ_Q2879_코딩은_예쁘게 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] cha = new int [N+2]; //줄별로 수정이 필요한 양 저장 ( 양 끝에 0을 넣어줌 )
		
		for(int i=1;i<=N;i++) {
			cha[i]=Integer.parseInt(st.nextToken()); // 현재 들여쓰기 상태 입력 받음
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			cha[i]=Integer.parseInt(st.nextToken())-cha[i]; // 목표 들여쓰기 상태 입력 받아 현재 상태와의 차이를 계산
		}
		System.out.println(Arrays.toString(cha)+"=cha"); //출력확인
				
		int ans = 0;  // 최소 편집 횟수를 저장할 변수
		if(N>1) {
			for(int i=1;i<=N+1;i++) {
				if(cha[i-1]*cha[i]<0) { //필요한 증감 부호 바뀔 경우
					ans += Math.abs(cha[i-1]); // 그 지점의 절대값을 정답에 더함
				}else if(Math.abs(cha[i-1])>=Math.abs(cha[i])) { 
					// 현재 줄의 들여쓰기 차이가 이전 줄보다 작거나 같은 경우
                    // 차이의 절대값에서 현재 줄의 절대값을 뺀 값을 더함
					ans+= Math.abs(cha[i-1])-Math.abs(cha[i]); 
				}
			}
		}else {
			ans = cha[0]; //N=1 이면
		}
		System.out.println(ans);
	}//main
}//class
