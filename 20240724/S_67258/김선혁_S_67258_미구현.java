import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        // 투포인터
        // 만약 보석들을 다 만족못하면 right를 +1해서늘리고
        // 다 만족한다면 left를 +1해서 줄여감
        // 중간 짧은 지점의 길이를 min에 저장해놓고 갱신해감
        
        // 우선은 hashset으로 보석들의 종류 개수를 count 함
        HashSet<String> hs = new HashSet();
        for(int i = 0;i<gems.length;i++){
            hs.add(gems[i]);
        }
        
        int cnt = hs.size(); // 전체 보석 종류 개수
        int min = 987654321;
        int mina = 0;
        int minb = 1000001;
        while(true){
            if(right == gems.length || left > right){
                break;
            }
            HashSet<String> tmp = new HashSet();
            for(int i = left;i<=right;i++){
                tmp.add(gems[i]);
            }
            // 다 넣었을 때 tmp의 개수가 cnt와 같으면 min 갱신하고 정답넣어놓음
            if(tmp.size() == cnt){
                if(right - left < minb - mina){
                    mina = left;
                    minb = right;
                }
                left++;
            }
            else{
                right++;
            }
            
        }
        answer[0] = mina+1;
        answer[1] = minb+1;
        
        return answer;
    }
}



