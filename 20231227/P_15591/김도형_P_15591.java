package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Q15591_MooTube {
	static class Video {
        int to; //이어진 곳
        int usa; //유사도

        public Video(int to, int usa) {
            this.to = to;
            this.usa = usa;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //소의 수 N
		int Q = Integer.parseInt(st.nextToken()); //질문 수 Q
		List<Video>[]adj = new ArrayList[N+1]; //인접리스트 정보 저장용 배열
		
		for(int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>(); //리스트들 초기화
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken()); 
			int r = Integer.parseInt(st.nextToken()); //동영상 p,q의 유사도 1~10억
			adj[p].add(new Video(q,r));
			adj[q].add(new Video(p,r)); //양방향 그래프니까..
		}
		
		//N-1개의 연결로 모든 정점을 연결하려면 절대 사이클이 존재할 수 없음!!
		
		for(int i=0;i<Q;i++) {
			st=new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken());
			int cnt = 0; //동영상 v와 유사도 k 이상인 모든 동영상 수 cnt
			
			//유사도 구하기 
			boolean[]visited = new boolean[N+1];
			visited[v]=true;
			Queue<Video>q = new LinkedList<>(); //bfs용 큐 생성
			q.add(new Video(v,0));
			while(!q.isEmpty()) {
				Video now = q.poll(); //현재 위치
				for(Video x : adj[now.to]) { //now와 연결된 모든 비디오들에 돌면서
					if(visited[x.to] || x.usa<k)continue; //이미 방문했거나 유사도가 k보다 작은건 재껴
					q.add(x);
					visited[x.to]=true;
					cnt++; //카운트 +1
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
