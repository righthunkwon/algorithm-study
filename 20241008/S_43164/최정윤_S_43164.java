import java.util.*;
class Solution {    
    public String[] solution(String[][] tickets) {
        len=tickets.length;
        map=new HashMap();
        //출발, 도착지 list 
        for(int i=0;i<tickets.length;i++){
            List<String> list = map.getOrDefault(tickets[i][0], new ArrayList());
            list.add(tickets[i][1]);
            map.put(tickets[i][0],list);
        }
        answer = new String[len+1];
        //알파벳 순서 정렬
        for(String key:map.keySet()){
            List<String> list=map.get(key);
            Collections.sort(list);
            map.put(key,list);
        }
        finish=false;
        dfs("ICN",0);
        
        return answer;
    }
    public static void dfs(String from, int cnt){
        if(finish) return;
        answer[cnt]=from; //정답 저장
        if(cnt==len) { //정답 완성
            finish=true;
            return;
        }
        if(map.get(from)==null) return; //가능한 경로 X 돌아가
        List<String> list=map.get(from);

        for(int i=0;i<list.size();i++){
            String to=list.get(0);
            list.remove(to);
            map.put(from,list);
            dfs(to,cnt+1);
            list.add(to);
            map.put(from,list);
        }
    }
    static List<String> list;
    static int len;
    static Map<String,List<String>> map;
    static String[] answer;
    static boolean finish;

}
