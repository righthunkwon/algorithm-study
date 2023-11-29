package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19638_센티와마법의뿅망치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken()); // 거인나라 인구수
		int H = Integer.parseInt(st.nextToken()); // 센티의 키
		int T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치 횟수제한
		PriorityQueue<Integer> giant = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			giant.add(Integer.parseInt(br.readLine()));
		}
		int cnt=T;
		a: while(T>0) {
			int tallest = giant.poll();
			// 센티보다 모두 키가 작으면 while문 반복할 필요 없으니까 나간다
			// 마지막에 비교해서 YES/NO 판단할거니까 다시 넣어서 나간다
			if(tallest<H) {
				giant.add(tallest);
				break a;
			}
			// 키가 1보다 클 때만 뿅망치 효과있다
			// 그 때 뿅망치 효과주고 다시 집어넣는다
			if(tallest>1) giant.add(tallest/2);
			
			// 가장 큰놈이 1일 땐 더 이상 뿅망치랑 상관없으므로
			// 마지막 비교를 위해 다시 넣은 다음에 나간다
			if(tallest==1) {
				giant.add(tallest);
				break a;
			}
			
			// 뿅망치 횟수 차감
			T--;
		}
		// 가장 큰놈 뽑아서 마지막으로 정답 출력할거 판단한다
		int tallest = giant.poll();

		if(tallest<H) {
			System.out.println("YES");
			System.out.println(cnt-T);
		}else {
			System.out.println("NO");
			System.out.println(tallest);
		}
	}//main

}
