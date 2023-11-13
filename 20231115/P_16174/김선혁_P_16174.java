import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean ans;
	static boolean[][] flag;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 입력끝 점프시작
		ans = false;
		flag = new boolean[N][N];
		solve(0,0);
//		if(ans) {
//		}
//		else {
			System.out.println("Hing");
//		}
			
	}
	public static void solve(int x, int y) {
		if(x==N-1 && y==N-1) {
			ans = true;
			System.out.println("HaruHaru");
			System.exit(0);
		}
		// 밑으로 점프		
		int a = arr[x][y];// 현재 좌표 위치만큼 이동해야함
		flag[x][y] = true;
		int nx = x+a;
		int ny = y+a;
		// 밑으로 갈 수 있거나 오른쪽으로 갈수있으면
		// if문 안에서 메서드 추가 실행
		if(nx<N && !flag[nx][y]){
			solve(nx,y);
		}
		if(ny<N && !flag[x][ny]) {
			solve(x,ny);
		}
		// 범위를 벗어나면 if문에 들어가지않고
		// 밑의 return으로 가게된다.
		return;
	}
}
