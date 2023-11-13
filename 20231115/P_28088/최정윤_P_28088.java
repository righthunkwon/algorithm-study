package baek;

import java.io.*;
import java.util.*;

public class Pro_28088_응애EASY {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] ex_hi = new boolean[N];
		boolean[] hi = new boolean[N];
		for (int i = 0; i < M; i++) {
			hi[Integer.parseInt(br.readLine())] = true;
		}

		while (K > 0) {
			K--;
			ex_hi = hi.clone();// 과거인사로 바꿔놓기
			hi = new boolean[N];// 현재 인사할 사람 초기화
			int f;
			int b;
			for (int i = 0; i < N; i++) {
				//범위초과할까봐 앞뒤 사람 지정해줌 0번과 N-1번
				if (i == 0) {f = 1;b = N - 1;} 
				else if (i == N - 1) {f = 0;b = N - 2;}
				else {f = i - 1;b = i + 1;}

				if (ex_hi[f] && ex_hi[b]) {//인사하는 사람이 양쪽에 존재하면 다음에 인사X
					continue;
				} else if (ex_hi[f] || ex_hi[b]) {//둘 중에 한명이 인사했다면 나는 다음에 인사한다.
					hi[i] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (hi[i])
				cnt++;
		}
		System.out.println(cnt);

	}
}
