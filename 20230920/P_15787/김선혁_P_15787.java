import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc;
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) {
		 sc = new Scanner(System.in);
		N = sc.nextInt(); // 기차수
		M = sc.nextInt(); // 명령수
		arr = new int[N+1][20+1]; // 기차 1~N까지만 사용 , 좌석도 1~20까지
		Set<String> s = new HashSet<>();
		
		solve();
		// 1부터 N번째 기차까지 
		// for문을 통해서 add해주고 
		// 중복은 알아서 제거되도록!
    	for(int i = 1; i < N + 1; i++) {
    		s.add(Arrays.toString(arr[i]));		
    	}

    	System.out.println(s.size());
		
	}
	public static void solve() {
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			// 1일때 b번째 기차 c좌석 1로
			if (a==1) {
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[b][c] = 1;
			}
			// 2일때 b번째 기차 c좌석 0으로 
			else if(a==2) {
				int b= sc.nextInt();
				int c = sc.nextInt();
				arr[b][c] = 0;				
			}
			// 3일때 좌석 뒤로 이동 -- 20에서 1로
			// 떨어지면 전꺼로 갱신 
			// 1번째는 0번째가 무조건 0이라 0
			else if(a==3) {
				int b =sc.nextInt();
				for(int in=20;in>=1;in--) {
					arr[b][in] = arr[b][in-1]; 
				}				
			}
			// 4일때 좌석 앞으로 이동
			// 뒤의 숫자를 앞으로 이동시킨다.
			else {
				int b= sc.nextInt();
				for(int in=1;in<20;in++) {
					arr[b][in]=arr[b][in+1];
				}
				// 20번째 좌석의 경우 그대로기 때문에
				// 앞으로 이동한것처럼 0으로 바꿔줌
				arr[b][20] = 0;
			}	
			
		}
		
		
	}

}
