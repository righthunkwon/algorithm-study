import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q1987_알파벳 {	
	static int R,C;
	static int [][]arr;
	static boolean[] visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max; //지날 수 있는 최대 칸 수
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);		
		R = sc.nextInt(); //세로길이
		C = sc.nextInt(); //가로길이	
		arr = new int[R][C]; //입력받을 배열
		visit = new boolean[26]; // 0(A)~25(Z)까지 	
		
		for(int i =0; i<R; i++) {
			String str = sc.next();
			for(int j =0; j<C; j++) {
				arr[i][j]=str.charAt(j)-65; // A-65 하면 0이되고, Z-65하면 25가 됨
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		//입력 끝		
		dfs(0,0,1);		
		System.out.println(max);				
	}//main
	
	// nx,ny : 현재 x,y 좌표  / depth : 깊이
	public static void dfs(int nx, int ny,int depth) {		
		visit[arr[nx][ny]]=true; //현위치 방문처리
		if(depth>max)
			max=depth; //더 큰 길이가 되면 갱신	
		for(int i = 0; i<4; i++) { //사방탐색		
			int newx = nx+dr[i];
			int newy = ny+dc[i];	
			if(newx>=0 && newy>=0 && newx<R && newy<C && !visit[arr[newx][newy]]) { 
				//배열 벗어나지 않고, 방문 안한 번호라면			
				dfs(newx,newy,depth+1);
				visit[arr[newx][newy]]=false; //원상복구
			}
		}		
	}//dfs
}
