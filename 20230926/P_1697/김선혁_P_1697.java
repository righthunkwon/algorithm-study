import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[] flag;
	static Queue<Integer> q;
	static int ans;
	public static void main(String[] args) {
		// 어떻게 보면 4방향이랑 똑같다고 볼수있음
		// +1, -1 , x2 
		// 나누기는 모르겠
		// 일단 기존의 N좌표에서 저렇게 3개 수식이 되는 지점에
		// 얼마나 걸렸는지 값을 넣어 놓음
		// 만약 중간에 K가 나오다면 그대로 return
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		K = sc.nextInt();
		flag = new int[100001]; // 0부터 100000까지 숫자 flag로
		q = new LinkedList<Integer>(); 
		q.add(N); // 시작점 N을 큐에다 넣고 시작
		solve();
		
		System.out.println(ans);
		
	}
	public static void solve() {
		while(true) {
			// x가 k나올때까지 무한 루프
			int x = q.poll();
			if(x == K) {
				// x==k일때 걸린 횟수를 알아야함
				ans = flag[x];
				return;
			}
//			System.out.println(x+" "+flag[x]);
			
			// 1. x+1
			// 2. x-1
			// 3. 2*x
			// 이 3가지 경우의 flag를 현재 x의 값보다 +1
			// 이것은 1초 더 걸린다는 의미 
			// +1해준다음 모두 큐에 넣어서 계속 구하기
			if(x+1<=100000 && flag[x+1]==0) {
				flag[x+1] = flag[x] +1;
				q.add(x+1);
			}
			if(x-1>=0 && flag[x-1]==0) { // 0보다 크고 횟수가 현재 없어야 아직 안나온 숫자
				flag[x-1] = flag[x] +1; // 기존의 횟수보다 +1
				q.add(x-1);
			}
			if(x*2<=100000 && flag[x*2]==0) {
				flag[x*2] = flag[x] +1;
				q.add(x*2);
			}				
			// +1과 *2에 부등호가 없으면
			// nullpointexception이 뜬다.
			// 아마 99999까지 모두 숫자가 있어 return되었지만
			// 답이없어서 그런듯
		}
		
		
	}
	
}
