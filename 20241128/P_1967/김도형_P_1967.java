import java.io.*;
import java.util.*;

public class BOJ_Q1967_트리의_지름 {

	static ArrayList<int[]>[]list;
	static boolean [] visit;
	static int ans, farthestNode;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		ans = 0;
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //노드1
			int b = Integer.parseInt(st.nextToken()); //노드2
			int w = Integer.parseInt(st.nextToken()); //가중치
			list[a].add(new int[] {b,w});
			list[b].add(new int[] {a,w});
		}
		farthestNode = 0; //루트노드에서 가장 먼 노드
		visit[1]=true;
		dfs(1,0); //루트노드에서 한번 dfs해서 가장 먼 노드를 구하고
		visit = new boolean[N+1];
		visit[farthestNode]=true;
		dfs(farthestNode,0); //가장먼 노드에서 dfs를 해서 트리의 지름을 구한다
		System.out.println(ans);
	}
	
	//현재노드 , 가중치 합 으로 dfs를 통해 sum의 최대값 갱신
	static void dfs(int now, int sum) {
		
		if(sum>ans) {
			farthestNode=now; //가장먼 노드 갱신
			ans = sum; //최대값 갱신
		}
		
		for(int[]linkNode : list[now]) {
			int node = linkNode[0];
			int weight = linkNode[1];
			if(!visit[node]) {
				visit[node]=true;
				dfs(node,sum+weight);				
			}
		}
		
	}//dfs

}
