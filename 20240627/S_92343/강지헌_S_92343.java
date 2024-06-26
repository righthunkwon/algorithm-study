class Solution {
    static int answer=0;
    boolean[] chk;
    public int solution(int[] info, int[][] edges) {
        chk = new boolean[(int)Math.pow(2,info.length)];
        dfs(0,new boolean[info.length],0,0,info,edges,1);
        return answer;
    }
    public void dfs(int t,boolean[] v, int s,int w,int[] info, int[][] edges, int st) {
        v[t]=true; chk[st]=true;
        if(info[t]==0) {
            s++;
            answer=Math.max(s,answer);
        }
        else w++;
        if(s<=w) return;
        for(int[] i:edges) {
            if(v[i[0]] && !v[i[1]] && !chk[st | (1<<i[1])]) {
                dfs(i[1],v.clone(),s,w,info,edges,st | (1<<i[1]));
            }
        }
    }
}
