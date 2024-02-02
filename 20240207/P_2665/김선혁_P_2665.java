import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int N;
	static int[][] arr;
	static Queue<Node> q;
	static int[][] flag;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		int cnt =0;
		for(int i = 0;i<N;i++) {
			String tmp = sc.next();
			for(int j = 0;j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
				// 다 잘라서 입력받음
				if(arr[i][j] == 0) {
					cnt++;
				}
				// 먼저 막혀있는길의 최대 개수를 구함
			}					
		}
		// 입력끝
		// 1의 위치가 갈 수 있는길
		// 0부터 시작해서 개수만큼 먼저 갈 수 있는길로 바꾸고
		// dfs돌림
		for(int index=0;index<=cnt;index++) {
			bfs(index);
		}
		
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	// index의 개수만큼 0을 1로 바꿔줌 
	
	public static void bfs(int index) {
		// flag에 다익스트라 개념 + 방문처리 확인해줌
		// 0이면 아직 방문 x , 방문했을떄 몇번 기회가 남아있는지기록(쉽게하기 위해 1을 0이라생각)
		flag = new int[N][N];
		q = new LinkedList<Node>();
		q.add(new Node(0,0,index+1));
		// 0,0부터 시작
		while(true) {
			if(q.size()==0) {
				return;
			}
			// 큐가 0이되면 불가능한거로 index+1해서 시작
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			if(x ==N-1 && y == N-1) {
				System.out.println(index);
				System.exit(0);
			}
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y+dy[in];
				// 범위 검사
				if(nx >= N || ny >= N || nx<0 || ny<0) {
					continue;
				}
				// 벽일때 만약 그 좌표에서의 index==1이면 continue
				if(arr[nx][ny] ==0 && n.cnt==1) {
					continue;
				}
				// 일단 arr좌표가 0일때는 그 좌표의 flag값이 만약 0이아니면
				// 1. flag값이 현재 좌표가 더 크면 교체
				// 2. 이하면 그냥 지나감
				if(arr[nx][ny] == 0) {
					if(flag[nx][ny]+1 <n.cnt) {
						// 벽의 좌표를 큐에추가하고 기회는 cnt-1
						flag[nx][ny] = n.cnt-1;
						q.add(new Node(nx,ny,n.cnt-1));
					}
				} 
				// 1일때는 flag값이 많을때만 갱신
				else if(arr[nx][ny] ==1 && flag[nx][ny] < n.cnt) {
					flag[nx][ny] = n.cnt;
					q.add(new Node(nx,ny,n.cnt));
				}				
			}
			
			
			
		}
		
		
	}
	
}
