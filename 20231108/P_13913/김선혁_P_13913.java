import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] time;
	static int ans;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		// 지나간길을 기록해야하니깐
		// 배열하나 더만들고 거기에 
		// 걸어온 바로 전 좌표를 넣자 
		// 그러고 마지막에 쭉 다 출력
		arr = new int[100001];
		time = new int[100001];
		ans = 0;
		solve();
		Stack<Integer> st = new Stack<>();
		// 여태 나온 수들을 모두 스택에 추가
		int tmp = K;
		for(int i =0;i<=ans;i++) {
			st.add(tmp);
			tmp = arr[tmp];
		}
		
		// 걸린 시간을 먼저 출력하고 
		System.out.println(ans);
		// 스택에 있는것들을 쭉 출력한다.
		for(int i =0;i<=ans;i++) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	public static void solve() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(true) {
			int x = q.poll();
			if(x==K) {
				ans = time[K];				        
				break;
			}
			// 0보다 크고 아직 방문 x 
			// 큐에 추가하고 
			// 시간 +1 해주고
			// 바로전 좌표 넣기
			if(x-1>=0 && time[x-1]==0) {
				q.add(x-1);
				time[x-1] = time[x]+1;
				arr[x-1] = x;
			}
			if(x+1<100001 && time[x+1]==0) {
				q.add(x+1);
				time[x+1] = time[x]+1;
				arr[x+1] = x;
			}
			if(x*2<100001 && time[x*2]==0) {
				q.add(x*2);
				time[x*2] = time[x]+1;
				arr[x*2] = x;
			}
			if(q.size()==0) {
				break;
			}
		}
		
		
	}
}
