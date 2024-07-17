import java.util.*;

class Solution {
    static boolean[] flag;
    static HashSet<String> set;
    static String[] user;
    static String[] ban;
    public int solution(String[] user_id, String[] banned_id) {
        // 총 가짓수기 때문에 hashset써보자
        flag = new boolean[user_id.length];
        set = new HashSet<String>();
        user = user_id;
        ban = banned_id;
        
        // dfs를 돌면서
        // banid와 일치하게 되면 그순간 그문자열 추가해서
        // 추가했을때만 다음 banid넘어가고
        // 마지막에 끝까지 가면 set 추가해서 개수만 체크
        
         for(int i=0; i<ban.length; i++){
        	ban[i] = ban[i].replace('*', '.');
         } // mathches쓰기위해 .으로 교체
        solve(0,"");
        
        return set.size();
    }
    
    public static void solve(int depth, String line){
        if(depth == ban.length){
            // 끝까지  검사 끝나면 현재 line에 있는것들 
            // 배열형태로 만들어서 정렬(겹치는거 제외하기 위해)
            String[] tmps = line.split(" ");
            Arrays.sort(tmps);
            // tmp를 이제 하나의 문장으로 만들기
            String tmp = "";
            for(int i = 0 ;i<tmps.length;i++){
                tmp += tmps[i];
            }
            set.add(tmp);
            return;
        }
        
        for(int i = 0 ;i<user.length;i++){
            // 현재 유저 검사해서 맞으면 다음 depth로 넘어가고
            // 이 유저 안겹치게 방문처리
            
            // 방문했거나 현재 유저랑 안맞으면 continue
            if(flag[i] || !user[i].matches(ban[depth])){
                continue;
            }
            flag[i] = true;
            solve(depth+1, line+" "+user[i]);
            flag[i] = false;
        }
        
        
    }
    
}
