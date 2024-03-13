package AlgoStudy;

import java.io.*;
import java.util.*;
public class BOJ_Q1800_인터넷_설치 {

	static int N,P,K,ans;
	static ArrayList<int[]>[]adj; //인접노드 정보 담을 리스트
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //학생 수
        P = Integer.parseInt(st.nextToken()); //케이블선 개수
        K = Integer.parseInt(st.nextToken()); //공짜 케이블선 개수

        adj = new ArrayList[N+1]; //인접리스트 배열
        
        for(int i=1;i<=N;i++) {
        	adj[i]=new ArrayList<>(); //각 노드별 인접노드(학생번호,비용) 리스트 생성
        }
        
        for(int i=0;i<P;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	adj[a].add(new int[] {b,cost});
        	adj[b].add(new int[] {a,cost});
        }
        ans = -1; //정답 -1로 초기화(N도착 못하면 -1출력)
    
        binarySearch(0,1000000); //이분탐색   
        System.out.println(ans);

	}//main
	
	//이분탐색 메서드
	static void binarySearch(int st,int ed) {
		while(st<=ed) {
			int mid = (st+ed)/2;
			if(dfs(mid)) {
				ans = mid;
				ed=mid-1;
			}else
				st=mid+1;
		}//while
	}
	
	
	//x원으로 N까지 인터넷 연결 가능한지 여부 확인하는 메서드
	public static boolean dfs(int x) {
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][]visit = new boolean[N+1][K+1];
		
		queue.add(new int[] {1,K}); //1부터 시작 현재 남은 공짜 지불 횟수 K번
		
		while(!queue.isEmpty()) {
			int[]now = queue.poll();
			
			//기저조건
			if(now[0]==N) return true; //N까지 도착했으면 true
			
			if(visit[now[0]][now[1]])continue; //방문했던곳 pass
			visit[now[0]][now[1]]=true; //방문처리
			
			for(int[]a : adj[now[0]]) { //현재 노드의 인접리스트에서
				if(a[1]<=x)queue.add(new int[] {a[0],now[1]}); //비용 초과 안하면 횟수 그대로 이동
				else if(now[1]>0)queue.add(new int[] {a[0],now[1]-1}); //비용 초과하는데, 아직 공짜 지불 횟수 남았으면
			}
		}
		
		return false;
	}
	
	
}//class
