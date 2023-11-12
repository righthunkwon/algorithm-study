import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	
	static int N;
	static int M;
	static int K;
	static int[] flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		K = sc.nextInt();
		// flag만들어서 만약 1로 바뀌었는데 한번더 왔으면 2로 바꾸자
		// 1인것들만 큐에 추가
		flag = new int[N];
		Queue<Integer> q = new LinkedList<>();
		for(int i =0;i<M;i++) {
			int tmp = sc.nextInt();
			q.add(tmp);
			flag[tmp]++;
		}
		// 초기값으로 큐에다가 다 넣고 시작
		int ans = 0;
		for(int tc=0;tc<K;tc++) {
			flag = new int[N];
			while(true) {
				if(q.size()==0) {
					break;
				}
				int x = q.poll();
//				System.out.print(x+" ");
				if(x+1==N) {
					flag[0]++;
				}
				else {
					flag[x+1]++;
				}
				/////////////////
				if(x-1==-1) {
					flag[N-1]++;
				}
				else {
					flag[x-1]++;
				}
				///////////////
				// 큐에 있는 수를 중심으로 
				// 둘다 +1씩 해줌
			}
//			System.out.println();
			for(int i =0;i<N;i++) {
				if(flag[i]==1) {
					q.add(i);
				}
			}
			// 큐에다가 1인거는 다 추가함
			// 양쪽인거 제외
		}
		for(int i =0;i<N;i++) {
			if(flag[i]==1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

		
	
}
