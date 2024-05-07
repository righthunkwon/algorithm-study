import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
                
        int answer = 200;
        //인접리스트 생성
         arr=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList();
        }
        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]].add(wires[i][1]);
            arr[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0;i<wires.length;i++){
            visited=new boolean[n+1];
            visited[wires[i][0]]=true;
            visited[wires[i][1]]=true;
            q=new LinkedList();
            q.add(wires[i][0]);
            int cnt1=bfs();
        
            q.add(wires[i][1]);
            int cnt2=bfs();
            answer=Math.min(Math.abs(cnt1-cnt2),answer);
        }

        return answer;
    }
    
    static boolean[] visited;
    static Queue<Integer> q;
    static List<Integer>[] arr;
    public static int bfs(){
        int cnt=0;
        while(!q.isEmpty()){
            int n=q.poll();
            cnt++;
            for(Integer node:arr[n]){
                if(!visited[node]){
                    q.add(node);
                    visited[node]=true;
                }
            }
        }
        return cnt;
    }
}
