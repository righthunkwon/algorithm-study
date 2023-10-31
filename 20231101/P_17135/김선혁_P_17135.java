import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M ;
	static int D;
	static int ans;
	static int[][] arr;
	static int[][] arr2;
	static boolean[] flag;
	static int[] pos;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M =sc.nextInt();
		D = sc.nextInt();
		arr = new int[N][M]; // 기존 적의 위치를 담을 배열
		arr2 = new int[N][M]; // 적위치 복사 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] =sc.nextInt();
			}
		}
		flag = new boolean[M];
		// 일단 배열에서 궁수 3명을 먼저 선별함
		// 선별된 궁수를 기준으로 계속 턴마다
		// 공격진행 -> 
		// 하나씩 좌표 내리고 다시 진행
		// 죽이는 수 중 최대점 골라냄
		ans = 0;
		pos = new int[3]; // 3명의 궁수를 선정할 배열
		choose(0,0);

		System.out.println(ans);
	}
	// 3명의 궁수를 선정하는 메서드
	// 3명이 완성되면 solve() 메서드
	private static void choose(int cnt, int idx) {
		if(idx== N) {
			if (cnt == 3) {
				// 3명이 선정되었으면 게임 진행
				// ans에는 최대죽이는 수 저장
				int tmp = solve();
				ans = Math.max(tmp, ans);
			}
			return;
		}
		// idx번째를 선정하고 안하고 두번 ㄱㄱ
		flag[idx] = true;
		choose(cnt+1,idx+1);
		flag[idx] = false;
		choose(cnt,idx+1);
	}

	private static int solve() {
		int index = 0;
		// 먼저 arr2배열을 arr배열에서 복사를 하고
		// 만약 i번째 궁수가 선정되었으면
		// pos배열에 i번째가 들어갔다는 것을 넣어줌
		for(int i = 0 ; i < N ; i++) {
			arr2[i] = Arrays.copyOf(arr[i], M);
			if(flag[i]) {
				pos[index++] = i;
			}
		}
		// pos 배열에다가는 0~2까지 각각 궁수의 위치 index가 적혀있음
		
		//반대로 생각해보면 궁수가 N-1에서 0쪽으로 전진한다고 생각해도 편함
		// front는 0부터 쭉 증가시켜서 궁수가 전진할 때마다 죽이는 적의 수 count
			int tmp = 0; // tmp는 현재 턴에서 죽이는 적의 수 
			int front = 0;  // front는 궁수의 전진위치
			Queue<Integer> qx  = new LinkedList<>();
			Queue<Integer> qy  = new LinkedList<>();
			// 큐를 배열형태로 선언하고 
			while (true) {
				// pos 배열의 궁수위치 0~2까지
				for (int k = 0; k < 3; k++) {
					int x = N - front; 
					int y = pos[k];
					// x,y는 궁수의 위치
					int min = 987654321;
					int tmpx = -1;
					int tmpy = -1;
					
					// 행은 N-1에서 전진위치 front만큼에서 시작하고
					// 만약 적을 발견하면 현재 궁수의 위치와 적의 위치를 구해서 
					// 최대 사정거리보다 멀다면 continue해버리고
					// 가장 가까운 적 알아내서 큐에다가 모두 추가(한명당 하나씩) -중복포함
					for (int i=N-front-1;i>=0;i--) {
						for (int j=0;j<M;j++) {
							if (arr2[i][j] == 1) {
								int dis = Math.abs(i - x) + Math.abs(j - y);
								if(dis > D) {
									// D보다 멀면 continue
									continue;
								}
								// 만약 가장가까운 값이라면
								// tmpx와 tmpy를 갱신해주고 
								// 거리도 min으로 갱신
								if (dis < min) {
									min = dis;
									tmpx = i;
									tmpy = j;
								}
								// 같다면 열을비교해서
								// 현재 발견한적이 더 왼쪽에 있다면
								// 좌표 갱신
								else if (dis == min) {
									if (j < tmpy) {
										tmpx = i;
										tmpy = j;
									}
								}
							} // if
						} // j for
					} // i for
					// 만약 둘중 하나라도 -1이면 못찾은거로 continue
					// 다음 궁수 차례로
					if(tmpx == -1 || tmpy == -1) {
						continue;
					}
					// 조건다 만족하면 큐에다가 추가
					qx.add(tmpx);
					qy.add(tmpy);
				}
				// 이제 죽여야할 적은 큐에 모두 추가하였기 때문에
				// 추가한 적들을 제거하여 주자
				while(true) {
					// 아무것도 없는체로 들어올 수도 있어서 위에다 배치
					if(qx.size()==0) {
						break;
					}
					int x = qx.poll();
					int y = qy.poll(); 
					// 한명이 두번포함될수도 있으므로 
					// 1인것을 확인해줌
					if(arr2[x][y]==1){
						arr2[x][y] = 0;
						tmp ++;
					}
				}
				// 모든 과정 끝났으니 전진 1칸
				front += 1;
				// 만약 0까지 간거면 break
				if(front>=N) {
					break;
				}
			}
			// 죽인 적 수 return
			return tmp;
		
			
			
		}
	}
