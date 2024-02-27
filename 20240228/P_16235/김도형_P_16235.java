package algo_study;

import java.io.*;
import java.util.*;

public class BOJ_Q_16235_나무_재테크 {
	static int[]dx = {-1,-1,-1, 0,0, 1,1,1};
	static int[]dy = {-1, 0, 1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N개의 줄
		int M = Integer.parseInt(st.nextToken()); // 상도가 심은 나무 수
		int K = Integer.parseInt(st.nextToken()); // K년이 지난 후 살아있는 나무 구하기

		int[][]feed=new int[N][N];
		int[][] A = new int[N][N]; // 더해질 양분 양 입력 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				feed[i][j]=5; //초기 양분 5씩 있음
			}
		}
		PriorityQueue<Integer>[][] pq = new PriorityQueue[N][N]; //어린 나무부터 양분 먹기위해 우선순위 큐 활용
		Stack<Integer>[][] stack = new Stack[N][N]; //나무 임시 저장용 스택
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				pq[i][j]=new PriorityQueue<Integer>();
				stack[i][j]=new Stack<Integer>();
			}
		}//N*N개의 우선순위큐, 스택 초기화
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq[x-1][y-1].add(z); // 중복없이 나무 나이 넣어
		}

		for (int year = 0; year < K; year++) { //K년 반복
			int deadToFeed[][]=new int[N][N]; //죽어서 양분 되는 양 저장용 배열(매년 0으로 초기화)
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					while(!pq[i][j].isEmpty()) {
						int tree = pq[i][j].poll();
						if(tree<=feed[i][j]) { //양분 먹을 수 있으면
							feed[i][j]-=tree; //나이만큼 양분 빼고
							stack[i][j].add(tree+1); //나이 1 더해진 놈 스택에 일단 넣어
						}else { //양분 못먹으면 죽어서 양분이 된다
							deadToFeed[i][j]+=(tree/2);
						}  
					}
				}
			}//여기까지 봄 , 여름 끝
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					while(!stack[i][j].isEmpty()) { //가을되면 나무 번식
						int tree = stack[i][j].pop();
						if(tree%5==0) {
							for(int z=0;z<8;z++) {
								int nx = i+dx[z];
								int ny = j+dy[z];
								if(nx>=0&&ny>=0&&nx<N&&ny<N) {
									pq[nx][ny].add(1); //범위 안이면 나무 심어
								}
							}
						}
						pq[i][j].add(tree);//그러고 다시 pq 들어가
					}
					feed[i][j]+= (deadToFeed[i][j]+A[i][j]); //겨울되면 양분 추가
				}
			}
		}//k년 반복
		int cnt = 0; //나무 수 카운트할 변수
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				cnt+=pq[i][j].size(); //큐에 남아있는 나무 숫자 세기
			}
		}
		System.out.println(cnt);
	}// main
}// class
