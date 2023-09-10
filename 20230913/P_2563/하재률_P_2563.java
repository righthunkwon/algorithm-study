package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		boolean flag[][] = new boolean[100][100]; // 검은 영역이면 true, 아니면 false
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 색종이의 크기는 항상 가로세로 10
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					if(!flag[j][k]) { // 검은 영역이 아니라면
						flag[j][k] = true; // true로 바꿔주고
						count ++; // 개수를 세자
					}
				}
			}
		}
		System.out.println(count);

	}

}
