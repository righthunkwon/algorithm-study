class Solution {
    static boolean [] visit;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visit = new boolean[words.length];
        dfs(0,begin,words,target);
        return answer==Integer.MAX_VALUE?0:answer;
    }
    
    static void dfs(int depth,String nowWord,String[]words,String target){
        if(depth>answer)return;
        if(nowWord.equals(target)){
            answer=Math.min(answer,depth);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(visit[i])continue;
            if(check(nowWord,words[i])){ //알파벳 1개차이고 방문한적 없으면 dfs 진행
                visit[i]=true;
                dfs(depth+1,words[i],words,target);
                visit[i]=false;
            }
        }
    }
    
    //단어 알파벳 1개만 다른지 체크 메서드
    static boolean check(String now,String to){
        int cnt = 0;
        for(int i=0;i<now.length();i++){
            if(cnt>1)return false;
            if(now.charAt(i)!=to.charAt(i))cnt++;
        }
        if(cnt==1)return true;
        else return false;
    } 
    
}
