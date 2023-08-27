package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
	/*
	 *  boolean[50000][50000] 만들기엔 좀 그렇다
	 *  겹치는 부분이 점/선분, 겹치지 않는 경우 빼면 모두 직사각형으로 겹친다
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		int ax = 0, ay = 0, ap = 0, aq = 0,
			bx = 0, by = 0, bp = 0, bq = 0;
		for(int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			ax = Integer.parseInt(st.nextToken());
			ay = Integer.parseInt(st.nextToken());
			ap = Integer.parseInt(st.nextToken());
			aq = Integer.parseInt(st.nextToken());
			bx = Integer.parseInt(st.nextToken());
			by = Integer.parseInt(st.nextToken());
			bp = Integer.parseInt(st.nextToken());
			bq = Integer.parseInt(st.nextToken());
			
			// 만나지 않는 경우
			// 순서대로 a가 b의 왼쪽, a가 b의 오른쪽
			// a가 b의 아래, a가 b의 위
			if(ap < bx || ax > bp || aq < by || ay > bq) {
				System.out.println("d");
			}
			// 점으로 만나는 경우
			// 순서대로 a의 오른쪽 위에 b, a의 왼쪽 위에 b
			// a의 오른쪽 아래 b, a의 왼쪽 아래 b
			else if((ap == bx && aq == by) || (ax == bp && aq == by) ||
					(ap == bx && ay == bq) || (ax == bp && ay == bq)) {
				System.out.println("c");
			}
			// 선으로 만나는 경우
			// 순서대로 a의 오른쪽과 b의 왼쪽이 수직 맞닿는 경우, a의 왼쪽과 b의 오른쪽이 수직으로 맞닿는 경우
			// a의 위와 b가 아래가 수평으로 맞닿는 경우, a의 아래와 b의 위가 수평으로 맞닿는 경우
			else if(ap == bx || ax == bp || aq == by || ay == bq) {
				System.out.println("b");
			}
			// 직사각형으로 만나는 경우
			else {
				System.out.println("a");
			}
		}
	}	
}
