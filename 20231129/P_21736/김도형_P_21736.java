package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q21736_헌내기는_친구가_필요해 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][]map = new char[N][M];
		
		for(int i = 0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String str = st.nextToken();
			map[i]=str.toCharArray();
		}
		
		int ans = 0;
		boolean [][] visit = new boolean[N][M];
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,1,-1};
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='I') { //도연이 찾았으면 bfs로 만날수있는 사람 수 카운트
					
					qx.add(i);
					qy.add(j);
					visit[i][j]=true;
					
					while(!qx.isEmpty() || !qy.isEmpty()) {
						int x = qx.poll();
						int y = qy.poll();
						
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];

              //범위 벗어나거나, 이미 방문했거나, 벽이면 pass
							if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] ||map[nx][ny]=='X')continue;
							
							if(map[nx][ny]=='P')ans++; //사람 만나면 ans에 +1
							
							qx.add(nx);
							qy.add(ny);
							visit[nx][ny]=true;
						}
					}
				}
			}
		}
		
		if(ans == 0) {
			System.out.println("TT");
		}else
		System.out.println(ans);
		
		
		
	}//main
}//class
