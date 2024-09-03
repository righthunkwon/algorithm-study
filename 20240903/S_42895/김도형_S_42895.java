class Solution {
    static int answer;
    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        
        dfs(N,number,0,0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public static void dfs(int N, int number,int depth,int nowNum){
        if(depth>8)return;
        if(nowNum==number){
            answer = Math.min(answer,depth);
            return;
        }
        int tmpNum = N;
        for(int i=0;i<8-depth;i++){
            dfs(N,number,depth+i+1,nowNum+tmpNum);
            dfs(N,number,depth+i+1,nowNum-tmpNum);
            dfs(N,number,depth+i+1,nowNum*tmpNum);
            dfs(N,number,depth+i+1,nowNum/tmpNum);
            tmpNum=tmpNum*10+N;
        }
        
    }
}
