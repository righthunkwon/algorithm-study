import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int H;
	static int W;
	static String[][] arr;
	static boolean[][] flag;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// bfs를 통해서 한무리의 양을 다 찾은다음에 +1해주고 그 양들은 true로 바꿔줌
		// 메인 메서드 내에서 또 false된 양을 찾은다음
		// bfs 메서드를 통해서 true바꿔주는거 반복
		// -끝
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
		H = sc.nextInt();
		W = sc.nextInt();

		arr = new String[H][W];
		for(int i =0;i<H;i++) {
			String tmp = sc.next();
			for(int j=0;j<W;j++) {
				arr[i][j] = tmp.substring(j,j+1);
			}
		}
		// 입력 완료  #이면 양 , .이면 풀
		flag = new boolean[H][W];
		qx = new LinkedList<>();
		qy = new LinkedList<>();

		//이제 2중for문을 통해 양의 위치를 파악해보자
		// 파악한 후에 그 양주변을 다 true로 바꿔줌
		int cnt =0; // 무리의 개수
		for(int i =0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(arr[i][j].equals("#") && !flag[i][j]) {
					flag[i][j] = true;
					qx.add(i); // 해당 좌표 큐에 추가
					qy.add(j);
					solve(); // 여러개의 붙어있는 양들이 true로
					cnt++; // 한번의 무리마다 cnt++
				}
			}
		}

		System.out.println(cnt);
		}
	}
	public static void solve() {
		while(true) {
			int x = qx.poll();
			int y = qy.poll();
			for(int in=0;in<4;in++) {
				int nx = x+dx[in];
				int ny = y + dy[in];
				if(nx>=0 && nx<H && ny>=0 && ny<W && arr[nx][ny].equals("#") && !flag[nx][ny]) {
					flag[nx][ny] = true;
					qx.add(nx);
					qy.add(ny);
				}			
			}
			if(qx.size()==0) { // 큐에 아무것도 없을 때까지
				break;
			}
		} // while

	}

}
