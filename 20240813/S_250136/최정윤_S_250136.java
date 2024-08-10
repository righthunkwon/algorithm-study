import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] land) {
        //bfs 한번에 돌면서 확인해보자
        ans=new int[land[0].length];
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,-1,1};
        this.land=land;
        visited=new boolean[land.length][land[0].length];
        q=new LinkedList();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1&&!visited[i][j]){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                    bfs();
                }
            }
        }
        // System.out.println(Arrays.toString(ans));
        int answer = 0;
        for(int i=0;i<ans.length;i++){
            answer=Math.max(answer,ans[i]);
        }
        
        return answer;
    }
    //석유있는 열 번호 기억한 후에 cnt로 마지막에 더해주기
    public static void bfs(){
        Set<Integer> v_set=new HashSet();
        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int[] curr=q.poll();
            v_set.add(curr[1]);
            for(int i=0;i<4;i++){
                int nr=curr[0]+dr[i];
                int nc=curr[1]+dc[i];
                if(nr<0||nc<0||nr>=land.length||nc>=land[0].length||visited[nr][nc]||land[nr][nc]==0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc]=true;
            }
        }
        for(Integer idx:v_set){
            ans[idx]+=cnt;
        }
    }
    static int[][] land;
    static Queue<int[]> q;
    static int[] ans,dr,dc;
    static boolean[][] visited;
}
