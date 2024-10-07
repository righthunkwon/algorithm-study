import java.util.*;

class Solution {    
    static boolean[] flag;
    static ArrayList<String> ar;
    public String[] solution(String[][] tickets) {
        // 모든 공항은 알파벳 대문자 3글자로 이루어짐
        // 앞에나오는 곳이 출발, 뒤에 나오는곳이 도착 항공권 -> 모두 사용해야함
        // 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return
        
        // dfs로 알파벳순서대로 진행 -> 모든 dfs 진행한 후에 정렬하면 도착지가 빠른순으로 올듯        
        // 정답같은 경우에는 지나가는 지점마다 String에 더해주고 맨 마지막에 split으로 배열에 담으면 됨
        flag = new boolean[tickets.length];
        ar = new ArrayList<String>();
        solve(0, "ICN", tickets);
        // 모두 진행후 정렬하면 됨
        Collections.sort(ar);
        String[] answer = ar.get(0).split(" ");
        
        return answer;
    }
    public static void solve(int index, String word, String[][] tickets){
        if(index == tickets.length){
            // 끝까지 다했으면 해당 string 리스트에 추가
            ar.add(word);
            return;
        }
        
        // 순서대로 방문처리하면서 진행
        for(int i = 0 ;i<tickets.length;i++){
            // 현재 도착지가 마지막 출발지랑 같아야 하며, 방문한적 없어야함
            if(!tickets[i][0].equals(word.substring(word.length()-3, word.length())) || flag[i]){
                continue;
            }
            flag[i] = true;
            solve(index+1, word + " "+ tickets[i][1], tickets);
            flag[i] = false;
        }
    }
    
    
}
