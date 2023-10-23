import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int H;
	static boolean[][] flag;
	static boolean ans;
	static int ansi;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 H = sc.nextInt();
		 // 3개모두 입력받고 
		 // flag는 1~H+1, 1~N+1만큼만 사용할거임
		flag = new boolean[H+1][N+1];
		for(int i = 0 ;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 입력받는 즉시 사다리의 위치는
			// 시작점을 기준으로 true처리해준다.
			flag[a][b] = true;
		}		
		// 먼저 판단해보고 필요한 사다리 개수를 
		// 1개씩 늘려나가면서 판단하며
		// ans가 중간에 true가 된다면
		// 더 늘릴필요(최소)가 없으므로 break처리해준다.
		ans = false;
		ansi = -1;
		// 3개까지 판단했을때 다 안되면 -1출력되도록 설정
		for(int i =3;i>=0;i--) {
			solve(i,1,1);			
			if(ans) {
				ansi = 3-i;
				break;
			}
		}
		System.out.println(ansi);
		
		
	}//main
	
	// 사다리 선정하는 메서드
	// x와 y좌표를 받고, 개수가 3개가 될때까지 선정
	public static void solve(int cnt, int x , int y) {
		if(cnt==3) {
			// 사다리 판단 가자
			// 판단해서 다 일치하면 
			// ans를 true처리해줌 
			if(solve2()) {
				ans = true;
			}
			return;
		}
		//여기서 부터는 사다리 선정 할거임
		for(int i= x;i<=H;i++) {
			for(int j = 1; j<N;j++) {
				if(i==x && j<y) {
					// 직전의 좌표보다 앞에좌표는
					// continue
					continue;
				}
				// 현재좌표를 중심으로 좌측 우측에 사다리가 있는지 확인하고
				// 있으면 패스 , 없으면 true하고 bfs 돌기
				if(!flag[i][j] && !flag[i][j-1] && !flag[i][j+1]) {
					flag[i][j] = true;
					solve(cnt+1, i,j);
					// 해당좌표 선정한게 끝났으면 false로 바꿔줌
					flag[i][j] = false;
				}
			}
		}		
	}
	// 사다리가 시작점과 끝점의 좌표가 같은지 판단하는 메서드
	public static boolean solve2() {		
		for(int i = 1;i<=N;i++) {
			int tmp = i;
			// 세로줄로 하나씩 판단 ㄱㄱ
			for(int j = 1;j<=H;j++) {
				// 만약 현재 위치가 true면
				// 오른쪽으로 사다리가 있으므로
				// tmp ++
				if(flag[j][tmp]) {
					tmp ++;
				}
				// 또는 왼쪽 위치가 true면
				// 사다리가 왼쪽에서 연결된것으로
				// tmp -- 처리
				else if(flag[j][tmp-1]) {
					tmp --;
				}
			}
			// 밑까지 내려갔을때 i랑 일치하는지 확인
			// 하나라도 다르면 바로 false처리
			if(tmp!=i) {
				return false;
			}
		}
		// 모든게 다 일치하면 true처리
		return true;
		
	}
	
}
