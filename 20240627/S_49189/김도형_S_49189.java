import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        //배열로 [n+1][n+1] 했더니 메모리 초과..
        // 연결 정보 리스트
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        
        int max = 0; // 가장 멀리 떨어진 노드까지의 거리
        boolean[] visit = new boolean[n + 1]; // 방문 확인용
        int[] minDist = new int[n + 1]; // 1로부터의 최단 거리 배열
        
        // BFS로 각 노드까지의 최단거리 구하면서 최대 거리 갱신
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list.get(now)) {
                if (!visit[next]) { // now와 연결되어 있으면서 방문한 적 없는 노드면
                    minDist[next] = minDist[now] + 1;
                    visit[next] = true; // 방문 처리
                    max = Math.max(max, minDist[next]);
                    q.add(next);
                }
            }
        }
        
        // 1로부터 가장 멀리 떨어진 노드 수 카운트
        for (int i = 2; i <= n; i++) {
            if (minDist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
