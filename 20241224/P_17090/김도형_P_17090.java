import java.io.*;
import java.util.*;

public class BOJ_G3_17090_미로_탈출하기 {
	static int n,m,cnt;
	static char[][]map;
	static boolean [][]visit,check;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt = 0; //탈출 가능한 시작지점 갯수
		map = new char[n][m];
		visit = new boolean[n][m];
		check = new boolean[n][m]; //탈출 가능여부 저장용 배열
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dfs(i,j);
			}
		}
		System.out.println(cnt);

	}//main
	
	public static boolean dfs(int x,int y) {
		visit[x][y]=true;
		
		int d = 0;
		if(map[x][y]=='R') {
			d = 1;
		}else if(map[x][y]=='D') {
			d = 2;
		}else if(map[x][y]=='L') {
			d = 3;
		}
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		//탈출 가능한 경우
		if ((nx < 0 || nx >= n || ny < 0 || ny >= m) || check[nx][ny]) {
            check[x][y] = true;
            cnt++;
            return true;
        }
		
		//탈출전에 방문했던 곳 다시 방문했으면 탈출 불가능
		if(visit[nx][ny]) {
			return false;
		}
		
		return check[x][y] = dfs(nx,ny);
		
	}

}
