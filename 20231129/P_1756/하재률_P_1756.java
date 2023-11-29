package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1756_피자굽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken()); // 오븐 깊이
		int N = Integer.parseInt(st.nextToken()); // 반죽 개수
		
		int[] oven = new int[D];
		int[] pizza = new int[N];
		
		st = new StringTokenizer(br.readLine());
		// 입구에서 막히면 밑엔 의미없다
		int tmpMin = 987654321;
		for(int i = 0; i < D; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			tmpMin = tmp < tmpMin ? tmp : tmpMin;
			oven[i] = tmpMin;
		}
//		for(int i = 0 ; i < D; i++) System.out.print(oven[i] + " ");
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) pizza[i] = Integer.parseInt(st.nextToken());
//		for(int i = 0 ; i < N; i++) System.out.print(pizza[i] + " ");
		
		int cnt = 0;
		int res = 0;
		
		int j = D - 1; // 너 위로 빠져
		// 피자 하나씩 넣을거야
		for(int i = 0; i < N; i++) {
			// 오븐은 뒤에서부터 들어갈 수 있는지
			for(; j >= 0; j--) {
				if(pizza[i] <= oven[j]) {
					cnt++;
					res = j + 1;
					j--;
					break;
				}
			}
		}
		res = cnt == N ? res : 0;
		System.out.println(res);
	}
}
