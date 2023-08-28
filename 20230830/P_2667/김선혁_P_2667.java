import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}

		int cnt =0;
		ArrayList<Integer> aList = new ArrayList<>();
		aList.add(0);
		aList.add(0);
		int change =2;

		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};

		boolean flag= false;
		while(true) {
			flag = false;
			a:	for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]== 1) {
						arr[i][j] = change;
						flag = true;
						break a;
					}
				}
			}			
			while(true) {
				int tmp =0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j] == change) {
							for(int index =0;index<4;index++) {
								if(i+dx[index]>=0 && i+dx[index]<N && j+dy[index]>=0 && j+dy[index]<N) {
									if(arr[i+dx[index]][j+dy[index]] ==1) {
										arr[i+dx[index]][j+dy[index]]=change;
										tmp++;
									}
								}
							}
						} // if 문
					}
				}
				if(tmp ==0) {
					break;
				}
			}
			change++;
			if(!flag) {
				break;
			}

		} // while 문
		//		for(int i=0;i<N;i++) {
		//			for(int j=0;j<N;j++) {
		//				System.out.print(arr[i][j]);
		//			}
		//		System.out.println();
		//		}

		//		int[] count = new int[change+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(aList.size()<=arr[i][j]) {
					aList.add(0);
				}
				aList.set(arr[i][j], aList.get(arr[i][j])+1);
			}
		}
		aList.remove(0);
		aList.remove(0);
		int[] ans = new int[aList.size()];
		for(int i=0;i<aList.size();i++) {
			ans[i] = aList.get(i);
		}
		Arrays.sort(ans);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}


	}	
}
/////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// BFS 
	// 그래프 탐색이란 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것
	// 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
	// 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
	// BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다
	// 여기까지 너비우선탐색에 대한 간략한 설명

	// 위문제는 1을 발견하면 그 좌표를 큐에다가 넣고 값을 0으로 바꿈
	// 큐에 들어가있는 좌표를 기준으로 4방향 검사 후
	// 만약 1을 발견하면 그 좌표를 큐에 추가하고 0으로 바꾸고 기준이었던 좌표 삭제
	// 이 과정을 반복하여 뭉쳐있는 1들을 0으로 바꾼후 count++ 하여
	// 총 뭉쳐있는 단지개수를 구한다.
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static int[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		// 입력 완료
		int count = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt =0;
		qx = new LinkedList<>();
		qy = new LinkedList<>();
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) { // 1을 먼저찾기
					qx.add(i);
					qy.add(j);
					arr[i][j] = 0;
					while(true) {
						search(qx.poll(),qy.poll());
						cnt++;
						if(qx.size()==0) {
							ans.add(cnt);
							cnt=0;
							break;
						}
					}
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(ans);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
		
	}
	// 4방향 탐색
	public static void search(int i,int j) {
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};	
		for(int in=0;in<4;in++) {
			if(i+dx[in]>=0 && i+dx[in]<N && j+dy[in]>=0 && j+dy[in]<N && arr[i+dx[in]][j+dy[in]]==1) {
				qx.add(i+dx[in]);
				qy.add(j+dy[in]);
				arr[i+dx[in]][j+dy[in]] = 0;
			}
		}
		//		i = qx.poll();
		//		j = qy.poll();
		//		search(i,j);


	}
}
