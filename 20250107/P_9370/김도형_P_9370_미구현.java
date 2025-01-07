package AlgoStudy;

import java.io.*;
import java.util.*;

public class BOJ_G2_9370_미확인_도착지 {
	static int n,s,g,h;
	static List<int[]>[]adj; //연결정보 리스트
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 수
		for(int tc = 1; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //교차로 수
			int m = Integer.parseInt(st.nextToken()); //도로 수
			int t = Integer.parseInt(st.nextToken()); //목적지 후보 수
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); //출발지
			g = Integer.parseInt(st.nextToken()); //예술가 지나간 교차로1
			h = Integer.parseInt(st.nextToken()); //예술가 지나간 교차로2
			
			List<Integer>ans = new ArrayList<>(); //가능한 목적지 저장용
			adj = new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				adj[i]= new ArrayList<>();
			}
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				int d = Integer.parseInt(st.nextToken()); //도로 길이
				adj[a].add(new int[]{b,d});
				adj[b].add(new int[]{a,d});
			}
			
			for(int i=0;i<t;i++) {
				int x = Integer.parseInt(br.readLine()); //목적지 후보
				if(dikstra(x))ans.add(x); //가능한 경우인지 확인
			}
			
			Collections.sort(ans); //오름차순 정렬
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<ans.size();i++) {
				sb.append(ans.get(i)+" ");
			}
			System.out.println(sb.toString());

		}//tc

	}//main
	
	//출발지(start)에서 도착지(end)로 가는 최단 경로에 g,h를 연결한 도로를 지나가는지 여부 확인
	public static boolean dikstra(int end) {
        int[] dist = new int[n + 1]; //출발지에서의 최단거리 저장용
        Arrays.fill(dist, 100000000); //큰값으로 채우기
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //가장 거리 짧은 교차로부터 꺼내는 우선순위큐
        pq.offer(new int[] { s, 0 });

        boolean[] visitedGH = new boolean[n + 1]; //출발지부터 각 교차로까지 가는 최단거리가 gh를 거쳐왔는지 여부 저장
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNum = now[0];
            int nowDist = now[1];

            if (nowDist > dist[nowNum]) continue;

            for (int[] neighbor : adj[nowNum]) {
                int nextNum = neighbor[0];
                int nextDist = neighbor[1];

                int newDist = dist[nowNum] + nextDist;

                if (newDist <= dist[nextNum]) {
                    if (newDist < dist[nextNum]) { // 새로운 최단 거리라면 갱신
                        dist[nextNum] = newDist;
                        pq.add(new int[] { nextNum, newDist });
                    }

                    // g-h 도로를 지나는지 여부 갱신
                    visitedGH[nextNum] = visitedGH[nextNum] || visitedGH[nowNum] ||
                                         ((nowNum == g && nextNum == h) || (nowNum == h && nextNum == g));
                }
            }
        }

        return dist[end] != Integer.MAX_VALUE && visitedGH[end]; //목적지에 도착했고 g,h경로 지나왔으면 true 반환
    }
	

}
