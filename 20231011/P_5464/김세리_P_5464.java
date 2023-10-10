import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5464_주차장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 주차공간 수
		int M = Integer.parseInt(st.nextToken()); // 차량 수
		
		// p : 주차장 배열
		// 1행: 주차공간 요금표, 2행: 주차되어 있는지 여부(0-빈공간, 1-주차중)
		int[][] p =new int [2][N];
		for(int i=0;i<N;i++) {
			p[0][i] = Integer.parseInt(br.readLine());
		}
		
		// w : 차량 무게(배열 크기는 M+1로)
		int [] w = new int [M+1];
		for(int i=1;i<M+1;i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		
		// 요금은 ans에 합산
		int ans = 0;
		
		// pnum = 각 차량이 주차된 주차번호 저장(베열 크기는 M+1로)
		int[] pnum = new int [M+1];
		Arrays.fill(pnum, -1);	// 주차 넘버가 0일수도 있어서 기본값을 -1로 채운다
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<2*M;i++) {
			// 들어오고 나가는 차량의 번호
			int a = Integer.parseInt(br.readLine());
			// 들어오는 경우
			if(a>0) {
				b : for(int j=0;j<N;j++) { // 주차는 앞자리부터
					if(p[1][j]==0) {
						p[1][j]=1;	// 비어있는걸 주차중으로 바꿔줌
						pnum[a] = j; // 주차 넘버 저장
						ans += p[0][j] * w[a]; // 주차요금 추가
						break b;
					}
					
				}
			// 주차장 다 차서 못들어감, 대기열 합류
			if(pnum[a]==-1) {
				q.add(a);
			}
				
			}
			if(a<0) {
				// 주차장에서 차가 빠져나간다, 자리빈거 표시
				p[1][pnum[-a]]=0;
				// 근데 대기하는 차가 있음
				if(!q.isEmpty()) {
					// 대기열에서 뽑아서 주차시켜준다
					int b = q.poll();
					p[1][pnum[-a]]=1; // 그 자리 다시 주차중으로 바꿔줌
					pnum[b] = pnum[-a]; // 주차 넘버 저장
					ans += p[0][pnum[-a]] * w[b]; // 주차요금 추가
				}
			}
		}//2*M
		
		System.out.println(ans);
		
		
	}//main

}
