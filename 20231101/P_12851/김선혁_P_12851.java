import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int time;
	static int cnt;
	static Queue<Integer> qx;
	static int[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 시작지점
		M = sc.nextInt(); // 도착지점
		qx = new LinkedList<>();
		flag = new int[100001]; // 여기에는 해당 값을 지날떄의 시간을 적을거임
		flag[N] = 0; // 일단 시작위치 N을 0으로 정해놓고 
		qx.add(N); // 큐에다가 추가한다.
		cnt =0 ; // 개수
		time =987654321; //시간
		solve();
		System.out.println(time);
		System.out.println(cnt);
	}
	public static void solve() {
		// 이동하는 좌표를 계속 q에서 꺼내서
		// 만약 M의 위치라면 time에 수를 대입하고 
		// cnt+1를 해준다.
		while(true) {
			int x = qx.poll();
			if(x==M) {
				time = flag[x];
				cnt +=1;
			}
			// 만약 정답위치에 도착해서 time이 갱신되었을 때 
			// 시간이 +1이라도 되면 break
			if(time<flag[x]) {
				break;
			}
			// x-1의 좌표가 아직 방문하지 않았거나 같은 시간때에 방문한경우
			if(x-1>=0 && (flag[x-1] ==0 || flag[x-1] ==flag[x]+1)) {
				qx.add(x-1);
				flag[x-1]= flag[x]+1;
			}
			// x+1의 좌표가 아직 방문하지 않았거나 같은 시간때에 방문한경우
			if(x+1<=100000 && (flag[x+1] ==0 || flag[x+1] ==flag[x]+1)) {
				qx.add(x+1);
				flag[x+1]= flag[x]+1;
			}
			// x*2의 좌표가 아직 방문하지 않았거나 같은 시간때에 방문한경우
			if(x*2<=100000 && (flag[x*2] ==0 || flag[2*x] == flag[x]+1)) {
				qx.add(x*2);
				flag[x*2]= flag[x]+1;
			}
			// 만약 큐 사이즈가 0이되면 break
			if(qx.size()==0) {
				break;
			}
		}
		
	}
}
