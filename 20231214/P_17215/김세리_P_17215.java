package _20231214;

import java.util.*;
import java.io.*;

public class _17215_볼링점수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] temp = new char[st.countTokens()];
		temp = st.nextToken().toCharArray();
		
		char[] score = new char[21];
		// 점수 기록판에 점수를 기록한다
		// -이거나 맨 마지막에 보너스 게임을 하지 못한 상황, S다음 투구시에는 0으로 기록한다
		// 이때 0은 char에서의 0으로 입력해야 다음 점수계산 때 오류가 없다.
		for(int i=0;i<21;i++) {
			for(int j=0;j<temp.length;j++) {
				char tmp = temp[j];
				if(tmp =='-') {
					score[i] = '0';
					i++;
				} else if(tmp=='S' && i<18) {
					score[i] = tmp;
					score[i+1]='0';
					i=i+2;
				} else {
					score[i] = tmp;
					i++;
				}
				if(score[20]==0) score[20]='0';
			}
		}//입력끝

//		System.out.println(Arrays.toString(score));
		
		// 각 투구시 계산되는 점수를 ans에 누적합한다
		int ans =0;
		
		// score에서 15까지 점수를 계산한다
		for(int i=0;i<16;i++) {
			int tmp = 0;

			if(score[i]=='P') {
				if(score[i+1]=='S') {
					tmp = 20 -score[i-1]+'0';

				} else {
					tmp = 10 -score[i-1]+'0' + score[i+1]-'0';
				}

			} else if(score[i]=='S') {
				// 터키일때
				if(score[i+2]=='S' && score[i+4]=='S') {
					tmp = 30;

				} else if(score[i+2]=='S') {
					tmp = 20 + score[i+4]-'0';

				} else if(score[i+3]=='P') {
					tmp = 20;

				} else {
					tmp = 10 + score[i+2]-'0' + score[i+3]-'0';
				}

			} else {
				tmp = score[i]-'0';
			}
			
			// 혹시 점수 합이 30을 넘더라도 최대 점수는 30이다
			if(tmp<=30) ans += tmp;
			else ans += 30;
//			System.out.println(i+": tmp-> "+tmp+" ans-> "+ans);
		}
		
		//score 16,17을 계산한다
		for(int i=16;i<18;i++) {
			int tmp =0;
			if(score[i]=='S') {

				if(score[i+2]=='S' && score[i+3]=='S') {
					tmp = 30;
				} else if(score[i-2]=='S' && score[i+2]=='S' && score[i+3]!='S') {
					tmp = 20 + score[i+3]-'0';
				}else if(score[i+2]=='S' && score[i+3]!='S') {
					tmp = 20 + score[19]-'0';
				}else if(score[i+2]!='S' && score[i+3]=='S') {
					tmp = 20 + score[i+2]-'0';
				}else if(score[i+3]=='P') {
					tmp = 20;
				}else {
					tmp = 10 + score[i+2]-'0'+score[i+3]-'0';
				}

			} else if(score[i]=='P') {
				if(score[i+1]=='S') {
					tmp = 20 - score[i-1]+'0';
				} else {
					tmp = 10 - score[i-1]+'0' + score[i+1]-'0';
				}
			} else {
				tmp = score[i]-'0';
			}
			if(tmp<=30) ans += tmp;
			else ans += 30;
//			System.out.println(i+": tmp-> "+tmp+" ans-> "+ans);


		}

		for(int i=18;i<21;i++) {
			int tmp =0;
			if(score[i]=='S') tmp =10;
			else if(score[i]=='P') tmp = 10-score[i-1]+'0';
			else tmp = score[i]-'0';
			if(tmp<=30) ans += tmp;
			else ans += 30;
//			System.out.println(i+": tmp-> "+tmp+" ans-> "+ans);

		}

		System.out.println(ans);
	}//main

}
