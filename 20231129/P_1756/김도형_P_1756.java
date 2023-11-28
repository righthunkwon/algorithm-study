package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q1756_피자_굽기 {
	public static void main(String[] args) throws IOException {

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()); // 오븐이 깊이 D
		int N = Integer.parseInt(st.nextToken()); // 반죽의 개수 N

		st = new StringTokenizer(br.readLine());
		int[] oven = new int[D]; //오븐 지름 저장
		
		for (int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if(i>0) {
				if(oven[i]>oven[i-1])oven[i]=oven[i-1]; //뒤로 갈수록 커지는 오븐 지름 의미X(앞에서 막힘)
			}
		}
//		System.out.println(Arrays.toString(oven));

		st = new StringTokenizer(br.readLine());
		int[] pizza = new int[N]; //피자 지름 저장 배열
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(pizza));
		
		//입력 끝

		int ovenIdx=D-1; //오븐 인덱스 맨 뒤부터 탐색
		int cnt=0; //넣은 피자 갯수
		int lastpizzalocation = 0; //마지막으로 넣은 피자 위치
		
		for(int i=0; i<N; i++) {
			while(ovenIdx>=0) {
				if(oven[ovenIdx]>=pizza[i]) { //현재 피자 넣을 수 있으면 넣자
					cnt++;
					ovenIdx--;
					lastpizzalocation = ovenIdx+1;
					break;
				}ovenIdx--;
			}
		}
		
		if(cnt==N)System.out.println(lastpizzalocation+1);
		else System.out.println(0);

		
		
		
		
//30만 * 30만 반복 시간초과ㅠㅠ
//		boolean[] pizzalocation = new boolean[D];
//		int top = 0;
//
//		l:for (int i = 0; i < N; i++) {
//			int nowpizza = pizza[i];
//			for (int j = 0; j < D; j++) {
//				if (oven[j] < nowpizza || pizzalocation[j]) {
//					top = j - 1;
////					System.out.println("top:"+top);
//					if (top < 0) {
//						System.out.println(0);
//						return; //맨 앞 오븐에도 넣을 수 없으면 0출력하고 끝
//					}else {
//						pizzalocation[top]=true;
//						break;						
//					}
//				}else if(j==D-1) { //맨끝 도착했으면 거기 피자 놓자
//					top = j;
//					pizzalocation[top]=true;
//					
//				}else
//					continue;
//			}
//		}
////		System.out.println(Arrays.toString(pizzalocation));
//		System.out.println(top+1); //오븐 최상단이 0이 아니라 1부터 시작하니까 +1
		
	}// main
}// class
