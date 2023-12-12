package _20231214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<W;j++) {
			int a = Integer.parseInt(st.nextToken());
			if(a>0) {
				for(int i=H-a;i<H;i++) {
					arr[i][j] = 1; // 블록이 쌓인 부분을 1로 입력받는다
				}
			}
		}//입력끝
		int rain=0;
		//아래서부터 시작해서 하나씩 위로 올라간다
		for(int i=H-1;i>=0;i--) {
			int a =-1; // 배열의 범위로 나올 수 없는 수를 기본값으로 시작한다
			int b =0;
			for(int j=0;j<W;j++) {
				// 블록이고 a가 -1이면 첫번째로 블록이 위치한 곳이므로 여기 열값을 기억한다
				if(arr[i][j]==1 && a==-1) {
					a=j;
				}
				// 그 다음에 블록이 나오면 빗물이 고일 수 있으므로
				// 고인 빗물의 양을 더해주고
				// 이때 열 값을 다시 시작점(a)으로 한다
				else if(arr[i][j]==1 && a!=-1) {
					b=j;
					rain +=b-a-1;
					a=j;
				}
			}
		}
		System.out.println(rain);
	}//main
}
