class Solution {
    public int solution(int storey) {
        int answer = 0;
        // 각 모든 숫자가 0에 가깝도록 설정해야함
        // 맨 마지막 숫자부터 5를 기준으로 적다면 -, 6이상은 +
        // 만약 5일 경우에는 그 전숫자를 보고 판단
        while(true){
            if(storey ==0){
                break;
            }
            int tmp = storey % 10;
            storey /= 10;
            // tmp를 보고 판단
            if(tmp > 5){
                // tmp가 10이 될만큼 +해주고 +1해줌
                answer += 10 - tmp;
                storey ++;
            }
            else if(tmp < 5){
                answer += tmp;
            }
            // 5일 경우에는 그 전숫자보고 판단
            else{
                // 5보다 작다면 그냥 -하는게 낫고
                // 5이상이라면 +해서 6이상의 숫자가 되게 만드는게 좋음
                if(storey % 10 < 5){
                    answer += tmp;
                }
                else{
                    answer += 10 - tmp;
                    storey ++;
                }
            }
        }
        
        
        return answer;
    }
}
