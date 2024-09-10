// 그냥 캐시 로직만 구현하면 되는 문제
// 입력이 10만이라 선형시간으로 끝내기
// 캐시 되었을 경우는 +1, 아닐 경우는 +5
// 캐시 리스트는 한칸씩 밀어내야 하기 때문에 Deque로 간단하게 구성, 뭘 쓰든 상관 없을 듯
// cacheSize 이상이면 삭제하는 로직 추가 or 사이즈 지정
// 링크드 리스트로 구현하는게 더 빠르려나
// 주의사항 1. 캐시된 도시이름 조회시 맨 앞으로 빼줄 것
// 주의사항 2. 대소문자 구분을 하지 않는 점 주의
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length*5;
        int runtime = 0;
        Deque<String> cache = new ArrayDeque<>();
        for(String el : cities){
            String city = el.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                runtime++;
            }else{
                if(cache.size() >= cacheSize){
                    cache.removeLast();
                }
                runtime+=5;
            }
            cache.addFirst(city );
        }
        return runtime;
    }
}