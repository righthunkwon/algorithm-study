package _20231129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19638_센티와마법의뿅망치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken()); // 거인나라 인구수
		int H = Integer.parseInt(st.nextToken()); // 센티의 키
		int T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치 횟수제한
		int[] giant = new int[N]; // 거인나라 키 모음
		for(int i=0;i<N;i++) {
			giant[i] = Integer.parseInt(br.readLine());
		}
		// 거인나라 애들 키를 순서대로 세워준다
		Arrays.sort(giant);
		int cnt = T;
		
		a: while(T>0) {
			// 센티보다 모두 키가 작으면 while문 반복할 필요 없으니까 나간다
			// 뿅망치 몇 번 휘둘렀는지는 cnt로 기록
			if(giant[N-1]<H) {
				cnt = cnt-T+1;
				break a;
			}
			// 제일 키 큰 놈의 키가 1보다 클 때만 뿅망치 효과있다
			if(giant[N-1]>1) giant[N-1] = giant[N-1]/2;
			
			// 거인 인구수가 1보다 클 때만 아래 비교를 통해서
			// 뿅망치 맞아서 작아진놈 앞으로 보내준다
			// 끝까지 가지말고 작아진놈 위치 찾았으면 빠져나온다
			if(N>1) {
				out : for(int i=N-1;i>0;i--) {
					if(giant[i]<giant[i-1]) {
						int tmp = giant[i];
						giant[i]=giant[i-1];
						giant[i-1]=tmp;
					}else {
						break out;
					}
				}
			}
			// 뿅망치 횟수 차감
			T--;
		}
		// 기본적으로 ans는 맨 끝에놈으로 해두고
		// 그 앞에놈보다 키 작으면 그 앞에놈을 ans로 해준다
		int ans = giant[N-1];
		if(T>1 && giant[T-1]<giant[T-2]) ans = giant[T-2];
		
		// 위 조건에서 안걸러졌는데 센티보다 다 키 작은 경우
		if(cnt==T && giant[N-1]<H) {
			cnt = cnt-T;
		}

		if(ans<H) {
			System.out.println("YES");
			System.out.println(cnt);
		}else {
			System.out.println("NO");
			System.out.println(ans);
		}
	}//main

}
