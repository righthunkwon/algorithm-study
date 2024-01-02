import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int ans;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		// 일단 tc를 0으로 해놓고 
		// 밑에서 부터는 while문으로 엮음
		while(true) {
			tc++;
			N = sc.nextInt();
			if(N==0) {
				break;
				// 0이 입력되면 종료
			}
			arr = new int[N][N];
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 입력끝
			ans = -987654321; // 0으로했다가 -음수도 나올수있어서
			for(int i =0;i<N;i++) { // 세로 좌표
				for(int j =0;j<N;j++) { // 가로 좌표
					for(int k = 0;k< d.length;k++) { // d의 괄호 개수만큼 
						sum = 0;
						// 이제 도형의 그림대로 가서
						// 좌표가 유효한지 확인
						// 유효하지 않은 좌표면 break 
						// 4번째까지 다 갔으면 ans 확인
						for(int in=0;in<4;in++) {
							int nx = i + d[k][0][in];
							int ny = j + d[k][1][in]; // d의 괄호안에서 앞에껀 x, 뒤에껀 y좌표
							// 마지막은 도형 순서
							// 범위 벗어나면 그대로 break
							if(nx>=N || ny >=N || nx<0 || ny<0) {
								break;
							}
							// 범위 안벗어나면 sum에 그자리 숫자 더함
							sum += arr[nx][ny];
							// 만약 끝까지 도형이 이루어지면 ans교체 판단
							if(in == 3) {
								ans = Math.max(ans, sum);
							}
						}
					} // k
				} // j
			} // i
			
			System.out.println(tc+". "+ans);
		}
	}
	// 모르겠다.. 모든 도형 다 경우의 수 해보자
	// 이거맞음?
	static int[][][] d = {
			// 첫번째 도형(가로)
			{
	            {0, 0, 0, 0}, {0, 1, 2, 3}
	        },
			// 첫번째 도형(세로)
	        {
	            {0, 1, 2, 3}, {0, 0, 0, 0}
	        },
	        // 두번째 도형(그대로)
	        {
	            {0, 0, 1, 1}, {0, 1, 1, 2}
	        },
	        // 두번째 도형(90도 아래로)
	        {
	            {0, 1, 1, 2}, {0, 0, -1, -1}
	        },
	        // 세번째 도형(그대로)
	        {
	            {0, 0, 0, 1}, {0, 1, 2, 2}
	        },
	        // 세번째 도형(-ㅣ 이 모형)
	        {
	            {0, 1, 2, 2}, {0, 0, 0, -1}
	        },
	        // 세번째 도형 (ㄴ자)
	        {
	            {0, 1, 1, 1}, {0, 0, 1, 2}
	        },
	        // 세번째 도형 ( ㅣ- 이 모형)
	        {
	            {0, 0, 1, 2}, {0, 1, 0, 0}
	        },
	        // 네번째 도형 (그대로)
	        {
	            {0, 1, 1, 1}, {0, -1, 0, 1}
	        },
	        // 네번째 도형 (90도회전)
	        {
	            {0, 1, 1, 2}, {0, 0, 1, 0}
	        },
	        // 네번쨰 도형(180도)
	        {
	            {0, 0, 0, 1}, {0, 1, 2, 1}
	        },
	        // 네번째 도형(270도)
	        {
	            {0, 1, 1, 2}, {0, -1, 0, 0}
	        },
	        // 마지막 도형
	        {
	            {0, 0, 1, 1}, {0, 1, 1, 0}
	        }
	    };
	
	
	
}
