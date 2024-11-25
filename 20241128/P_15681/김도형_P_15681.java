import java.io.*;
import java.util.*;

public class BOJ_Q15681_트리와쿼리 {

	static int [] childCnt; //해당 정점을 루트로 하는 서브트리의 정점 수 저장용 배열
	static List<Integer>[] adArr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //트리 정점의 수
		int R = Integer.parseInt(st.nextToken()); //루트번호
		int Q = Integer.parseInt(st.nextToken()); //쿼리의 수
		childCnt = new int[N+1];
		Arrays.fill(childCnt, 1); //본인도 서브트리 정점의 개수에 포함되니까 일단 1로 다 채워줌

		adArr = new ArrayList[N+1];
		for(int i=0;i<=N;i++)adArr[i]=new ArrayList<>();
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			adArr[U].add(V);
			adArr[V].add(U); //양방향으로 인접한 정점 저장
		}
		dfs(R,-1); //루트노드부터 dfs로 리프노드까지 방문하면서 자식 수 계산
		
		for(int i=0;i<Q;i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(childCnt[num]);
		}

	}
	
	static void dfs(int now,int parent) {
		for(int vertex:adArr[now]) {
			if(vertex!=parent) { //양방향으로 저장해놨기 때문에 부모노드로 다시 방문 안하도록
				dfs(vertex,now);
			}
		}
		
		if(parent!=-1) {
			childCnt[parent]+=childCnt[now]; //리프노드부터 루트노드까지 돌아가면서 자식수를 누적합해줌
		}

	}

}
