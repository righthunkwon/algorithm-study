class Solution {
    static String target;
    static int min;
    static String[] words;
    static boolean[] flag;
    public int solution(String begin, String target, String[] words) {
        // 직접 하나만 차이나는걸 찾아서 dfs 돌아야하나..?
        min = 987654321;
        this.target = target;
        this.words = words;
        flag = new boolean[words.length];
        // 만약 words에 target과 같은게 없다면
        // 0으로 그냥 리턴
        boolean tmp = false;
        for(int i = 0;i<words.length;i++){
            if(words[i].equals(target)){
                tmp = true;
                break;
            }
        }
        if(!tmp){
            return 0;
        }
        
        solve(0, begin);
        return min;
    }
    
    static void solve(int cnt, String now){
        if(now.equals(target)){
            min = Math.min(min, cnt);
            return;
        }
        // 백트래킹
        if(cnt > min){
            return ;
        }
        
        // 만약 하나만 그 단어로 교체하고 방문처리
        for(int i = 0;i<words.length;i++){
            if(flag[i]){
                continue;
            }
            // i번째 단어와 현재 now가 1개만 다르면 그 단어로 dfs 돌기
            int tmp = 0;
            for(int j=0;j<words[i].length();j++){
                if(!words[i].substring(j,j+1).equals(now.substring(j,j+1))){
                    tmp++;
                }
            }
            // 1글자만 다를때 방문처리하고
            // 현재 i번째 단어로 교체해서 dfs 돌기
            if(tmp ==1){
                flag[i] = true;
                solve(cnt+1, words[i]);
                flag[i] = false;
            }
            
        }
        return;
        
    }
    
}
