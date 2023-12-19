package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q18223_민준이와_마산_그리고_건우 {
	static int V,E,P;
	static int[][]arr; //인접 행렬
	static int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());//정점 수 V(2~5000)
		E = Integer.parseInt(st.nextToken());//간선 수 E(1~10000)
		P = Integer.parseInt(st.nextToken());//건우가 있는 정점 P(1~V)
		
		arr = new int[V+1][V+1]; //인접 행렬 초기화
		
		for (int i = 1; i <= V; i++) {
            Arrays.fill(arr[i], INF); // 모든 정점 간 거리를 최대값으로 초기화
            arr[i][i] = 0; // 자기 자신으로의 거리는 0
        }
		
		for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[from][to] = weight;
            arr[to][from] = weight; // 양방향 그래프니까..
        }
		
		//다잌스트라... ㅈㅈ
		
		
		
	}//main
}//class
