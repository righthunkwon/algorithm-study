import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2차원 배열에서 각 땅의 높이가
		// 균일한 상태로 만들기
		// 일단 완전탐색
		// 1번 쭉 해본 시간
		// 2번쭉 해본시간
		// 비교해서 더 작은 시간을 정답으로
		// 그때의 높이를 출력 +
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int M= sc.nextInt();
		int K =sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		// 2차원 배열 N*M에 모두 입력완료
		
		int t=0;
		// 2번 경우의 수
		// 목적의 수 하나 구하기
		int height =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				height = arr[i][j];
				for()		
				
				
				
				
			}
		}
		
		
		
		
		
	}
}
