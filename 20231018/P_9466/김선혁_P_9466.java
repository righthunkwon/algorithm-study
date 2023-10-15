import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] flag;
	static Queue<Integer> q;
	static boolean[] tmp;
	static int count;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			// flag생성해놓고
			// 현재 들어오는 수에서 계속 원을 그려보자
			// 아직 flag가 false인 것이 나오면
			// 메서드를 실행하고 
			// 최종적으로 false 개수 count하면 끝
			arr = new int[N+1];
			flag = new boolean[N+1];
			for(int i =1;i<=N;i++) {
				arr[i] =sc.nextInt();
			}
			// 입력완료 
			
			count = 0;
			tmp = new boolean[N+1]; // 한번씩 지나가는 애들은 다시 볼 필요가 없기때문에
			// 지나가는 애들을 true 처리해줄 tmp 
			
			// 처음에 tmp를 solve 바로위에 선언하고
			// false로 바꾸는 부분 없이했는데 ==> 시간초과떠서 위로 올리고 false로 바꿔주는거 추가
			for(int i =1;i<N+1;i++) {
				if(!flag[i]) {
					solve(i,arr[i]);
				}
			}
			
			System.out.println(N-count);
			
		}


	}
	// 시작하는 좌표 first를 기억했지만
	// 어떻게 써야할지 고민하다가 포기
	public static void solve(int first,int num) {
		if(flag[num]) {
			return; // 이전에 이미 검사했다는 뜻이므로 더 이상 들어갈 필요가 없다.
		}
		if(tmp[num]) { // 현재 tmp가 true라는 것은 
			// 방금 dfs에서 방문했었던 것으로 사이클을 의미
			// 다시 사이클 한바퀴 도는것으로
			// 다 true 체크해주고 count++
			flag[num] = true; 
			count++; 
		}
		else {
			tmp[num] = true; // 지나갔다는 의미
		}
 		solve(first,arr[num]);
		flag[num] = true; // 일단 모두 체크했던것들
		// 사이클이든 아니든 모두 true처리(어차피 사이클이 안되서 못나올 애들임)
		tmp[num] = false;
	}
}
