import java.io.*;
import java.util.*;

class Solution {
    static boolean []visit;
    static List<String>list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        visit = new boolean[tickets.length];//방문체크용
        
        dfs(0,"ICN","ICN",tickets);
        
        Collections.sort(list); //경로들 정렬 (알파벳순)
        
        String ans = list.get(0); 
        
        //3글자씩 쪼개서 정답 배열에 넣기
        for(int i=0;i<ans.length();i+=3){
            answer[i/3]=ans.charAt(i)+""+ans.charAt(i+1)+""+ans.charAt(i+2);
        }
        
        return answer;
    }
    
    //깊이, 현재위치, 누적된 경로 sum
    public void dfs(int depth,String now,String sum,String[][]tickets){
        
        if(depth==tickets.length){
            list.add(sum);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(visit[i])continue;
            
            if(now.equals(tickets[i][0])){
                visit[i]=true;
                dfs(depth+1,tickets[i][1],sum+""+tickets[i][1],tickets);
                visit[i]=false;
            } 
        }
        
    }
}
