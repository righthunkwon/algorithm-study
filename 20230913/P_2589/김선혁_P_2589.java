import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class pos{
		int x;
		int y;
		int cnt;
		public pos(int x, int y, int cnt) {			
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}			
	}	
	// pos라는 하나의 생성자를 생성하여줘서
	// 해당 좌표에서의 x좌표 y좌표 체크된 개수를 저장하여 준다.
	static int N; // 세로
	static int M; // 가로
	static String[][] arr;
	static boolean[][] flag; // 방문했는지 확인
	static Queue<pos> q;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int max; // 전체에서의 최단거리의 최대값
	static int tmpmax; // 한 좌표에서의 최대값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();	
		arr = new String[N][M];
		for(int i =0;i<N;i++) {
			String tmp = sc.next();
			for(int j = 0;j<M;j++) {
				arr[i][j] = tmp.substring(j,j+1);
			}
		}
		// 입력완료 

		max = 0; // 최단거리의 최대값
		tmpmax =0;
		q = new LinkedList<pos>();
		// 육지인 좌표를 찾게 되면 
		// 그 육지를 중심으로 최단거리의 
		// 최대값을 구해보자 
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j].contentEquals("L")) {
//					System.out.println(i+" "+j);
					flag = new boolean[N][M]; // flag 초기화
					flag[i][j] = true;
					q.add(new pos(i,j,0));	// 큐에 해당 좌표 넣고 돌리기
					solve();
//					System.out.println(tmpmax);
					if(max<tmpmax) { // 현재 좌표에서 계산한 tmpmax값이
						max = tmpmax; // 여태나온 최단거리보다 길다면 교체
					}
				}
			}
		}
		System.out.println(max);



	}
	// 해당 좌표를 중심으로 가장 큰 값을 찾기
	public static void solve() {
		tmpmax = 0; // 해당좌표에서의 가장 큰값을 저장할 변수
		while(true) {
			pos po = q.poll(); // 큐에 저장되어있는것을 po로 꺼냄 
			int x= po.x; // po에 큐의 x, y, cnt를 각각 저장하고
			int y =po.y;
			int cnt = po.cnt;
			for(int in=0;in<4;in++) {
				// 해당 조건을 만족하는지 확인후에 만족하면 true,
				if(x+dx[in]>=0 && x+dx[in]<N && y+dy[in]>=0 && y+dy[in]<M && !flag[x+dx[in]][y+dy[in]] && arr[x+dx[in]][y+dy[in]].equals("L")) {
//					System.out.println(cnt+" "+tmpmax+" "+max);
					flag[x+dx[in]][y+dy[in]] = true; 
					q.add(new pos(x+dx[in],y+dy[in],cnt+1)); // q에 해당 좌표 추가
					if(cnt+1>tmpmax) { // cnt+1이 최대인 지점을 찾아야 하므로 중간마다 계속 확인
						tmpmax = cnt+1;
					}
				}			
			} // for

			if(q.size()==0) { // q에 저장된것이 없을 때까지 무한루프 -> 더이상 이어진 육지가 x
				return;
			}
		}
	}


}
