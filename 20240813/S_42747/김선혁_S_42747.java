import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // h번 인용된 논문이 h이상일 때 h의 값
        // 우선 n>=h
        
        // 정렬했다 생각하면
        // 0 1 3 5 6 에서
        // 4를 예시로 들면
        // 4이상 값이 4개이상이려면
        // 전체 길이 - 4 인덱스가 4이상이어야함
        // 똑같이 3이면 5-3 = 2번째 부터 3이상이어야하고 이런식
        Arrays.sort(citations);
        // 뒤에서부터 하나 나오면 끝나면 될듯
        for(int i = 0;i<citations.length;i++){
            int tmp = citations.length - i;
            // tmp는 길이가 5면 5 4 3 2 1이런식으로 넣어짐
            // i번째 값이 tmp보다 커야함
            if(citations[i] >= tmp){
                answer = tmp;
                break;
            }
        }
        
        
        
        return answer;
    }
}
