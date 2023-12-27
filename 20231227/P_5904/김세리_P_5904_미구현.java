package _20231227;

import java.util.*;

public class _5904_Moo게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int idx=0; // 몇번째 묶음인지의 인덱스
		int tmp=0; // N이 음수가 되기 전 숫자를 저장

		while(N>0) {
			for(int i=1;i<N/2;i++) {
				int sum=0;
				idx = i;
				tmp = N;
				for(int j=0;j<=i;j++) {
					sum += Math.pow(2, j);

				}
				N = N-sum;
				if(N<=0) break;
			}

		}
		String ans="";
		int start = 2+idx;
		int save=0;
		if(tmp<=3) {
			if(tmp-1==0) ans ="m";
			else ans ="o";

		}else {
			if(tmp-(idx+2)<=0) {
				save = tmp-(idx+2);
				tmp = -1;
			} else {
				tmp = tmp-(idx+2);
			}
			out: while(tmp>0) {
				for(int i=0;i<idx-1;i++) {
					save = tmp;
					tmp = tmp-(i+3);
				}
				for(int i=idx;i>=0;i--) {
					save = tmp;
					tmp = tmp-i;
				}
			}

			if(save-1==0) ans="m";
			else ans="o";
		}

		System.out.println(ans);

	}//main

}
