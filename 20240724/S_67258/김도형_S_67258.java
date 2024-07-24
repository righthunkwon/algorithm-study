import java.util.*;
import java.io.*;
 
class Solution {
    public int[] solution(String[] gems) {

        //1. 일단 보석 종류 파악 -> hashset으로
        //2. 보석별 갯수를 hashmap으로 관리하면서
        //3. 투포인터로 모든 보석을 포함하는 큐를 만들고
        
        Set<String> set = new HashSet<>(); //보석의 종류
        Map<String, Integer> map = new HashMap<>(); //보석의 종류별 개수
        
        //hashset에 보석 모두 추가 (보석 종류 갯수 파악)
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        int start = 1;
        int tmpStart = 1;
        int len = gems.length; //구간 크기 일단 전체로 초기화
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]); //구간 맨뒤에 보석 추가
            
            //구간 맨 앞 보석이 2개이상이면 빼줌
            while(true) {
                String gem = q.peek();
                if(map.get(gem) > 1) {
                    map.put(gem, map.get(gem) - 1);
                    q.poll();
                    tmpStart++;
                } else break;
            }
            
            //모든 보석을 포함하면서, 구간의 길이가 더 짧으면 갱신
            if(map.size() == set.size() && len > q.size()) {
                    len = q.size();
                    start = tmpStart;
            }
        }
        return new int[] {start, start + len -1};
    }
}
