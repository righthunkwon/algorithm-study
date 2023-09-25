import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;

            return this.x == node.x && this.y == node.y;
        }
	}
	static int N;
	static int K;
	static int R;
	static int[][] arr;
	static ArrayList<Node> pos;
	static ArrayList<Node>[][] bridge;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int cnt;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);	
		// 이문제는 먼저 소의 좌표와 다리의 위치를
		// 각각 배열에 넣어주고 arr배열에서 소가있는 위치는
		// 값을 1로 설정해준다.
		// 소가 있는 배열에서 소의 위치를 하나 선정 후에
		// bfs를 통해 큐에 계속 좌표를 넣어감
		// 이 과정중에 소와 만나면 true, 큐가 비고 아직 소를 만나지못하면
		// 길을 건너야 하는 것이므로 +1;
		N = sc.nextInt();
		K = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N+1][N+1];
		bridge = new ArrayList[N+1][N+1]; // 1부터 N까지 사용
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				bridge[i][j] = new ArrayList<>();
			}
		}
		// N개의 bridge 리스트 배열을 선언
		for(int i =0;i<R;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			bridge[a][b].add(new Node(c,d));
			bridge[c][d].add(new Node(a,b));
		}
		// a,b,c,d 4개의 값을 모두 받아서
		// 양방향으로 현재의 위치와 나머지 두개의 다리 좌표를 노드로 추가

		pos = new ArrayList<>();
		for(int i =0;i<K;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pos.add(new Node(a,b));	
			arr[a][b] = 1;
		}
		// 소 위치 입력 완료
		
		cnt = 0;
		solve();
		System.out.println(cnt);


	}
	public static void solve() {
		for (int i=0;i<K;i++) {
            Node po = pos.get(i);
            // 0번째부터 쭉 po에 소 한마리 정보를 대입
            

            boolean[][] visited = new boolean[N+1][N+1]; // 소가 그 지점을 밟았는지 확인하기위함
            boolean[][] flag = new boolean[K][K]; // 해당 소가 다른소를 만났는지 
            Queue<Node> queue = new LinkedList<>();

            queue.add(po); // 선택된 소를 큐에다 넣고 그 소가 있는 위치를 true로 전환
            visited[po.x][po.y] = true;
            // 이제 큐에 있는 좌표를 중심으로 
            while (!queue.isEmpty()) {
                Node node = queue.poll(); // 저장된 큐에서 하나씩 위치 꺼냄
                // 큐에서 좌표를 꺼냈을 때 
                // 소가 있는 위치에서 1을 만난거면 
                // 그 위치는 소가 있는 위치로
                // 이 지점에서 다른 소와의 flag를
                // true로 바꿔주고 break;
                if (arr[node.x][node.y] == 1) {
                    for(int j=i+1;j<K;j++) {
                        Node ncow = pos.get(j);
                        // 소가 둘이 만난경우
                        // true를 바꿔줌
                        if(ncow.x == node.x && ncow.y == node.y) {
                            flag[i][j] = true;
                            break;
                        }
                    }
                }
                for (int in=0;in<4;in++) {
                	// nx와 ny가 범위를 만족하고 
                	// 방문하지 않은 좌표라면 큐에 추가하는 과정
                    int nx = node.x + dx[in];
                    int ny = node.y + dy[in];                    
                    // 현재 위치가 범위를 벗어나지 않고 
                    // 방문했었는지 판단 
                    if (!check(nx,ny) || visited[nx][ny]) {
                        continue;
                    }
                    // 해당 다리의 값이 이미 들어있다면 continue
                    if (bridge[node.x][node.y].contains(new Node(nx, ny))) {
                        continue;
                    }
                    // 위의 조건에 걸리지 않으면 true로 바꾸고 큐에 좌표를 넣는다.
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                }
            }

            for (int j=i+1;j<K;j++) {
                if (!flag[i][j]) {
//                	System.out.println(i+" "+j);
                    cnt++;
                }
            }
        }
		
	}// 현재의 x와 y의 좌표가
	// 목장의 범위를 벗어나는지 
	// 확인하는 메서드
	 private static boolean check(int x, int y) {
	        return x>0 && x<=N && y>0  && y<=N;
	    }

}
