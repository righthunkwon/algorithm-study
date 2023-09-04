import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int line;
	static String[][] arr;
	public static void main(String[] args) {
		// 2448 별 찍기 
		// 우선 크게 보면
		// K=1일때 6줄 삼각형 3개, 가로는 11 
		// K=2일때 12줄 삼각형 9개, 가로는 23 
		// k=3 24줄 삼각형 28개 , 가로는 47    
		// 우선 2차원 배열을 선언하고 모두다 빈칸으로 채움
		// 높이가 3의배수로 끊어질때마다
		// 재귀 돌려서 좌표를 별로 바꿔줌 
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new String[N][N * 2 - 1]; // 위의 세로와 가로에 따라 이렇게 선언, 꼭대기 별이 (0,N-1)에 찍힘
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], " "); // 배열의 전 공간을 공백으로 채움
		}
		// 맨꼭대기 지점부터 시작 
		solve(0,N-1,N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2 * N - 1; j++) {
//				sb.append(arr[i][j]);
//			}
//			sb.append('\n');
//		}
//		System.out.println(sb);

	}
	
	public static void solve(int x, int y, int N) {
		if (N == 3) { // 맨밑에 줄일 때 한 지점을 중심으로 맨위지점부터 별 찍기
			arr[x][y] = "*"; // 가장 맨위 꼭대기 별 
			arr[x + 1][y - 1] = arr[x + 1][y + 1] = "*"; // 가운데 줄의 별 
			arr[x + 2][y - 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = "*"; // 맨밑에 줄의 별
			return;
		} else { // 큰 삼각형 세개로 다시 쪼갬
			int cut = N / 2; // 단위 삼각형이 하나가 될때까지 쪼갠다고 보면됨!!!!!
			solve(x, y, cut); // 제일 위에 삼각형
			solve(x + cut, y - cut, cut); // 아래 왼쪽 삼각형
			solve(x + cut, y + cut, cut); // 아래 오른쪽 삼각형
		}
	}
	public static void one() {
		System.out.println("  *  ");
		System.out.println(" * * ");
		System.out.println("*****");
	}

}
