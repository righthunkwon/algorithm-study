package 백준;

import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt(); 
			M = sc.nextInt();
			arr = new int[N+1][N+1];
			
			for(int i=1; i<= N; i++) {
				for(int j=1; j<= N; j++) {
					arr[i][j] = 987654321;
					if(i == j) {
						arr[i][j] = 0;
					}
				}
			}
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				arr[a][b] = Math.min(c, arr[a][b]);
			}
			solve();
			// 이제 하나씩 출력			
			for(int i = 1 ; i<=N;i++) {
				for(int j = 1; j<=N;j++) {
					if(arr[i][j] == 987654321) {
						arr[i][j] = 0;
					}
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		
	}
	public static void solve() {
		for(int st = 1 ; st<=N ;st++) {
			for(int i = 1;i<=N ;i++) {
				for(int j = 1;j<=N;j++) {
					// 이점을 기준으로 현재 연결되는 값의 합이 기존의 값보다 크면 교체
					if(arr[i][j] > arr[i][st] + arr[st][j]) {
						arr[i][j] = arr[i][st] + arr[st][j];
					}
				}
			}
		}
		
		
		
	}
	
}
