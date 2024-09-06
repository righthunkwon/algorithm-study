import java.io.*;
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(String city : cities){
            city = city.toUpperCase();//대소문자 구분 없으니까 대문자로 만듦
            
            //캐시사이즈 0이면 무조건 실행시간 5씩 걸림
            if(cacheSize==0){
                answer+=5;
                continue;
            }
            
            if(cache.size()==0){//아무것도 캐시에 없는 경우
                cache.add(city);
                answer+=5;
            }else{
                if(cache.contains(city)){//캐시에 해당 도시 있을 경우
                    answer++;
                    cache.remove(city);
                    cache.add(city);
                }else{
                    if(cache.size()==cacheSize){//캐시가 꽉 찬 경우
                        cache.poll();
                        cache.add(city);
                        answer+=5;
                    }else{//캐시에 아직 여유공간 있을 경우
                        cache.add(city);
                        answer+=5;
                    }
                }
            }
        }
        return answer;
    }
}
