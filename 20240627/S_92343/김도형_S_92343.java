import java.io.*;
import java.util.*;

class Solution {
    
    static int len;
    static List<Integer>[] list;
    static boolean[]visit;
    static int[]infos; //전역으로 쓰기 위해
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        
        len = info.length; //노드 수 
        list= new List[len];
        visit = new boolean[len];
        infos = info;
        //인접 정보 리스트
        for (int i = 0; i < info.length; i++)
			list[i] = new ArrayList<>();
        
        //연결정보 리스트에 입력
		for (int[] edge : edges)
			list[edge[0]].add(edge[1]);
        
        //0번 노드(양)와 연결된 곳 방문가능
        for(int next : list[0])
			visit[next] = true; 
        
        dfs(1,0); 
        return answer;
    }
    
    public static void dfs(int sheep, int wolf){
        answer = Math.max(answer, sheep); //최대 양 개수 갱신
        
        for (int i = 1; i < len; i++) {
			// 방문할 수 있는 곳이면
			if (visit[i]) {
				visit[i] = false; //재방문X
                //양인 경우
				if (infos[i] == 0) { 
					for (int next : list[i])
						visit[next] = true;
					dfs(sheep + 1, wolf);
					for (int next : list[i])
						visit[next] = false;

				} else { //늑대인 경우
                	//양이 더 많아야만 방문 가능
					if (sheep > wolf + 1) {
						for (int next : list[i])
							visit[next] = true;
						dfs(sheep, wolf + 1);
						for (int next : list[i])
							visit[next] = false;
					}
				}
				visit[i] = true;
			}
		}
        
    }
    
    
    
}
