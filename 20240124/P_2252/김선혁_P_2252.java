import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
static int N;
static int M;
static ArrayList<Integer>[] ar;
static int[] arr;
static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 이거 한방향으로 시작점 리스트에 추가해놓고
		// 다 나올떄마다 +1씩해주고
		// 확인하는과정에서 0되면 그때 넣으면됨
		
		arr = new int[N+1]; // 1부터 N까지
		 ar = new ArrayList[N+1];
		for(int i = 1;i<N+1;i++) {
			ar[i] = new ArrayList<>();
		}
		// 다 초기화 세팅
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			arr[b]++;
			// a로 시작하는거에 다 리스트 추가하고
			// arr배열에서 앞에 있어야하는게
			// 필요한 개수만큼 +해줌
		}
		q = new LinkedList<>();
		solve();
		
	}	
	static void solve() {
		// 일단 arr배열에서 값이 0개인것들을
		// 먼저 큐에다가 추가
		for(int i = 1;i<N+1;i++) {
			if(arr[i] ==0) {
				q.add(i);
			}
		}
		// 추가완료하고 이제 하나씩 큐에있는거 꺼내서 
		// ar에서 향하는곳의 숫자의 값 -1해주고
		// 0 이되면 큐에 추가
		while(true) {
			if(q.size()==0) {
				break;
			}
			int num = q.poll();
			// 일단 num는 출력해줌
			System.out.print(num+" ");
			
			// ar에서 num번째 배열의 숫자 하나씩 -1
			for(int i = 0;i<ar[num].size();i++) {
				int tmp = ar[num].get(i);
				arr[tmp] --;
				// -1해주고 0이되면 큐에추가
				if(arr[tmp] == 0) {
					q.add(tmp);
				}
			} // i for
		}
		
	}
	
}
