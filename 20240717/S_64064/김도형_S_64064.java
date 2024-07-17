import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer>[] list;
    static Set<Integer> set;
    static Set<String> ans;
    static int answer,ulen,blen;
    
    public int solution(String[] user_id, String[] banned_id) {
        ulen = user_id.length; // 유저 아이디 수
        blen = banned_id.length; // 불량 아이디 수
        list = new ArrayList[banned_id.length]; // 각 불량 아이디에 매칭되는 유저 아이디 리스트
        
        //각 불량 아이디에 대해
        for (int i = 0; i < blen; ++i) {
            list[i] = new ArrayList<>(); //리스트 초기화
            for (int j = 0; j < ulen; ++j) {
                if (banned_id[i].length() != user_id[j].length()) continue; // 길이가 다르면 pass
                boolean valid = true;
                // 불량 아이디와 유저 아이디를 비교하여
                for (int k = 0; k < user_id[j].length(); ++k) {
                    if (banned_id[i].charAt(k) == '*') continue; // '*'는 모든 문자와 매칭 가능
                    if (banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                        valid = false; //다른 문자면 불량아이디x
                        break;
                    }
                }
                if (valid) list[i].add(j); // 불량 아이디와 매칭되는 유저 아이디의 인덱스를 리스트에 추가
            }
        }
        
        set = new HashSet<>(); // 현재 선택된 유저 아이디 저장용
        ans = new HashSet<>(); // 생성된 조합 저장용
        dfs(0);
        
        return answer; 
    }
    
    // dfs로 불량 아이디에 매칭되는 유저 아이디 조합을 찾음
    public void dfs(int depth) {
        if (depth == blen) { // 모든 불량 아이디 돌고
            StringBuilder sb = new StringBuilder();
            for (int n : set) {
                sb.append(n); // 선택된 유저 아이디의 인덱스를 문자열로 만듦
            }
            if (!ans.contains(sb.toString())) { //중복된 조합이 아니면
                ans.add(sb.toString());
                answer++; // 경우의 수 +1
            }
            return;
        }
        
        // 현재 깊이에 대해 가능한 유저 아이디 인덱스 선택
        for (int idx : list[depth]) {
            if (!set.contains(idx)) { //이미 선택된 유저 아이디가 아니면
                set.add(idx); 
                dfs(depth + 1); 
                set.remove(idx); 
            }
        }
    }
}
