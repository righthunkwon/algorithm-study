package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_Q14621_나만_안되는_연애 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int []sex = new int[N+1];
		boolean[]visit = new boolean[N+1];
		ArrayList<int[]>[] edges = new ArrayList[N+1]; // 배열로{연결된 학교 번호 ,거리} 리스트 생성 
		for(int i=1;i<=N;i++) {
			edges[i]=new ArrayList<>(); 
			if(st.nextToken().charAt(0)=='M') {
				sex[i]=1; //남자면 1
			}else sex[i]=-1; //여자면 -1
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(sex[a]+sex[b]==0) { //남녀학교인거만 연결
          edges[a].add(new int[] {b, d}); // ArrayList에 추가
          edges[b].add(new int[] {a, d}); // ArrayList에 추가
      }
		}
		//여기부터 최소 스패닝트리 구하기
		int cnt = N; //학교 다 이어졌는지 확인하기 위해 카운트용..
		int ans = 0;
		//거리 짧은거부터 poll되게끔 우선순위 큐 생성
		PriorityQueue<int[]>pq = new PriorityQueue<int[]>(Comparator.comparing(o->o[1]));
		pq.add(new int[] {1,0}); //시작점 넣기{학교 번호, 거리}
		
		while(!pq.isEmpty() && cnt>0) {
			int[]now = pq.poll();
			if(visit[now[0]])continue;
			visit[now[0]]=true;
			cnt--;
			ans += now[1];

			for(int[]e:edges[now[0]]) { //현재 학교와 연결된 학교들 중
				if(!visit[e[0]]) { //방문 안한곳이면
					pq.add(new int[] {e[0],e[1]}); //pq에 추가
				}
			}
		}//while
		
		if(cnt>0) { //모든 학교 못이어졌으면 cnt가 0보다 큼
			System.out.println(-1);
		}else System.out.println(ans);
		
	}//main
}//class
