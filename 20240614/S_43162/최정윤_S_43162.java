import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        //dfs 로 돌고 방문안한것만 돌면 된다.
        visited=new boolean[n];
        computers2=computers;
        n2=n;
        int answer = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                visited[i]=true;
                dfs(i);
                answer++;
            }            
        }
        return answer;
    }
    static boolean[] visited;
    static int[][] computers2;
    static int n2;
    public static void dfs(int idx){
        for(int i=0;i<n2;i++){
            if(computers2[idx][i]==1&&!visited[i]){
                visited[i]=true;
                dfs(i);
            }
        }
        
    }
}
