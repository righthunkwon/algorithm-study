import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Node {
		int x;
		int y;
		int dis;		
		public Node(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	static int N;
	static int[][] arr;
	static int dx[] = {-1, 0, 1, 0}; 
	static int dy[] = {0, 1, 0, -1};
	static Queue<Node> q = new LinkedList<>(); // 이동하는배열
	static int ans;
	static int level;
	static int eat;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); 
		arr = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 9){
					// 시작되는 좌표를 
					// 미리 큐에다가 넣어놓고
					// 0 으로바꿈
					q.add(new Node(i, j, 0));
					arr[i][j] = 0;
				}
			}
		}
		ans = 0;  //떨어진 거리(시간)
		 level = 2; // 시작 레벨
		 eat = 0; // 해당레벨에서 먹은 개수
		 
		 solve();
		 System.out.println(ans);
		 
	}
	public static void solve() {
		while(true){
			// 매번 고기를 먹을때 마다 한번씩
			// 다시 fish와 거리와 관련된 값을 초기화 시켜준다.
			LinkedList<Node> fish = new LinkedList<>(); // 먹을수있는 물고기의 좌표
			int[][] dis = new int[N][N]; 
			while (true) {
				// cur은 현재의 좌표 
				Node cur = q.poll();
				// 4방향 탐색
				for(int in=0; in<4; in++){
					int nx = cur.x + dx[in];
					int ny = cur.y + dy[in];
					// 조건에 맞고 해당 거리값이 아직 0이고(방문x), 현재 레벨보다 낮은 값이면
					// 현재의 거리에 +1해준값을 넣어준다. (다음부터는 방문 x)
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && dis[nx][ny]==0 && arr[nx][ny] <= level){
						dis[nx][ny] = dis[cur.x][cur.y] + 1;
						// 해당 좌표를 큐에 추가
						q.add(new Node(nx, ny, dis[nx][ny]));
						// 만약 그 좌표가 먹을 수 있는 물고기의 레벨이면
						// fish라는 큐에다가 추가함
						if(1 <= arr[nx][ny] && arr[nx][ny] <= 6 && arr[nx][ny] < level) {
							fish.add(new Node(nx, ny, dis[nx][ny]));
						}
					}
				}
				// 이동할 수 있는곳이 없으면
				// break
				if(q.size()==0) {
					break;
				}
			}
			// 모든 갈 수 있는 좌표 탐색이 끝나면 
			// 이제 가까운 물고기 좌표를 가야하는데
			// 만약 아무곳도 갈 수 없으면 break하고
			// 현재 먹은 상어의 개수 출력
			if(fish.size() == 0){
				return;
			}
			
			Node min = fish.get(0);
			// 첫번째 애를 임시로 잡고 해당 애보다 
			// 거리를 비교하고 
			// 만약 거리가 같으면 위, 좌측에 있는지 비교
			for(int i = 1; i < fish.size(); i++) {
				if (min.dis > fish.get(i).dis) {
					// 거리가 가까우면 node 교체
					min = fish.get(i);
				}
				// 만약 거리가 같으면
				// 더 위에 있는거로 선택
				else if (min.dis == fish.get(i).dis) {
					if (min.x > fish.get(i).x) {
						min = fish.get(i);
					}
					// 좌측에 있는거 선택
					else if (min.x == fish.get(i).x) {
						if (min.y > fish.get(i).y) min = fish.get(i);   
					}
				}   
			}
			// 걸린 시간만큼 ans에 더해주고 
			// 먹은 상어마리 개수 ++
			ans += min.dis;
			eat++;
			arr[min.x][min.y] = 0;
			// 먹은 좌표는 0으로 바꿔주고
			// 만약 레벨과 먹은상어마리가 같으면
			// 레벨+1하고 eat은 0으로 교체
			if(eat == level) {
				level++;
				eat = 0;
			}
			// 다 끝나면 마지막 좌표를 큐에 추가해서 한번 더돌림
			q.add(new Node(min.x, min.y, 0));
		}
	}
}    
