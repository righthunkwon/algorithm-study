import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
       
        // 최근 등장하지 않은 도시 교체
        // 최대 횟수는 30 x 100000 = 3000000
        Queue<String> q = new LinkedList<String>();
        // 큐에다 넣고 확인하고 없으면 5추가 있으면 뒤에다 놓고 1추가 이런방식
        
        // 이문장 없으면 2개 틀림
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(int i = 0 ;i<cities.length;i++){
            // 먼저 대소문자 구분이 없으니 도시 꺼내고
            // 1. 큐 사이즈가 catchSize보다 작을 때 
            // 2. 큐사이즈가 같을 때 나눠서 계산
            String word = cities[i].toLowerCase();
            // 1번먼저 실행
            if(q.size() < cacheSize){
                // 여기서도 2가지로 나뉘는데 
                // 현재 도시가 큐에 있을 경우 or 없을 경우
                // 있다면 큐에서 나올때까지 찾고 나머지 도시 옮기고 맨뒤에 추가
                if(q.contains(word)){
                    int len = q.size();
                    for(int j = 0;j<len;j++){
                        // 같다면 현재 단어 뽑고 다음거 뽑기 진행
                        // 다르면 그냥 현재 단어 뽑아서 큐에 넣기
                        if(q.peek().equals(word)){
                            q.poll();
                        }
                        else {
                            q.add(q.poll());
                        }
                    }
                    // 전부다 옮겼으면 현재 단어 맨뒤에 추가
                    q.add(word);
                    answer += 1;
                }
                // 현재 이단어가 없다면 큐에다가 그냥 추가하고 answer+=5
                else {
                    q.add(word);
                    answer += 5;
                }
            }
            // 2번 실행
            else {
                // 여기도 단어 있고 없고로 나눠서 계산
                if(q.contains(word)){
                    for(int j = 0;j<cacheSize;j++){
                        if(word.equals(q.peek())){
                            q.poll();
                        }
                        else {
                            q.add(q.poll());
                        }
                    }
                    q.add(word);
                    answer += 1;
                }
                // 포함하고 있지 않으면 큐에서 하나 뽑고 현재 도시 추가
                else {
                    q.poll();
                    q.add(word);
                    answer += 5;
                }
            }
            
        }
        
        
        return answer;
    }
}
