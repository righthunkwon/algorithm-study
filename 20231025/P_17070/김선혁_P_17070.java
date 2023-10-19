import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int ans;
	static boolean[][] flag;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N][N];
    	for(int i =0;i<N;i++) {
    		for(int j =0;j<N;j++) {
    			arr[i][j] = sc.nextInt();
    		}
    	}
    	// 입력끝
    	
    	// 이문제도 dfs로 현재의 가로 , 대각선 ,세로의 상태를
    	// input으로 
    	// 1 2 3 이렇게 넘겨서
    	// 갈 수 있는 방향대로 좌표와 방향을 넣어보자
    	
    	ans = 0;
    	flag = new boolean[N][N];
    	flag[0][0] = true;
    	solve(0,1,1);
    	System.out.println(ans);
    }
    public static void solve(int i,int j , int pos) {
    	if(i<0 || i >=N || j<0 || j>=N || arr[i][j] ==1 || flag[i][j]) {
    		// 범위판단 + 벽 + 방문여부
    		return;
    	}
    	// 여기서 2인경우에 (대각선)
    	// 왼쪽과 위가 벽이 아니어야함!!
    	if(pos==2) {
    		// 위에판단 
    		if(arr[i-1][j]==1 || arr[i][j-1] ==1) {
    			return;
    		}
    	}
    	// 가는곳의 좌표를 판단하는것이 아닌
    	// 현재위치를 판단하는 방법으로 
    	// 목적지에 도달하였어도
    	// 범위랑 조건을 먼저 판단하고 ans를 ++해줘야한다.
    	if(i==N-1 && j==N-1) {
    		ans++;
    		return;
    	}
    	flag[i][j] =true;
    	
    	if(pos ==1) {
    		solve(i,j+1,1); // 가로
    		solve(i+1,j+1,2); //대각선
    	}
    	else if(pos ==2) {
    		solve(i,j+1,1); // 가로
    		solve(i+1,j+1,2); //대각선
    		solve(i+1,j,3); // 세로
    	}
    	else {
    		solve(i+1,j+1,2); //대각선
    		solve(i+1,j,3); // 세로
    	}
    	flag[i][j] = false;
    	
    }
}
